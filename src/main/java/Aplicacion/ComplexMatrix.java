package Aplicacion;

import java.util.ArrayList;

public class ComplexMatrix {
    private ComplexNumber[][] matrix;

    public ComplexMatrix(int i, int j){
        matrix = new ComplexNumber[i][j];
    }

    public ComplexMatrix(ComplexNumber[][] matrix){
        this.matrix = matrix;
    }



    public void put(int i, int j, ComplexNumber c){
        matrix[i][j] = c;
    }

    public ComplexMatrix sum(ComplexMatrix complexMatrix) throws ComplexException {
        if(matrix.length != complexMatrix.getMatrix().length || matrix[0].length != complexMatrix.getMatrix()[0].length){
            throw new ComplexException(ComplexException.BADSIZE);
        }
        ComplexNumber[][] resultado = new ComplexNumber[matrix.length][matrix[0].length];
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                resultado[i][j] = matrix[i][j].sum(complexMatrix.getMatrix()[i][j]);
            }
        }
        return new ComplexMatrix(resultado);
    }

    public ComplexMatrix rest(ComplexMatrix complexMatrix) throws ComplexException {
        if(matrix.length != complexMatrix.getMatrix().length || matrix[0].length != complexMatrix.getMatrix()[0].length){
            throw new ComplexException(ComplexException.BADSIZE);
        }
        ComplexNumber[][] resultado = new ComplexNumber[matrix.length][matrix[0].length];
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                resultado[i][j] = matrix[i][j].rest(complexMatrix.getMatrix()[i][j]);
            }
        }
        return new ComplexMatrix(resultado);
    }

    public ComplexMatrix multiply(ComplexMatrix complexMatrix) throws ComplexException {
        if(matrix[0].length != complexMatrix.getMatrix().length) throw new ComplexException(ComplexException.BADSIZE);
        ComplexNumber[][] resultado = new ComplexNumber[matrix.length][complexMatrix.getMatrix()[0].length];
        for(int i = 0; i< matrix.length; i++){
            for(int k = 0; k< complexMatrix.getMatrix()[0].length; k++){
                ComplexNumber temp = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
                for(int j = 0; j< matrix[0].length; j++){
                    temp = temp.sum(matrix[i][j].multiply(complexMatrix.getMatrix()[j][k]));
                }
                resultado[i][k] = temp;
            }
        }
        return new ComplexMatrix(resultado);
    }

    public ComplexMatrix multiplyEscalar(ComplexNumber complexNumber){
        ComplexNumber[][] resultado = new ComplexNumber[matrix.length][matrix[0].length];
        for(int i = 0; i<matrix.length;i++){
            for(int j = 0; j<matrix[0].length;j++){
                resultado[i][j] = matrix[i][j].multiply(complexNumber);
            }
        }
        return new ComplexMatrix(resultado);
    }

    public ComplexMatrix traspose(){
        ComplexNumber[][] resultado = new ComplexNumber[matrix[0].length][matrix.length];
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                resultado[j][i] = matrix[i][j];
            }
        }
        return new ComplexMatrix(resultado);
    }

    public ComplexMatrix conjugate(){
        ComplexNumber[][] resultado = new ComplexNumber[matrix.length][matrix[0].length];
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                resultado[i][j] = matrix[i][j].conjugate();
            }
        }
        return new ComplexMatrix(resultado);
    }

    public ComplexMatrix adjoint(){
        return this.traspose().conjugate();
    }

    public ComplexMatrix negative(){
        ComplexNumber[][] resultado = new ComplexNumber[matrix.length][matrix[0].length];
        for(int i = 0; i< matrix.length; i++){
            for (int j = 0; j< matrix[0].length; j++){
                resultado[i][j] = matrix[i][j].inverse();
            }
        }
        return new ComplexMatrix(resultado);
    }

    public ComplexNumber innerProduct(ComplexMatrix complexMatrix) throws ComplexException {
        if(matrix.length != complexMatrix.getMatrix().length || matrix[0].length != complexMatrix.getMatrix()[0].length)
            throw new ComplexException(ComplexException.BADSIZE);
        ComplexNumber temp = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                temp = temp.sum(matrix[i][j].multiply(complexMatrix.getMatrix()[i][j]));
            }
        }
        return temp;
    }

    public ComplexMatrix tensor(ComplexMatrix complexMatrix){
        ComplexNumber[][] resultado = new ComplexNumber[matrix.length* complexMatrix.getMatrix().length]
                [matrix[0].length* complexMatrix.getMatrix()[0].length];
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                for(int m = 0; m< complexMatrix.getMatrix().length; m++){
                    for(int n = 0; n< complexMatrix.getMatrix()[0].length; n++){
                        resultado[i* complexMatrix.getMatrix().length+m][j* complexMatrix.getMatrix()[0].length+n] =
                                matrix[i][j].multiply(complexMatrix.getMatrix()[m][n]);
                    }
                }
            }
        }
        return new ComplexMatrix(resultado);
    }

    public Double norm(){
        Double temp = 0.0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                //resultado = resultado.sum(matrix[i][j].power(2));
                temp+=Math.pow(matrix[i][j].norm(),2);
            }
        }
        return  Math.sqrt(temp);
    }

    public Double distance(ComplexMatrix complexMatrix) throws ComplexException {
        if(matrix.length != 1 || complexMatrix.getMatrix().length != 1) throw new ComplexException(ComplexException.BADSIZE);
        return this.rest(complexMatrix).norm();
    }

    public boolean isHermitian(){
        if(this.equals(this.adjoint())){
            return true;
        }else{
            return false;
        }
    }

    public boolean isUnitary() throws ComplexException {
        if(matrix.length != matrix[0].length) throw new ComplexException(ComplexException.BADSIZE);
        ComplexNumber[][] tempMatrix = new ComplexNumber[matrix.length][matrix.length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(i==j){
                    tempMatrix[i][j] = ComplexNumber.newComplexNumberAlgebraicForm(1,0);
                }else{
                    tempMatrix[i][j] = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
                }
            }
        }
        ComplexMatrix iden = new ComplexMatrix(tempMatrix);
        ComplexMatrix first = this.multiply(this.adjoint());
        ComplexMatrix second = this.adjoint().multiply(this);
        boolean bol = true;

        for (int i = 0; i<matrix.length;i++){
            for(int j = 0; j<matrix.length;j++){
                if(!first.getMatrix()[i][j].equals(iden.getMatrix()[i][j]) ||
                !second.getMatrix()[i][j].equals(iden.getMatrix()[i][j])) bol = false;
            }
        }
        return bol;
    }

    public double calculateProbabilityInAPosition(int n) throws ComplexException {
        if(matrix.length>1) throw new ComplexException(ComplexException.BADSIZE);
        return Math.pow(matrix[0][n].norm()/this.norm(),2);
    }

    public ComplexMatrix bra() throws ComplexException {
        return this.adjoint();
    }

    public ComplexNumber amplitudeTransition(ComplexMatrix complexMatrix) throws ComplexException {
        if(complexMatrix.getMatrix().length>1) throw new ComplexException(ComplexException.BADSIZE);
        return this.bra().innerProduct(complexMatrix);
    }

    public ComplexNumber varience(ComplexMatrix complexMatrix) throws ComplexException {
        if(!isHermitian()){
            return null;
        }else{
            ComplexNumber mu = mean(complexMatrix);
            ComplexNumber[][] matrixTemp = new ComplexNumber[matrix.length][matrix.length];
            for(int i = 0; i<matrixTemp.length;i++){
                for(int j = 0;j<matrixTemp.length;j++){
                    if(i==j) matrixTemp[i][j] = mu;
                    else matrixTemp[i][j] = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
                }
            }
            return complexMatrix.bra()
                    .multiply(this.rest(new ComplexMatrix(matrixTemp))
                            .multiply(this.rest(new ComplexMatrix(matrixTemp))))
                    .multiply(complexMatrix).getMatrix()[0][0];
        }
    }

    public ComplexNumber mean(ComplexMatrix complexMatrix) throws ComplexException {
        return multiply(complexMatrix).bra().multiply(complexMatrix).getMatrix()[0][0];
    }

    public static ComplexMatrix finalOrbit(ArrayList<ComplexMatrix> complexMatrices, ComplexMatrix vector) throws ComplexException {
        if(!verifySizesOrbit(complexMatrices,vector)){
            return null;
        }else{
            ComplexMatrix temp = vector;
            for(ComplexMatrix complexMatrix:complexMatrices){
                temp = complexMatrix.multiply(temp);
            }
            return temp;
        }
    }

    private static boolean verifySizesOrbit(ArrayList<ComplexMatrix> complexMatrices, ComplexMatrix vector) throws ComplexException {
        boolean bol = true;
        int size = complexMatrices.get(0).getMatrix().length;
        for(ComplexMatrix complexMatrix:complexMatrices){
            if(!complexMatrix.isUnitary() || complexMatrix.getMatrix().length!=size) bol = false;
        }
        if(vector.getMatrix().length!=size) {
            bol =false;
        }
        return bol;
    }

    public boolean equals(ComplexMatrix complexMatrix){
        if(matrix.length != complexMatrix.getMatrix().length || matrix[0].length != complexMatrix.getMatrix()[0].length){
            return false;
        }
        boolean temp = true;
        for(int i = 0; i< matrix.length && temp; i++){
            for(int j = 0; j< matrix[0].length && temp; j++){
                if(!matrix[i][j].equals(complexMatrix.getMatrix()[i][j])) temp = false;
            }
        }
        return temp;

    }

    @Override
    public String toString(){
        String temp = "";
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                temp += "Row: " + i + " Column: " + j + " Number: " + matrix[i][j];
            }
            temp+="\n";
        }
        return temp;
    }

    public ComplexNumber[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(ComplexNumber[][] matrix) {
        this.matrix = matrix;
    }
}

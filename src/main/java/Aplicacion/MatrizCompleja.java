package Aplicacion;

import java.util.ArrayList;

public class MatrizCompleja {
    private NumeroComplejo[][] matrix;

    public MatrizCompleja(int i, int j){
        matrix = new NumeroComplejo[i][j];
    }

    public MatrizCompleja(NumeroComplejo[][] matrix){
        this.matrix = matrix;
    }



    public void put(int i, int j, NumeroComplejo c){
        matrix[i][j] = c;
    }

    public MatrizCompleja sum(MatrizCompleja complexMatrix) throws ComplexException {
        if(matrix.length != complexMatrix.getMatrix().length || matrix[0].length != complexMatrix.getMatrix()[0].length){
            throw new ComplexException(ComplexException.BADSIZE);
        }
        NumeroComplejo[][] resultado = new NumeroComplejo[matrix.length][matrix[0].length];
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                resultado[i][j] = matrix[i][j].sum(complexMatrix.getMatrix()[i][j]);
            }
        }
        return new MatrizCompleja(resultado);
    }

    public MatrizCompleja rest(MatrizCompleja complexMatrix) throws ComplexException {
        if(matrix.length != complexMatrix.getMatrix().length || matrix[0].length != complexMatrix.getMatrix()[0].length){
            throw new ComplexException(ComplexException.BADSIZE);
        }
        NumeroComplejo[][] resultado = new NumeroComplejo[matrix.length][matrix[0].length];
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                resultado[i][j] = matrix[i][j].rest(complexMatrix.getMatrix()[i][j]);
            }
        }
        return new MatrizCompleja(resultado);
    }

    public MatrizCompleja multiply(MatrizCompleja complexMatrix) throws ComplexException {
        if(matrix[0].length != complexMatrix.getMatrix().length) throw new ComplexException(ComplexException.BADSIZE);
        NumeroComplejo[][] resultado = new NumeroComplejo[matrix.length][complexMatrix.getMatrix()[0].length];
        for(int i = 0; i< matrix.length; i++){
            for(int k = 0; k< complexMatrix.getMatrix()[0].length; k++){
                NumeroComplejo temp = NumeroComplejo.newComplexNumberAlgebraicForm(0,0);
                for(int j = 0; j< matrix[0].length; j++){
                    temp = temp.sum(matrix[i][j].multiply(complexMatrix.getMatrix()[j][k]));
                }
                resultado[i][k] = temp;
            }
        }
        return new MatrizCompleja(resultado);
    }

    public MatrizCompleja multiplyEscalar(NumeroComplejo complexNumber){
        NumeroComplejo[][] resultado = new NumeroComplejo[matrix.length][matrix[0].length];
        for(int i = 0; i<matrix.length;i++){
            for(int j = 0; j<matrix[0].length;j++){
                resultado[i][j] = matrix[i][j].multiply(complexNumber);
            }
        }
        return new MatrizCompleja(resultado);
    }

    public MatrizCompleja traspose(){
        NumeroComplejo[][] resultado = new NumeroComplejo[matrix[0].length][matrix.length];
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                resultado[j][i] = matrix[i][j];
            }
        }
        return new MatrizCompleja(resultado);
    }

    public MatrizCompleja conjugate(){
        NumeroComplejo[][] resultado = new NumeroComplejo[matrix.length][matrix[0].length];
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                resultado[i][j] = matrix[i][j].conjugate();
            }
        }
        return new MatrizCompleja(resultado);
    }

    public MatrizCompleja adjoint(){
        return this.traspose().conjugate();
    }

    public MatrizCompleja negative(){
        NumeroComplejo[][] resultado = new NumeroComplejo[matrix.length][matrix[0].length];
        for(int i = 0; i< matrix.length; i++){
            for (int j = 0; j< matrix[0].length; j++){
                resultado[i][j] = matrix[i][j].inverse();
            }
        }
        return new MatrizCompleja(resultado);
    }

    public NumeroComplejo innerProduct(MatrizCompleja complexMatrix) throws ComplexException {
        if(matrix.length != complexMatrix.getMatrix().length || matrix[0].length != complexMatrix.getMatrix()[0].length)
            throw new ComplexException(ComplexException.BADSIZE);
        NumeroComplejo temp = NumeroComplejo.newComplexNumberAlgebraicForm(0,0);
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                temp = temp.sum(matrix[i][j].multiply(complexMatrix.getMatrix()[i][j]));
            }
        }
        return temp;
    }

    public MatrizCompleja tensor(MatrizCompleja complexMatrix){
        NumeroComplejo[][] resultado = new NumeroComplejo[matrix.length* complexMatrix.getMatrix().length]
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
        return new MatrizCompleja(resultado);
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

    public Double distance(MatrizCompleja complexMatrix) throws ComplexException {
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
        NumeroComplejo[][] tempMatrix = new NumeroComplejo[matrix.length][matrix.length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(i==j){
                    tempMatrix[i][j] = NumeroComplejo.newComplexNumberAlgebraicForm(1,0);
                }else{
                    tempMatrix[i][j] = NumeroComplejo.newComplexNumberAlgebraicForm(0,0);
                }
            }
        }
        MatrizCompleja iden = new MatrizCompleja(tempMatrix);
        MatrizCompleja first = this.multiply(this.adjoint());
        MatrizCompleja second = this.adjoint().multiply(this);
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

    public MatrizCompleja bra() throws ComplexException {
        return this.adjoint();
    }

    public NumeroComplejo amplitudeTransition(MatrizCompleja complexMatrix) throws ComplexException {
        if(complexMatrix.getMatrix().length>1) throw new ComplexException(ComplexException.BADSIZE);
        return this.bra().innerProduct(complexMatrix);
    }

    public NumeroComplejo varience(MatrizCompleja complexMatrix) throws ComplexException {
        if(!isHermitian()){
            return null;
        }else{
            NumeroComplejo mu = mean(complexMatrix);
            NumeroComplejo[][] matrixTemp = new NumeroComplejo[matrix.length][matrix.length];
            for(int i = 0; i<matrixTemp.length;i++){
                for(int j = 0;j<matrixTemp.length;j++){
                    if(i==j) matrixTemp[i][j] = mu;
                    else matrixTemp[i][j] = NumeroComplejo.newComplexNumberAlgebraicForm(0,0);
                }
            }
            return complexMatrix.bra()
                    .multiply(this.rest(new MatrizCompleja(matrixTemp))
                            .multiply(this.rest(new MatrizCompleja(matrixTemp))))
                    .multiply(complexMatrix).getMatrix()[0][0];
        }
    }

    public NumeroComplejo mean(MatrizCompleja complexMatrix) throws ComplexException {
        return multiply(complexMatrix).bra().multiply(complexMatrix).getMatrix()[0][0];
    }

    public static MatrizCompleja finalOrbit(ArrayList<MatrizCompleja> complexMatrices, MatrizCompleja vector) throws ComplexException {
        if(!verifySizesOrbit(complexMatrices,vector)){
            return null;
        }else{
            MatrizCompleja temp = vector;
            for(MatrizCompleja complexMatrix:complexMatrices){
                temp = complexMatrix.multiply(temp);
            }
            return temp;
        }
    }

    private static boolean verifySizesOrbit(ArrayList<MatrizCompleja> complexMatrices, MatrizCompleja vector) throws ComplexException {
        boolean bol = true;
        int size = complexMatrices.get(0).getMatrix().length;
        for(MatrizCompleja complexMatrix:complexMatrices){
            if(!complexMatrix.isUnitary() || complexMatrix.getMatrix().length!=size) bol = false;
        }
        if(vector.getMatrix().length!=size) {
            bol =false;
        }
        return bol;
    }

    public boolean equals(MatrizCompleja complexMatrix){
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

    public NumeroComplejo[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(NumeroComplejo[][] matrix) {
        this.matrix = matrix;
    }
}

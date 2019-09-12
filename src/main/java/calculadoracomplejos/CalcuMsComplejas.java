/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoracomplejos;


public class CalcuMsComplejas {
    
    private CalcuComplejos[][] matriz;

    public CalcuMsComplejas(int i, int j){
        matriz = new CalcuComplejos[i][j];
    }

    public CalcuMsComplejas(CalcuComplejos[][] matrix){
        this.matriz = matrix;
    }
    
    
    public void agregar(int i, int j, CalcuComplejos numero){
        matriz[i][j] = numero;
    }
    
   
    public CalcuMsComplejas suma(CalcuMsComplejas m1){
        CalcuComplejos[][] resultado = new CalcuComplejos[matriz.length][matriz[0].length];
        for(int i = 0; i< matriz.length; i++){
            for(int j = 0; j< matriz[0].length; j++){
                resultado[i][j] = matriz[i][j].suma(m1.getMatriz()[i][j]); 
            }
        }
        return new CalcuMsComplejas(resultado);
    }
    
    
    public CalcuMsComplejas resta(CalcuMsComplejas m1){
        CalcuComplejos[][] resultado = new CalcuComplejos[matriz.length][matriz[0].length];
        for(int i = 0; i< matriz.length; i++){
            for(int j = 0; j< matriz[0].length; j++){
                resultado[i][j] = matriz[i][j].resta(m1.getMatriz()[i][j]);
            }
        }
        return new CalcuMsComplejas(resultado);
    }
    
    
    public CalcuMsComplejas producto(CalcuMsComplejas complexMatrix){
        CalcuComplejos[][] resultado = new CalcuComplejos[matriz.length][complexMatrix.getMatriz()[0].length];
        for(int i = 0; i< matriz.length; i++){
            for(int k = 0; k< complexMatrix.getMatriz()[0].length; k++){
                CalcuComplejos temp = new CalcuComplejos(0,0);
                for(int j = 0; j< matriz[0].length; j++){
                    temp = temp.suma(matriz[i][j].producto(complexMatrix.getMatriz()[j][k]));
                }
                resultado[i][k] = temp;
            }
        }
        return new CalcuMsComplejas(resultado);
    }
    
    
    public CalcuMsComplejas productoEscalar(CalcuComplejos n1){
        CalcuComplejos[][] resultado = new CalcuComplejos[matriz.length][matriz[0].length];
        for(int i = 0; i<matriz.length;i++){
            for(int j = 0; j<matriz[0].length;j++){
                resultado[i][j] = matriz[i][j].producto(n1);
            }
        }
        return new CalcuMsComplejas(resultado);
    }
    
    
    public CalcuMsComplejas transpuesta(){
        CalcuComplejos[][] resultado = new CalcuComplejos[matriz[0].length][matriz.length];
        for(int i = 0; i< matriz.length; i++){
            for(int j = 0; j< matriz[0].length; j++){
                resultado[j][i] = matriz[i][j];
            }
        }
        return new CalcuMsComplejas(resultado);
    }
    
    
    public CalcuMsComplejas conjugada(){
        CalcuComplejos[][] resultado = new CalcuComplejos[matriz.length][matriz[0].length];
        for(int i = 0; i< matriz.length; i++){
            for(int j = 0; j< matriz[0].length; j++){
                resultado[i][j] = matriz[i][j].conjugado();
            }
        }
        return new CalcuMsComplejas(resultado);
    }
    
    
    public CalcuMsComplejas adjunta(){
        return this.transpuesta().conjugada();
    }
    
    
    public CalcuMsComplejas tensor(CalcuMsComplejas complexMatrix){
        CalcuComplejos[][] resultado = new CalcuComplejos[matriz.length* complexMatrix.getMatriz().length]
                [matriz[0].length* complexMatrix.getMatriz()[0].length];
        for(int i = 0; i< matriz.length; i++){
            for(int j = 0; j< matriz[0].length; j++){
                for(int m = 0; m< complexMatrix.getMatriz().length; m++){
                    for(int n = 0; n< complexMatrix.getMatriz()[0].length; n++){
                        resultado[i* complexMatrix.getMatriz().length+m][j* complexMatrix.getMatriz()[0].length+n] =
                                matriz[i][j].producto(complexMatrix.getMatriz()[m][n]);
                    }
                }
            }
        }
        return new CalcuMsComplejas(resultado);
    }
    
    
    public Double norma(){
        Double temp = 0.0;
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[0].length; j++){
                //resultado = resultado.sum(matrix[i][j].power(2));
                temp+=Math.pow(matriz[i][j].norma(),2);
            }
        }
        return  Math.sqrt(temp);
    }
    
    
    public Double distancia(CalcuMsComplejas m1){
        return this.resta(m1).norma();
    }
    
   
    public boolean Hermitian(){
        if(this.equals(this.adjunta())){
            return true;
        }else{
            return false;
        }
    }
    
    
    public boolean isUnitary(){
        CalcuComplejos[][] tempMatrix = new CalcuComplejos[matriz.length][matriz.length];
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz.length; j++){
                if(i==j){
                    tempMatrix[i][j] = new CalcuComplejos(1,0);
                }else{
                    tempMatrix[i][j] = new CalcuComplejos(0,0);
                }
            }
        }
        CalcuMsComplejas iden = new CalcuMsComplejas(tempMatrix);
        CalcuMsComplejas first = this.producto(this.adjunta());
        CalcuMsComplejas second = this.adjunta().producto(this);
        boolean bol = true;

        for (int i = 0; i<matriz.length;i++){
            for(int j = 0; j<matriz.length;j++){
                if(!first.getMatriz()[i][j].equals(iden.getMatriz()[i][j]) ||
                !second.getMatriz()[i][j].equals(iden.getMatriz()[i][j])) bol = false;
            }
        }
        return bol;
    }
    
    public boolean equals(CalcuMsComplejas m1){
        boolean bandera = true;
        for(int i = 0; i< matriz.length && bandera; i++){
            for(int j = 0; j< matriz[0].length && bandera; j++){
                if(!matriz[i][j].equals(m1.getMatriz()[i][j])){
                    bandera = false;
                }
            }
        }
        return bandera;
    }
    
    public CalcuComplejos[][] getMatriz(){
        return matriz;
    }
}

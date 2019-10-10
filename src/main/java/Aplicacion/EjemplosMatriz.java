package Aplicacion;

public class EjemplosMatriz {

    public EjemplosMatriz(){

    }

    public ComplexMatrix getEjemploMatrizCompleja(){
        ComplexNumber[][] matrix = new ComplexNumber[8][8];
        for(int i = 0; i<8;i++){matrix[0][i]=ComplexNumber.newComplexNumberAlgebraicForm(0,0);}
        matrix[1][0] = ComplexNumber.newComplexNumberAlgebraicForm(1.0/Math.sqrt(2),0);
        for(int i = 1; i<8;i++) {matrix[1][i] = ComplexNumber.newComplexNumberAlgebraicForm(0, 0);}
        matrix[2][0] = ComplexNumber.newComplexNumberAlgebraicForm(1.0/Math.sqrt(2),0);
        for(int i = 1; i<8;i++) {matrix[2][i] = ComplexNumber.newComplexNumberAlgebraicForm(0, 0);}
        for(int i = 0;i<8;i++){ComplexNumber temp;
            if(i==1) {temp = ComplexNumber.newComplexNumberAlgebraicForm(-1.0, 1).multiplyEscalar(1.0 / Math.sqrt(6));
            }else if(i==3){temp = ComplexNumber.newComplexNumberAlgebraicForm(1,0);
            }else{temp = ComplexNumber.newComplexNumberAlgebraicForm(0,0);}
            matrix[3][i] = temp;
        }
        for(int i = 0;i<8;i++){
            ComplexNumber temp;
            if(i==1) {temp = ComplexNumber.newComplexNumberAlgebraicForm(-1.0, -1.0).multiplyEscalar(1.0 / Math.sqrt(6));
            }else if(i==4){temp = ComplexNumber.newComplexNumberAlgebraicForm(1,0);
            }else{temp = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
            }
            matrix[4][i] = temp;
        }
        for(int i = 0;i<8;i++){
            ComplexNumber temp;
            if(i==1) {temp = ComplexNumber.newComplexNumberAlgebraicForm(1.0, -1.0).multiplyEscalar(1.0 / Math.sqrt(6));
            }else if(i==2){temp = ComplexNumber.newComplexNumberAlgebraicForm(-1.0, 1.0).multiplyEscalar(1.0 / Math.sqrt(6));
            }else if(i==5){temp = ComplexNumber.newComplexNumberAlgebraicForm(1,0);
            }else{temp = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
            }
            matrix[5][i] = temp;
        }
        for(int i = 0;i<8;i++){
            ComplexNumber temp;
            if(i==2) {temp = ComplexNumber.newComplexNumberAlgebraicForm(-1.0, -1.0).multiplyEscalar(1.0 / Math.sqrt(6));
            }else if(i==6){temp = ComplexNumber.newComplexNumberAlgebraicForm(1,0);
            }else{temp = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
            }
            matrix[6][i] = temp;
        }
        for(int i = 0;i<8;i++){
            ComplexNumber temp;
            if(i==2) {temp = ComplexNumber.newComplexNumberAlgebraicForm(1.0, -1.0).multiplyEscalar(1.0 / Math.sqrt(6));
            }else if(i==7){temp = ComplexNumber.newComplexNumberAlgebraicForm(1,0);
            }else{temp = ComplexNumber.newComplexNumberAlgebraicForm(0,0);}
            matrix[7][i] = temp;
        }
        ComplexMatrix result = new ComplexMatrix(matrix);
        return result;
    }

    public ComplexMatrix getMatrizEsperada(){
        ComplexNumber[][] expected = new ComplexNumber[8][8];
        for(int i = 0; i<3;i++){
            for(int j = 0; j<8;j++){expected[i][j]=ComplexNumber.newComplexNumberAlgebraicForm(0,0);}
        }
        for(int i = 0; i<8;i++){
            ComplexNumber temp;
            if(i==0){temp = ComplexNumber.newComplexNumberAlgebraicForm(-1,1).multiplyEscalar(1.0/Math.sqrt(12));
            }else if(i==1){temp = ComplexNumber.newComplexNumberAlgebraicForm(-1,1).multiplyEscalar(1.0/Math.sqrt(6));
            }else if(i==3){temp = ComplexNumber.newComplexNumberAlgebraicForm(1,0);
            }else{temp = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
            }
            expected[3][i] = temp;
        }
        for(int i = 0; i<8;i++){
            ComplexNumber temp;
            if(i==0){temp = ComplexNumber.newComplexNumberAlgebraicForm(-1,-1).multiplyEscalar(1.0/Math.sqrt(12));
            }else if(i==1){temp = ComplexNumber.newComplexNumberAlgebraicForm(-1,-1).multiplyEscalar(1.0/Math.sqrt(6));
            }else if(i==4){temp = ComplexNumber.newComplexNumberAlgebraicForm(1,0);
            }else{temp = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
            }
            expected[4][i] = temp;
        }
        for(int i = 0; i<8;i++){
            ComplexNumber temp;
            if(i==1){temp = ComplexNumber.newComplexNumberAlgebraicForm(1,-1).multiplyEscalar(1.0/Math.sqrt(6));
            }else if(i==2){temp = ComplexNumber.newComplexNumberAlgebraicForm(-1,1).multiplyEscalar(1.0/Math.sqrt(6));
            }else if(i==5){temp = ComplexNumber.newComplexNumberAlgebraicForm(1,0);
            }else{temp = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
            }
            expected[5][i] = temp;
        }
        for(int i = 0; i<8;i++){
            ComplexNumber temp;
            if(i==0){temp = ComplexNumber.newComplexNumberAlgebraicForm(-1,-1).multiplyEscalar(1.0/Math.sqrt(12));
            }else if(i==2){temp = ComplexNumber.newComplexNumberAlgebraicForm(-1,-1).multiplyEscalar(1.0/Math.sqrt(6));
            }else if(i==6){temp = ComplexNumber.newComplexNumberAlgebraicForm(1,0);
            }else{temp = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
            }
            expected[6][i] = temp;
        }
        for(int i = 0; i<8;i++){
            ComplexNumber temp;
            if(i==0){temp = ComplexNumber.newComplexNumberAlgebraicForm(1,-1).multiplyEscalar(1.0/Math.sqrt(12));
            }else if(i==2){temp = ComplexNumber.newComplexNumberAlgebraicForm(1,-1).multiplyEscalar(1.0/Math.sqrt(6));
            }else if(i==7){temp = ComplexNumber.newComplexNumberAlgebraicForm(1,0);
            }else{temp = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
            }
            expected[7][i] = temp;
        }
        ComplexMatrix expectedMatrix = new ComplexMatrix(expected);
        return expectedMatrix;
    }

    public ComplexMatrix getMatrizPruebaBalas(){
        ComplexNumber[][] matrix = new ComplexNumber[8][8];
        for(int i = 0; i<8; i++){
            for(int j = 0;j<8;j++){
                ComplexNumber temp;
                if((i==1 && j==0)||(i==2 && j==0)) temp = ComplexNumber.newComplexNumberAlgebraicForm(1.0/2.0,0);
                else if((i==3 && j==1) || (i==4 && j==1) || (i==5 && j==1) || (i==5 && j==2) || (i==6 && j==2) || (i==7 && j==2))
                    temp = ComplexNumber.newComplexNumberAlgebraicForm(1.0/3.0,0);
                else if(i>2 && j>2 && i==j) temp = ComplexNumber.newComplexNumberAlgebraicForm(1,0);
                else temp = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
                matrix[i][j] = temp;
            }
        }
        ComplexMatrix complexMatrix = new ComplexMatrix(matrix);
        ComplexNumber[][] matrixX = new ComplexNumber[8][1];
        for(int i = 0; i<8;i++){
            ComplexNumber temp;
            if (i==0) temp = ComplexNumber.newComplexNumberAlgebraicForm(1,0);
            else temp = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
            matrixX[i][0] = temp;
        }
        ComplexMatrix X = new ComplexMatrix(matrixX);
        ComplexNumber[][] test = new ComplexNumber[8][1];
        for(int i = 0; i<8;i++){
            ComplexNumber temp;
            if(i==3 || i==4 || i==6 || i==7) temp = ComplexNumber.newComplexNumberAlgebraicForm(1.0/6.0,0);
            else if(i == 5) temp = ComplexNumber.newComplexNumberAlgebraicForm(1.0/3.0,0);
            else temp = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
            test[i][0] = temp;
        }
        ComplexMatrix matrixTest = new ComplexMatrix(test);
        return matrixTest;
    }

}

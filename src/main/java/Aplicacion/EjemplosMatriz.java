package Aplicacion;

public class EjemplosMatriz {

    public EjemplosMatriz(){

    }

    public MatrizCompleja getEjemploMatrizCompleja(){
        NumeroComplejo[][] matrix = new NumeroComplejo[8][8];
        for(int i = 0; i<8;i++){matrix[0][i]= NumeroComplejo.newComplexNumberAlgebraicForm(0,0);}
        matrix[1][0] = NumeroComplejo.newComplexNumberAlgebraicForm(1.0/Math.sqrt(2),0);
        for(int i = 1; i<8;i++) {matrix[1][i] = NumeroComplejo.newComplexNumberAlgebraicForm(0, 0);}
        matrix[2][0] = NumeroComplejo.newComplexNumberAlgebraicForm(1.0/Math.sqrt(2),0);
        for(int i = 1; i<8;i++) {matrix[2][i] = NumeroComplejo.newComplexNumberAlgebraicForm(0, 0);}
        for(int i = 0;i<8;i++){
            NumeroComplejo temp;
            if(i==1) {temp = NumeroComplejo.newComplexNumberAlgebraicForm(-1.0, 1).multiplyEscalar(1.0 / Math.sqrt(6));
            }else if(i==3){temp = NumeroComplejo.newComplexNumberAlgebraicForm(1,0);
            }else{temp = NumeroComplejo.newComplexNumberAlgebraicForm(0,0);}
            matrix[3][i] = temp;
        }
        for(int i = 0;i<8;i++){
            NumeroComplejo temp;
            if(i==1) {temp = NumeroComplejo.newComplexNumberAlgebraicForm(-1.0, -1.0).multiplyEscalar(1.0 / Math.sqrt(6));
            }else if(i==4){temp = NumeroComplejo.newComplexNumberAlgebraicForm(1,0);
            }else{temp = NumeroComplejo.newComplexNumberAlgebraicForm(0,0);
            }
            matrix[4][i] = temp;
        }
        for(int i = 0;i<8;i++){
            NumeroComplejo temp;
            if(i==1) {temp = NumeroComplejo.newComplexNumberAlgebraicForm(1.0, -1.0).multiplyEscalar(1.0 / Math.sqrt(6));
            }else if(i==2){temp = NumeroComplejo.newComplexNumberAlgebraicForm(-1.0, 1.0).multiplyEscalar(1.0 / Math.sqrt(6));
            }else if(i==5){temp = NumeroComplejo.newComplexNumberAlgebraicForm(1,0);
            }else{temp = NumeroComplejo.newComplexNumberAlgebraicForm(0,0);
            }
            matrix[5][i] = temp;
        }
        for(int i = 0;i<8;i++){
            NumeroComplejo temp;
            if(i==2) {temp = NumeroComplejo.newComplexNumberAlgebraicForm(-1.0, -1.0).multiplyEscalar(1.0 / Math.sqrt(6));
            }else if(i==6){temp = NumeroComplejo.newComplexNumberAlgebraicForm(1,0);
            }else{temp = NumeroComplejo.newComplexNumberAlgebraicForm(0,0);
            }
            matrix[6][i] = temp;
        }
        for(int i = 0;i<8;i++){
            NumeroComplejo temp;
            if(i==2) {temp = NumeroComplejo.newComplexNumberAlgebraicForm(1.0, -1.0).multiplyEscalar(1.0 / Math.sqrt(6));
            }else if(i==7){temp = NumeroComplejo.newComplexNumberAlgebraicForm(1,0);
            }else{temp = NumeroComplejo.newComplexNumberAlgebraicForm(0,0);}
            matrix[7][i] = temp;
        }
        MatrizCompleja result = new MatrizCompleja(matrix);
        return result;
    }

    public MatrizCompleja getMatrizEsperada(){
        NumeroComplejo[][] expected = new NumeroComplejo[8][8];
        for(int i = 0; i<3;i++){
            for(int j = 0; j<8;j++){expected[i][j]= NumeroComplejo.newComplexNumberAlgebraicForm(0,0);}
        }
        for(int i = 0; i<8;i++){
            NumeroComplejo temp;
            if(i==0){temp = NumeroComplejo.newComplexNumberAlgebraicForm(-1,1).multiplyEscalar(1.0/Math.sqrt(12));
            }else if(i==1){temp = NumeroComplejo.newComplexNumberAlgebraicForm(-1,1).multiplyEscalar(1.0/Math.sqrt(6));
            }else if(i==3){temp = NumeroComplejo.newComplexNumberAlgebraicForm(1,0);
            }else{temp = NumeroComplejo.newComplexNumberAlgebraicForm(0,0);
            }
            expected[3][i] = temp;
        }
        for(int i = 0; i<8;i++){
            NumeroComplejo temp;
            if(i==0){temp = NumeroComplejo.newComplexNumberAlgebraicForm(-1,-1).multiplyEscalar(1.0/Math.sqrt(12));
            }else if(i==1){temp = NumeroComplejo.newComplexNumberAlgebraicForm(-1,-1).multiplyEscalar(1.0/Math.sqrt(6));
            }else if(i==4){temp = NumeroComplejo.newComplexNumberAlgebraicForm(1,0);
            }else{temp = NumeroComplejo.newComplexNumberAlgebraicForm(0,0);
            }
            expected[4][i] = temp;
        }
        for(int i = 0; i<8;i++){
            NumeroComplejo temp;
            if(i==1){temp = NumeroComplejo.newComplexNumberAlgebraicForm(1,-1).multiplyEscalar(1.0/Math.sqrt(6));
            }else if(i==2){temp = NumeroComplejo.newComplexNumberAlgebraicForm(-1,1).multiplyEscalar(1.0/Math.sqrt(6));
            }else if(i==5){temp = NumeroComplejo.newComplexNumberAlgebraicForm(1,0);
            }else{temp = NumeroComplejo.newComplexNumberAlgebraicForm(0,0);
            }
            expected[5][i] = temp;
        }
        for(int i = 0; i<8;i++){
            NumeroComplejo temp;
            if(i==0){temp = NumeroComplejo.newComplexNumberAlgebraicForm(-1,-1).multiplyEscalar(1.0/Math.sqrt(12));
            }else if(i==2){temp = NumeroComplejo.newComplexNumberAlgebraicForm(-1,-1).multiplyEscalar(1.0/Math.sqrt(6));
            }else if(i==6){temp = NumeroComplejo.newComplexNumberAlgebraicForm(1,0);
            }else{temp = NumeroComplejo.newComplexNumberAlgebraicForm(0,0);
            }
            expected[6][i] = temp;
        }
        for(int i = 0; i<8;i++){
            NumeroComplejo temp;
            if(i==0){temp = NumeroComplejo.newComplexNumberAlgebraicForm(1,-1).multiplyEscalar(1.0/Math.sqrt(12));
            }else if(i==2){temp = NumeroComplejo.newComplexNumberAlgebraicForm(1,-1).multiplyEscalar(1.0/Math.sqrt(6));
            }else if(i==7){temp = NumeroComplejo.newComplexNumberAlgebraicForm(1,0);
            }else{temp = NumeroComplejo.newComplexNumberAlgebraicForm(0,0);
            }
            expected[7][i] = temp;
        }
        MatrizCompleja expectedMatrix = new MatrizCompleja(expected);
        return expectedMatrix;
    }

    public MatrizCompleja getMatrizPruebaBalas(){
        NumeroComplejo[][] matrix = new NumeroComplejo[8][8];
        for(int i = 0; i<8; i++){
            for(int j = 0;j<8;j++){
                NumeroComplejo temp;
                if((i==1 && j==0)||(i==2 && j==0)) temp = NumeroComplejo.newComplexNumberAlgebraicForm(1.0/2.0,0);
                else if((i==3 && j==1) || (i==4 && j==1) || (i==5 && j==1) || (i==5 && j==2) || (i==6 && j==2) || (i==7 && j==2))
                    temp = NumeroComplejo.newComplexNumberAlgebraicForm(1.0/3.0,0);
                else if(i>2 && j>2 && i==j) temp = NumeroComplejo.newComplexNumberAlgebraicForm(1,0);
                else temp = NumeroComplejo.newComplexNumberAlgebraicForm(0,0);
                matrix[i][j] = temp;
            }
        }
        MatrizCompleja complexMatrix = new MatrizCompleja(matrix);
        return  complexMatrix;

    }

    public  MatrizCompleja getMatrizEsperadaPruebaBalas(){
        NumeroComplejo[][] test = new NumeroComplejo[8][1];
        for(int i = 0; i<8;i++){
            NumeroComplejo temp;
            if(i==3 || i==4 || i==6 || i==7) temp = NumeroComplejo.newComplexNumberAlgebraicForm(1.0/6.0,0);
            else if(i == 5) temp = NumeroComplejo.newComplexNumberAlgebraicForm(1.0/3.0,0);
            else temp = NumeroComplejo.newComplexNumberAlgebraicForm(0,0);
            test[i][0] = temp;
        }
        MatrizCompleja matrixTest = new MatrizCompleja(test);
        return matrixTest;
    }

    public MatrizCompleja getMatrizCoeficiente(){
        NumeroComplejo[][] matrix = new NumeroComplejo[6][6];
        for(int i = 0; i<6;i++){
            for(int j = 0; j<6;j++){
                NumeroComplejo temp;
                if((i==2 && j==1) || (i==2 && j==5) || (i==3 && j==3) || (i==4 && j==2) || (i==5 && j==0) || (i==5 && j==4))
                    temp = NumeroComplejo.newComplexNumberAlgebraicForm(1,0);
                else temp = NumeroComplejo.newComplexNumberAlgebraicForm(0,0);
                matrix[i][j] = temp;
            }
        }
        MatrizCompleja complexMatrix = new MatrizCompleja(matrix);
        return complexMatrix;
    }

}

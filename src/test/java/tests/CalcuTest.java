package tests;

import static org.junit.Assert.*;

import Aplicacion.ComplexException;
import Aplicacion.ComplexMatrix;
import Aplicacion.ComplexNumber;
import org.junit.Test;


import calculadoracomplejos.CalcuMsComplejas;
import calculadoracomplejos.CalcuComplejos;



public class CalcuTest {
    
    @Test
    public void suma(){
        CalcuComplejos n1 = new CalcuComplejos(5,2);
        CalcuComplejos n2 = new CalcuComplejos(6,8);
        CalcuComplejos res = new CalcuComplejos(11,10);
        
        assertTrue(n1.suma(n2).equals(res));
    } 
    
    @Test
    public void producto(){
        CalcuComplejos n1 = new CalcuComplejos(0,1);
        CalcuComplejos n2 = new CalcuComplejos(0,1);
        CalcuComplejos res = new CalcuComplejos(-1,0);
        
        assertTrue(n1.producto(n2).equals(res));
    }
    
    @Test
    public void resta(){
        CalcuComplejos n1 = new CalcuComplejos(5,10);
        CalcuComplejos n2 = new CalcuComplejos(2,5);
        CalcuComplejos res = new CalcuComplejos(3,5);
        
        assertTrue(n1.resta(n2).equals(res));
    }
    
    @Test
    public void division(){
        CalcuComplejos n1 = new CalcuComplejos(3,5);
        CalcuComplejos n2 = new CalcuComplejos(1,-1);
        CalcuComplejos res = new CalcuComplejos(-1,4);
        
        assertTrue(n1.division(n2).equals(res));
    }
    
    @Test
    public void modulo(){
        CalcuComplejos n1 = new CalcuComplejos(3,5);
        double res = 5.83;
        
        assertTrue(n1.modulo()== res);
    }
    
    @Test
    public void conjugado(){
        CalcuComplejos n1 = new CalcuComplejos(3,5);
        CalcuComplejos res = new CalcuComplejos(3,-5);
        
        assertTrue(n1.conjugado().equals(res));
    }
    
    @Test
    public void polar(){
        CalcuComplejos n1 = new CalcuComplejos(3,5);
        String res = "5.83,1.03";
        
        assertTrue(n1.polar().equals(res));
    }
    
    @Test
    public void fase(){
        CalcuComplejos n1 = new CalcuComplejos(3,5);
        double res = 1.03;
        
        assertTrue(n1.fase()== res);
    }
    
    @Test
    public void adicionVector(){
        CalcuComplejos n1 = new CalcuComplejos(3,5);
        double res = 1.03;
        
        assertTrue(n1.fase()== res);
    }
    
    

    CalcuComplejos c1 = new CalcuComplejos(3,2);
    CalcuComplejos c2 = new CalcuComplejos(-1,3);
    CalcuComplejos c3 = new CalcuComplejos(-10,-7);
    CalcuComplejos c4 = new CalcuComplejos(9,-8);

    CalcuMsComplejas cm1 = new CalcuMsComplejas(new CalcuComplejos[][]{{c1,c2},{c3,c4}});

    CalcuComplejos c5 = new CalcuComplejos(-2,2);
    CalcuComplejos c6 = new CalcuComplejos(6,3);
    CalcuComplejos c7 = new CalcuComplejos(-4,-3);
    CalcuComplejos c8 = new CalcuComplejos(2,-3);

    CalcuMsComplejas cm2 = new CalcuMsComplejas(new CalcuComplejos[][]{{c5,c6},{c7,c8}});

    @Test
    public void sumaMatriz() {
        CalcuComplejos t1 = new CalcuComplejos(1,4);
        CalcuComplejos t2 = new CalcuComplejos(5,6);
        CalcuComplejos t3 = new CalcuComplejos(-14,-10);
        CalcuComplejos t4 = new CalcuComplejos(11,-11);

        CalcuMsComplejas tm1 = new CalcuMsComplejas(new CalcuComplejos[][]{{t1,t2},{t3,t4}});
        assertTrue(tm1.equals(cm1.suma(cm2)));
    }

    @Test
    public void restaMatriz() {
        CalcuComplejos t1 = new CalcuComplejos(5,0);
        CalcuComplejos t2 = new CalcuComplejos(-7,0);
        CalcuComplejos t3 = new CalcuComplejos(-6,-4);
        CalcuComplejos t4 = new CalcuComplejos(7,-5);

        CalcuMsComplejas tm1 = new CalcuMsComplejas(new CalcuComplejos[][]{{t1,t2},{t3,t4}});
        assertTrue(tm1.equals(cm1.resta(cm2)));
    }
    
    @Test
    public void productoMatriz() {
        CalcuComplejos t1 = new CalcuComplejos(3,-7);
        CalcuComplejos t2 = new CalcuComplejos(19,30);
        CalcuComplejos t3 = new CalcuComplejos(-26,-1);
        CalcuComplejos t4 = new CalcuComplejos(-45,-115);

        CalcuMsComplejas tm1 = new CalcuMsComplejas(new CalcuComplejos[][]{{t1,t2},{t3,t4}});
        assertTrue(tm1.equals(cm1.producto(cm2)));
    }
    
    @Test
    public void productoEscalarMatriz() {
        CalcuComplejos t1 = new CalcuComplejos(12,-5);
        CalcuComplejos t2 = new CalcuComplejos(7,9);
        CalcuComplejos t3 = new CalcuComplejos(-41,16);
        CalcuComplejos t4 = new CalcuComplejos(-6,-43);
        CalcuMsComplejas tm1= new CalcuMsComplejas(new CalcuComplejos[][]{{t1,t2},{t3,t4}});
        assertTrue(tm1.equals(cm1.productoEscalar(new CalcuComplejos(2,-3))));
    }

    @Test
    public void transpuestaMatriz() {
        CalcuMsComplejas tm1 = new CalcuMsComplejas(new CalcuComplejos[][]{{c1,c3},{c2,c4}});
        assertTrue(tm1.equals(cm1.transpuesta()));
    }

    @Test
    public void conjugadaMatriz() {
        CalcuMsComplejas tm1 = new CalcuMsComplejas(new CalcuComplejos[][]{{c1.conjugado(),c2.conjugado()},
                                                                    {c3.conjugado(),c4.conjugado()}});
        assertTrue(tm1.equals(cm1.conjugada()));
    }

    @Test
    public void adjuntaMatriz() {
        CalcuMsComplejas tm1 = new CalcuMsComplejas(new CalcuComplejos[][]{{c1.conjugado(),c3.conjugado()},
                                                                    {c2.conjugado(),c4.conjugado()}});
        assertTrue(tm1.equals(cm1.adjunta()));
    }
    
    @Test
    public void tensorMatriz() {
        CalcuComplejos t1 = new CalcuComplejos(-10,2);
        CalcuComplejos t2 = new CalcuComplejos(12,21);
        CalcuComplejos t3 = new CalcuComplejos(-4,-8);
        CalcuComplejos t4 = new CalcuComplejos(-15,15);
        CalcuComplejos t5 = new CalcuComplejos(-6,-17);
        CalcuComplejos t6 = new CalcuComplejos(12,-5);
        CalcuComplejos t7 = new CalcuComplejos(13,-9);
        CalcuComplejos t8 = new CalcuComplejos(7,9);
        CalcuComplejos t9 = new CalcuComplejos(34,-6);
        CalcuComplejos t10 = new CalcuComplejos(-39,-72);
        CalcuComplejos t11 = new CalcuComplejos(-2,34);
        CalcuComplejos t12 = new CalcuComplejos(78,-21);
        CalcuComplejos t13 = new CalcuComplejos(19,58);
        CalcuComplejos t14 = new CalcuComplejos(-41,16);
        CalcuComplejos t15 = new CalcuComplejos(-60,5);
        CalcuComplejos t16 = new CalcuComplejos(-6,-43);
        CalcuMsComplejas tm1 = new CalcuMsComplejas(new CalcuComplejos[][]{{t1,t2,t3,t4},
                                                                    {t5,t6,t7,t8},
                                                                    {t9,t10,t11,t12},
                                                                    {t13,t14,t15,t16}});
        assertTrue(tm1.equals(cm1.tensor(cm2)));
    }

    @Test
    public void normaMatriz() {
        CalcuMsComplejas tm1 = new CalcuMsComplejas(new CalcuComplejos[][]{{c1,c2,c3,c4}});
        double ans = Math.sqrt(317);
        double comp = tm1.norma();
        assertEquals(ans,comp,0);
        
    }

    @Test
    public void distanciaMatriz() {
        CalcuMsComplejas tm1 = new CalcuMsComplejas(new CalcuComplejos[][]{{c1,c2,c3,c4}});
        CalcuMsComplejas tm2 = new CalcuMsComplejas(new CalcuComplejos[][]{{c5,c6,c7,c8}});
        double ans = Math.sqrt(200);
        double comp = tm1.distancia(tm2);
        assertEquals(ans,comp,0);
    }

    @Test
    public void hermitianMatriz() {
        CalcuComplejos t1 = new CalcuComplejos(2,0);
        CalcuComplejos t2 = new CalcuComplejos(2,1);
        CalcuComplejos t3 = new CalcuComplejos(4,0);
        CalcuComplejos t4 = new CalcuComplejos(2,-1);
        CalcuComplejos t5 = new CalcuComplejos(3,0);
        CalcuComplejos t6 = new CalcuComplejos(0,1);
        CalcuComplejos t7 = new CalcuComplejos(4,0);
        CalcuComplejos t8 = new CalcuComplejos(0,-1);
        CalcuComplejos t9 = new CalcuComplejos(1,0);
        assertTrue(new CalcuMsComplejas(new CalcuComplejos[][]{{t1,t2,t3},{t4,t5,t6},{t7,t8,t9}}).Hermitian());
    }

    @Test
    public void unitariaMatriz() {
        CalcuComplejos t1 = new CalcuComplejos(1,1);
        CalcuComplejos t2 = new CalcuComplejos(1,-1);
        CalcuMsComplejas complexMatrix = new CalcuMsComplejas(new CalcuComplejos[][]{{t1,t2},{t2,t1}});
        assertTrue(complexMatrix.productoEscalar(new CalcuComplejos(1.0/2.0,0)).isUnitary());
    }

    // Pruebas retos de programacion

    @Test
    public void deterministicTest() throws ComplexException {
        ComplexNumber[][] matrix = new ComplexNumber[6][6];
        for(int i = 0; i<6;i++){
            for(int j = 0; j<6;j++){
                ComplexNumber temp;
                if((i==2 && j==1) || (i==2 && j==5) || (i==3 && j==3) || (i==4 && j==2) || (i==5 && j==0) || (i==5 && j==4))
                    temp = ComplexNumber.newComplexNumberAlgebraicForm(1,0);
                else temp = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
                matrix[i][j] = temp;
            }
        }
        ComplexMatrix complexMatrix = new ComplexMatrix(matrix);
        ComplexNumber[][] matrixX = new ComplexNumber[6][1];
        matrixX[0][0] = ComplexNumber.newComplexNumberAlgebraicForm(6,0);
        matrixX[1][0] = ComplexNumber.newComplexNumberAlgebraicForm(2,0);
        matrixX[2][0] = ComplexNumber.newComplexNumberAlgebraicForm(1,0);
        matrixX[3][0] = ComplexNumber.newComplexNumberAlgebraicForm(5,0);
        matrixX[4][0] = ComplexNumber.newComplexNumberAlgebraicForm(3,0);
        matrixX[5][0] = ComplexNumber.newComplexNumberAlgebraicForm(10,0);
        ComplexMatrix X = new ComplexMatrix(matrixX);
        ComplexNumber[][] matrixTest = new ComplexNumber[6][1];
        matrixTest[0][0] = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
        matrixTest[1][0] = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
        matrixTest[2][0] = ComplexNumber.newComplexNumberAlgebraicForm(12,0);
        matrixTest[3][0] = ComplexNumber.newComplexNumberAlgebraicForm(5,0);
        matrixTest[4][0] = ComplexNumber.newComplexNumberAlgebraicForm(1,0);
        matrixTest[5][0] = ComplexNumber.newComplexNumberAlgebraicForm(9,0);
        ComplexMatrix test = new ComplexMatrix(matrixTest);
        assertTrue(complexMatrix.multiply(X).equals(test));
    }

    @Test
    public void BulletTest() throws ComplexException {
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
        assertTrue(complexMatrix.multiply(complexMatrix).multiply(X).equals(matrixTest));
    }

    @Test
    public void doubleSlit() throws ComplexException {
        ComplexNumber[][] matrix = new ComplexNumber[8][8];
        for(int i = 0; i<8;i++){
            matrix[0][i]=ComplexNumber.newComplexNumberAlgebraicForm(0,0);
        }
        matrix[1][0] = ComplexNumber.newComplexNumberAlgebraicForm(1.0/Math.sqrt(2),0);
        for(int i = 1; i<8;i++) {
            matrix[1][i] = ComplexNumber.newComplexNumberAlgebraicForm(0, 0);
        }
        matrix[2][0] = ComplexNumber.newComplexNumberAlgebraicForm(1.0/Math.sqrt(2),0);
        for(int i = 1; i<8;i++) {
            matrix[2][i] = ComplexNumber.newComplexNumberAlgebraicForm(0, 0);
        }
        for(int i = 0;i<8;i++){
            ComplexNumber temp;
            if(i==1) {
                temp = ComplexNumber.newComplexNumberAlgebraicForm(-1.0, 1).multiplyEscalar(1.0 / Math.sqrt(6));
            }else if(i==3){
                temp = ComplexNumber.newComplexNumberAlgebraicForm(1,0);
            }else{
                temp = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
            }
            matrix[3][i] = temp;
        }
        for(int i = 0;i<8;i++){
            ComplexNumber temp;
            if(i==1) {
                temp = ComplexNumber.newComplexNumberAlgebraicForm(-1.0, -1.0).multiplyEscalar(1.0 / Math.sqrt(6));
            }else if(i==4){
                temp = ComplexNumber.newComplexNumberAlgebraicForm(1,0);
            }else{
                temp = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
            }
            matrix[4][i] = temp;
        }
        for(int i = 0;i<8;i++){
            ComplexNumber temp;
            if(i==1) {
                temp = ComplexNumber.newComplexNumberAlgebraicForm(1.0, -1.0).multiplyEscalar(1.0 / Math.sqrt(6));
            }else if(i==2){
                temp = ComplexNumber.newComplexNumberAlgebraicForm(-1.0, 1.0).multiplyEscalar(1.0 / Math.sqrt(6));
            }else if(i==5){
                temp = ComplexNumber.newComplexNumberAlgebraicForm(1,0);
            }else{
                temp = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
            }
            matrix[5][i] = temp;
        }
        for(int i = 0;i<8;i++){
            ComplexNumber temp;
            if(i==2) {
                temp = ComplexNumber.newComplexNumberAlgebraicForm(-1.0, -1.0).multiplyEscalar(1.0 / Math.sqrt(6));
            }else if(i==6){
                temp = ComplexNumber.newComplexNumberAlgebraicForm(1,0);
            }else{
                temp = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
            }
            matrix[6][i] = temp;
        }
        for(int i = 0;i<8;i++){
            ComplexNumber temp;
            if(i==2) {
                temp = ComplexNumber.newComplexNumberAlgebraicForm(1.0, -1.0).multiplyEscalar(1.0 / Math.sqrt(6));
            }else if(i==7){
                temp = ComplexNumber.newComplexNumberAlgebraicForm(1,0);
            }else{
                temp = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
            }
            matrix[7][i] = temp;
        }
        ComplexMatrix result = new ComplexMatrix(matrix);

        //EXPECTED
        ComplexNumber[][] expected = new ComplexNumber[8][8];
        for(int i = 0; i<3;i++){
            for(int j = 0; j<8;j++){
                expected[i][j]=ComplexNumber.newComplexNumberAlgebraicForm(0,0);
            }
        }
        for(int i = 0; i<8;i++){
            ComplexNumber temp;
            if(i==0){
                temp = ComplexNumber.newComplexNumberAlgebraicForm(-1,1).multiplyEscalar(1.0/Math.sqrt(12));
            }else if(i==1){
                temp = ComplexNumber.newComplexNumberAlgebraicForm(-1,1).multiplyEscalar(1.0/Math.sqrt(6));
            }else if(i==3){
                temp = ComplexNumber.newComplexNumberAlgebraicForm(1,0);
            }else{
                temp = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
            }
            expected[3][i] = temp;
        }
        for(int i = 0; i<8;i++){
            ComplexNumber temp;
            if(i==0){
                temp = ComplexNumber.newComplexNumberAlgebraicForm(-1,-1).multiplyEscalar(1.0/Math.sqrt(12));
            }else if(i==1){
                temp = ComplexNumber.newComplexNumberAlgebraicForm(-1,-1).multiplyEscalar(1.0/Math.sqrt(6));
            }else if(i==4){
                temp = ComplexNumber.newComplexNumberAlgebraicForm(1,0);
            }else{
                temp = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
            }
            expected[4][i] = temp;
        }
        for(int i = 0; i<8;i++){
            ComplexNumber temp;
            if(i==1){
                temp = ComplexNumber.newComplexNumberAlgebraicForm(1,-1).multiplyEscalar(1.0/Math.sqrt(6));
            }else if(i==2){
                temp = ComplexNumber.newComplexNumberAlgebraicForm(-1,1).multiplyEscalar(1.0/Math.sqrt(6));
            }else if(i==5){
                temp = ComplexNumber.newComplexNumberAlgebraicForm(1,0);
            }else{
                temp = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
            }
            expected[5][i] = temp;
        }
        for(int i = 0; i<8;i++){
            ComplexNumber temp;
            if(i==0){
                temp = ComplexNumber.newComplexNumberAlgebraicForm(-1,-1).multiplyEscalar(1.0/Math.sqrt(12));
            }else if(i==2){
                temp = ComplexNumber.newComplexNumberAlgebraicForm(-1,-1).multiplyEscalar(1.0/Math.sqrt(6));
            }else if(i==6){
                temp = ComplexNumber.newComplexNumberAlgebraicForm(1,0);
            }else{
                temp = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
            }
            expected[6][i] = temp;
        }
        for(int i = 0; i<8;i++){
            ComplexNumber temp;
            if(i==0){
                temp = ComplexNumber.newComplexNumberAlgebraicForm(1,-1).multiplyEscalar(1.0/Math.sqrt(12));
            }else if(i==2){
                temp = ComplexNumber.newComplexNumberAlgebraicForm(1,-1).multiplyEscalar(1.0/Math.sqrt(6));
            }else if(i==7){
                temp = ComplexNumber.newComplexNumberAlgebraicForm(1,0);
            }else{
                temp = ComplexNumber.newComplexNumberAlgebraicForm(0,0);
            }
            expected[7][i] = temp;
        }
        ComplexMatrix expectedMatrix = new ComplexMatrix(expected);
        assertTrue(result.multiply(result).multiply(result).equals(expectedMatrix));
}

    @Test
    public void probabilityInAPosition() throws ComplexException {
        ComplexNumber[][] matrix = new ComplexNumber[1][4];
        matrix[0][0] = ComplexNumber.newComplexNumberAlgebraicForm(-3,-1);
        matrix[0][1] = ComplexNumber.newComplexNumberAlgebraicForm(0,-2);
        matrix[0][2] = ComplexNumber.newComplexNumberAlgebraicForm(0,1);
        matrix[0][3] = ComplexNumber.newComplexNumberAlgebraicForm(2,0);
        assertEquals(new ComplexMatrix(matrix).calculateProbabilityInAPosition(2),0.05263157894736841,0.00001);
    }

    @Test
    public void transition() throws ComplexException {
        ComplexNumber[][] si = new ComplexNumber[1][2];
        ComplexNumber[][] phi = new ComplexNumber[1][2];
        si[0][0] = ComplexNumber.newComplexNumberAlgebraicForm(0,1);
        si[0][1] = ComplexNumber.newComplexNumberAlgebraicForm(-1,0);

        phi[0][0] = ComplexNumber.newComplexNumberAlgebraicForm(1,0);
        phi[0][1] = ComplexNumber.newComplexNumberAlgebraicForm(0,1);

        assertTrue(new ComplexMatrix(si).bra().traspose().multiplyEscalar(ComplexNumber.newComplexNumberAlgebraicForm(Math.sqrt(2)/2,0)).
                innerProduct(new ComplexMatrix(phi).multiplyEscalar(ComplexNumber.newComplexNumberAlgebraicForm(Math.sqrt(2)/2,0))).equals(
                ComplexNumber.newComplexNumberAlgebraicForm(0,-1.0000000000000002)));
    }

}
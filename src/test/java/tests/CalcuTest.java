package tests;

import static org.junit.Assert.*;

import Aplicacion.ComplexException;
import Aplicacion.EjemplosMatriz;
import Aplicacion.MatrizCompleja;
import Aplicacion.NumeroComplejo;
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
    ////////////////////////////////
    // Pruebas retos de programacion


    @Test
    public void pruebaBalas() throws ComplexException {

        NumeroComplejo[][] ma = new NumeroComplejo[8][1];
        for(int i = 0; i<8;i++){
            NumeroComplejo temp;
            if (i==0) temp = NumeroComplejo.newComplexNumberAlgebraicForm(1,0);
            else temp = NumeroComplejo.newComplexNumberAlgebraicForm(0,0);
            ma[i][0] = temp;
        }
        EjemplosMatriz eje = new EjemplosMatriz();
        MatrizCompleja X = new MatrizCompleja(ma);
        MatrizCompleja macom = eje.getMatrizPruebaBalas();
        MatrizCompleja matrixTest = eje.getMatrizEsperadaPruebaBalas();
        assertTrue(macom.multiply(macom).multiply(X).equals(matrixTest));

    }

    @Test
    public void pruebaDobleRendija() throws ComplexException {
        EjemplosMatriz eje = new EjemplosMatriz();
        // Matriz a comparar
        MatrizCompleja result = eje.getEjemploMatrizCompleja();
        // Matriz esperada
        MatrizCompleja maesperada = eje.getMatrizEsperada();
        assertTrue(result.multiply(result).multiply(result).equals(maesperada));
    }

    @Test
    public void probabilidadEnUnaPosicion() throws ComplexException {
        NumeroComplejo[][] ma = new NumeroComplejo[1][4];
        ma[0][0] = NumeroComplejo.newComplexNumberAlgebraicForm(-3,-1);
        ma[0][1] = NumeroComplejo.newComplexNumberAlgebraicForm(0,-2);
        ma[0][2] = NumeroComplejo.newComplexNumberAlgebraicForm(0,1);
        ma[0][3] = NumeroComplejo.newComplexNumberAlgebraicForm(2,0);
        assertEquals(new MatrizCompleja(ma).calculateProbabilityInAPosition(2),0.05263157894736841,0.00001);
    }

    @Test
    public void pruebaTransicion() throws ComplexException {
        NumeroComplejo[][] si = new NumeroComplejo[1][2];
        NumeroComplejo[][] phi = new NumeroComplejo[1][2];
        si[0][0] = NumeroComplejo.newComplexNumberAlgebraicForm(0,1);
        si[0][1] = NumeroComplejo.newComplexNumberAlgebraicForm(-1,0);

        phi[0][0] = NumeroComplejo.newComplexNumberAlgebraicForm(1,0);
        phi[0][1] = NumeroComplejo.newComplexNumberAlgebraicForm(0,1);

        assertTrue(new MatrizCompleja(si).bra().traspose().multiplyEscalar(NumeroComplejo.newComplexNumberAlgebraicForm(Math.sqrt(2)/2,0)).
                innerProduct(new MatrizCompleja(phi).multiplyEscalar(NumeroComplejo.newComplexNumberAlgebraicForm(Math.sqrt(2)/2,0))).equals(
                NumeroComplejo.newComplexNumberAlgebraicForm(0,-1.0000000000000002)));
    }

    @Test
    public void pruebaCoeficiente() throws ComplexException {
        EjemplosMatriz eje = new EjemplosMatriz();
        MatrizCompleja matrizCom = eje.getMatrizCoeficiente();
        NumeroComplejo[][] max = new NumeroComplejo[6][1];
        max[0][0] = NumeroComplejo.newComplexNumberAlgebraicForm(6,0);
        max[1][0] = NumeroComplejo.newComplexNumberAlgebraicForm(2,0);
        max[2][0] = NumeroComplejo.newComplexNumberAlgebraicForm(1,0);
        max[3][0] = NumeroComplejo.newComplexNumberAlgebraicForm(5,0);
        max[4][0] = NumeroComplejo.newComplexNumberAlgebraicForm(3,0);
        max[5][0] = NumeroComplejo.newComplexNumberAlgebraicForm(10,0);
        MatrizCompleja X = new MatrizCompleja(max);
        NumeroComplejo[][] macomparar = new NumeroComplejo[6][1];
        macomparar[0][0] = NumeroComplejo.newComplexNumberAlgebraicForm(0,0);
        macomparar[1][0] = NumeroComplejo.newComplexNumberAlgebraicForm(0,0);
        macomparar[2][0] = NumeroComplejo.newComplexNumberAlgebraicForm(12,0);
        macomparar[3][0] = NumeroComplejo.newComplexNumberAlgebraicForm(5,0);
        macomparar[4][0] = NumeroComplejo.newComplexNumberAlgebraicForm(1,0);
        macomparar[5][0] = NumeroComplejo.newComplexNumberAlgebraicForm(9,0);
        MatrizCompleja comparar = new MatrizCompleja(macomparar);
        assertTrue(matrizCom.multiply(X).equals(comparar));
    }
}
package AplicacionTest;

import Aplicacion.*;
import java.lang.Math; 
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PruebasCalcu {
	
	Mathemataising m = new Mathemataising();

	@Test
	void deberiaSumarComplejos() {
		Complejo c1 = m.sumaQC(new Complejo(2, 4), new Complejo(3, 5));
		Complejo c2 = new Complejo(5, 9);		
		assertTrue(c1.equals(c2));
	}
	
	@Test
	void deberiaRestarComplejos() {
		Complejo c1 = m.restaQC(new Complejo(2, 4), new Complejo(3, 5));
		Complejo c2 = new Complejo(-1, -1);		
		assertTrue(c1.equals(c2));
	}
	
	@Test
	void deberiaMultiplicarComplejos() {
		Complejo c1 = m.multiplacionQC(new Complejo(5, 4), new Complejo(3, 7));
		Complejo c2 = new Complejo(-13, 47);		
		assertTrue(c1.equals(c2));
	}
	
	@Test
	void deberiaDividirComplejos() {
		Complejo c1 = m.divisionQC(new Complejo(6, -1), new Complejo(-3, 4));
		Complejo c2 = new Complejo(-0.88, -0.84);		
		assertTrue(c1.equals(c2));
	}
	
	@Test
	void deberiaSacarModuloComplejo() {
		double var = m.moduloQC(new Complejo(7, 11));
		assertEquals(var, Math.sqrt(7*7+11*11));
	}
	
	@Test
	void deberiaSacarFaseComplejo() {
		double var = m.faseQC(new Complejo(7, 11));
		assertEquals(var, (Math.toDegrees(Math.atan((double)11/(double)7))));
	}
	
	@Test
	void deberiaConvertirCartesianoAPolar() {
		double[] var = new double[2];
		var[0] = Math.sqrt(5*5+2*2);
		var[1] = Math.toDegrees(Math.atan((double)2/(double)5));
		double[] res = m.conversionCaP(new Complejo(5, 2));
		assertEquals(var[0], res[0]);
		assertEquals(var[1], res[1]);
	}
	
	@Test
	void deberiaConvertirPolarACartesiano() {
		double[] var = new double[2];
		double[] res = m.conversionPaC(new Complejo(7, 11));
		//n complejo expresado en polares: [13.038404810405298,57.528807709151515] 
		var[0] = 13.038404810405298*Math.cos(57.528807709151515); 
		var[1] = 13.038404810405298*Math.sin(57.528807709151515);		
		assertEquals(var[0], res[0]);
		assertEquals(var[1], res[1]);
	}
	
	@Test
	void deberiaSacarConjugado() {
		//Complejo: (11,-25) => (11 - 25i), Conjugado: (11, 25) => (11 + 25i)
		Complejo exp = new Complejo(11, 25);
		assertTrue(exp.equals(m.conjugadoQC(new Complejo(11, -25))));
	}
}

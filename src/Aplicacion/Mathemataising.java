package Aplicacion;
import java.lang.Math;

public class Mathemataising {
	
	String resultado;
	String signoRes;
	
	public Mathemataising() {		
	}
	
	public Complejo sumaQC(Complejo n1, Complejo n2) {
		double sPtReal = n1.parteReal + n2.parteReal;
		double sPtIma = n1.parteImag + n2.parteImag;		
		System.out.println("( " + sPtReal + " " + sPtIma +" )");
		Complejo resultado = new Complejo(sPtReal, sPtIma);
		return resultado;
	}
	
	public Complejo restaQC(Complejo n1, Complejo n2) {
		double sPtReal = n1.parteReal - n2.parteReal;
		double sPtIma = n1.parteImag - n2.parteImag;		
		System.out.println("( " + sPtReal + " " + sPtIma +" )");
		Complejo resultado = new Complejo(sPtReal, sPtIma);
		return resultado;
	}
	
	public Complejo multiplacionQC(Complejo n1, Complejo n2) {
		double sPtReal = n1.parteReal * n2.parteReal;		
		double sPtImaNuevoReal = (n1.parteImag * n2.parteImag)*(-1);		
		double resPtReal = sPtReal + sPtImaNuevoReal;
		double resPtIma = (n1.parteReal * n2.parteImag) + (n1.parteImag * n2.parteReal);
		if(resPtReal == 0  ) {
			System.out.println("( " + resPtIma +" )");
			Complejo resultado = new Complejo(0, resPtIma);
			return resultado;
		}
		else if (resPtIma == 0){
			System.out.println("( " + resPtReal + " )");
			Complejo resultado = new Complejo(resPtReal, 0);
			return resultado;
		}
		
		else {
			System.out.println("( " + resPtReal + " " + resPtIma +"i )");
			Complejo resultado = new Complejo(resPtReal, resPtIma);
			return resultado;
		}		
	}
	
	public Complejo divisionQC(Complejo n1, Complejo n2) {
		Complejo var1 = multiplacionQC(n1, conjugadoQC(n2));
		Complejo var2 = multiplacionQC(n2, conjugadoQC(n2));
		double resPtReal = var1.parteReal/var2.parteReal;
		double resPtIma = var1.parteImag/var2.parteReal;
		System.out.println("("+ resPtReal+" "+ resPtIma +"i )");
		Complejo resultado = new Complejo(resPtReal, resPtIma);
		return resultado;
	}
	
	public Complejo conjugadoQC(Complejo n1) {
		Complejo resultado = new Complejo(n1.getParteReal(),n1.getParteImaConju());
		System.out.println("( " + n1.getParteReal() + " " + n1.getParteImaConju() +" )");
		return resultado;
	}	
	
	public double faseQC(Complejo n1) {
		System.out.println(Math.toDegrees(Math.atan(n1.parteImag/n1.parteReal)));
		return Math.toDegrees(Math.atan(n1.parteImag/n1.parteReal));
	}
	
	public double moduloQC(Complejo n1) {	
		System.out.println(Math.sqrt(n1.parteReal*n1.parteReal+n1.parteImag*n1.parteImag));
		return Math.sqrt(n1.parteReal*n1.parteReal+n1.parteImag*n1.parteImag);
	}
	
	public double[]  conversionCaP(Complejo n1) {
		double[] var = new double[2];
		var[0] = Math.sqrt(n1.parteReal*n1.parteReal+n1.parteImag*n1.parteImag);
		var[1] = Math.toDegrees(Math.atan(n1.parteImag/n1.parteReal));
		return var;
	}	
	
	
	public static void main(String[] args) {
		Mathemataising calcu = new Mathemataising();
		//calcu.multiplacionQC(new Complejo(5, 4),new Complejo(3, 7));
		//calcu.divisionQC(new Complejo(6, -1),new Complejo(-3,4));		
		calcu.faseQC(new Complejo(7, 11));
		System.out.println((double)Math.toDegrees(Math.atan((double)11/(double)7)));
		//calcu.moduloQC(new Complejo(7, 11));
	}	

}

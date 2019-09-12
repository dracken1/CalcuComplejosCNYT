package Aplicacion;

public class Complejo {
	double parteReal;
	double parteImag;
	String signoIma;
	double parteImaConju;


	public Complejo(double r, double ima) {
		// constructor stub
		 parteImag = ima;
		 parteReal = r;
		 if(ima < 0) {
			 signoIma = "-";
		 }else {
			 signoIma = "+";
		 }	
		 parteImaConju = parteImag*(-1);
	}	
	
	
	public double getParteReal() {
		return parteReal;
	}
	
	
	public void setParteReal(double parteReal) {
		this.parteReal = parteReal;
	}
	
	
	public double getParteImag() {
		return parteImag;
	}
	
	
	public void setParteImag(double parteImag) {
		this.parteImag = parteImag;
	}


	public String getSignoIma() {
		return signoIma;
	}


	public void setSignoIma(String signoIma) {
		this.signoIma = signoIma;
	}


	public double getParteImaConju() {
		return parteImaConju;
	}


	public void setParteImaConju(double parteImaConju) {
		this.parteImaConju = parteImaConju;
	}	
	
	public boolean equals(Complejo c) {		
		return this.parteReal == c.parteReal && this.parteImag == c.parteImag;
	}
	
}



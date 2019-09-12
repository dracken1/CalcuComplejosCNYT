package Aplicacion;

public class VectorComplejo {
	
	Complejo pos1;
	Complejo pos2;
	
	public VectorComplejo(Complejo c1, Complejo c2) {
		pos1 = c1;
		pos2 = c2;		
	}
	
	public Complejo getPos1() {
		return pos1;
	}
	
	public void setPos1(Complejo pos1) {
		this.pos1 = pos1;
	}
	
	public Complejo getPos2() {
		return pos2;
	}
	
	public void setPos2(Complejo pos2) {
		this.pos2 = pos2;
	}	
}

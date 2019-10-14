package Aplicacion;

public class NumeroComplejo {

    private double realPart;
    private double imaginaryPart;

    private NumeroComplejo(double realPart, double imaginaryPart){
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public static NumeroComplejo newComplexNumberAlgebraicForm(double realPart, double imaginaryPart){
        return new NumeroComplejo(realPart, imaginaryPart);
    }

    public static NumeroComplejo newComplexNumberGraphicForm(double module, Angle angle) {
        return new NumeroComplejo(module * Math.cos(angle.getAngle()*Math.PI/180), module * Math.sin(angle.getAngle()*Math.PI/180));
    }

    public NumeroComplejo sum(NumeroComplejo c){
        return new NumeroComplejo(realPart+c.getRealPart(), imaginaryPart+c.getImaginaryPart());
    }

    public NumeroComplejo rest(NumeroComplejo c){
        return new NumeroComplejo(realPart-c.getRealPart(), imaginaryPart-c.getImaginaryPart());
    }

    public NumeroComplejo multiply(NumeroComplejo c){
        return new NumeroComplejo(realPart*c.getRealPart()-imaginaryPart*c.getImaginaryPart(),
                    realPart*c.getImaginaryPart()+imaginaryPart*c.getRealPart());
    }

    public NumeroComplejo divide(NumeroComplejo c){
        double div = Math.pow(c.getRealPart(),2)+Math.pow(c.getImaginaryPart(),2);
        return new NumeroComplejo((realPart*c.getRealPart()+imaginaryPart*c.getImaginaryPart())/div,
                    (imaginaryPart*c.getRealPart()-realPart*c.getImaginaryPart())/div);
    }

    public NumeroComplejo inverse(){
        return new NumeroComplejo(-realPart, -imaginaryPart);
    }

    public NumeroComplejo power(int n){
        NumeroComplejo resultado = NumeroComplejo.newComplexNumberAlgebraicForm(realPart, imaginaryPart);
        for(int i = 0; i<n-1; i++){
            resultado = resultado.multiply(resultado);
        }
        return  resultado;
    }

    public Double norm(){
        return Math.sqrt(Math.pow(realPart,2)+Math.pow(imaginaryPart,2));
    }

    public boolean equals(NumeroComplejo c){
        return realPart == c.getRealPart() && imaginaryPart == c.getImaginaryPart();
    }
    public NumeroComplejo multiplyEscalar(double num){
        return new NumeroComplejo(realPart*num, imaginaryPart*num);
    }

    public double getRealPart() {
        return realPart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    public double getModule(){
        return Math.sqrt(Math.pow(realPart,2)+Math.pow(imaginaryPart,2));
    }

    public Angle getAngle(){
        return new Angle((Math.atan(imaginaryPart/realPart)*180/Math.PI));
    }

    public NumeroComplejo conjugate(){ return new NumeroComplejo(realPart, -imaginaryPart);}

    @Override
    public String toString() {
        return "main.ComplexNumber{" +
                "realPart=" + realPart +
                ", imaginaryPart=" + imaginaryPart +
                '}';
    }
}

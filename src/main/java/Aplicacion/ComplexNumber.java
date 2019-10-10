package Aplicacion;

public class ComplexNumber {

    private double realPart;
    private double imaginaryPart;

    private ComplexNumber(double realPart, double imaginaryPart){
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public static ComplexNumber newComplexNumberAlgebraicForm(double realPart, double imaginaryPart){
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public static ComplexNumber newComplexNumberGraphicForm(double module, Angle angle) {
        return new ComplexNumber(module * Math.cos(angle.getAngle()*Math.PI/180), module * Math.sin(angle.getAngle()*Math.PI/180));
    }

    public ComplexNumber sum(ComplexNumber c){
        return new ComplexNumber(realPart+c.getRealPart(), imaginaryPart+c.getImaginaryPart());
    }

    public ComplexNumber rest(ComplexNumber c){
        return new ComplexNumber(realPart-c.getRealPart(), imaginaryPart-c.getImaginaryPart());
    }

    public ComplexNumber multiply(ComplexNumber c){
        return new ComplexNumber(realPart*c.getRealPart()-imaginaryPart*c.getImaginaryPart(),
                    realPart*c.getImaginaryPart()+imaginaryPart*c.getRealPart());
    }

    public ComplexNumber divide(ComplexNumber c){
        double div = Math.pow(c.getRealPart(),2)+Math.pow(c.getImaginaryPart(),2);
        return new ComplexNumber((realPart*c.getRealPart()+imaginaryPart*c.getImaginaryPart())/div,
                    (imaginaryPart*c.getRealPart()-realPart*c.getImaginaryPart())/div);
    }

    public ComplexNumber inverse(){
        return new ComplexNumber(-realPart, -imaginaryPart);
    }

    public ComplexNumber power(int n){
        ComplexNumber resultado = ComplexNumber.newComplexNumberAlgebraicForm(realPart, imaginaryPart);
        for(int i = 0; i<n-1; i++){
            resultado = resultado.multiply(resultado);
        }
        return  resultado;
    }

    public Double norm(){
        return Math.sqrt(Math.pow(realPart,2)+Math.pow(imaginaryPart,2));
    }

    public boolean equals(ComplexNumber c){
        return realPart == c.getRealPart() && imaginaryPart == c.getImaginaryPart();
    }
    public ComplexNumber multiplyEscalar(double num){
        return new ComplexNumber(realPart*num, imaginaryPart*num);
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

    public ComplexNumber conjugate(){ return new ComplexNumber(realPart, -imaginaryPart);}

    @Override
    public String toString() {
        return "main.ComplexNumber{" +
                "realPart=" + realPart +
                ", imaginaryPart=" + imaginaryPart +
                '}';
    }
}

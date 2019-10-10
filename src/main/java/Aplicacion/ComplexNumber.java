package Aplicacion;

public class ComplexNumber {

    private double realPart;
    private double imaginaryPart;

    private ComplexNumber(double realPart, double imaginaryPart){
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    /**
     * New Complex Number with real and imaginary parts
     * @param realPart Real part
     * @param imaginaryPart Imaginary Part
     * @return
     */
    public static ComplexNumber newComplexNumberAlgebraicForm(double realPart, double imaginaryPart){
        return new ComplexNumber(realPart, imaginaryPart);
    }

    /**
     * New Complex Number with module and angle
     * @param module module of the complex number
     * @param angle angle of the compplex number
     * @return
     */
    public static ComplexNumber newComplexNumberGraphicForm(double module, Angle angle) {
        return new ComplexNumber(module * Math.cos(angle.getAngle()*Math.PI/180), module * Math.sin(angle.getAngle()*Math.PI/180));
    }

    /**
     * Sums two number complex
     * @param c the other complex number
     * @return
     */
    public ComplexNumber sum(ComplexNumber c){
        return new ComplexNumber(realPart+c.getRealPart(), imaginaryPart+c.getImaginaryPart());
    }

    /**
     * Rests two number complex
     * @param c the other complex number
     * @return
     */
    public ComplexNumber rest(ComplexNumber c){
        return new ComplexNumber(realPart-c.getRealPart(), imaginaryPart-c.getImaginaryPart());
    }

    /**
     * Multiplys two complex numbers
     * @param c the other complex number
     * @return
     */
    public ComplexNumber multiply(ComplexNumber c){
        return new ComplexNumber(realPart*c.getRealPart()-imaginaryPart*c.getImaginaryPart(),
                    realPart*c.getImaginaryPart()+imaginaryPart*c.getRealPart());
    }

    /**
     * Divides two complex numbers
     * @param c the other complex number
     * @return
     */
    public ComplexNumber divide(ComplexNumber c){
        double div = Math.pow(c.getRealPart(),2)+Math.pow(c.getImaginaryPart(),2);
        return new ComplexNumber((realPart*c.getRealPart()+imaginaryPart*c.getImaginaryPart())/div,
                    (imaginaryPart*c.getRealPart()-realPart*c.getImaginaryPart())/div);
    }

    /**
     * The inverse of the number
     * @return The inverse of the number
     */
    public ComplexNumber inverse(){
        return new ComplexNumber(-realPart, -imaginaryPart);
    }

    /**
     * Returns the power of the complex number
     * @param n the power
     * @return the power to the n
     */
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

    /**
     * look if two complex numberws are equal
     * @param c the other complex number
     * @return
     */
    public boolean equals(ComplexNumber c){
        return realPart == c.getRealPart() && imaginaryPart == c.getImaginaryPart();
    }

    /**
     * Multiplys by a escalar
     * @param num number excalar
     * @return new complex number multiplied
     */
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

    /**
     * Returns the conjugate of the Complex Number
     * @return
     */
    public ComplexNumber conjugate(){ return new ComplexNumber(realPart, -imaginaryPart);}

    @Override
    public String toString() {
        return "main.ComplexNumber{" +
                "realPart=" + realPart +
                ", imaginaryPart=" + imaginaryPart +
                '}';
    }
}

package Aplicacion;

public class ComplexException extends Exception{
    public static final String BADSIZE = "The size of both matrizes are not compatible to this operation";

    public ComplexException(String message){
        super(message);
    }
}

package Exceptions;

public class NegativeAgeException extends Exception{
    public NegativeAgeException(String errorMessage){
        super(errorMessage);
    }
}

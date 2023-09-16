package org.example.exceptions;

/**
 * Causing by searching not-existing element into StringArray
 */
public class WrongSearchingArgumentException extends IllegalArgumentException{
    public WrongSearchingArgumentException(){
        super();
    }
    public WrongSearchingArgumentException(String msg){
        super(msg);
    }
}

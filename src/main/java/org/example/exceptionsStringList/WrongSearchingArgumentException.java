package org.example.exceptionsStringList;

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

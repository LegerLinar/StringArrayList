package org.example.exceptions;

public class IndexOutOfStringArrayException extends IndexOutOfBoundsException{
    public IndexOutOfStringArrayException(String msg){
        super(msg);
    }
    public IndexOutOfStringArrayException(){
        super();
    }
}

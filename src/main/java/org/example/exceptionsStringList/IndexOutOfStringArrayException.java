package org.example.exceptionsStringList;

public class IndexOutOfStringArrayException extends IndexOutOfBoundsException{
    public IndexOutOfStringArrayException(String msg){
        super(msg);
    }
    public IndexOutOfStringArrayException(){
        super();
    }
}

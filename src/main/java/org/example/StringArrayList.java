package org.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class StringArrayList implements StringList{
    private String[] EMPTY_STRING_DATA = {};
    private String[] stringData;
    private int DEFAULT_CAPACITY = 10;
    private int size;


    public StringArrayList(){
        this.stringData = EMPTY_STRING_DATA;
    }

    public StringArrayList(int initialValue){
        this.stringData = new String[initialValue];
    }

    public StringArrayList(String[] basedArray){
        this.stringData = Arrays.copyOf(basedArray, basedArray.length);
    }
    @Override
    public String add(String item) {
        return null;
    }

    @Override
    public String add(int index, String item) {
        return null;
    }

    @Override
    public String set(int index, String item) {
        return null;
    }

    @Override
    public String remove(String item) {
        return null;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public boolean contains(String item) {
        return false;
    }

    @Override
    public int indexOf(String item) {
        return 0;
    }

    @Override
    public int lastIndexOf(String id) {
        return 0;
    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public boolean equals(StringList otherList) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String[] toArray() {
        return new String[0];
    }
}

package org.example;

import org.example.exceptions.IndexOutOfStringArrayException;
import org.example.exceptions.NullStringArrayException;
import org.example.exceptions.NullStringDataException;
import org.example.exceptions.WrongSearchingArgumentException;

import java.util.Arrays;

public class StringArrayList implements StringList {
    private String[] EMPTY_STRING_DATA = {};
    private String[] stringData;
    private int DEFAULT_CAPACITY = 10;
    private int size;


    public StringArrayList(String item) {
        isNullString(item);
        this.stringData = new String[1];
        stringData[0] = item;
        size = stringData.length;
    }

//    public StringArrayList(int initialValue){
//        this.stringData = new String[initialValue];
//    }

    public StringArrayList(String[] basedArray) {
        System.arraycopy(basedArray, 0, stringData, 0, basedArray.length);
        size = basedArray.length;
    }


    @Override
    public String add(String item) {
        isNullString(item);
        grow();
        String[] curData = stringData;
        System.arraycopy(curData, 0, stringData, 0, size);
        stringData[size - 1] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        isNullString(item);
        indexChecker(index);
        String[] curData = this.stringData;
        grow();
        System.arraycopy(curData, index, stringData, index + 1, curData.length - index);
//        String[] leftSide = Arrays.copyOf(stringData, index);

//        System.arraycopy(leftSide, 0, tempData, 0, leftSide.length);
//        System.arraycopy(stringData, index + 1, tempData, index, ((size - index) - 1));
        stringData[index] = item;
        return item;
    }

    @Override
    public String set(int index, String item) {
        isNullString(item);
        indexChecker(index);
        stringData[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        if (item == null) {
            throw new WrongSearchingArgumentException();
        }
        boolean isContains = false;
        int index = 0;
        for (String stringElement : stringData) {
            if (stringElement.equals(item)) {
                isContains = true;
                break;
            }
            index++;
        }
        if (isContains) {
            remove(index);
        } else {
            throw new WrongSearchingArgumentException("No such element in the list");
        }
        return item;
    }

    @Override
    public String remove(int index) {
        indexChecker(index);
        //Проверка на наличие индекса
        String item = stringData[index];
        String[] tempData = new String[stringData.length - 1];

        if (index == 0) {
            System.arraycopy(stringData, index + 1, tempData, index, size - 1);
        } else if (index == stringData.length - 1) {
            tempData = Arrays.copyOf(stringData, index);
        } else {
            String[] leftSide = Arrays.copyOf(stringData, index);

            System.arraycopy(leftSide, 0, tempData, 0, leftSide.length);
            System.arraycopy(stringData, index + 1, tempData, index, ((size - index) - 1));
        }
        stringData = tempData;
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        ;
        boolean isContains = false;
        for (String stringElement : stringData) {
            if (stringElement.equals(item)) {
                isContains = true;
                break;
            }
        }
        return isContains;
    }

    @Override
    public int indexOf(String item) {
        boolean isContains = false;
        int index = 0;
        for (String stringElement : stringData) {
            if (stringElement.equals(item)) {
                isContains = true;
                break;
            }
            index++;
        }
        if (isContains) {
            return index;
        } else {
            return -1;
        }
    }

    @Override
    public int lastIndexOf(String item) {
        boolean isContains = false;
        int reverseIndex = stringData.length - 1;
        for (; reverseIndex >= 0; ) {
            if (stringData[reverseIndex].equals(item)) {
                isContains = true;
                break;
            }
            reverseIndex--;
        }
        if (isContains) {
            return reverseIndex;
        } else {
            return -1;
        }
    }

    @Override
    public String get(int index) {
        indexChecker(index);
//        Проверка индекса
        return stringData[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new NullStringArrayException();
        }
        if (size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!stringData[i].equals(otherList.get(i))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        stringData = EMPTY_STRING_DATA;
    }

    @Override
    public String[] toArray() {
        String[] arrayOfString = new String[stringData.length];
        for (int i = 0; i < stringData.length; i++) {
            arrayOfString[i] = get(i);
        }
        return arrayOfString;
    }

    private void indexChecker(int index) {
        if (index > stringData.length || index < 0) throw new IndexOutOfStringArrayException();
    }

    private void isNullString(String item) {
        if (item == null) throw new NullStringDataException();
    }

    private void grow() {
        size++;
        stringData = Arrays.copyOf(stringData, size);

    }


}

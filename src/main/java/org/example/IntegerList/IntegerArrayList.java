package org.example.IntegerList;

import io.swagger.v3.oas.models.security.SecurityScheme;
import org.example.StringList.StringList;
import org.example.exceptionsIntegerList.NullIntegerArrayException;
import org.example.exceptionsStringList.IndexOutOfStringArrayException;
import org.example.exceptionsStringList.NullStringDataException;
import org.example.exceptionsStringList.WrongSearchingArgumentException;

import java.util.Arrays;

public class IntegerArrayList implements IntegerList {
    private Integer[] EMPTY_INTEGER_DATA = {};
    private Integer[] integerData = {};
    private int size;

    public IntegerArrayList(Integer item) {
        isNullInteger(item);
        this.integerData = new Integer[1];
        integerData[0] = item;
        size = integerData.length;
    }

    public IntegerArrayList(Integer[] basedArray) {
        if (basedArray == null) throw new NullIntegerArrayException();
        integerData = Arrays.copyOf(basedArray, basedArray.length);
        size = integerData.length;
    }

    @Override
    public Integer add(Integer item) {
        isNullInteger(item);
        grow();
        Integer[] curData = integerData;
        System.arraycopy(curData, 0, integerData, 0, size);
        integerData[size - 1] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        isNullInteger(item);
        indexChecker(index);
        Integer[] curData = this.integerData;
        grow();
        System.arraycopy(curData, index, integerData, index + 1, curData.length - index);
        integerData[index] = item;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        isNullInteger(item);
        indexChecker(index);
        integerData[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        if (item == null) {
            throw new WrongSearchingArgumentException();
        }
        boolean isContains = false;
        int index = 0;

        for (Integer integerElement : integerData) {
            if (integerElement.equals(item)) {
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
    public Integer remove(int index) {
        indexChecker(index);
        Integer item = integerData[index];
        Integer[] tempData = new Integer[integerData.length - 1];

        if (index == 0) {
            System.arraycopy(integerData, index + 1, tempData, index, size - 1);
        } else if (index == integerData.length - 1) {
            tempData = Arrays.copyOf(integerData, index);
        } else {
            Integer[] leftSide = Arrays.copyOf(integerData, index);

            System.arraycopy(leftSide, 0, tempData, 0, leftSide.length);
            System.arraycopy(integerData, index + 1,
                    tempData, index, ((size - index) - 1));
        }
        integerData = tempData;
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] tempArray = Arrays.copyOf(integerData, integerData.length);
        sort(tempArray);
        return binarySearch(tempArray, item);
    }

    @Override
    public int indexOf(Integer item) {
        boolean isContains = false;
        int index = 0;
        for (Integer integerElement : integerData) {
            if (integerElement.equals(item)) {
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
    public int lastIndexOf(Integer item) {
        boolean isContains = false;
        int reverseIndex = integerData.length - 1;
        for (; reverseIndex >= 0; ) {
            if (integerData[reverseIndex].equals(item)) {
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
    public Integer get(int index) {
        indexChecker(index);
        return integerData[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            throw new NullIntegerArrayException();
        }
        if (size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!integerData[i].equals(otherList.get(i))) {
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
        integerData = EMPTY_INTEGER_DATA;
    }

    @Override
    public Integer[] toArray() {
        Integer[] arrayOfInteger = new Integer[integerData.length];
        for (int i = 0; i < integerData.length; i++) {
            integerData[i] = get(i);
        }
        return arrayOfInteger;
    }

    @Override
    public void sort(Integer[] arr) {
        mergeSort(arr);
    }

    private void indexChecker(int index) {
        if (index >= integerData.length || index < 0) throw new IndexOutOfStringArrayException();
    }

    private void isNullInteger(Integer item) {
        if (item == null) throw new NullStringDataException();
    }

    private void grow() {
        size++;
        integerData = Arrays.copyOf(integerData, size);

    }

    private void selectiveSort(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElIndex]) {
                    minElIndex = j;
                }
            }
            swapElements(arr, i, minElIndex);
        }
    }

    private void swapElements(Integer[] arr, int indexA, int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;

    }

    private boolean binarySearch(Integer[] arr, int e) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = min + max / 2;
            if (e == arr[mid]) {
                return true;
            }
            if (e < arr[mid]) {
                max = mid - 1;
            }
            if (e > arr[mid]) {
                min = mid + 1;
            }
        }
        return false;
    }

    public static void mergeSort(Integer[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        Integer[] left = new Integer[mid];
        Integer[] right = new Integer[arr.length - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    public static void merge(Integer[] arr, Integer[] left, Integer[] right) {

        int mainP = 0;
        int leftP = 0;
        int rightP = 0;
        while (leftP < left.length && rightP < right.length) {
            if (left[leftP] <= right[rightP]) {
                arr[mainP++] = left[leftP++];
            } else {
                arr[mainP++] = right[rightP++];
            }
        }
        while (leftP < left.length) {
            arr[mainP++] = left[leftP++];
        }
        while (rightP < right.length) {
            arr[mainP++] = right[rightP++];
        }
    }
}

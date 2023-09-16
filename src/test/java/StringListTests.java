import org.example.StringList.StringArrayList;
import org.example.StringList.StringList;
import org.example.exceptions.IndexOutOfStringArrayException;
import org.example.exceptions.NullStringArrayException;
import org.example.exceptions.NullStringDataException;
import org.example.exceptions.WrongSearchingArgumentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringListTests {
    final static String NULL_STRING = null;
    final static String STARTING_VALUE = "Start";
    final static String NORMAL_STRING_1 = "Test1";
    final static String NORMAL_STRING_2 = "Test2";
    final static String NORMAL_STRING_3 = "Test3";
    final static String[] NULL_STRING_LIST = null;

    private StringList out = new StringArrayList(STARTING_VALUE);

    @Test
    public void shouldThrowNullStringDataException() {
        assertThrows(NullStringDataException.class,
                () -> new StringArrayList(NULL_STRING));
    }

    @Test
    public void shouldThrowNullStringArrayException() {
        assertThrows(NullStringArrayException.class,
                () -> new StringArrayList(NULL_STRING_LIST));
    }

    @Test
    public void shouldAddAnnReturn() {

        String actual = out.add(NORMAL_STRING_1);
        String expected = NORMAL_STRING_1;

        int actualElementIndex = out.indexOf(NORMAL_STRING_1);
        int expectedElementIndex = 1;
        assertEquals(expected, actual);
        assertEquals(expectedElementIndex, actualElementIndex);
    }

    @Test
    public void shouldThrowNullDataException(){
        assertThrows(NullStringDataException.class,
                () -> out.add(NULL_STRING));
    }

    @Test
    public void shouldAddAndReturnByIndex() {
        out.add(NORMAL_STRING_1);
        String actual = out.add(1, NORMAL_STRING_2);
        String expected = NORMAL_STRING_2;

        int actualIndex = out.indexOf(NORMAL_STRING_2);
        int expectedIndex = 1;

        assertEquals(expected, actual);
        assertEquals(expectedIndex, actualIndex);

    }

    @Test
    public void shouldThrowIndexOutOfStringArrayException(){
        assertThrows(NullStringDataException.class,
                () -> out.add(0, NULL_STRING));
        assertThrows(IndexOutOfStringArrayException.class,
                () -> out.add(5, NORMAL_STRING_1));
    }

    @Test
    public void shouldReturnAndSet() {
        out.add(NORMAL_STRING_1);
        out.add(NORMAL_STRING_2);
        String actual = out.set(2, NORMAL_STRING_3);
        String expected = NORMAL_STRING_3;

        int actualIndex = out.indexOf(NORMAL_STRING_3);
        int expectedIndex = 2;

        assertEquals(expected, actual);
        assertEquals(expectedIndex, actualIndex);

    }

    @Test
    public void shouldThrowIndexOutOfStringArray(){
        assertThrows(IndexOutOfStringArrayException.class,
                () -> out.set(5, NORMAL_STRING_1));
    }

    @Test
    public void shouldThrowNullStringData(){
        assertThrows(NullStringDataException.class,
                () -> out.set(0, NULL_STRING));
    }

    @Test
    public void shouldRemoveByItem() {
        out.add(NORMAL_STRING_1);
        String actual = out.remove(NORMAL_STRING_1);
        String expected = NORMAL_STRING_1;

        String[] actualArray = out.toArray();
        String[] expectedArray = {STARTING_VALUE};

        assertEquals(expected, actual);
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void shouldThrowWrongSearchingExc(){
        assertThrows(WrongSearchingArgumentException.class,
                () -> out.remove(NORMAL_STRING_1));
    }

    @Test
    public void shouldRemoveByIndex() {
        out.add(NORMAL_STRING_1);

        String actual = out.remove(1);
        String expected = NORMAL_STRING_1;

        assertEquals(expected, actual);

    }

    @Test
    public void shouldThrowIndexOutExc(){
        assertThrows(IndexOutOfStringArrayException.class,
                () -> out.remove(1));
    }

    @Test
    public void shouldShowIfContains() {
        boolean actual = out.contains(STARTING_VALUE);

        String[] actualArray = out.toArray();
        String[] expectedArray = {STARTING_VALUE};

        assertTrue(actual);
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void shouldReturnIndexOf() {
        out.add(NORMAL_STRING_1);
        out.add(NORMAL_STRING_2);
        out.add(NORMAL_STRING_1);
        out.add(NORMAL_STRING_2);

        int actual = out.indexOf(NORMAL_STRING_2);
        int expected = 2;

        int actualNotFound = out.indexOf(NORMAL_STRING_3);
        int expectedNotFound = -1;

        assertEquals(expected, actual);
        assertEquals(expectedNotFound,actualNotFound);

    }

    @Test
    public void shouldReturnLastIndexOf() {
        out.add(NORMAL_STRING_1);
        out.add(NORMAL_STRING_2);
        out.add(NORMAL_STRING_1);
        out.add(NORMAL_STRING_2);

        int actual = out.lastIndexOf(NORMAL_STRING_2);
        int expected = 4;

        int actualNotFound = out.lastIndexOf(NORMAL_STRING_3);
        int expectedNotFound = -1;

        assertTrue(actual == expected);
        assertEquals(expectedNotFound,actualNotFound);

    }

    @Test
    public void shouldGetByIndex() {
        out.add(NORMAL_STRING_1);
        out.add(NORMAL_STRING_2);
        out.add(NORMAL_STRING_3);

        String actual = out.get(2);
        String expected = NORMAL_STRING_2;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowWrongIndexExc(){
        assertThrows(IndexOutOfStringArrayException.class,
                () -> out.get(2));
    }

    @Test
    public void shouldShowIfEquals() {
        out.add(NORMAL_STRING_1);

        StringList actual = out;

        String[] basedArray = {STARTING_VALUE
                , NORMAL_STRING_1};

        StringList expected = new StringArrayList(basedArray);

        assertTrue(actual.equals(expected));
    }

    @Test
    public void shouldReturnSize() {
        int actual = out.size();
        int expected = 1;

        assertEquals(expected,actual);
    }

    @Test
    public void shouldShowIfEmpty() {
        out.remove(0);
        assertTrue(out.isEmpty());
    }

    @Test
    public void shouldClear() {
        out.clear();
        String[] actual = out.toArray();
        String[] expected = {};

        assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldReturnArray() {
        String[] actual = out.toArray();
        String[] expected = {STARTING_VALUE};

        assertArrayEquals(expected,actual);
    }
}

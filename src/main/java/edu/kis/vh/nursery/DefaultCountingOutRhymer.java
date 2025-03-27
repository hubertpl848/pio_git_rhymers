package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    public static final int CAPPACITY = 12;
    public static final int RETURN1 = -1;
    public static final int RETURN2 = -1;
    final private int[] numbers = new int[CAPPACITY];


    final static int LOOPS = 4;

    final static int FIRST = -1;
    final static int SECOND  = 11;
    public int total = FIRST;

    public int getTotal() {
        return total;
    }


    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    public boolean callCheck() {
        return total == FIRST;
    }

    public boolean isFull() {
        return total == SECOND;
    }

    protected int peekaboo() {
        if (callCheck())
            return RETURN1;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return RETURN2;
        return numbers[total--];
    }

    public int[] getNumbers() {
        return numbers;
    }
}

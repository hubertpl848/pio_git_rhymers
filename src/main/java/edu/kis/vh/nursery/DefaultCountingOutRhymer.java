package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    public static final int CAPPACITY = 12;
    public static final int RETURN1 = -1;
    public static final int RETURN2 = -1;
    private int[] numbers = new int[CAPPACITY];

    public int getTotal() {
        return total;
    }

    private int total = -1;

    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    public boolean callCheck() {
        return total == -1;
    }

    public boolean isFull() {
        return total == 11;
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

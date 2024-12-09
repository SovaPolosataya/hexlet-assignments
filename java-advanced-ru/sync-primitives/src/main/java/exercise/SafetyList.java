package exercise;

import java.util.Arrays;

class SafetyList {
    // BEGIN
    private int[] numbers = new int[0];

    SafetyList() {
        this.numbers = numbers;
    }

    public synchronized void add(int number) {
        int[] newNumbers = Arrays.copyOf(numbers, numbers.length + 1);
        newNumbers[numbers.length] = number;
        numbers = newNumbers;
    }

    public int get(int index) {
        return numbers[index];
    }

    public int getSize() {
        return numbers.length;
    }
    // END
}

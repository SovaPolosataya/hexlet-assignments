package exercise;

import java.util.Arrays;

class SafetyList {
    // BEGIN
    private int[] numbers = new int[10];
    private int size;

//    SafetyList() {
//        this.numbers = numbers;
//    }

    public synchronized void add(int number) {
//        int[] newNumbers = Arrays.copyOf(numbers, numbers.length + 1);
//        newNumbers[numbers.length] = number;
//        numbers = newNumbers;
        if (numbers.length == size) {
            int[] newNumbers = new int[numbers.length * 2];
            System.arraycopy(numbers, 0, newNumbers, 0, numbers.length);
            numbers = newNumbers;
        }

        numbers[size++] = number;
    }

    public int get(int index) {
        return numbers[index];
    }

    public int getSize() {
//        return numbers.length;
        return size;
    }
    // END
}

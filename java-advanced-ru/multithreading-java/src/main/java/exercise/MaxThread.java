package exercise;

// BEGIN
class MaxThread extends Thread {

    private int number = Integer.MIN_VALUE;
    private int[] nums;

    MaxThread(int[] numbers) {
        this.nums = numbers;
    }

    @Override
    public void run() {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > number) {
                number = nums[i];
            }
        }
    }

    public int getMax() {
        return number;
    }
}
// END

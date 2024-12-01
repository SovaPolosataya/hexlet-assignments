package exercise;

// BEGIN
class MinThread extends Thread {

    private int number = Integer.MAX_VALUE;
    private int[] nums;

    MinThread(int[] numbers) {
        this.nums = numbers;
    }

    @Override
    public void run() {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < number) {
                number = nums[i];
            }
        }
    }

    public int getMin() {
        return number;
    }
}
// END

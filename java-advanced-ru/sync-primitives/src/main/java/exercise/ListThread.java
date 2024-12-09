package exercise;

// BEGIN
class ListThread extends Thread {
    private SafetyList safetyList;

    ListThread(SafetyList safetyList) {
        this.safetyList = safetyList;
    }

    @Override
    public void run() {
        int num = 0;
        for (int i = 0; i < 1000; i++) {
            num = (int)(Math.random() * 100);
            safetyList.add(num);
        }
    }
}
// END

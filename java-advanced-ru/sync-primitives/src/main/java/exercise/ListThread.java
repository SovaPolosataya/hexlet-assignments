package exercise;

// BEGIN
class ListThread extends Thread {
    private SafetyList safetyList;

    ListThread(SafetyList safetyList) {
        this.safetyList = safetyList;
    }

    @Override
    public void run() {
//        int num = 0;
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            num = (int)(Math.random() * 100);
//            safetyList.add(num);
            safetyList.add(i);
        }
    }
}
// END
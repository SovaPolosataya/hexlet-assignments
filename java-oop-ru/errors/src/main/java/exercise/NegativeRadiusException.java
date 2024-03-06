package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {
    private String massage;

    public NegativeRadiusException(String message) {
        this.massage = message;
    }

    public String getMessage() {
        return massage;
    }
}
// END

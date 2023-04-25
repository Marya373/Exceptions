package skelet.Baze;

public class ExceptionGender extends Exception {
    String inputString;

    public ExceptionGender(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Только латинские буквы f или m, а не '" + inputString + "'\n";
    }
}
package skelet.Baze;

public class ExceptionName extends Exception {

    String inputString;

    public ExceptionName(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "ФИО вводить не так: '" + inputString + "'. Только буквы.\n";
    }
}

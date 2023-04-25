package skelet.Baze;

public class ExceptionNumberPhone extends Exception {
    String inputString;

    public ExceptionNumberPhone(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Не понятно " + inputString + " формат телефона 10 цифр без разделителей 8888888888)\n";
    }
}

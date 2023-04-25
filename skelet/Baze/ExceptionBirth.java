package skelet.Baze;

public class ExceptionBirth extends Exception {
    
    String inputString;

    public ExceptionBirth(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Ошибка формата ввода '" + inputString + "', формат 'дд.мм.гггг'.\n";
    }
}
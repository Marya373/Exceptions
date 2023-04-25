package skelet.Baze;

public class ExceptionParsData extends Exception {
    String message;

    public ExceptionParsData(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}

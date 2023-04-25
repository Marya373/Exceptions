import skelet.Communication.Communication;
import skelet.Display.DisplayConsole;
import skelet.Display.Display;

public class Program {
    public static void main(String[] args) {
        Communication<Display> prog = new Communication<Display>(new DisplayConsole());
        prog.start();
    }
}



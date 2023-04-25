package skelet.Display;

import java.util.Scanner;

public class DisplayConsole implements Display {

    private Scanner in = new Scanner(System.in, "IBM866");

    @Override
    public void printOutput(String message) {
        System.out.printf("%s", message);
    }

    @Override
    public String getInput(String message) {
        System.out.printf("%s", message);
        return in.nextLine();
    }

}
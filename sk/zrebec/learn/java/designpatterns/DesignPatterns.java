package sk.zrebec.learn.java.designpatterns;

import java.sql.Array;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DesignPatterns {
    public static void main(String[] args) {


        int inputValue = 0;
        do {
            try {
                System.out.println("What Design pattern do you want to start?");
                System.out.println("1 - Singleton");
                System.out.println("2 - Adapter");
                System.out.println("3 - Flyweight");
                System.out.println("4 - Observer");
                System.out.println("5 - Prototype");
                System.out.println("6 - Factory");
                System.out.println("0 - Exit");
                Scanner input = new Scanner(System.in);
                inputValue = input.nextInt();
                switch (inputValue) {
                    case 1 -> sk.zrebec.learn.java.designpatterns.singleton.Program.main(args);
                    case 2 -> sk.zrebec.learn.java.designpatterns.adapter.Program.main(args);
                    case 3 -> sk.zrebec.learn.java.designpatterns.flyweight.Program.main(args);
                    case 4 -> sk.zrebec.learn.java.designpatterns.observer.Program.main(args);
                    case 5 -> sk.zrebec.learn.java.designpatterns.prototype.Program.main(args);
                    case 6 -> sk.zrebec.learn.java.designpatterns.factory.Program.main(args);
                    case 0 -> System.out.println("Exit the program");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input parameter");
            }
        } while (inputValue != 0);
    }
}
package us.mattgreen;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private final FileOutput outFile = new FileOutput("animals.txt");
    private final FileInput inFile = new FileInput("animals.txt");

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        ArrayList<Talkable> zoo = new ArrayList<>();

        Scanner key = new Scanner(System.in);
        String name = "";
        char input;
        boolean quit = false;
        int micekilled;
        int age;
        boolean friendly = true;

        boolean quitall = false;
        while(!quitall) {
            System.out.println("What is the name of the animal?");
            name = key.nextLine();
            System.out.println("What animal?\n" +
                    "A) Person\n" +
                    "B) Cat\n" +
                    "C) Dog\n");
            input = key.nextLine().toUpperCase().charAt(0);
            try {
                while (!quit) {
                    switch (input) {
                        case ('A'):
                            System.out.println("How many years does " + name + " have?");
                            age = key.nextInt();
                            zoo.add(new Student(age, name));
                            quit = true;
                            break;
                        case ('B'):
                            System.out.println("How many mice has it killed?");
                            micekilled = key.nextInt();
                            zoo.add(new Cat(micekilled, name));
                            quit = true;
                            break;
                        case ('C'):
                            System.out.println("Is " + name + " friendly?(Y/N)");
                            input = key.nextLine().charAt(0);
                            friendly = input == 'Y' ? true : false;
                            zoo.add(new Dog(friendly, name));
                            quit = true;
                            break;
                        default:
                            System.out.println("You did not type an acceptable answer.");
                    }

                }


            } catch (Exception e) {
                System.out.println("You made an error occur because you didn't listen.");
            }
            try {

                for (Talkable thing : zoo) {
                    printOut(thing);
                }
                outFile.fileClose();

                System.out.println("\n*** Reading/printing entire file using fileRead method\n");

                inFile.fileRead();
                inFile.fileClose();

                System.out.println("\n*** Reading/printing one line at a time using fileReadLine method\n");

                FileInput indata = new FileInput("animals.txt");
                String line;
                while ((line = indata.fileReadLine()) != null) {
                    System.out.println(line);
                }

                System.out.println(quitall ? "You have exited the program.":"Now enter another animal!");
            } catch (Exception e) {
                System.out.println("Something went wrong...");
                System.out.println(e);
            }

        }

        // Lines to Replace
        //zoo.add(new Dog(true, "Pete"));
        //zoo.add(new Cat(9, "Anne Belly"));
        //zoo.add(new Student(19, "Joe John Johnson"));
        // End Lines to Replace


    }

    public void printOut(Talkable p) {
        System.out.println(p.getName() + " says = " + p.talk());
        outFile.fileWrite(p.getName() + "|" + p.talk());
    }
}

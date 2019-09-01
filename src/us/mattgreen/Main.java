package us.mattgreen;

import java.util.ArrayList;

public class Main {

    private final FileOutput outFile = new FileOutput("animals.txt");
    private final FileInput inFile = new FileInput("animals.txt");

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        ArrayList<Talkable> zoo = new ArrayList<>();

        // Lines to Replace
        zoo.add(new Dog(true, "Pete"));
        zoo.add(new Cat(9, "Anne Belly"));
        zoo.add(new Student(19, "Joe John Johnson"));
        // End Lines to Replace

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
    }

    public void printOut(Talkable p) {
        System.out.println(p.getName() + " says = " + p.talk());
        outFile.fileWrite(p.getName() + "|" + p.talk());
    }
}

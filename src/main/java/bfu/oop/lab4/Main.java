package bfu.oop.lab4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Keyboard keyboard = new Keyboard();
        keyboard.addCommand("A", new Key("A"));
        keyboard.addCommand("TextCommand", new StringCommand("TextCommand"));
        keyboard.addCommandGroup("Insert", new Group(Arrays.asList(new StringCommand("firstCommand"), new StringCommand("secondCommand"), new StringCommand("thirdCommand"))));
        keyboard.pressKey("TextCommand");
        keyboard.pressKey("A");
        keyboard.pressKey("Insert");
        keyboard.undoLastAction();
        keyboard.undoLastAction();
    }
}


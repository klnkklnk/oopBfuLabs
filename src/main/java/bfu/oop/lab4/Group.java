package bfu.oop.lab4;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private ArrayList<Command> commands;

    public Group(List<Command> commands) {
        this.commands = new ArrayList<>();
        this.commands.addAll(commands);
    }

    public void addCommand(Command command) {
        this.commands.add(command);
    }

    public void undoLastCommand() {
        for (Command command : this.commands) {
            command.undo();
        }
    }

    public void execute() {
        for (Command command : this.commands) {
            command.execute();
        }
    }

    public void undo() {
        this.commands.get(this.commands.size()-1).undo();
        this.commands.remove(this.commands.size() - 1);
    }

    public boolean isEmpty() {
        return this.commands.isEmpty();
    }

    public List<Command> getCommands() {
        return this.commands;
    }

}
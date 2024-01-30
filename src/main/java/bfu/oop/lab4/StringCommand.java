package bfu.oop.lab4;

public class StringCommand extends Command {
    private String data;

    @Override
    public void execute() {
        System.out.println("Print: " + this.data);
    }

    @Override
    public void undo() {
        System.out.println("Undo: " + this.data);
    }

    public StringCommand(String data) {
        this.data = data;
    }
}
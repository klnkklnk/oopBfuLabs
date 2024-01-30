package bfu.oop.lab4;

public class Key extends Command{
    private String name;

    public Key(String name) {
        this.name = name;
    }

    @Override
    public void execute() {
        System.out.println("Print key: " + this.name);
    }

    @Override
    public void undo() {
        System.out.println("Undo key: " + this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

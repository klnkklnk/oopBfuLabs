package bfu.oop.lab6;

public class WindowsLabel extends Control implements Label {
    private String text;


    @Override
    public void setText(String text) {
        System.out.println("Method called from Windows Button");
    }

    @Override
    public String getText() {
        return text;
    }
}

package bfu.oop.lab6;

public class WindowsTextBox extends Control implements TextBox {
    private String text;
    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void onValueChanged() {
        System.out.println("Linux value changed");
    }
}

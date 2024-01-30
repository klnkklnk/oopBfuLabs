package bfu.oop.lab6;

public class WindowsControlFactory implements ControlFactory{
    public WindowsControlFactory() {
        System.out.println("Creating WindowsControlFactory");
    }
    @Override
    public Label createLabel() {
        return new WindowsLabel();
    }

    @Override
    public TextBox createTextBox() {
        return new WindowsTextBox();
    }

    @Override
    public ComboBox createComboBox() {
        return new WindowsComboBox();
    }

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}

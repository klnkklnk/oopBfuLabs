package bfu.oop.lab6;

public class OSControlFactory implements ControlFactory {
    String osName = System.getProperty("os.name").toLowerCase();
    @Override
    public Label createLabel() {
        if (osName.startsWith("windows")) {
            return new WindowsLabel();
        }
        return null;
    }

    @Override
    public TextBox createTextBox() {
        if (osName.startsWith("windows")) {
            return new WindowsTextBox();
        }
        return null;
    }

    @Override
    public ComboBox createComboBox() {
        if (osName.startsWith("windows")) {
            return new WindowsComboBox();
        }
        return null;
    }

    @Override
    public Button createButton() {
        if (osName.startsWith("windows")) {
            return new WindowsButton();
        }
        return null;
    }
}

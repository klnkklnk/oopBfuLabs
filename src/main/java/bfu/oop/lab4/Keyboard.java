package bfu.oop.lab4;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Keyboard {
    private List<Group> history;
    private Map<String, Group> keyboard;
    private Map<String, String> keyMappings;

    public Keyboard() {
        this.history = new ArrayList<>();
        this.keyboard = new HashMap<>();
        this.keyMappings = new HashMap<>();
    }

    public void pressKey(String key) {
        this.keyboard.get(getRemappedKey(key)).execute();
        this.history.add(this.keyboard.get(getRemappedKey(key)));
    }

    public void pressKeyTimeLong(String key, int time) throws InterruptedException {
        TimeUnit.SECONDS.sleep(time);
        this.keyboard.get(getRemappedKey(key)).execute();
    }

    public boolean undoLastAction() {
        if (!this.history.isEmpty()) {
            this.history.get(this.history.size() - 1).undo();
            this.history.remove(this.history.size() - 1);
            return true;
        }
        return false;
    }
    public void remapKey(String originalKey, String newKey) {
        keyMappings.put(originalKey, newKey);
        Group groupCommandText = this.keyboard.get(originalKey);
        this.keyboard.remove(originalKey);
        this.keyboard.put(newKey, groupCommandText);
    }

    public String getRemappedKey(String originalKey) {
        if (keyMappings.containsKey(originalKey)) {
            return keyMappings.get(originalKey);
        }
        return originalKey;
    }

    public void addCommand(String key, Command command)
    {
        if (keyboard.containsKey(getRemappedKey(key))) {
            keyboard.get(getRemappedKey(key)).addCommand(command);
            return;
        }
        this.keyboard.put(key, new Group(Collections.singletonList(command)));
    }

    public void addCommandGroup(String key, Group groupCommand) {
        if (this.keyboard.containsKey(getRemappedKey(key))) {
            for (Command command : groupCommand.getCommands()) {
                this.keyboard.get(getRemappedKey(key)).addCommand(command);
            }
            return;
        }
        this.keyboard.put(getRemappedKey(key), groupCommand);
    }

    public void undoCommand(String key) {
        if(this.keyboard.containsKey(getRemappedKey(key))) {
            this.keyboard.get(getRemappedKey(key)).undo();
            if (this.keyboard.get(getRemappedKey(key)).isEmpty()) {
                this.keyboard.remove(getRemappedKey(key));
            }
        }
    }

}
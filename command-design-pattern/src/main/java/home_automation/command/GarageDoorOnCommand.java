package home_automation.command;

import home_automation.devices.GarageDoor;

public class GarageDoorOnCommand implements SimpleCommand{

    GarageDoor garageDoor;

    public GarageDoorOnCommand(GarageDoor garageDoor){
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }
}

package home_automation.command;

import home_automation.devices.GarageDoor;

public class GarageDoorOffCommand implements SimpleCommand{

    GarageDoor garageDoor;

    public GarageDoorOffCommand(GarageDoor garageDoor){
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.down();
    }
}

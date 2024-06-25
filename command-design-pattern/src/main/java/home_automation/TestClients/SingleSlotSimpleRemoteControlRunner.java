package home_automation.TestClients;

import home_automation.command.GarageDoorOffCommand;
import home_automation.command.GarageDoorOnCommand;
import home_automation.devices.GarageDoor;
import home_automation.remotecontrol.SingleSlotSimpleRemoteControl;

public class SingleSlotSimpleRemoteControlRunner {
    public static void main(String[] args) {
        SingleSlotSimpleRemoteControl control = new SingleSlotSimpleRemoteControl();
        GarageDoor garageDoor = new GarageDoor("Main");
        GarageDoorOnCommand onCommand = new GarageDoorOnCommand(garageDoor);
        control.setCommandToSlot(onCommand);
        control.buttonWasPressed();

        GarageDoorOffCommand offCommand = new GarageDoorOffCommand(garageDoor);
        control.setCommandToSlot(offCommand);
        control.buttonWasPressed();
    }
}

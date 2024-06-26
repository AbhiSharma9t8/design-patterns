package home_automation.TestClients;

import home_automation.command.GarageDoorOffCommand;
import home_automation.command.GarageDoorOnCommand;
import home_automation.command.LightOnCommand;
import home_automation.devices.GarageDoor;
import home_automation.devices.Light;
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

        //The Control#setCommand method expects a command which has only one abstract method
        //Which when implemented by lightOnCommand executes light.on() method
        //therefore in setCommand method we can directly pass a lambda or method::reference
        Light light = new Light("Living room");
        control.setCommandToSlot(()-> light.on()); //lambda
        control.buttonWasPressed();
        control.setCommandToSlot(light::off); // method reference
        control.buttonWasPressed();
    }
}

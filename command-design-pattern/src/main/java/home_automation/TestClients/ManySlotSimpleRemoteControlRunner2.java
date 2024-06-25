package home_automation.TestClients;

import home_automation.command.undo.UNDOLightOffCommand;
import home_automation.command.undo.UNDOLightOnCommand;
import home_automation.devices.Light;
import home_automation.remotecontrol.ManySlotSimpleRemoteControl;

public class ManySlotSimpleRemoteControlRunner2 {
    public static void main(String[] args) {
        ManySlotSimpleRemoteControl control = new ManySlotSimpleRemoteControl(2);
        Light light = new Light("living Room");
        UNDOLightOnCommand lightOnCommand = new UNDOLightOnCommand(light);
        UNDOLightOffCommand lightOffCommand = new UNDOLightOffCommand(light);
        control.setCommands(0,lightOnCommand,lightOffCommand);

        control.onButtonWasPressed(0);
        control.offButtonWasPressed(0);
        control.undoButtonWasPressed();

    }
}

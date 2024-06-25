package home_automation.TestClients;

import home_automation.command.undo.*;
import home_automation.devices.CeilingFan;
import home_automation.remotecontrol.ManySlotSimpleRemoteControl;

public class ManySlotStateSimpleRemoteControlRunner3 {
    public static void main(String[] args) {
        ManySlotSimpleRemoteControl control = new ManySlotSimpleRemoteControl(3);
        CeilingFan ceilingFan = new CeilingFan();

        UNDOCeilingFanHighCommand highCommand = new UNDOCeilingFanHighCommand(ceilingFan);
        UNDOCeilingFanMediumCommand mediumCommand = new UNDOCeilingFanMediumCommand(ceilingFan);
        UNDOCeilingFanLowCommand lowCommand = new UNDOCeilingFanLowCommand(ceilingFan);
        UNDOCeilingFanOffCommand offCommand = new UNDOCeilingFanOffCommand(ceilingFan);

        control.setCommands(0,highCommand,offCommand);
        control.setCommands(1,mediumCommand,offCommand);
        control.setCommands(2,lowCommand,offCommand);

        control.onButtonWasPressed(0);
        control.undoButtonWasPressed();

        control.onButtonWasPressed(2);
        control.undoButtonWasPressed();
    }




}

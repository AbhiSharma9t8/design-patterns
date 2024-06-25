package home_automation.TestClients;

import home_automation.command.MacroCommand;
import home_automation.command.UNDOAbleCommand;
import home_automation.command.undo.UNDOCeilingFanHighCommand;
import home_automation.command.undo.UNDOCeilingFanOffCommand;
import home_automation.command.undo.UNDOLightOffCommand;
import home_automation.command.undo.UNDOLightOnCommand;
import home_automation.devices.CeilingFan;
import home_automation.devices.Light;
import home_automation.remotecontrol.ManySlotSimpleRemoteControl;

public class MacroCommandRunner4 {
    public static void main(String[] args) {
        Light light = new Light("Living Room");
        CeilingFan ceilingFan = new CeilingFan();
        UNDOAbleCommand[] devicesAtAwakeTime = { new UNDOLightOffCommand(light),new UNDOCeilingFanOffCommand(ceilingFan)};
        UNDOAbleCommand[] devicesAtSleepTime = { new UNDOLightOnCommand(light), new UNDOCeilingFanHighCommand(ceilingFan)};
        MacroCommand sleepSetting = new MacroCommand(devicesAtSleepTime);
        MacroCommand awakeSetting = new MacroCommand(devicesAtAwakeTime);
        ManySlotSimpleRemoteControl control = new ManySlotSimpleRemoteControl(1);
        control.setCommands(0,sleepSetting,awakeSetting);
        control.onButtonWasPressed(0);
        control.offButtonWasPressed(0);
        control.undoButtonWasPressed();

    }
}

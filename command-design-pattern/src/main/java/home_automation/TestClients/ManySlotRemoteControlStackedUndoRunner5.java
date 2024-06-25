package home_automation.TestClients;

import home_automation.command.undo.*;
import home_automation.devices.CeilingFan;
import home_automation.devices.Light;
import home_automation.remotecontrol.ManySlotSimpleRemoteControlStackedUndo;

public class ManySlotRemoteControlStackedUndoRunner5 {
    public static void main(String[] args) {
        Light light = new Light("living room");
        CeilingFan ceilingFan = new CeilingFan();
        UNDOLightOnCommand lightOnCommand = new UNDOLightOnCommand(light);
        UNDOLightOffCommand lightOffCommand = new UNDOLightOffCommand(light);

        UNDOCeilingFanOffCommand fanOffCommand = new UNDOCeilingFanOffCommand(ceilingFan);
        UNDOCeilingFanMediumCommand fanMediumCommand = new UNDOCeilingFanMediumCommand(ceilingFan);
        UNDOCeilingFanHighCommand fanHighCommand = new UNDOCeilingFanHighCommand(ceilingFan);

        ManySlotSimpleRemoteControlStackedUndo controlStackedUndo = new ManySlotSimpleRemoteControlStackedUndo(3);
        controlStackedUndo.setCommands(0,lightOnCommand,lightOffCommand);
        controlStackedUndo.setCommands(1,fanHighCommand,fanOffCommand);
        controlStackedUndo.setCommands(2,fanMediumCommand,fanOffCommand);

        //firing slots
        controlStackedUndo.onButtonWasPushed(0);
        controlStackedUndo.onButtonWasPushed(1);
        controlStackedUndo.onButtonWasPushed(2);

        //firing undos
        controlStackedUndo.undoButtonWasPressed();
        controlStackedUndo.undoButtonWasPressed();
        controlStackedUndo.undoButtonWasPressed();
        controlStackedUndo.undoButtonWasPressed();

    }
}

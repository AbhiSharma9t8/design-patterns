package home_automation.remotecontrol;

import home_automation.command.UNDOAbleCommand;

public class ManySlotSimpleRemoteControl {

    UNDOAbleCommand[] onCommands;
    UNDOAbleCommand[] offCommands;
    UNDOAbleCommand undoCommand;

    public ManySlotSimpleRemoteControl(int noOfSlots) {
        onCommands = new UNDOAbleCommand[noOfSlots];
        offCommands = new UNDOAbleCommand[noOfSlots];
        for (int i = 0; i < noOfSlots; i++) {
            onCommands[i] = null;
            offCommands[i] = null;
        }
        undoCommand = null;
    }

    public void setCommands(int slot, UNDOAbleCommand onCommand, UNDOAbleCommand offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPressed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPressed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPressed(){
        undoCommand.undo();
    }

}

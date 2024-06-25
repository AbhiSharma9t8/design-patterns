package home_automation.remotecontrol;

import home_automation.command.UNDOAbleCommand;

import java.util.Stack;

public class ManySlotSimpleRemoteControlStackedUndo {
    UNDOAbleCommand[] onCommands;
    UNDOAbleCommand[] offCommands;
    Stack<UNDOAbleCommand> undoCommandStack;

    public ManySlotSimpleRemoteControlStackedUndo(int noOfSlots){
        onCommands = new UNDOAbleCommand[noOfSlots];
        offCommands = new UNDOAbleCommand[noOfSlots];
        for (int i = 0; i < noOfSlots; i++) {
            onCommands[i] = offCommands[i] = null;
        }
        undoCommandStack = new Stack<>();
    }

    public void setCommands(int slot, UNDOAbleCommand onCommand, UNDOAbleCommand offCommand){
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot){
        onCommands[slot].execute();
        undoCommandStack.push(onCommands[slot]);
    }

    public void offButtonWasPushed(int slot){
        offCommands[slot].execute();
        undoCommandStack.push(offCommands[slot]);
    }

    public void undoButtonWasPressed(){
        while(!undoCommandStack.empty()){
            undoCommandStack.pop().undo();
        }
    }

}

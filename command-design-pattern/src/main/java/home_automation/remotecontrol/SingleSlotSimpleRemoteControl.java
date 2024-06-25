package home_automation.remotecontrol;

import home_automation.command.SimpleCommand;

public class SingleSlotSimpleRemoteControl {

    SimpleCommand slot; //single slot

    public void setCommandToSlot(SimpleCommand command){
        slot = command;
    }

    public void buttonWasPressed(){
        slot.execute();
    }
}

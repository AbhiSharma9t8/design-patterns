package home_automation.command.undo;

import home_automation.command.UNDOAbleCommand;
import home_automation.devices.CeilingFan;

public class UNDOCeilingFanHighCommand implements UNDOAbleCommand {

    CeilingFan ceilingFan;
    int prevSpeed;
    public UNDOCeilingFanHighCommand(CeilingFan ceilingFan){
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
    }

    @Override
    public void undo() {
        switch (prevSpeed){
            case CeilingFan.HIGH -> {
                ceilingFan.high();
            }
            case CeilingFan.MEDIUM -> {
                ceilingFan.medium();
            }
            case CeilingFan.LOW -> {
                ceilingFan.low();
            }
            case CeilingFan.OFF -> {
                ceilingFan.off();
            }
        }
    }
}

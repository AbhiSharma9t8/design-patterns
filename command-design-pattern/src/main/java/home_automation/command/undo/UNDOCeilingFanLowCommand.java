package home_automation.command.undo;

import home_automation.command.UNDOAbleCommand;
import home_automation.devices.CeilingFan;

public class UNDOCeilingFanLowCommand implements UNDOAbleCommand {

    CeilingFan ceilingFan;
    int prevSpeed;
    public UNDOCeilingFanLowCommand(CeilingFan ceilingFan){
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.low();
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

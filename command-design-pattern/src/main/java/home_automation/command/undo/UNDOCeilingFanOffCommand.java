package home_automation.command.undo;

import home_automation.devices.CeilingFan;

public class UNDOCeilingFanOffCommand implements UNDOAbleCommand {

    CeilingFan ceilingFan;
    int prevSpeed;
    public UNDOCeilingFanOffCommand(CeilingFan ceilingFan){
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.off();
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

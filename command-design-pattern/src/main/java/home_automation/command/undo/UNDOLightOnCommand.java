package home_automation.command.undo;

import home_automation.command.UNDOAbleCommand;
import home_automation.devices.Light;

public class UNDOLightOnCommand implements UNDOAbleCommand {

    Light light;
    public UNDOLightOnCommand(Light light){
        this.light = light;
    }
    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}

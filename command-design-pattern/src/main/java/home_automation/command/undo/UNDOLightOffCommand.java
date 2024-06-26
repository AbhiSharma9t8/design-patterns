package home_automation.command.undo;

import home_automation.devices.Light;

public class UNDOLightOffCommand implements UNDOAbleCommand {

    Light light;
    public UNDOLightOffCommand(Light light){
        this.light = light;
    }
    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}

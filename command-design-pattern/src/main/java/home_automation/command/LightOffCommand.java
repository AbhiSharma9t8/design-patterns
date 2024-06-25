package home_automation.command;

import home_automation.devices.Light;

public class LightOffCommand implements SimpleCommand{

    Light  light;

    public LightOffCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}

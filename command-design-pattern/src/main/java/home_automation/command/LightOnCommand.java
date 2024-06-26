package home_automation.command;

import home_automation.devices.Light;

public class LightOnCommand implements SimpleCommand{

    Light  light;

    public LightOnCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

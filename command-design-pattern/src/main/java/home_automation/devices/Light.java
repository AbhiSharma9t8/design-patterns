package home_automation.devices;

public class Light {
    String location;
    public Light(String location){
        this.location = location;
    }

    public void on(){
        System.out.println("%s light in ON".formatted(location));
    }

    public void off(){
        System.out.println("%s light in off".formatted(location));
    }
}

package home_automation.devices;

public class GarageDoor {
    String location;
    Light light = new Light("Garage");
    public GarageDoor(String location){
        this.location = location;
    }

    public void up(){
        lightOn();
        System.out.println("Garage Door is opening up");
        stop();
    }

    public void down(){
        lightOff();
        System.out.println("Garage Door is closing down");
        stop();
    }

    private void lightOff() {
        light.off();
    }

    private void lightOn() {
        light.on();
    }

    private void stop() {
        System.out.println("Garage Door is stopped moving");
    }

}

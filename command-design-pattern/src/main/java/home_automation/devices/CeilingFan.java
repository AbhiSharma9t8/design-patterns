package home_automation.devices;

public class CeilingFan {
    public static final int HIGH = 4;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;

    int speed;

    public CeilingFan(){
        speed =OFF; // always creating new fan in OFF state
    }

    public void high(){
        speed = HIGH;
        System.out.println("Fan moving at HIGH speed");
    }

    public void medium(){
        speed = MEDIUM;
        System.out.println("Fan moving at MEDIUM speed");
    }

    public void low(){
        speed = LOW;
        System.out.println("Fan moving at LOW speed");
    }

    public void off(){
        speed = OFF;
        System.out.println("Fan Stopped Moving");
    }

    public int getSpeed() {
        return speed;
    }
}

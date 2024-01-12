package Dahinh;

public class Animal {
    protected int speed;

    void run(){System.out.println("running");}
    public Animal(int speed){
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

package hardware;

public class Car {
    private int velocity;
    private int position;

    public Car(int velocity) {
        this(velocity, 0);
    }

    public Car(int velocity, int position) {
        this.velocity = velocity;
        this.position = position;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getVelocity() {
        return velocity;
    }

    public int getPosition() {
        return position;
    }
}

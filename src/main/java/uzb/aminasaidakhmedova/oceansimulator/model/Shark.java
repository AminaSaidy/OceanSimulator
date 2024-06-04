package uzb.aminasaidakhmedova.oceansimulator.model;

public class Shark {

    private int energy = 100;
    private int health = 100;
    private final double FANGS = 2.0;

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return this.energy;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }
}

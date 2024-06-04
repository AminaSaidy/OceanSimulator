package uzb.aminasaidakhmedova.oceansimulator._main;

import uzb.aminasaidakhmedova.oceansimulator.model.Shark;
import uzb.aminasaidakhmedova.oceansimulator.util.EventSimulator;

public class _Main {
    public static void main(String[] args) {
        Shark shark = new Shark();
        EventSimulator eventSimulator = new EventSimulator();
        eventSimulator.startSimulator(shark);
    }

}

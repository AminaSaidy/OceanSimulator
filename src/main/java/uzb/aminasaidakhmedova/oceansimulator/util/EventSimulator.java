package uzb.aminasaidakhmedova.oceansimulator.util;

import uzb.aminasaidakhmedova.oceansimulator.model.Shark;

public class EventSimulator {

    /*
    1-25 sleep -> +12 energy
    25-40 ate a seagull-> -5 energy, +FANGS*2 hp
    40-52 ate a dolphin -> -8 energy, +FANGS*5 hp
    52-60 hit with a harpoon -> -10 hp
    60-77 stuck in reefs -> -10 energy;
    77-90 broke a boat -> -10 energy; 1-40 there are people -> eat -> -6 energy +FANGS*5 hp; 40-100 no ppl, nothing
    90-99 caught by hunters: if energy>15 ->escaped -> -10 energy, -5 hp; else -> dead
    99-100 got eaten by a whale -> dead
    */

    //if energy = 0 -> -5 hp; if hp = 0 -> dead

    private void sleepEvent(Shark shark) {
        int energy = shark.getEnergy();
        energy += 12;
        if (energy > 100) {
            energy = 100;
        }
        shark.setEnergy(energy);
    }

    private void eatSeagull(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy -= 5;
        health += (shark.getFANGS() * 2);
        shark.setEnergy(energy);
        shark.setHealth(health);
    }

    private void eatDolphin(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy -= 8;
        health += (shark.getFANGS() * 5);
        shark.setEnergy(energy);
        shark.setHealth(health);
    }

    private void attackByHarpoon(Shark shark) {
        int health = shark.getHealth();
        health -= 10;
        shark.setHealth(health);
    }

    private void stuckInReefs(Shark shark) {
        int energy = shark.getEnergy();
        energy -= 10;
        shark.setEnergy(energy);
    }
}

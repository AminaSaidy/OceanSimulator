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

    public void startSimulator(Shark shark) {
        while (checkStatus(shark)) {
            int eventNumber = (int) (Math.random() * 100);
            if (eventNumber >= 0 && eventNumber < 25) {
                sleepEvent(shark);
            } else if (eventNumber >= 25 && eventNumber < 40) {
                eatSeagull(shark);
            } else if (eventNumber >= 40 && eventNumber < 52) {
                eatDolphin(shark);
            } else if (eventNumber >= 52 && eventNumber < 60) {
                attackByHarpoon(shark);
            } else if (eventNumber >= 60 && eventNumber < 77) {
                stuckInReefs(shark);
            } else if (eventNumber >= 77 && eventNumber < 90) {
                attackBoat(shark);
            } else if (eventNumber >= 90 && eventNumber < 99) {
                caughtByHunters(shark);
            } else if (eventNumber >= 99 && eventNumber <= 100) {
                eatenByWhale(shark);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("Shark died... RIP");
    }

    private void sleepEvent(Shark shark) {
        int energy = shark.getEnergy();
        energy += 12;
        if (energy > 100) {
            energy = 100;
        }
        shark.setEnergy(energy);
        checkEnergy(shark);
        checkStatus(shark);
        System.out.println("Shark slept for a while. Current energy: " + shark.getEnergy() + " Current health: " + shark.getHealth());
    }

    private void eatSeagull(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy -= 5;
        health += (shark.getFANGS() * 2);
        if (health > 100) {
            health = 100;
        }
        shark.setEnergy(energy);
        shark.setHealth(health);
        checkEnergy(shark);
        checkStatus(shark);
        System.out.println("Shark ate a seagull. Current energy: " + shark.getEnergy() + " Current health: " + shark.getHealth());
    }

    private void eatDolphin(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy -= 8;
        health += (shark.getFANGS() * 5);
        if (health > 100) {
            health = 100;
        }
        shark.setEnergy(energy);
        shark.setHealth(health);
        checkEnergy(shark);
        checkStatus(shark);
        System.out.println("Shark ate a dolphin. Current energy: " + shark.getEnergy() + " Current health: " + shark.getHealth());
    }

    private void attackByHarpoon(Shark shark) {
        int health = shark.getHealth();
        health -= 10;
        shark.setHealth(health);
        checkStatus(shark);
        System.out.println("Shark was attacked by a harpoon. Current energy: " + shark.getEnergy() + " Current health: " + shark.getHealth());
    }

    private void stuckInReefs(Shark shark) {
        int energy = shark.getEnergy();
        energy -= 10;
        shark.setEnergy(energy);
        checkEnergy(shark);
        checkStatus(shark);
        System.out.println("Shark stuck in reefs. Current energy: " + shark.getEnergy() + " Current health: " + shark.getHealth());
    }

    private void attackBoat(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy -= 10;
        int eatPeople = (int) (Math.random() * 100);
        if (eatPeople >= 0 && eatPeople < 40) {
            energy -= 6;
            health += (shark.getFANGS() * 5);
            if (health > 100) {
                health = 100;
            }
            shark.setEnergy(energy);
            shark.setHealth(health);
            System.out.println("Shark attacked a boat and ate people from there. Current energy: " + shark.getEnergy() + " Current health: " + shark.getHealth());
        } else {
            shark.setEnergy(energy);
            shark.setHealth(health);
            System.out.println("Shark attacked a boat, but there were no people. Current energy: " + shark.getEnergy() + " Current health: " + shark.getHealth());
        }
        checkEnergy(shark);
        checkStatus(shark);
    }

    private void caughtByHunters(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        if (energy > 15) {
            energy -= 10;
            health -= 5;
            shark.setEnergy(energy);
            shark.setHealth(health);
            System.out.println("Shark was caught by hunters and escaped. Current energy: " + shark.getEnergy() + " Current health: " + shark.getHealth());
        } else {
            energy = 0;
            health = 0;
            shark.setEnergy(energy);
            shark.setHealth(health);
            System.out.println("Shark was caught by hunters and couldn't escape.");
        }
        checkEnergy(shark);
        checkStatus(shark);
    }

    private void eatenByWhale(Shark shark) {
        shark.setEnergy(0);
        shark.setHealth(0);
        System.out.println("Shark was eaten by a whale.");
        checkStatus(shark);
    }

    private boolean checkStatus(Shark shark) {
        if (shark.getHealth() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    private void checkEnergy(Shark shark) {
        int health = shark.getHealth();
        if (shark.getEnergy() <= 0) {
            health -= 5;
        }
        if (health < 0) {
            health = 0;
        }
    }
}


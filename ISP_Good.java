interface FeatheredCreature {
    void molt();
}

interface FlyingCreature {
    void fly();
}

interface SwimmingCreature {
    void swim();
}

class Eagle implements FlyingCreature, FeatheredCreature {
    String currentLocation;
    int numberOfFeathers;

    Eagle(int initialNumberOfFeathers) {
        numberOfFeathers = initialNumberOfFeathers;
    }

    public void fly() {
        currentLocation = "in the air";
    }

    public void molt() {
        numberOfFeathers -= 1;
    }
}

class Penguin implements SwimmingCreature, FeatheredCreature {
    String currentLocation;
    int numberOfFeathers;

    Penguin(int initialNumberOfFeathers) {
        numberOfFeathers = initialNumberOfFeathers;
    }

    public void swim() {
        currentLocation = "in the water";
    }

    public void molt() {
        numberOfFeathers -= 2;
    }
}

public class Main {
    public static void main(String[] args) {
        FlyingCreature eagle = new Eagle(100);
        SwimmingCreature penguin = new Penguin(50);

        eagle.fly();
        penguin.swim();
        penguin.molt();

        System.out.println("Eagle location: " + ((Eagle) eagle).currentLocation);
        System.out.println("Penguin location: " + ((Penguin) penguin).currentLocation);
        System.out.println("Penguin feather count: " + ((Penguin) penguin).numberOfFeathers);
    }
}

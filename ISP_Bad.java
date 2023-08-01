interface Bird {
    void fly();
    void molt();
}

class Eagle implements Bird {
    String currentLocation;
    int numberOfFeathers;

    Eagle(int initialFeatherCount) {
        numberOfFeathers = initialFeatherCount;
    }

    public void fly() {
        currentLocation = "in the air";
    }

    public void molt() {
        numberOfFeathers -= 1;
    }
}

class Penguin implements Bird {
    String currentLocation;
    int numberOfFeathers;

    Penguin(int initialFeatherCount) {
        numberOfFeathers = initialFeatherCount;
    }

    public void molt() {
        numberOfFeathers -= 1;
    }

    public void swim() {
        currentLocation = "in the water";
    }

    public void fly() {
        throw new UnsupportedOperationException();
    }
}

public class Main {
    public static void main(String[] args) {
        Bird eagle = new Eagle(100);
        Bird penguin = new Penguin(50);

        eagle.fly();
        penguin.swim();
        penguin.molt();

        System.out.println("Eagle location: " + ((Eagle) eagle).currentLocation);
        System.out.println("Penguin location: " + ((Penguin) penguin).currentLocation);
        System.out.println("Penguin feather count: " + ((Penguin) penguin).numberOfFeathers);
    }
}

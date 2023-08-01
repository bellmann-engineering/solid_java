interface GreetingStrategy {
    String greet();
}

class FormalGreeting implements GreetingStrategy {
    public String greet() {
        return "Good evening, sir.";
    }
}

class CasualGreeting implements GreetingStrategy {
    public String greet() {
        return "Sup bro?";
    }
}

class IntimateGreeting implements GreetingStrategy {
    public String greet() {
        return "Hello Darling!";
    }
}

class Greeter {
    private GreetingStrategy greetingStrategy;

    public void setGreetingStrategy(GreetingStrategy strategy) {
        this.greetingStrategy = strategy;
    }

    public String greet() {
        if (greetingStrategy != null) {
            return greetingStrategy.greet();
        } else {
            return "Hello.";
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        greeter.setGreetingStrategy(new CasualGreeting());
        System.out.println(greeter.greet());
    }
}

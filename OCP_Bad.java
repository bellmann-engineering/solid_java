class Greeter {
    private String formality;

    public String greet() {
        if (formality.equals("formal")) {
            return "Good evening, sir.";
        } else if (formality.equals("casual")) {
            return "Sup bro?";
        } else if (formality.equals("intimate")) {
            return "Hello Darling!";
        } else {
            return "Hello.";
        }
    }

    public void setFormality(String formality) {
        this.formality = formality;
    }
}

public class Main {
    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        greeter.setFormality("casual");
        String greeting = greeter.greet();
        System.out.println(greeting);
    }
}

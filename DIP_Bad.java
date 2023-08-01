class Phone {
    // This class is creating a text alert for the mobile phone

    public String generateWeatherAlert(String weatherConditions) {
        String alert = "It is " + weatherConditions;
        return alert;
    }
}

class Emailer {
    // This class is creating a text message for an e-mail

    public String generateWeatherAlert(String weatherConditions) {
        String alert = "It is " + weatherConditions;
        return alert;
    }
}

class WeatherTracker {
    // This class is supposed to track the current weather
    // and it also sends out messages to a mobile device or an email
    // but it is dependent on the Phone and Emailer class to create these messages first

    String currentConditions;

    Phone phone;
    Emailer emailer;

    void setCurrentConditions(String weatherDescription) {
        // The weather conditions are tracked
        currentConditions = weatherDescription;

        if (weatherDescription.equals("rainy")) {
            // and the text message created by the Phone class is sent
            String alert = phone.generateWeatherAlert(weatherDescription);
            System.out.println(alert);
        }

        if (weatherDescription.equals("sunny")) {
            // same for the email
            String alert = emailer.generateWeatherAlert(weatherDescription);
            System.out.println(alert);
        }

        // This class should not be dependent on the other classes to do its job
        // The "Dependency Inversion Principle" states
        // "High-level modules should not depend on low-level modules. Both should depend on the abstraction"
        // and "Abstractions should not depend on details. Details should depend on abstractions."
    }
}

public class Main {
    public static void main(String[] args) {
        WeatherTracker tracker = new WeatherTracker();
        tracker.phone = new Phone();
        tracker.emailer = new Emailer();

        tracker.setCurrentConditions("rainy");
        tracker.setCurrentConditions("sunny");
    }
}

interface Notifier {
    void alertWeatherConditions(String weatherConditions);
}

class EmailClient implements Notifier {
    // We also have one class for the e-mail. But this time it sends the message directly after creating it

    public void alertWeatherConditions(String weatherConditions) {
        if (weatherConditions.equals("sunny"))
            System.out.println("It is sunny");
    }
}

class MobileDevice implements Notifier {
    // For mobile devices, it works the same

    public void alertWeatherConditions(String weatherConditions) {
        if (weatherConditions.equals("rainy"))
            System.out.println("It is rainy");
    }
}

class WeatherTracker {
    // Now our tracker has only one job. To get and set the current weather conditions.
    // It is no longer dependent on other classes

    String currentConditions;

    void setCurrentConditions(String weatherDescription) {
        currentConditions = weatherDescription;
    }

    String notify(Notifier notifier) {
        notifier.alertWeatherConditions(currentConditions);
        return currentConditions;
    }
}

public class Main {
    public static void main(String[] args) {
        WeatherTracker tracker = new WeatherTracker();
        tracker.setCurrentConditions("rainy");

        MobileDevice mobileDevice = new MobileDevice();
        tracker.notify(mobileDevice);
    }
}

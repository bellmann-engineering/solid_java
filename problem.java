import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// 1. Verletzung von Single Responsibility: Diese Klasse macht alles – von Order-Logik über Zahlung bis hin zu Reporting und Benachrichtigung.
public class OrderService {
    private List<Order> orders = new ArrayList<>();

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println("Order placed: " + order.getId());
        processPayment(order);
        exportOrderAsPDF(order);
        sendConfirmationEmail(order);
    }

    // 2. Verletzung von Dependency Inversion: Hier wird direkt mit konkreten Klassen gearbeitet.
    private void processPayment(Order order) {
        CreditCardProcessor cc = new CreditCardProcessor();
        if (order.getPaymentMethod().equals("CC")) {
            cc.charge(order.getTotal());
        } else {
            PayPalProcessor pp = new PayPalProcessor();
            pp.sendPayment(order.getTotal());
        }
        System.out.println("Payment processed for order " + order.getId());
    }

    // 3. Verletzung von Open/Closed: Jedes Mal, wenn ein neuer Export benötigt wird, muss diese Methode geändert werden.
    private void exportOrderAsPDF(Order order) {
        try (FileOutputStream fos = new FileOutputStream("order_" + order.getId() + ".pdf")) {
            String content = "Order ID: " + order.getId() + "\nTotal: " + order.getTotal();
            fos.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Exported order to PDF: " + order.getId());
    }

    // 4. Verletzung von Interface Segregation: Wir haben eine riesige Notification-API, obwohl wir nur E-Mails brauchen.
    private void sendConfirmationEmail(Order order) {
        NotificationService notifier = new NotificationServiceImpl();
        notifier.sendEmail(order.getCustomer().getEmail(), "Your order #" + order.getId() + " is confirmed");
    }

    public List<Order> getOrders() {
        return orders;
    }
}

// Einfaches Order-Objekt
class Order {
    private int id;
    private double total;
    private String paymentMethod;
    private Customer customer;

    public Order(int id, double total, String paymentMethod, Customer customer) {
        this.id = id;
        this.total = total;
        this.paymentMethod = paymentMethod;
        this.customer = customer;
    }

    public int getId() { return id; }
    public double getTotal() { return total; }
    public String getPaymentMethod() { return paymentMethod; }
    public Customer getCustomer() { return customer; }
}

// 5. Verletzung von Liskov Substitution: Diese Subklasse verhält sich anders und wirft für bestimmte Aufträge eine Exception.
class SpecialOrder extends Order {
    public SpecialOrder(int id, double total, String paymentMethod, Customer customer) {
        super(id, total, paymentMethod, customer);
    }

    @Override
    public double getTotal() {
        if (super.getTotal() < 0) {
            throw new RuntimeException("Total darf nicht negativ sein!");
        }
        return super.getTotal();
    }
}

class Customer {
    private String name;
    private String email;
    public Customer(String name, String email) {
        this.name = name; this.email = email;
    }
    public String getName() { return name; }
    public String getEmail() { return email; }
}

// Konkrete Payment-Processor, ohne gemeinsame Abstraktion
class CreditCardProcessor {
    public void charge(double amount) {
        System.out.println("Charging credit card: " + amount);
    }
}

class PayPalProcessor {
    public void sendPayment(double amount) {
        System.out.println("Sending PayPal payment: " + amount);
    }
}

// Großes Notification-Interface, Interface Segregation verletzt
interface NotificationService {
    void sendEmail(String to, String message);
    void sendSMS(String to, String message);
    void sendPush(String deviceId, String message);
}

class NotificationServiceImpl implements NotificationService {
    @Override
    public void sendEmail(String to, String message) {
        System.out.println("Email to " + to + ": " + message);
    }
    @Override
    public void sendSMS(String to, String message) {
        System.out.println("SMS to " + to + ": " + message);
    }
    @Override
    public void sendPush(String deviceId, String message) {
        System.out.println("Push to " + deviceId + ": " + message);
    }
}

// Logger mit harter Verkettung statt Injection – weitere DIP-Verletzung
class Logger {
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

public class Application {
    public static void main(String[] args) {
        Customer c = new Customer("Max Mustermann", "max@example.com");
        Order o1 = new Order(1, 100.0, "CC", c);
        OrderService service = new OrderService();
        service.placeOrder(o1);
    }
}

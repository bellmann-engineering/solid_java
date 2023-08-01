class Product {

    private String title;
    private float price;
    private float taxRate;

    public Product(String title, float price, float taxRate) {
        this.title = title;
        this.price = price;
        this.taxRate = taxRate;
    }

    public float calculateTax() {
        return this.price * this.taxRate;
    }
}

public class Main {

    public static void main(String[] args) {
        Product tshirt = new Product("Hugo Boss", 20.00f, 0.19f); // Note: Use 'f' suffix for float literals in Java.
        float taxesForShirt = tshirt.calculateTax();
        System.out.println("Taxes for the shirt: " + taxesForShirt);
    }
}

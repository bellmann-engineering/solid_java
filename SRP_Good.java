class Product {

    private String title;
    private float price;
    private float taxRate;

    public Product(String title, float price, float taxRate) {
        this.title = title;
        this.price = price;
        this.taxRate = taxRate;
    }

    public float getPrice() {
        return this.price;
    }

    public float getTaxRate() {
        return this.taxRate;
    }
}

class TaxCalculator {

    public float calculateTax(Product p) {
        return p.getPrice() * p.getTaxRate();
    }
}

public class Main {

    public static void main(String[] args) {
        float germanRate = 0.19f; 
        Product tshirt = new Product("Hugo Boss Shirt", 19.90f, germanRate);
        TaxCalculator calculator = new TaxCalculator();
        float taxAmount = calculator.calculateTax(tshirt);
        System.out.println("Taxes for the shirt: " + taxAmount);
    }
}

class Apartment {
    protected String apartmentName;
    protected int squareFootage;
    protected int numberOfBedrooms;

    public Apartment(String apartmentName, int numberOfBedrooms) {
        this.apartmentName = apartmentName;
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public void setSquareFootage(int sqft) {
        squareFootage = sqft;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void upgrade() {
        squareFootage += 40;
        numberOfBedrooms += getAdditionalBedrooms();
    }

    protected int getAdditionalBedrooms() {
        return 0; // Default behavior for the base class
    }
}

class PenthouseSuite extends Apartment {
    public PenthouseSuite() {
        super("Penthouse", 4);
    }

    @Override
    protected int getAdditionalBedrooms() {
        return 1; // Penthouse has an additional bedroom
    }
}

class Studio extends Apartment {
    public Studio() {
        super("Studio", 0);
    }
}

class UnitUpgrader {
    public void upgrade(Apartment apartment) {
        apartment.upgrade();
    }
}

public class Main {
    public static void main(String[] args) {
        Apartment penthouse = new PenthouseSuite();
        penthouse.setSquareFootage(2000);

        Apartment studio = new Studio();
        studio.setSquareFootage(500);

        UnitUpgrader upgrader = new UnitUpgrader();
        upgrader.upgrade(penthouse);
        upgrader.upgrade(studio);

        System.out.println("Penthouse: " + penthouse.getApartmentName() + ", Bedrooms: " + penthouse.getNumberOfBedrooms() + ", Square Footage: " + penthouse.squareFootage);
        System.out.println("Studio: " + studio.getApartmentName() + ", Bedrooms: " + studio.getNumberOfBedrooms() + ", Square Footage: " + studio.squareFootage);
    }
}

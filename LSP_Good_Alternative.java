public class Apartment {
    public String apartmentName;
    public int squareFootage;
    public int numberOfBedrooms;

    public void setSquareFootage(int sqft) {
        squareFootage = sqft;
    }

    public void upgrade() {
        // Default upgrade behavior
    }

    public void displayDetails() {
        System.out.println("Apartment Name: " + apartmentName);
        System.out.println("Square Footage: " + squareFootage + " sqft");
        System.out.println("Number of Bedrooms: " + numberOfBedrooms);
    }
}

public class PenthouseSuite extends Apartment {
    public PenthouseSuite() {
        numberOfBedrooms = 4;
        apartmentName = "Penthouse";
    }

    @Override
    public void setSquareFootage(int sqft) {
        squareFootage = sqft;
    }

    @Override
    public void upgrade() {
        // Upgrade behavior for PenthouseSuite
        squareFootage += 50;  // Different upgrade for PenthouseSuite
        numberOfBedrooms += 2;  // Different upgrade for PenthouseSuite
    }
}

public class Studio extends Apartment {
    public Studio() {
        numberOfBedrooms = 0;
        apartmentName = "Studio";
    }

    @Override
    public void setSquareFootage(int sqft) {
        squareFootage = sqft;
    }

    @Override
    public void upgrade() {
        // Studio apartments do not have additional bedrooms in the upgrade
        squareFootage += 30;  // Different upgrade for Studio
    }
}

public class Main {
    public static void main(String[] args) {
        PenthouseSuite penthouse = new PenthouseSuite();
        Studio studio = new Studio();

        penthouse.displayDetails();
        penthouse.upgrade();
        penthouse.displayDetails();

        studio.displayDetails();
        studio.upgrade();
        studio.displayDetails();
    }
}

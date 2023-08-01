class Apartment {
    protected String apartmentName;
    protected int squareFootage;
    protected int numberOfBedrooms;

    public void setSquareFootage(int sqft) {
        squareFootage = sqft;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }
}

class PenthouseSuite extends Apartment {
    public PenthouseSuite() {
        apartmentName = "Penthouse";
        numberOfBedrooms = 4;
    }

    public void setName() {
        apartmentName = "Penthouse";
    }
}

class Studio extends Apartment {
    public Studio() {
        apartmentName = "Studio";
        numberOfBedrooms = 0;
    }

    public void setName() {
        apartmentName = "Studio";
    }
}

class UnitUpgrader {
    public void upgrade(Apartment apartment) {
        apartment.squareFootage += 40;

        if (!apartment.getApartmentName().equals("Studio")) {
            apartment.numberOfBedrooms += 1;
        }
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

        System.out.println("Penthouse: " + penthouse.getApartmentName() + ", Bedrooms: " + penthouse.getNumberOfBedrooms());
        System.out.println("Studio: " + studio.getApartmentName() + ", Bedrooms: " + studio.getNumberOfBedrooms());
    }
}

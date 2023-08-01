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

    // Methods for any common functionality between subclasses can be added here.
}

class PenthouseSuite extends Apartment {
    public PenthouseSuite() {
        apartmentName = "Penthouse";
        numberOfBedrooms = 4;
    }

    // PenthouseSuite-specific methods can be added here.
}

class Studio extends Apartment {
    public Studio() {
        apartmentName = "Studio";
        numberOfBedrooms = 0;
    }

    // Studio-specific methods can be added here.
}

public class Main {
    public static void main(String[] args) {
        Apartment penthouse = new PenthouseSuite();
        penthouse.setSquareFootage(2000);

        Apartment studio = new Studio();
        studio.setSquareFootage(500);
    }
}

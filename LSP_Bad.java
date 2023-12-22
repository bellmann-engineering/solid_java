public class Apartment {
    protected String apartmentName;
    protected int squareFootage;
    protected int numberOfBedrooms;

    public void setSquareFootage(int sqft) {
        squareFootage = sqft;
    }
}

class PenthouseSuite extends Apartment {
    public PenthouseSuite() {
        numberOfBedrooms = 4;
        setName("Penthouse");
    }

    public void setName() {
        apartmentName = "Penthouse";
    }

    @Override
    public void setSquareFootage(int sqft) {
        squareFootage = sqft;
    }
}

class Studio extends Apartment {
    public Studio() {
        numberOfBedrooms = 0;
        setName("Studio");
    }

    public void setName() {
        apartmentName = "Studio";
    }

    @Override
    public void setSquareFootage(int sqft) {
        squareFootage = sqft;
    }
}

class UnitUpgrader {
    public void upgrade(Apartment apartment) {
        apartment.squareFootage += 40;

        if (!apartment.apartmentName.equals("Studio")) {
            apartment.numberOfBedrooms += 1;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Your main code here
    }
}

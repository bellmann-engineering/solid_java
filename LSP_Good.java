public class PenthouseSuite {
    public int squareFootage;
    public int numberOfBedrooms;

    public PenthouseSuite() {
        numberOfBedrooms = 4;
    }

    public void setSquareFootage(int sqft) {
        squareFootage = sqft;
    }
}

public class Studio {
    public int squareFootage;
    public int numberOfBedrooms;

    public Studio() {
        numberOfBedrooms = 0;
    }

    public void setSquareFootage(int sqft) {
        squareFootage = sqft;
    }
}

public class BedroomAdder {
    public void addBedroom(PenthouseSuite penthouse) {
        penthouse.numberOfBedrooms += 1;
    }
}

public class Main {
    public static void main(String[] args) {
        // Your main code here
    }
}

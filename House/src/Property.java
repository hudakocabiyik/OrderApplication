import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Property {
    private int area;
    private int price;
    private int roomCount;
    private int livingRoomCount;

    public Property(int area, int price, int roomCount, int livingRoomCount) {
        this.area = area;
        this.price = price;
        this.roomCount = roomCount;
        this.livingRoomCount = livingRoomCount;
    }

    public int getArea() {
        return area;
    }

    public int getPrice() {
        return price;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public int getLivingRoomCount() {
        return livingRoomCount;
    }
}

class House extends Property {
    public House(int area, int price, int roomCount, int livingRoomCount) {
        super(area, price, roomCount, livingRoomCount);
    }
}

class Villa extends Property {
    public Villa(int area, int price, int roomCount, int livingRoomCount) {
        super(area, price, roomCount, livingRoomCount);
    }
}

class SummerHouse extends Property {
    public SummerHouse(int area, int price, int roomCount, int livingRoomCount) {
        super(area, price, roomCount, livingRoomCount);
    }
}

class PropertyService {
    private List<Property> properties;

    public PropertyService(List<Property> properties) {
        this.properties = properties;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public List<House> getHouses() {
        List<House> houses = new ArrayList<>();
        for (Property property : properties) {
            if (property instanceof House) {
                houses.add((House) property);
            }
        }
        return houses;
    }

    public List<Villa> getVillas() {
        List<Villa> villas = new ArrayList<>();
        for (Property property : properties) {
            if (property instanceof Villa) {
                villas.add((Villa) property);
            }
        }
        return villas;
    }

    public List<SummerHouse> getSummerHouses() {
        List<SummerHouse> summerHouses = new ArrayList<>();
        for (Property property : properties) {
            if (property instanceof SummerHouse) {
                summerHouses.add((SummerHouse) property);
            }
        }
        return summerHouses;
    }

    public int getTotalHousePrice() {
        int total = 0;
        for (House house : getHouses()) {
            total += house.getPrice();
        }
        return total;
    }

    public int getTotalVillaPrice() {
        int total = 0;
        for (Villa villa : getVillas()) {
            total += villa.getPrice();
        }
        return total;
    }

    public int getTotalSummerHousePrice() {
        int total = 0;
        for (SummerHouse summerHouse : getSummerHouses()) {
            total += summerHouse.getPrice();
        }
        return total;
    }

    public int getTotalPropertyPrice() {
        int total = 0;
        for (Property property : properties) {
            total += property.getPrice();
        }
        return total;
    }

    public double getHouseAvgArea() {
        double totalArea = 0;
        for (House house : getHouses()) {
            totalArea += house.getArea();
        }
        return totalArea / getHouses().size();
    }

    public double getVillaAvgArea() {
        double totalArea = 0;
        for (Villa villa : getVillas()) {
            totalArea += villa.getArea();
        }
    return totalArea/ getVillas().size();}}

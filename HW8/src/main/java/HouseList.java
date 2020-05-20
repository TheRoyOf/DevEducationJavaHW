import java.util.ArrayList;

public class HouseList {

    ArrayList<House> houses = new ArrayList<House>();

    public ArrayList<House> GetByRooms(int Room)
    {
        ArrayList<House> rezult = new ArrayList<House>();

        for (House house:houses)
        {
            if (house.rooms==Room)
                rezult.add(house);
        }
        return rezult;
    }

    public ArrayList<House> GetByArea(int minArea)
    {
        ArrayList<House> rezult = new ArrayList<House>();

        for (House house:houses)
        {
            if (house.rooms>=minArea)
                rezult.add(house);
        }
        return rezult;
    }

}

import java.util.*;

public class Main {
    static String[] types = {"Kitchen", "Bedroom", "Bathroom", "Living room"};

    public static void main(String[] args) {
        int N = 4;
        Room[] floor1 = new Room[N];
        ArrayList<Room> floor2 = new ArrayList<>();
        ArrayDeque<Room> floor3 = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            floor1[i] = randomizeRoom();
            floor2.add(randomizeRoom());
            floor3.add(randomizeRoom());
        }

        Iterator[] floors = {Arrays.stream(floor1).iterator(), floor2.iterator(), floor3.iterator()};
        Room curRoom;
        int total_area = 0;
        int[] floor_area = new int[3];
        int[] area_by_type = new int[types.length];

        for (int i = 0; i<floors.length; i++) {
            Iterator<Room> iterator = floors[i];
            while (iterator.hasNext()) {
                curRoom = iterator.next();
                total_area += curRoom.getArea();
                floor_area[i] += curRoom.getArea();
                switch (curRoom.getType()){
                    case "Kitchen" -> area_by_type[0] += curRoom.getArea();
                    case "Bedroom" -> area_by_type[1] += curRoom.getArea();
                    case "Bathroom" -> area_by_type[2] += curRoom.getArea();
                    default -> area_by_type[3] += curRoom.getArea();
                }
            }
        }

        System.out.println(String.format("Общая площадь: %d кв. м", total_area));
        System.out.println("Площадь по этажам:");
        for (int i = 0; i<floors.length; i++) {
            System.out.println(String.format("\t%d этаж: %d кв. м", i, floor_area[i]));
        }
        System.out.println("Площадь по типам комнат:");
        for (int i = 0; i<types.length; i++) {
            System.out.println(String.format("\t%s: %d кв. м", types[i], area_by_type[i]));
        }
    }

    public static Room randomizeRoom() {
        Random rand = new Random();
        String type = types[rand.nextInt(types.length)];
        int area = rand.nextInt(5, 45);
        return new Room(type, area);
    }
}

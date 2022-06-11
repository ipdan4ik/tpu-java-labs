import java.util.Random;

public class PortableConsoleFabric extends ConsoleFabric {
    public PortableConsole createConsole() {
        return new PortableConsole(createName(), createDeveloper(), createMedia(), createPrice(), createRam(), createCPU(), createBatteryCapacity(), createDisplay());
    }

    public PortableConsole.Display createDisplay() {
        int display_width = rand.nextInt(10000);
        int display_height = rand.nextInt(10000);
        float diagonal = rand.nextFloat() * rand.nextInt(20);
        return new PortableConsole.Display(display_height, display_width, diagonal);
    }

    public float createBatteryCapacity() {
        return rand.nextFloat() * rand.nextInt(100000);
    }

}

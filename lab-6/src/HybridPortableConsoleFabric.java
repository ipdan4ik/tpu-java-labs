import java.util.Random;

public class HybridPortableConsoleFabric extends PortableConsoleFabric {
    public PortableConsole createConsole() {
        boolean hasDocStation = rand.nextBoolean();
        boolean hasPortableControllers = rand.nextBoolean();

        return new HybridPortableConsole(createName(), createDeveloper(), createMedia(), createPrice(), createRam(), createCPU(), createBatteryCapacity(), createDisplay(), hasDocStation, hasPortableControllers);
    }
}

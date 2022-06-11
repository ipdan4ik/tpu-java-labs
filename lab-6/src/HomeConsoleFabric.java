import java.util.Random;

public class HomeConsoleFabric extends ConsoleFabric{

    public HomeConsole createConsole() {
        return new HomeConsole(createName(), createDeveloper(), createMedia(), createPrice(), createRam(), createCPU());
    }
}

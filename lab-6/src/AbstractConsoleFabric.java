public interface AbstractConsoleFabric {
    Console createConsole();
    String createName();
    String createDeveloper();
    String createMedia();
    float createPrice();
    int createRam();
    BaseConsole.CPU createCPU();
}

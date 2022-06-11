public class Main {
    public static void main(String[] args) {

        int N = 10;
        Console [] consoles = new Console[N];
        for (int i=0; i<N; i++) {
            AbstractConsoleFabric consoleFactory = new ConsoleFabric();
            consoles[i] = consoleFactory.createConsole();
        }

        for (int i = 0; i<N; i++) {
            System.out.println((i+1) + ". " + consoles[i].getDescription() + "\n");
        }
    }
}

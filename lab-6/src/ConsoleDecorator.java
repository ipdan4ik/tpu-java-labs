public class ConsoleDecorator implements Console{
    private final Console console;

    public ConsoleDecorator(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return console.getDescription();
    }
}

import java.util.Random;

public class ConsoleFabric {
    public Console createConsole() {
        Random rand = new Random();

        Console console;
        int type = rand.nextInt(3);
        console = switch (type) {
            case 1 -> {
                HomeConsoleFabric fabric = new HomeConsoleFabric();
                yield fabric.createConsole();
            }
            case 2 -> {
                PortableConsoleFabric fabric = new PortableConsoleFabric();
                yield fabric.createConsole();
            }
            default -> {
                HybridPortableConsoleFabric fabric = new HybridPortableConsoleFabric();
                yield fabric.createConsole();
            }
        };

        boolean withMotionTracker = rand.nextBoolean();
        if (withMotionTracker) {
            console = new MotionTracker(console);
        }

        boolean withSoundCard = rand.nextBoolean();
        if (withSoundCard) {
            String[] sound_card_names = {"Zilog Z80", "Atari POKEY", "Konami VRC6", "Ricoh 2A03", "Sony SPC700", "PCM"};
            String soundCardTitle = sound_card_names[rand.nextInt(sound_card_names.length)];
            float soundFrequency = rand.nextFloat() * rand.nextInt(10);
            int soundArchitecture = rand.nextInt(3) * 8;
            console = new SoundCard(console, soundCardTitle, soundFrequency, soundArchitecture);
        }

        return console;
    }
}

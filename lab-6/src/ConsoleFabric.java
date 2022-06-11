import java.util.Random;

public class ConsoleFabric implements AbstractConsoleFabric {
    Random rand = new Random();
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

    public String createName() {
        String [] name_array = {"Nintendo Entertainment System", "Sega Mega Drive", "TurboGrafx", "Atari", "Comodore64", "Nintendo Switch", "PSP", "PlayStation 1", "Wii U"};
        return name_array[rand.nextInt(name_array.length)];
    }

    public String createDeveloper() {
        String [] developer_array = {"Nintendo", "Sony", "Atari", "Sega", "Commodore"};
        return developer_array[rand.nextInt(developer_array.length)];
    }

    public String createMedia() {
        String [] media_array = {"Floppy disk", "Cartridge", "CD/DVD", "Digital"};
        return media_array[rand.nextInt(media_array.length)];
    }

    public float createPrice() {
        return rand.nextFloat() * rand.nextInt(1000);
    }

    public int createRam() {
        return rand.nextInt(1000000);
    }

    public BaseConsole.CPU createCPU() {
        String [] cpu_titles = {"MIPS R4000", "ARM946E-S", "PowerPC 750CXe", "Cell Broadband Engine", "Zen 2", "NVIDIA Tegra X1", "IBM Power 750"};
        String cpuTitle = cpu_titles[rand.nextInt(cpu_titles.length)];
        float frequency = rand.nextFloat() * rand.nextInt(10);
        int cpuArchitecture = rand.nextInt(3) * 8;
        return new HomeConsole.CPU(cpuTitle, frequency, cpuArchitecture);
    }
}

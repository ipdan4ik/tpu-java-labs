import java.util.Random;

public class Main {

    public static Console randomizeConsole() {
        Random rand = new Random();

        String [] name_array = {"Nintendo Entertainment System", "Sega Mega Drive", "TurboGrafx", "Atari", "Comodore64", "Nintendo Switch", "PSP", "PlayStation 1", "Wii U"};
        String [] developer_array = {"Nintendo", "Sony", "Atari", "Sega", "Commodore"};
        String [] media_array = {"Floppy disk", "Cartridge", "CD/DVD", "Digital"};
        String [] cpu_titles = {"MIPS R4000", "ARM946E-S", "PowerPC 750CXe", "Cell Broadband Engine", "Zen 2", "NVIDIA Tegra X1", "IBM Power 750"};
        String name = name_array[rand.nextInt(name_array.length)];
        String developer = developer_array[rand.nextInt(developer_array.length)];
        String media = media_array[rand.nextInt(media_array.length)];
        float priceUSD = rand.nextFloat() * rand.nextInt(1000);
        int ramMB = rand.nextInt(1000000);
        String cpuTitle = cpu_titles[rand.nextInt(cpu_titles.length)];
        float frequency = rand.nextFloat() * rand.nextInt(10);
        int cpuArchitecture = rand.nextInt(3) * 8;
        HomeConsole.CPU cpu = new HomeConsole.CPU(cpuTitle, frequency, cpuArchitecture);

        int display_width = rand.nextInt(10000);
        int display_height = rand.nextInt(10000);
        float diagonal = rand.nextFloat() * rand.nextInt(20);
        float batteryCapacity = rand.nextFloat() * rand.nextInt(100000);
        PortableConsole.Display display = new PortableConsole.Display(display_height, display_width, diagonal);

        boolean hasDocStation = rand.nextBoolean();
        boolean hasPortableControllers = rand.nextBoolean();

        Console console;
        int type = rand.nextInt(3);
        switch (type) {
            case 1: console = new HomeConsole(name, developer, media, priceUSD, ramMB, cpu);
                break;
            case 2: console = new PortableConsole(name, developer, media, priceUSD, ramMB, cpu, batteryCapacity, display);
                break;
            default: console = new HybridPortableConsole(name, developer, media, priceUSD, ramMB, cpu, batteryCapacity, display, hasDocStation, hasPortableControllers);
        };

        boolean withMotionTracker = rand.nextBoolean();
        if (withMotionTracker) {
            console = new MotionTracker(console);
        }

        boolean withSoundCard = rand.nextBoolean();
        if (withSoundCard) {
            String [] sound_card_names = {"Zilog Z80", "Atari POKEY", "Konami VRC6", "Ricoh 2A03", "Sony SPC700", "PCM"};
            String soundCardTitle = sound_card_names[rand.nextInt(sound_card_names.length)];
            float soundFrequency = rand.nextFloat() * rand.nextInt(10);
            int soundArchitecture = rand.nextInt(3) * 8;
            console = new SoundCard(console, soundCardTitle, soundFrequency, soundArchitecture);
        }

        return console;
    }

    public static void main(String[] args) {

        int N = 10;
        Console [] consoles = new Console[N];
        for (int i=0; i<N; i++) {
            consoles[i] = randomizeConsole();
        }

        for (int i = 0; i<N; i++) {
            System.out.println(String.valueOf(i+1) + ". " + consoles[i].getDescription() + "\n");
        }

    }


}

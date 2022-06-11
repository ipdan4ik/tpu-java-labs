import java.util.Random;

public class HomeConsoleFabric {

    public HomeConsole createConsole() {
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

        return new HomeConsole(name, developer, media, priceUSD, ramMB, cpu);
    }
}

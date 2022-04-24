package ru.tpu.hierarchy;

import java.util.Random;

public class Main {

    public static BaseConsole randomizeConsole() {
        Random rand = new Random();
        int type = rand.nextInt(3);
        String [] name_array = {"Nintendo Entertainment System", "Sega Mega Drive", "TurboGrafx", "Atari", "Comodore64", "Nintendo Switch", "PSP", "PlayStation 1", "Wii U"};
        String [] developer_array = {"Nintendo", "Sony", "Atari", "Sega", "Commodore"};
        String [] media_array = {"Floppy disk", "Cartridge", "CD/DVD", "Digital"};
        String [] cpu_titles = {"MIPS R4000", "ARM946E-S", "PowerPC 750CXe", "Cell Broadband Engine", "Zen 2", "NVIDIA Tegra X1", "IBM Power 750"};
        String name = name_array[rand.nextInt(name_array.length)];
        String developer = developer_array[rand.nextInt(developer_array.length)];
        String media = media_array[rand.nextInt(media_array.length)];
        float priceUSD = rand.nextFloat() * rand.nextInt(1000);
        int ramMB = rand.nextInt(1000000);

        String cpu_title = cpu_titles[rand.nextInt(cpu_titles.length)];
        float frequency = rand.nextFloat() * rand.nextInt(10);
        int cpu_architecture = rand.nextInt(3) * 8;
        HomeConsole.CPU cpu = new HomeConsole.CPU(cpu_title, frequency, cpu_architecture);
        HomeConsole homeConsole = new HomeConsole(name, developer, media, priceUSD, ramMB, cpu);

        int display_width = rand.nextInt(10000);
        int display_height = rand.nextInt(10000);
        float diagonal = rand.nextFloat() * rand.nextInt(20);
        float batteryCapacity = rand.nextFloat() * rand.nextInt(100000);
        PortableConsole.Display display = new PortableConsole.Display(display_height, display_width, diagonal);
        PortableConsole portableConsole = new PortableConsole(name, developer, media, priceUSD, ramMB, cpu, batteryCapacity, display);

        boolean hasDocStation = rand.nextBoolean();
        boolean hasPortableControllers = rand.nextBoolean();
        HybridPortableConsole hybridPortableConsole = new HybridPortableConsole(name, developer, media, priceUSD, ramMB, cpu, batteryCapacity, display, hasDocStation, hasPortableControllers);

        return switch (type) {
            case 1 -> portableConsole;
            case 2 -> hybridPortableConsole;
            default -> homeConsole;
        };
    }

    public static void main(String[] args) {

        int N = 10;
        BaseConsole [] consoles = new BaseConsole[N];
        for (int i=0; i<N; i++) {
            consoles[i] = randomizeConsole();
        }

        for (int i = 0; i<N; i++) {
            System.out.println(String.valueOf(i+1) + ". " + consoles[i].getDescription() + "\n");
        }

    }


}

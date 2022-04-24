package ru.tpu.hierarchy;

public class BaseConsole {
    public static class CPU {
        private String title;
        private float frequency;
        private int architecture;

        public CPU(String title, float frequency, int architecture) {
            this.title = title;
            this.frequency = frequency;
            this.architecture = architecture;
        }

        public String getDescription() {
            return String.format("\tProcessor %s\n\t\tArchitecture: %d bit\n\t\tMax frequency: %s GHz", this.title, this.architecture, this.frequency);
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public float getFrequency() {
            return frequency;
        }

        public void setFrequency(float frequency) {
            this.frequency = frequency;
        }

        public int getArchitecture() {
            return architecture;
        }

        public void setArchitecture(int architecture) {
            this.architecture = architecture;
        }
    }

    private String name;
    private String developer;
    private String media;
    private float priceUsd;
    private int ramMb;
    private CPU cpu;

    public BaseConsole(String name, String developer, String media, float priceUsd, int ramMb, CPU cpu) {
        this.name = name;
        this.developer = developer;
        this.media = media;
        this.priceUsd = priceUsd;
        this.ramMb = ramMb;
        this.cpu = cpu;
    }

    public String getDescription() {
        return String.format("Console %s\n\tDeveloper: %s\n\tPrice: %f usd\n\tMedium: %s\n\tRAM: %d\n%s", this.name, this.developer, this.priceUsd, this.media, this.ramMb, this.cpu.getDescription());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public float getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(float priceUsd) {
        this.priceUsd = priceUsd;
    }

    public int getRamMb() {
        return ramMb;
    }

    public void setRamMb(int ramMb) {
        this.ramMb = ramMb;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }
}

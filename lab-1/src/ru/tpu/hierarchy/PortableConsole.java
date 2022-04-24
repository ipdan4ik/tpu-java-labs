package ru.tpu.hierarchy;

public class PortableConsole extends BaseConsole {
    public static class Display {
        private int height;
        private int width;
        private float diagonal;

        public Display(int height, int width, float diagonal) {
            this.height = height;
            this.width = width;
            this.diagonal = diagonal;
        }

        public String getDescription() {
            return String.format("\tDisplay\n\t\tResolution: %d x %d\n\t\tDiagonal %f", this.width, this.height, this.diagonal);
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public float getDiagonal() {
            return diagonal;
        }

        public void setDiagonal(float diagonal) {
            this.diagonal = diagonal;
        }
    }

    private float batteryCapacity;
    private Display display;

    public PortableConsole(String name, String developer, String media, float priceUsd, int ramMb, CPU cpu, float batteryCapacity, Display display) {
        super(name, developer, media, priceUsd, ramMb, cpu);
        this.batteryCapacity = batteryCapacity;
        this.display = display;
    }

    @Override
    public String getDescription() {
        String description = super.getDescription();
        String description_new = String.format("\tBattery capacity: %f MAh\n%s", this.batteryCapacity, this.display.getDescription());
        return description + description_new;
    }

    public float getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(float batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }
}

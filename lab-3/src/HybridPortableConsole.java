public class HybridPortableConsole extends PortableConsole {
    private boolean hasDocStation;
    private boolean hasPortableControllers;

    public HybridPortableConsole(String name, String developer, String media, float priceUsd, int ramMb, CPU cpu, float batteryCapacity, Display display, boolean hasDocStation, boolean hasPortableControllers) {
        super(name, developer, media, priceUsd, ramMb, cpu, batteryCapacity, display);
        this.hasDocStation = hasDocStation;
        this.hasPortableControllers = hasPortableControllers;
    }

    @Override
    public String getDescription() {
        String description = super.getDescription();
        if (this.hasDocStation) {
            description += "\n\tDoc station included";
        }
        if (this.hasPortableControllers) {
            description += "\n\tSupport of distinct controllers";
        }

        return description;
    }

    public boolean isHasDocStation() {
        return hasDocStation;
    }

    public void setHasDocStation(boolean hasDocStation) {
        this.hasDocStation = hasDocStation;
    }

    public boolean isHasPortableControllers() {
        return hasPortableControllers;
    }

    public void setHasPortableControllers(boolean hasPortableControllers) {
        this.hasPortableControllers = hasPortableControllers;
    }
}

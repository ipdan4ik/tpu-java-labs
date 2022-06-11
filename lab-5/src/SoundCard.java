public class SoundCard extends ConsoleDecorator {

    private String title;
    private float frequency;
    private int architecture;

    public SoundCard(Console console, String title, float frequency, int architecture) {
        super(console);
        this.title = title;
        this.frequency = frequency;
        this.architecture = architecture;
    }

    public String getDescription() {
        return super.getDescription() + decorateWithSoundCard();
    }

    private String decorateWithSoundCard() {
        return String.format("\n\tSound card %s\n\t\tArchitecture: %d bit\n\t\tFrequency: %f GHz", title, architecture, frequency);
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



public class MotionTracker extends ConsoleDecorator{
    public MotionTracker(Console console) {
        super(console);
    }

    public String getDescription() {
        return super.getDescription() + decorateWithMotionTracker();
    }

    private String decorateWithMotionTracker() {
        return "\n\twith Motion Tracker";
    }
}

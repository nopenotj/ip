public class Event extends Task {
    private String time;
    public Event(String description, String time) {
        super(description);
        this.time = time;
    }
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + time + ")";
    }

    @Override
    public String convertToData() {
        return "D | " + (isDone ? 1 : 0) + " | " + description + " | " + time;
    }
}

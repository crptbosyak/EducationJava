package programming.with.classes.car;

public class Wheel {
    String type;

    public Wheel(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "type='" + type + '\'' +
                '}';
    }
}

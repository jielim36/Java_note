package exercise08;

public class LabeledPoint extends Point{

    private String note;

    public LabeledPoint(double x, double y) {
        super(x, y);
    }

    public LabeledPoint(double x, double y, String note) {
        super(x, y, note);
    }

    public void showInfo() {
        super.showInfo(note);
    }


}

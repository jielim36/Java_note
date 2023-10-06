package exercise08;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y,String note) {
        this.x = x;
        this.y = y;
        showInfo(note);

    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }


    public void showInfo(String note){
        System.out.println("Label : " + note + "\tX : " + x + "\tY : " + y);
    }

}

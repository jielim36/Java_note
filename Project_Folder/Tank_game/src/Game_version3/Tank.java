package Game_version3;

public class Tank {
    private int x;
    private int y;
    private int direct = 0;//默认0
    private int speed;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public void moveUp(){
        y -= speed;
    }

    public void moveRight(){
        x += speed;
    }

    public void moveLeft(){
        x -= speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void moveDown(){
        y += speed;
    }

}

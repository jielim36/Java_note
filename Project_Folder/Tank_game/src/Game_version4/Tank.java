package Game_version4;

public class Tank {
    private int x;
    private int y;
    private int direct = 0;//默认0
    private int speed;

    boolean isLive = true;

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

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
        if (y < 5 && y > 1245  ){
            return;
        }

        y -= speed;
    }

    public void moveRight(){
        if (x < 5 && x > 895  ){
            return;
        }
        x += speed;
    }

    public void moveLeft(){
        if (x < 5 && x > 895  ){
            return;
        }
        x -= speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void moveDown(){
        if (y < 5 && y > 1245  ){
            return;
        }
        y += speed;
    }

}

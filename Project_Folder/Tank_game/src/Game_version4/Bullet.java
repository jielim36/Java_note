package Game_version4;


import javax.swing.*;

public class Bullet extends JPanel implements Runnable{
    private int x;
    private int y;
    private int Direct;
    private int speed = 4;
    private boolean isLive = true; //子弹是否存在，默认true
    private MyPanel mp = null;

    public Bullet(int x, int y, int Direct , MyPanel mp) {
        this.x = x;
        this.y = y;
        this.Direct = Direct;
        this.mp = mp;
    }

    @Override
    public void run() {
        while(true) {
            switch (Direct) {
                case 0://上
                    y -= speed;
                    break;
                case 1://右
                    x += speed;
                    break;
                case 2://左
                    x -= speed;
                    break;
                case 3://下
                    y += speed;
                    break;

            }
            mp.repaint();

            try {
                Thread.sleep(9);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

//            System.out.println("子弹坐标  X:"+x + "  Y:" + y );

            if (!(x <= 1250 && y <= 900 && x >= 0 && y >= 0 && isLive)){ //如果子弹超出地图
                isLive = false;
                break;
            }
        }
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
}

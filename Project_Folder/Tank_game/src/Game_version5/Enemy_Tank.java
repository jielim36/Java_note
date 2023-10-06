package Game_version5;

import java.util.Vector;

public class Enemy_Tank extends Tank implements Runnable{
    Vector<Bullet> shots = new Vector<>();
    private boolean isLive = true;

    MyPanel mp = null;
    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public Enemy_Tank(int x , int y, int speed, MyPanel mp) {
        super.setX(x);
        super.setY(y);
        super.setSpeed(speed);
        this.mp = mp;

    }

    @Override
    public void run() {
        while(true) {

            //实现敌方会规律的发射子弹，当子弹集合里没有子弹时就发射
            if (isLive && shots.size() == 0){
                Bullet bullet = new Bullet(this.getX() , this.getY(),getDirect(),mp);
                shots.add(bullet);
                new Thread(bullet).start();
            }

            for (int i = 0; i < 10 ; i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                switch (getDirect()) {
                    case 0://up
                        if ( getY()-20 > 5 ){
                            moveUp();
                        }
                        break;
                    case 1://right
                        if ( getX()+60 < 1245 ){
                            moveRight();
                        }
                        break;
                    case 2://left
                        if ( getX()-20  > 5 ){
                            moveLeft();
                        }
                        break;
                    case 3://down
                        if ( getY() +80 < 900 ){
                            moveDown();
                        }
                        break;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            setDirect((int)(Math.random()*4));//随机生成0-3的号码，赋给setDirect，形成一个随机的方向

            //提示：一旦写并发程序（多线程），一定要考虑该线程什么时候结束
            if (!this.isLive){ //== false
                break;
            }

        }




    }
}

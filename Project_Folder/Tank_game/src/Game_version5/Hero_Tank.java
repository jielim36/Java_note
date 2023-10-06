package Game_version5;

import java.util.Vector;

public class Hero_Tank extends Tank {
    Bullet bullet;
    MyPanel mp= null;
//    Vector<Bullet> shots = new Vector<>();
    public Hero_Tank(int x, int y , int speed , MyPanel mp) {
        super.setX(x);
        super.setY(y);
        super.setSpeed(speed);
        this.mp = mp;
    }

    public void shot() {

//        if (shots.size() >= 1){ //如果当前已有五颗子弹，就不能再发射
//            return;
//        }

        switch (getDirect()){
            case 0://上
                bullet = new Bullet(getX()+9,getY()-20,getDirect(),mp);//xy要炮管的坐标，原始坐标是坦克的中间圆形
                break;
            case 1://右
                bullet = new Bullet(getX()+3,getY()+10,getDirect(),mp);
                break;
            case 2://左
                bullet = new Bullet(getX()-20,getY()+10,getDirect(),mp);
                break;
            case 3://下
                bullet = new Bullet(getX()+9,getY(),getDirect(),mp);
                break;
        }

//        shots.add(bullet);

        new Thread(bullet).start();
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }

}

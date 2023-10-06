package Game_version3;

public class Hero_Tank extends Tank{
    Bullet bullet;
    public Hero_Tank(int x, int y , int speed) {
        super.setX(x);
        super.setY(y);
        super.setSpeed(speed);

    }

    public void shot(){
        switch (getDirect()){
            case 0://上
                bullet = new Bullet(getX()+9,getY()-20,this);//xy要炮管的坐标，原始坐标是坦克的中间圆形
                break;
            case 1://右
                bullet = new Bullet(getX()+3,getY()+10,this);
                break;
            case 2://左
                bullet = new Bullet(getX()-20,getY()+10,this);
                break;
            case 3://下
                bullet = new Bullet(getX()+9,getY(),this);
                break;

        }

        new Thread(bullet).start();
    }


}

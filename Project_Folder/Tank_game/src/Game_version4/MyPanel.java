package Game_version4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener,Runnable {
    //定义我的坦克
    Hero_Tank heroTank = null;
    Vector<Enemy_Tank> enemyTanksList = new Vector<>();//不考虑使用ArrayList，因为之后这个游戏会涉及多线程的问题
    int enemyTanksSize = 3;
    Vector<Bomb> bombs = new Vector<>();
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;


    public MyPanel(){
        heroTank = new Hero_Tank(100,120,7,this);

        int enemySpawnX = 300;
        for (int i = 0; i < enemyTanksSize; i++) {
            Enemy_Tank enemyTank = new Enemy_Tank(enemySpawnX,600,7,this);
            enemyTanksList.add(enemyTank);
            Bullet shot = new Bullet(enemyTank.getX(), enemyTank.getY(), enemyTank.getDirect(),this);
            enemyTank.shots.add(shot);
            new Thread(enemyTank).start();//开启敌方坦克线程，让敌方可以随机移动
            new Thread(shot).start();
            enemySpawnX+=150;
        }

        //初始化爆炸效果图
        image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/1.png"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/2.png"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/3.png"));

    }


    @Override
    public void paint(Graphics g) {
        g.setColor(Color.darkGray);
        g.fillRect(0,0,1250,900);

        gameResult(g);

        //画出坦克-封装方法
        if (heroTank != null && heroTank.isLive){
            drawTank(heroTank.getX(),heroTank.getY(),g,heroTank.getDirect(),0);//direct 0 代表向上，type0代表我方坦克
        }

        for (int i = 0; i < heroTank.shots.size(); i++) {
            Bullet bullet = heroTank.shots.get(i);
            if (bullet != null && bullet.isLive()){
                g.fillOval(bullet.getX() , bullet.getY() , 10 , 10);
            }else {
                heroTank.shots.remove(bullet);
            }

        }


        //如果bombs集合中有对象，就画出
        for (int i = 0; i < bombs.size(); i++) {
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Bomb bomb =bombs.get(i);
            if (bomb.life > 2){
                g.drawImage(image1 , bomb.x , bomb.y ,60 , 60 , this);
            }else if (bomb.life > 1){
                g.drawImage(image2 , bomb.x , bomb.y ,60 , 60 , this);
            }else {
                g.drawImage(image3 , bomb.x , bomb.y ,60 , 60 , this);
            }
            bomb.lifeDown();
            if (bomb.life == 0 ){
                bombs.remove(bomb);
            }
        }


        for (int i = 0 ; i < enemyTanksList.size() ; i++){
            Enemy_Tank enemyTank = enemyTanksList.get(i);
            if (enemyTank.isLive()) { //判断坦克是否存活，如果还活着才画出该坦克
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    Bullet shot = enemyTank.shots.get(j);//从enemyTank的Vector里取出每一个shot对象赋给这里的shot对象
                    if (shot.isLive()) {//isLive == true
                        g.fillOval(shot.getX(), shot.getY(), 10, 10);
                    } else {
                        enemyTank.shots.remove(j);//如果isLive == false表示已经超出地图或击中我方时，remove这个shot对象（销毁子弹）
                    }
                }
            }
        }


    }

    /**
     *
     * @param x 坦克的左上角x坐标
     * @param y 坦克的左上角y左边
     * @param g 画笔
     * @param direct 坦克的方向（上下左右）
     * @param type  坦克类型
     */
    public void drawTank(int x ,int y , Graphics g , int direct , int type){
        //根据不同类型的坦克，设置不同的颜色
        switch (type){
            case 0: //0代表我方坦克
                g.setColor(Color.cyan);
                break;

            case 1: //1代表敌方坦克
                g.setColor(Color.yellow);
                break;

        }
        //根据坦克不同的方向，来绘制坦克
        switch (direct){
            case 0: //0代表向上
                g.fill3DRect(x-10 , y-20, 10 ,60 , false);//坦克左轮
                g.fill3DRect(x+20 , y-20 , 10 ,60 , false);//坦克右轮
                g.fill3DRect(x , y-10, 20 ,40 , false);//坦克中间的正方形
                g.fillOval(x , y ,20 , 20);//坦克中间的圆形 （也是坐标的中心点）
                g.fillRect(x+9 , y-20 , 2 , 40);//坦克的炮管

                break;

            case 1: //向右
                g.fill3DRect(x-20 , y-10, 60 ,10 , false);//坦克左轮
                g.fill3DRect(x-20 , y+20 , 60 ,10 , false);//坦克右轮
                g.fill3DRect(x-10 , y, 40 ,20 , false);//坦克中间的正方形
                g.fillOval(x , y ,20 , 20);//坦克中间的圆形 （也是坐标的中心点）
                g.fillRect(x+3 , y+10 , 40 , 2);//坦克的炮管
                break;

            case 2: //向左
                g.fill3DRect(x-20 , y-10, 60 ,10 , false);//坦克左轮
                g.fill3DRect(x-20 , y+20 , 60 ,10 , false);//坦克右轮
                g.fill3DRect(x-10 , y, 40 ,20 , false);//坦克中间的正方形
                g.fillOval(x , y ,20 , 20);//坦克中间的圆形 （也是坐标的中心点）
                g.fillRect(x-20 , y+10 , 40 , 2);//坦克的炮管
                break;

            case 3: //向下
                g.fill3DRect(x-10 , y-20, 10 ,60 , false);//坦克左轮
                g.fill3DRect(x+20 , y-20 , 10 ,60 , false);//坦克右轮
                g.fill3DRect(x , y-10, 20 ,40 , false);//坦克中间的正方形
                g.fillOval(x , y ,20 , 20);//坦克中间的圆形 （也是坐标的中心点）
                g.fillRect(x+9 , y , 2 , 40);//坦克的炮管

                break;

        }
    }

    public void dead(Bullet s , Tank tank){

        if (tank instanceof Enemy_Tank) {
            Enemy_Tank enemy_tank = (Enemy_Tank) tank;

            if (enemy_tank.getDirect() == 0 || enemy_tank.getDirect() == 1){
                if (s.getX() < enemy_tank.getX() + 30 && s.getX() > enemy_tank.getX() - 20
                        && s.getY() < enemy_tank.getY() + 20 && s.getY() > enemy_tank.getY() - 20) {
                    s.setLive(false);
                    enemy_tank.setLive(false);
                    //创建Bomb对象，加入集合
                    Bomb bomb = new Bomb(enemy_tank.getX(),enemy_tank.getY());
                    bombs.add(bomb);
                    enemyTanksList.remove(enemy_tank);
                    enemyTanksSize--;
                }
            }

            if (enemy_tank.getDirect() == 2 || enemy_tank.getDirect() == 3){
                if (s.getX() < enemy_tank.getX() + 25 && s.getX() > enemy_tank.getX() - 25
                        && s.getY() < enemy_tank.getY() + 40 && s.getY() > enemy_tank.getY() - 40) {
                    s.setLive(false);
                    enemy_tank.setLive(false);
                    //创建Bomb对象，加入集合
                    Bomb bomb = new Bomb(enemy_tank.getX(),enemy_tank.getY());
                    bombs.add(bomb);
                    enemyTanksList.remove(enemy_tank);
                    enemyTanksSize--;
                }
            }

        }

        if(tank instanceof Hero_Tank){
            Hero_Tank hero_tank = (Hero_Tank) tank;
            if (s.getX() < hero_tank.getX() + 30 && s.getX() > hero_tank.getX() - 20
                && s.getY() < hero_tank.getY() + 20 && s.getY() > hero_tank.getY() - 20) {
                    s.setLive(false);
                    hero_tank.setLive(false);
                    Bomb bomb = new Bomb(hero_tank.getX(),hero_tank.getY());
                    bombs.add(bomb);

            }
        }

    }

    public void hitHero(){
        for (int i = 0 ; i < enemyTanksList.size() ; i++) {
            //取出敌方坦克
            Enemy_Tank enemyTank = enemyTanksList.get(i);
            //遍历该敌方坦克的所有子弹
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                //取出子弹
                Bullet bullet = enemyTank.shots.get(j);
                //判断敌方子弹是否击中我方
                if (heroTank.isLive && bullet.isLive()){
                    dead(bullet,heroTank);
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override //按下时
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            //改变坦克的方向
            heroTank.setDirect(0);//0代表上
            if ( heroTank.getY()-20 > 5 ){
                heroTank.moveUp();
            }

        }else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            //改变坦克的方向
            heroTank.setDirect(1);//1代表右边
            if ( heroTank.getX()+60 < 1245 ){
                heroTank.moveRight();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            //改变坦克的方向
            heroTank.setDirect(2);//2代表左边
            if ( heroTank.getX()-20  > 5 ){
                heroTank.moveLeft();
            }

        }else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            //改变坦克的方向
            heroTank.setDirect(3);//3代表下
            if ( heroTank.getY() +80 < 900 ){
                heroTank.moveDown();
            }
        }else if (e.getKeyCode() == KeyEvent.VK_Z){
//            if (heroTank.bullet == null || heroTank.bullet.isLive() == false) {//实现当子弹存在时无法再次发射
//            }
            heroTank.shot();

        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void gameResult(Graphics g){
        //判断输赢
        if (!(heroTank != null && heroTank.isLive)){
            Image lose = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/lose.png"));
            g.drawImage(lose,270,40,700,700,this);
        }
        if (enemyTanksList.size() == 0){
            Image win = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/win.png"));
            g.drawImage(win,270,40,700,500,this);
        }
    }


    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //判断我方是否击中敌方
            for (int i = 0; i < heroTank.shots.size(); i++) {
                Bullet bullet = heroTank.shots.get(i);
                if (heroTank.bullet != null && heroTank.bullet.isLive()){//如果玩家的子弹还存在
                    //遍历每一个敌人是否有被击中
                    for (int j = 0; i < enemyTanksSize; i++) {
                        dead(bullet , enemyTanksList.get(j));
                    }
                }
            }
            //敌人坦克是否击中我们
            hitHero();

            repaint(); //为了让子弹可以一直重绘
        }
    }
}

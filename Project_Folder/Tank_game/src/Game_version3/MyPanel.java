package Game_version3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener,Runnable {
    //定义我的坦克
    Hero_Tank heroTank = null;
    Vector<Enemy_Tank> enemyTanksList = new Vector<>();//不考虑使用ArrayList，因为之后这个游戏会涉及多线程的问题


    public MyPanel(){
        heroTank = new Hero_Tank(50,50,7);

        enemyTanksList.add(new Enemy_Tank(300,600,5));
        enemyTanksList.add(new Enemy_Tank(450,600,5));
        enemyTanksList.add(new Enemy_Tank(600,600,5));



    }


    @Override
    public void paint(Graphics g) {
        g.fillRect(0,0,1250,900);

        //画出坦克-封装方法
        drawTank(heroTank.getX(),heroTank.getY(),g,heroTank.getDirect(),0);//direct 0 代表向上，type0代表我方坦克

        //子弹
        if (heroTank.bullet != null && heroTank.bullet.isLive()){
            g.fillOval(heroTank.bullet.getX(), heroTank.bullet.getY() , 10,10);
        }


        for (int i = 0 ; i < enemyTanksList.size() ; i++){
//            drawTank(enemyTanksList.get(i).getX(),enemyTanksList.get(i).getY(),g,enemyTanksList.get(i).getDirect(),1);
            Enemy_Tank enemyTank = enemyTanksList.get(i);
            drawTank(enemyTank.getX(),enemyTank.getY(),g,enemyTank.getDirect(),1);
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override //按下时
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            //改变坦克的方向
            heroTank.setDirect(0);//0代表上
            heroTank.moveUp();
        }else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            //改变坦克的方向
            heroTank.setDirect(1);//1代表右边
            heroTank.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            //改变坦克的方向
            heroTank.setDirect(2);//2代表左边
            heroTank.moveLeft();

        }else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            //改变坦克的方向
            heroTank.setDirect(3);//3代表下
            heroTank.moveDown();

        }else if (e.getKeyCode() == KeyEvent.VK_Z){
            heroTank.shot();

        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            repaint(); //为了让子弹可以一直重绘
        }
    }
}

package Game;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    //定义我的坦克
    Hero_Tank heroTank = null;

    public MyPanel(){
        heroTank = new Hero_Tank(10,10);
    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(0,0,1250,900);

        //画出坦克-封装方法
        drawTank(heroTank.getX(),heroTank.getY(),g,0,0);//direct 0 代表向上，type0代表我方坦克
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
                g.fill3DRect(x , y, 10 ,60 , false);//坦克左轮
                g.fill3DRect(x+30 , y , 10 ,60 , false);//坦克右轮
                g.fill3DRect(x+10 , y+10, 20 ,40 , false);//坦克中间的正方形
                g.fillOval(x+9 , y+20 , 20 , 20);//坦克中间的圆形
                g.fillRect(x+19 , y , 2 , 40);//坦克中间的圆形



            default:

        }

    }

}

package learn_draw.chapter01;

import javax.swing.*;
import java.awt.*;

public class chapter01 {
    public static void main(String[] args) {
        DrawCircle dc = new DrawCircle();
    }
}

class MyPanel extends JPanel{
    //当组件第一次在屏幕显示的时候，程序会自动的调用paint（）方法来绘制组件
//在以下情况中paint（）将会被调用
//1.窗口最小化，再最大化
//2.窗口的大小发生变化
//3.repaint函数被调用
    @Override
    public void paint(Graphics g) { //重写JPanel的有参构造器
        super.paint(g); //重写构造器就要保留super

        g.drawOval(10,10,100,100);//画圆圈的方法
        g.drawLine(10,10,100,10);//x1y1起点 x2y2终点
        g.drawRect(20,20,100,100);
        g.setColor(Color.blue);
        g.fillRect(100,100,200,200);

        //获取图片资源
        Image image01 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/image01.png"));
        g.drawImage(image01,200,200,100,100,this);
        g.drawString("你好!",200,50);

    }
}

class DrawCircle extends JFrame{

    private MyPanel myPanel = null;

    public DrawCircle(){
        //初始化面板对象
        myPanel = new MyPanel();
        //把Panel放进JFrame
        this.add(myPanel);
        //设置窗口的大小
        this.setSize(1000,800);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置退出方式，当关掉窗口时程序也会关闭（如果没写的话关掉窗口程序不会停止）
        this.setVisible(true);

    }

}

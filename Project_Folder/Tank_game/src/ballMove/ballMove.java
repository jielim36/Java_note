package ballMove;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ballMove extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        ballMove bm = new ballMove();

    }


    public ballMove() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400,400);
        this.addKeyListener(mp);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel extends JPanel implements KeyListener {
    private int x=20;
    private int y=20;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x,y,20,20);
    }

    @Override  //如果有字符输入的话，该方法会触发
    public void keyTyped(KeyEvent e) {

    }

    @Override//当某个按键 按下时，该方法会触发
    public void keyPressed(KeyEvent e) {
        System.out.println((char)e.getKeyCode() + "按键按下了...");
        //根据用户按下的不同key，来处理小球的移动
        if (e.getKeyCode() == KeyEvent.VK_DOWN){//vVK_DOWN是java给键盘的箭头向下按键分配的一个值
            y+=7;
        }else if (e.getKeyCode() == KeyEvent.VK_UP){
            y-=7;
        }else if (e.getKeyCode() == KeyEvent.VK_LEFT){
        x-=7;
        }else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
        x+=7;
        }
        this.repaint();//重绘，作用：更新一次画面
    }

    @Override//当某个按键 松开时，该方法会触发
    public void keyReleased(KeyEvent e) {
        System.out.println((char)e.getKeyCode() + "按键松开了...");
    }
}
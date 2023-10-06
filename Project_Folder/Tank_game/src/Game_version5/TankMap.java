package Game_version5;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class TankMap extends JFrame {

    MyPanel mp = null;
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {


        TankMap tm = new TankMap();
    }

    public TankMap() {
        System.out.println("请输入选择 \n1：继续上一局游戏\t2. 新游戏");
        int option = input.nextInt();

        mp = new MyPanel(option);
        new Thread(mp).start();
        this.add(mp);
        this.setSize(1600,900);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //响应关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.saveGame();

                System.exit(0);
            }
        });


        this.setVisible(true);
    }
}

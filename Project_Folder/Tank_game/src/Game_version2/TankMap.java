package Game_version2;

import javax.swing.*;

public class TankMap extends JFrame {

    MyPanel mp = null;

    public static void main(String[] args) {
        TankMap tm = new TankMap();
    }

    public TankMap() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1250,900);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

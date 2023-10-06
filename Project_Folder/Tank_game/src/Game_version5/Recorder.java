package Game_version5;

import java.io.*;
import java.util.Vector;

/*
该类记录了游戏的相关信息比如击杀数，上一局游戏的记录等。和与文件交互
 */
public class Recorder {
    //定义变量，记录我方击毁敌人坦克数
    private static int EnemyNumber = 0;
    private static BufferedWriter bw = null;//处理流
    private static BufferedReader br = null;
    private static String recordFilePath = "src\\myRecord.txt";
    private static Vector<Enemy_Tank> enemyTanks = null;
    private static Hero_Tank saveHero = null;
    public static String [] heroInfoArray;
    private static Vector<Node> nodes = new Vector<>();

    public static void setSaveHero(Hero_Tank saveHero) {
        Recorder.saveHero = saveHero;
    }

    public static void setEnemyTanks(Vector<Enemy_Tank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    public static Hero_Tank getSaveHero() {
        return saveHero;
    }

    //增加一个用于读取myRecord文件，恢复游戏进度
    public static Vector<Node> getNodesAndEnemy(){
        try {
            br = new BufferedReader(new FileReader(recordFilePath));
            try {
                EnemyNumber = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                System.out.println("数据有误，将累计人数调至0");
            } finally {
                EnemyNumber = 0;
            }
            String heroInfo = "";

                heroInfo = br.readLine();
                if (heroInfo != null){
                    heroInfoArray = heroInfo.split(" ");
                }else { //如果上一局没有数据...
                    System.out.println("我方坦克数据有误! 生成默认位置");
                    String defaultSpawn = "100 120 3";
                    heroInfoArray = defaultSpawn.split(" ");
                }



            //循环读取文件，生成Nodes集合
            String line = "";
            while ((line = br.readLine()) != null){
                String [] s = line.split(" ");//读取敌方坦克信息 x y direct 信息在一行，用空格分隔三个具体信息
                Node node = new Node(Integer.parseInt(s[0]) ,   Integer.parseInt(s[1])  ,   Integer.parseInt(s[2]));
                try {
                    nodes.add(node);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return nodes;
    }

    public static void saveGame(){
        try {
            bw = new BufferedWriter(new FileWriter(recordFilePath));
            bw.write(EnemyNumber+"");
            bw.newLine();//换行

            //记录我方
            String saveHeroTank = saveHero.getX() + " " + saveHero.getY() + " " + saveHero.getDirect();
            bw.write(saveHeroTank);
            bw.newLine();

            //记录敌方坦克信息
            for (int i = 0; i < enemyTanks.size(); i++) {
                Enemy_Tank  enemyTank = enemyTanks.get(i);
                if (enemyTank.isLive()){
                    String dataEnemy = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirect();
                    bw.write(dataEnemy);
                    bw.newLine();
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    public static void addKillNumber(){
        ++Recorder.EnemyNumber;
    }

    public static int getEnemyNumber() {
        return EnemyNumber;
    }

    public static void setEnemyNumber(int enemyNumber) {
        EnemyNumber = enemyNumber;
    }
}

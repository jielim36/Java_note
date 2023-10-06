import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class HorseChessBoard {

    private static int Y = 6;//棋盘的高度 row
    private static int X = 6;//棋盘的宽度 col
    private static int [][] board = new int [Y][X];//棋盘数组
    private static boolean [] visited = new boolean[X*Y];//记录某个方格是否被访问过
    private static boolean finished = false;//记录马儿是否遍历完棋盘

    public static void main(String[] args) {
        //马儿 出生位置
        int row = 2;
        int col = 2;

        long start = System.currentTimeMillis();
        traversalChessBoard(board , row-1 , col-1 , 1);
        long end = System.currentTimeMillis();

        System.out.println("当前棋盘情况：");
        System.out.println(board);

        for (int [] rows : board) { //二维数组改成遍历多个一维数组
            for (int step : rows){ //一维数组再改成各个输入
                System.out.print(step + "\t");
            }
            System.out.println();
        }

        System.out.println("花费时长：" + (end - start));
        //还没使用贪心算法时花费的时长为：43000毫秒
        //使用贪心算法后花费的时长为：13毫秒
    }

    //该方法是编写最核心的算法，遍历棋盘，如果遍历成功，就把finished改成true
    //并且将马儿走的每一步记录到Board
    public static void traversalChessBoard(int [][] board , int row , int col , int step){
        //先把走到第几步记录到chessBoard中
        board[row][col] = step;

        //把这个位置设置成已经访问
        visited[row * X + col ] = true; //传入的row和col表示马儿当前在二维数组的位置，然后通过row*X+col可以得到具体的方格，然后对这个方格的boolean值改成true表示该方格已被访问

        //获取当前位置可以走什么方向
        ArrayList<Point> ps = next(new Point(col, row));
        sort(ps);

        //遍历
        while (!ps.isEmpty()){//如果该ArrayList不为空，就执行
            //取出一个位置(点)
            Point p = ps.remove(0);
            //判断该位置是否走过，如果没有走过我们就递归遍历
            if (!visited[p.y * X + p.x]){
                //递归遍历
                traversalChessBoard(board,p.y,p.x,step+1);
            }
        }
        //当退出while循环，看看是否遍历成功，如果没有成功，就重置相应的值，然后进行回溯
        if (step < X * Y && !finished){ //如果总步数少于整个棋盘的大小的同时，也还没有finished，就回溯
            //重置
            board[row][col] = 0;
            visited[ row * X + col] = false;
        } else {
            finished = true;//表示已通关
        }
    }


    public static ArrayList<Point> next(Point currentPoint) {
        //创建array list
        ArrayList<Point> pointsList = new ArrayList<>();

        //创建一个Point对象（点/位置），准备放入points arraylist
        Point p1 = new Point();

        //判断再currentPoint是否可以走如下位置，如果可以走，就将该点(Point) 放入到ps
        //这些位置都是从 马儿 的中心点来看它周围方向是否可以走，比如位置5并不是局限在位置5，而是一个的方向，
        // 也就是说这些位置其实只是马儿走的方向，比如位置5走左偏上，位置6走上偏左，位置7走上偏右，位置0走右偏上
        //共有八种方向(位置 0-7)

        //判断是否可以走位置5
        if ((p1.x = currentPoint.x - 2) >= 0 && (p1.y = currentPoint.y - 1) >= 0) {
            pointsList.add(new Point(p1));
        }

        //判断是否可以走位置6
        if ((p1.x = currentPoint.x - 1) >= 0 && (p1.y = currentPoint.y - 2) >= 0) {
            pointsList.add(new Point(p1));
        }

        //判断是否可以走位置7
        if ((p1.x = currentPoint.x + 1) < X && (p1.y = currentPoint.y - 2) >= 0) {
            pointsList.add(new Point(p1));
        }

        //判断是否可以走位置0
        if ((p1.x = currentPoint.x + 2) < X && (p1.y = currentPoint.y - 1) >= 0) {
            pointsList.add(new Point(p1));
        }

        //判断是否可以走位置1
        if ((p1.x = currentPoint.x + 2) < X && (p1.y = currentPoint.y + 1) < Y) {
            pointsList.add(new Point(p1));
        }

        //判断是否可以走位置2
        if ((p1.x = currentPoint.x + 1) < X && (p1.y = currentPoint.y + 2) < Y) {
            pointsList.add(new Point(p1));
        }

        //判断是否可以走位置3
        if ((p1.x = currentPoint.x - 1) >= 0 && (p1.y = currentPoint.y + 2) < Y) {
            pointsList.add(new Point(p1));
        }

        //判断是否可以走位置4
        if ((p1.x = currentPoint.x - 2) >= 0 && (p1.y = currentPoint.y + 1) < Y) {
            pointsList.add(new Point(p1));
        }

        return pointsList;
    }

    //贪心算法的部分
    //写一个方法，对ps的各个位置，可以走的下一个位置的次数进行排序，把可能走的下一个位置从小到大排序
    //然后从选择较少的路径先走就可以有效的减少回溯次数
    public static void sort(ArrayList<Point> ps){
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return next(o1).size() - next(o2).size();//两个对象相减后可以得到
            }
        });
    }

}

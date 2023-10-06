import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int n,i,qt,count=0,temp,sq=0,bt[],wt[],tat[],rem_bt[];
        float awt=0,atat=0;
        bt = new int[10];//Burst Time:是进程在 CPU 上执行所花费的总时间。它也被称为执行时间。
        wt = new int[10];//Waiting Time:这是进程完成执行所花费的时间。Waiting Time = Turnaround Time - Burst Time
        tat = new int[10];//Turn Around Time：这是进程在系统中存在的时间量。Turn around time = Completion Time - Arrival Time
        rem_bt = new int[10];
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the number of process (maximum 10) = ");
        n = s.nextInt();//输入CPU此时的模拟Process数量
        System.out.print("Enter the burst time of the process\n");
        for (i=0;i<n;i++)//输入每个process的Burst Time
        {
            System.out.print("P"+i+" = ");
            bt[i] = s.nextInt();
            rem_bt[i] = bt[i];
        }
        System.out.print("Enter the quantum time: ");
        qt = s.nextInt();//输入Quantum Time
        while(true)
        {
            for (i=0,count=0 ; i<n ; i++)//轮流执行每一个process一次
            {
                temp = qt;//将时间片大小（Quantum Time）赋值给变量temp，表示当前进程可以执行的时间片大小。
                if(rem_bt[i] == 0)//检查当前进程的Burst Time是否为0，如果是0，则表示该进程已经执行完毕.
                {
                    count++;//该进程已经执行完毕，将count加1，并继续下一个循环。
                    continue;
                }
                if(rem_bt[i]>qt) {//如果该Process的BurstTime 大于 Quantum Time，表示执行了Quantum Time后还未完成工作，准备下一次循环继续工作
                    //如果是，则表示该进程执行了一个Quantum Time,但还没完成全部工作，将剩余时间减去时间片大小。
                    rem_bt[i] = rem_bt[i] - qt;
                }else if(rem_bt[i]>=0)//来到这里就表示Quantum Time大于该Process的Burst Time, 这次的执行就可以完成工作了
                {
                    temp = rem_bt[i];
                    rem_bt[i] = 0;//把该Process的Burst Time设为0，下一次循环可以count++ 记录已有一个Process完成工作
                }
                sq = sq + temp;//total time目前花费的时间
                tat[i] = sq;//把目前的时间赋给当前正在执行的process
            }
            if(n == count) //当全部Process都完成工作后停止循环
                break;
        }
        System.out.print("--------------------------------------------------------------------------------");
        System.out.print("\nProcess\t   Burst Time\t   Turnaround Time\t    Waiting Time\n");
        System.out.print("--------------------------------------------------------------------------------");
        for(i=0;i<n;i++)
        {
            wt[i]=tat[i]-bt[i];//waiting time = turn around time - burst time
            awt=awt+wt[i];//average waiting time
            atat=atat+tat[i];//average turn around time
            System.out.print("\n "+(i+1)+"\t\t\t "+bt[i]+"\t\t\t\t "+tat[i]+"\t\t\t\t "+wt[i]+"\n");
        }
        awt=awt/n;
        atat=atat/n;
        System.out.println("\nAverage waiting Time = "+awt+"\n");
        System.out.println("Average turnaround time = "+atat);
    }
}
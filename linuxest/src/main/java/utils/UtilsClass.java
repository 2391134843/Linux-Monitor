package utils;

import gui.MyActionListener;
import gui.MyActionListener2;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class UtilsClass {

    /**
     * 显示此CPU的关键信息内容：CPU频率范围，当然CPU频率等等..
     */
    public  static void useLinuxCommond(){
        try {
            Process p = Runtime.getRuntime().exec("lscpu");  //调用Linux的相关命令-列出cpu信息
//            Process p = Runtime.getRuntime().exec("gnome-terminal -e 'bash -c ls; exec bash'");  //调用Linux的相关命令-列出cpu信息
//            Process p = Runtime.getRuntime().exec("s-tui");  //调用Linux的相关命令
//            Process p = Runtime.getRuntime().exec("vmstat");  //调用Linux的相关命令
//            Process p = Runtime.getRuntime().exec("vmstat -n 3");  //调用Linux的相关命令
//            Process p = Runtime.getRuntime().exec("cpupower frequency-info");  //调用Linux的相关命令
            InputStreamReader ir = new InputStreamReader(p.getInputStream());
            LineNumberReader input = new LineNumberReader (ir);      //创建IO管道，准备输出命令执行后的显示内容
            String line;
            String line2="内容:"+"\n";
            while ((line = input.readLine ()) != null){     //按行打印输出内容
                System.out.println(line);
                line2 = line2 + line+"\n";
                MyActionListener.textField.setText(line2+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * vmstat
     *PROC(ESSES)
     * --r:如果在processes中运行的序列(process r)是连续的大于在系统中的CPU的个数表示系统现在运行比较慢,有多数的进程等待CPU.
     * 如果r的输出数大于系统中可用CPU个数的4倍的话,则系统面临着CPU短缺的问题,或者是CPU的速率过低,系统中有多数的进程在等待CPU,造成系统中进程运行过慢.
     * SYSTEM
     * --in:每秒产生的中断次数
     * --cs:每秒产生的上下文切换次数
     * 上面2个值越大，会看到由内核消耗的CPU时间会越大
     * CPU
     * -us:用户进程消耗的CPU时间百分
     * us的值比较高时，说明用户进程消耗的CPU时间多，但是如果长期超50%的使用，那么我们就该考虑优化程序算法或者进行加速（比如PHP/PERL）
     * -sy:内核进程消耗的CPU时间百分比（sy的值高时，说明系统内核消耗的CPU资源多，这并不是良性表现，我们应该检查原因）
     * -wa:IO等待消耗的CPU时间百分比
     * wa的值高时，说明IO等待比较严重，这可能由于磁盘大量作随机访问造成，也有可能磁盘出现瓶颈（块操作）。
     * -id:CPU处于空闲状态时间百分比,如果空闲时间(cpu id)持续为0并且系统时间(cpu sy)是用户时间的两倍(cpu us) 系统则面临着CPU资源的短缺.
     * r
     * 当前可运行的进程数。
     * b
     * 等待I/O完成的被阻塞进程数
     * in
     * 系统发生中断的次数
     *
     * cs
     * 系统发生上下文切换的次数
     *
     * us
     * 用户进程消耗的CPU时间百分比
     *
     * sy
     * 系统进程消耗的CPU时间百分比
     *
     * id
     * 系统空闲时间的百分比
     *
     * wa
     * 等待IO消耗的总的CPU时间百分比
     */
    public  static void useLinuxCommond2(){
        try {
//            Process p = Runtime.getRuntime().exec("lscpu");  //调用Linux的相关命令-列出cpu信息
//            Process p = Runtime.getRuntime().exec("s-tui");  //调用Linux的相关命令
//            Process p = Runtime.getRuntime().exec("vmstat");  //调用Linux的相关命令
            /**
             * root@ubuntu:~# vmstat 2 1
             * procs -----------memory---------- ---swap-- -----io---- -system-- ----cpu----
             *  r  b   swpd   free   buff  cache   si   so    bi    bo   in   cs us sy id wa
             *  1  0      0 3498472 315836 3819540    0    0     0     1    2    0  0  0 100  0
             * 2表示每个两秒采集一次服务器状态，1表示只采集一次。
             */
            MyActionListener2.textField.setText("请等待10s...系统正在记录CPU状况："+"\n");

            Process p = Runtime.getRuntime().exec("vmstat 2 5");  //调用Linux的相关命令
            InputStreamReader ir = new InputStreamReader(p.getInputStream());
            LineNumberReader input = new LineNumberReader (ir);      //创建IO管道，准备输出命令执行后的显示内容

            String line;
            String line2="内容:"+"\n";
            while ((line = input.readLine ()) != null){     //按行打印输出内容
                System.out.println(line);
                line2 = line2 + line+"\n";
                MyActionListener2.textField.setText(line2+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 意见优化cpu
     */
    public  static void useLinuxCommond3(){
        try {
            /**
             * ifconfig ${Interface} mtu ${SIZE} up
             * ifconfig eth1 mtu 9000 up
             */
            Process p = Runtime.getRuntime().exec("ifconfig ${Interface} mtu ${SIZE} up");  //调用Linux的相关命令-列出cpu信息
//            Process p = Runtime.getRuntime().exec("s-tui");  //调用Linux的相关命令
//            Process p = Runtime.getRuntime().exec("vmstat");  //调用Linux的相关命令
//            Process p = Runtime.getRuntime().exec("vmstat -n 3");  //调用Linux的相关命令
//            Process p = Runtime.getRuntime().exec("cpupower frequency-info");  //调用Linux的相关命令
            /**
             * 待写入进去的参数值，利用改变mtu参数来优化CPU
             */
            InputStreamReader ir = new InputStreamReader(p.getInputStream());
            LineNumberReader input = new LineNumberReader (ir);      //创建IO管道，准备输出命令执行后的显示内容
            String line;
            String line2="内容:"+"\n";
            while ((line = input.readLine ()) != null){     //按行打印输出内容
                System.out.println(line);
                line2 = line2 + line+"\n";
                MyActionListener.textField.setText(line2+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打开监控CPU温度频率界面
     */
    public  static void useLinuxCommond4(){
        try {
//            Process p = Runtime.getRuntime().exec("lscpu");  //调用Linux的相关命令-列出cpu信息
            Process p = Runtime.getRuntime().exec("gnome-terminal -e 's-tui'");  //打开温度与CPU频率等监控界面
//            Process p = Runtime.getRuntime().exec("gnome-terminal -e 'bash -c ls; exec bash'");  //调用Linux的相关命令-列出cpu信息
//            Process p = Runtime.getRuntime().exec("s-tui");  //调用Linux的相关命令
//            Process p = Runtime.getRuntime().exec("vmstat");  //调用Linux的相关命令
//            Process p = Runtime.getRuntime().exec("vmstat -n 3");  //调用Linux的相关命令
//            Process p = Runtime.getRuntime().exec("cpupower frequency-info");  //调用Linux的相关命令
            InputStreamReader ir = new InputStreamReader(p.getInputStream());
            LineNumberReader input = new LineNumberReader (ir);      //创建IO管道，准备输出命令执行后的显示内容
            String line;
            String line2="内容:"+"\n";
            while ((line = input.readLine ()) != null){     //按行打印输出内容
                System.out.println(line);
                line2 = line2 + line+"\n";
                MyActionListener.textField.setText(line2+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        utils.UtilsClass utils.UtilsClass = new utils.UtilsClass();
        UtilsClass.useLinuxCommond();
    }

}

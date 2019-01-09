package com.imooc.task;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@Component
public class TimerDemo implements ApplicationListener<ContextRefreshedEvent> {

    public static void main(String[] args) {
//        timer1();
//        timer2();
//        timer3();
        timer4();
    }

    /**
     * 第一种方法：设定指定任务task在指定时间time执行
     * schedule(TimerTask task, Date time)
     */
    public static void timer1(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("------timer1方法执行-------");
            }
        },5000);// 程序启动后，过1秒再执行；然后退出 (只执行一次，然后就不再执行了！)
    }

    /**
     * 第二种方法：设定指定任务task在指定延迟delay后进行固定延迟peroid的执行
     * schedule(TimerTask task, long delay, long period)
     */
    public static void timer2(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("------timer2方法执行-------");
            }
        },1000,5000);// 程序启动后，过一秒再执行；然后每隔5秒执行一次
    }

    /**
     * 第三种方法：设定指定任务task在指定延迟delay后进行固定频率peroid的执行
     * scheduleAtFixedRate(TimerTask task, long delay, long period)
     */
    public static void timer3(){
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("------timer3方法执行-------");
            }
        },1000,2000);// 程序启动后，过一秒再执行；然后每隔2秒执行一次
    }

    /**
     * 第四种方法：安排指定的任务task在指定的时间firstTime开始进行重复的固定速率period执行
     * scheduleAtFixedRate(TimerTask task,Date firstTime,long period)
     */
    public static void timer4(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12); // 控制时
        calendar.set(Calendar.MINUTE, 0); // 控制分
        calendar.set(Calendar.SECOND, 0); // 控制秒
        Date time = calendar.getTime();     // 得出执行任务的时间,此处为今天的12：00：00

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("------timer4方法执行-------");
            }
        },time, 1000 * 60 * 60 * 24);// 程序启动后，将在每天的这个时间"12:00:00"执行
    }

    @Scheduled(fixedDelay = 1000 * 20)
    public static void schedule(){
        System.out.println("------schedule方法执行-------");
    }

    /**
     * 容器启动时执行
     * @param contextRefreshedEvent
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("------容器启动时执行的方法-------");
            }
        },1000);
    }
}

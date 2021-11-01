package cn.com.xvym.learning.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Xv
 * @Date: 2021/8/8 23:08
 * @Description:
 */
@Slf4j
public class AtomicBooleanTest {

    public static volatile boolean flag = true;

    private AtomicInteger atomicInteger;

    private ReentrantLock reentrantLock;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 500; i++) {
            Thread t1 = new Thread(() -> doSomeThing("张三"));
            Thread t2 = new Thread(() -> doSomeThing("李四"));
            t1.start();
            t2.start();
            Thread.sleep(5000);
        }
    }

    public static void doSomeThing(String name) {
        if (flag) {
            System.out.println(name + "起床");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "睡觉");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "吃饭");try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            flag = !flag;
        } else {
            System.out.println(name + "起不了床！因为有人正在占着茅坑！");
        }
    }

}

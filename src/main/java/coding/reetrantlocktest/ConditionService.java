/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : ConditionService
 * Date Created : 2024-05-06
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-05-06       Admin     xxx
 * --------------------------------------------------------------------
 */

package coding.reetrantlocktest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: coding.reetrantlocktest
 * @description: xxx
 * @author: Admin
 * @create: 2024-05-06
 **/
public class ConditionService {

    // 通过nextThread控制下一个执行的线程
    private static int nextThread = 1;
    private ReentrantLock lock = new ReentrantLock();
    // 有三个线程，所以注册三个Condition
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();

    public void excuteA() {
        try {
            lock.lock();
            while (nextThread != 1) {
                conditionA.await();
            }
            //conditionA.await();
            System.out.println(Thread.currentThread().getName() + " 工作");
            nextThread = 2;
            conditionB.signalAll();
            //conditionA.await();
            /*if(nextThread==1){
                System.out.println(Thread.currentThread().getName() + " 工作");
                nextThread = 2;
                conditionB.signalAll();
                conditionA.await();
            }*/

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void excuteB() {
        try {
            lock.lock();
            while (nextThread != 2) {
                conditionB.await();
            }
            //如果不while，直接在下面await，那么当app启动，在excuteA 还没conditionB.signalAll();之前，excuteB已经执行到了conditionB.await();于是就永远await了下去
            //conditionB.await();
            System.out.println(Thread.currentThread().getName() + " 工作");
            nextThread = 3;

            conditionC.signalAll();
            //conditionB.await();
            /*if(nextThread!=1){
                System.out.println(Thread.currentThread().getName() + " 工作");
                nextThread = 3;

                conditionC.signalAll();
                conditionB.await();
            }*/
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void excuteC() {
        try {
            lock.lock();
            while (nextThread != 3) {
                conditionC.await();
            }
            //conditionC.await();
            System.out.println(Thread.currentThread().getName() + " 工作");
            nextThread = 1;

            conditionA.signalAll();
            //conditionC.await();
            /*if(nextThread!=1){
                System.out.println(Thread.currentThread().getName() + " 工作");
                nextThread = 1;

                conditionA.signalAll();
                conditionC.await();
            }*/
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
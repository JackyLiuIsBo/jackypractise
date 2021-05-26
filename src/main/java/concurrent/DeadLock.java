package concurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class DeadLock {
    private Object lockA = new Object();
    private Object lockB = new Object();

    public void getLock(){


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockA){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("join lockB");
                    synchronized (lockB){

                    }
                }
            }
        }).start();

        new Thread(()->{
            synchronized(lockB){
                try {
                    Thread.sleep(Long.parseLong("1000"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("join lockA");
                synchronized (lockA) {
                }
                }
        }).start();
    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(t1,t2) ->{
                if(t1[0] != t2[0]){
                    return t2[0] - t1[0];
                }else{
                    return t1[1] - t2[1];
                }
            }
        );
        ArrayList<int []> result = new ArrayList();
        for(int [] temp : people){
            result.add(temp[1],temp);
        }
        return   result.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        //int [][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        //int[][] ints1 = reconstructQueue(people);
        DeadLock deadLock = new DeadLock();
        deadLock.getLock();
    }
}

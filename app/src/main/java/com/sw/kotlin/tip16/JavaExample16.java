package com.sw.kotlin.tip16;


public class JavaExample16 {

    /**
     * 定义策略接口
     */
    public interface Strategy {
        void doSth();
    }

    /**
     * A策略
     */
    public static class AStrategy implements Strategy {
        @Override
        public void doSth() {
            System.out.println("Do A Strategy");
        }
    }

    /**
     * B策略
     */
    public static class BStrategy implements Strategy {
        @Override
        public void doSth() {
            System.out.println("Do B Strategy");
        }
    }

    /**
     * 策略实施者
     */
    public static class Worker {

        private Strategy strategy;

        public Worker(Strategy strategy) {
            this.strategy = strategy;
        }

        public void work() {
            System.out.println("START");
            if (strategy != null) {
                strategy.doSth();
            }
            System.out.println("END");
        }
    }


    /*
    * 测试策略
    * */
    public void testStrategy() {
        Worker worker1 = new Worker(new AStrategy());
        Worker worker2 = new Worker(new BStrategy());
        worker1.work();
        worker2.work();
    }


}

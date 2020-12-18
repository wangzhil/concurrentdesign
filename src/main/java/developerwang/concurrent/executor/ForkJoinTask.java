package developerwang.concurrent.executor;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author wangzhilei
 * @version V1.0
 * @Package developerwang.concurrent.executor
 * @description
 * @date 2020/12/18 15:59
 * @Copyright © 2020-2021 sinosoft.com.cn
 */
public class ForkJoinTask extends RecursiveTask<Long> {

    private static final int THRESHOLD = 10000;
    private long start;
    private long end;

    public ForkJoinTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask forkJoinTask = new ForkJoinTask(0, 200000L);
        ForkJoinTask result = (ForkJoinTask) forkJoinPool.submit(forkJoinTask);
        try {
            long res  = result.get();
            System.out.println("sum = " + res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Long compute() {
        long sum = 0;
        boolean canCompute = (end - start) < THRESHOLD;
        if (canCompute) {
            for (long i = start; i <= end; i ++) {
                sum += i;
            }
        } else {
            long step = (start + end ) / 100;
            ArrayList<ForkJoinTask> subTasks = new ArrayList<ForkJoinTask>();
            long pos = start;
            for (int i = 0; i < 100; i++) {
                long lastOne = pos + step;
                if (lastOne > end) {
                    lastOne = end;
                }
                ForkJoinTask subTask = new ForkJoinTask(pos, lastOne);
                pos += step + 1;
                subTasks.add(subTask);
                subTask.fork();
            }
            for (ForkJoinTask fork : subTasks) {
                sum += fork.join();
            }
        }
        return sum;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tournament.impl.executor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Tobias
 */
public class MultiThreadMatchExecutor implements MatchExecutor
{
    private final int numberOfThreads;

    public MultiThreadMatchExecutor(int numberOfThreads)
    {
        this.numberOfThreads = numberOfThreads;
    }

    @Override
    public void executeAll(List<Runnable> matches)
    {
        ExecutorService executor;
        if (numberOfThreads < 1)
        {
            executor = Executors.newCachedThreadPool();
        }
        else if (numberOfThreads == 1)
        {
            for (Runnable r : matches)
            {
                r.run();
            }
            return;
        }
        else
        {
            executor = Executors.newFixedThreadPool(numberOfThreads);
        }
        
        for (Runnable r : matches)
        {
            executor.submit(r);
        }
        executor.shutdown();

        while (!executor.isTerminated())
        {
            try
            {
                executor.awaitTermination(1, TimeUnit.MINUTES);
            } catch (InterruptedException ex)
            {
            }
        }
    }

}

package testbench;

import GUI.Main;
import bench.CPU.CPUThreadedRoots;
import bench.IBenchmark;
import logging.ConsoleLogger;
import logging.ILogger;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

public class TestCPUThreadRoots {
    public void method2() {
        int nThreads = Runtime.getRuntime().availableProcessors();
        ITimer timer = new Timer();
        ILogger log = new ConsoleLogger();
        IBenchmark benchmark = new CPUThreadedRoots();
        benchmark.initialize(1000000);
        timer.start();
        benchmark.run(nThreads);
        long time = timer.stop();
        log.write("Finished in", TimeUnit.convert(time, TimeUnit.Milli) + " ms");
        Main.str_root = "finished in " + TimeUnit.convert(time, TimeUnit.Milli) + " ms";
        Main.score += TimeUnit.convert(time, TimeUnit.Milli);
        System.out.println(Main.str_root);
        log.write(benchmark.getClass());

        benchmark.clean();
        log.close();
    }
}

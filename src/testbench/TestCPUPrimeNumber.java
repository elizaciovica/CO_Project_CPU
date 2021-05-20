package testbench;

import GUI.Main;
import bench.CPU.CPUPrimeNumber;
import bench.IBenchmark;
import logging.ConsoleLogger;
import logging.ILogger;
import timing.ITimer;
import timing.Timer;
import logging.TimeUnit;

public class TestCPUPrimeNumber{
    public void method1() {

        ITimer timer = new Timer();
        ILogger log = new ConsoleLogger();
        IBenchmark benchmark = new CPUPrimeNumber();
        benchmark.initialize(1000);
        int k = 0;
            timer.start();
            benchmark.run(50000);
            long time = timer.stop();
            log.write("Finished in ", TimeUnit.convert(time, TimeUnit.Milli) + "ms");
            Main.alo3 = "Finished in " + TimeUnit.convert(time, TimeUnit.Milli) + "ms";

        System.out.println(Main.alo3);
        log.write(benchmark.getClass());

        benchmark.clean();
        log.close();


    }

}
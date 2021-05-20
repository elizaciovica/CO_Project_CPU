package testbench;

import bench.CPU.CPUDigitsOfPi;
import bench.IBenchmark;
import logging.ConsoleLogger;
import logging.FileLogger;
import logging.ILogger;
import timing.ITimer;
import timing.Timer;
import logging.TimeUnit;


public class TestCPUDigitsOfPi {
    public void method() {
        ITimer timer = new Timer();
        //put here the path in your pc
        ILogger log = new FileLogger("D:\\an2CTIeng\\semII\\CO\\CO_Project_CPU\\Output.txt\\"   );
        IBenchmark benchmark = new CPUDigitsOfPi();
        benchmark.initialize(1000);
        benchmark.warmUp();
        timer.start();
        benchmark.run(1);
        long time = timer.stop();
        log.write("Finished in", TimeUnit.convert(time, TimeUnit.Milli) + "ms");
        log.write(benchmark.getClass());

        benchmark.clean();
        log.close();


    }
}

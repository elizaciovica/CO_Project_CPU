package testbench;

import bench.CPU.CPUDigitsOfPi;
import bench.IBenchmark;
import logging.ConsoleLogger;
import logging.ILogger;
import timing.ITimer;
import timing.Timer;
import logging.TimeUnit;


public class TestCPUDigitsOfPi {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILogger log = new ConsoleLogger();
        IBenchmark benchmark = new CPUDigitsOfPi();
        benchmark.initialize(1000);
        timer.start();
        benchmark.run(0);
        long time = timer.stop();
        log.write("Finished in", TimeUnit.convert(time, TimeUnit.Milli) + "ms");
        log.write(benchmark.getClass());

        benchmark.clean();
        log.close();


    }
}

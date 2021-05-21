package testbench;

import GUI.Main;
import bench.CPU.CPUDigitsOfPi;
import bench.CPU.CPUFixedPoint;
import bench.IBenchmark;
import logging.ConsoleLogger;
import logging.ILogger;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

public class TestCPUFixedPoint {
    public void method4() {

        ITimer timer = new Timer();
        ILogger log = new ConsoleLogger();
        IBenchmark benchmark = new CPUFixedPoint();
        benchmark.initialize(1000000);
        timer.start();
        benchmark.run(2);
        long time = timer.stop();
        log.write("Finished in ", TimeUnit.convert(time, TimeUnit.Milli) + " ms");
        Main.str_fixed ="finished in "+ TimeUnit.convert(time, TimeUnit.Milli) + " ms";
        Main.score += TimeUnit.convert(time, TimeUnit.Milli);
        System.out.println(Main.str_fixed);
        log.write(benchmark.getClass());

        benchmark.clean();
        log.close();


    }
}

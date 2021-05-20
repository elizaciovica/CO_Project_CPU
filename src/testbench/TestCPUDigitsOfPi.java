package testbench;

import GUI.Main;
import bench.CPU.CPUDigitsOfPi;
import bench.IBenchmark;
import logging.ConsoleLogger;
import logging.ILogger;
import timing.ITimer;
import timing.Timer;
import logging.TimeUnit;


public class TestCPUDigitsOfPi {
    public void method() {

        ITimer timer = new Timer();
        ILogger log = new ConsoleLogger();
        IBenchmark benchmark = new CPUDigitsOfPi();
        benchmark.initialize(1000);
        timer.start();
        benchmark.run(0);
        long time = timer.stop();
        log.write("Finished in", TimeUnit.convert(time, TimeUnit.Milli) + "ms");
         Main.alo ="Finished in "+ TimeUnit.convert(time, TimeUnit.Milli) + "ms";
         System.out.println(Main.alo);
        log.write(benchmark.getClass());

        benchmark.clean();
        log.close();


    }
}

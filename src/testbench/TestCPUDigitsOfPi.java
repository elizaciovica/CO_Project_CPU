
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
        log.write("Finished in", TimeUnit.convert(time, TimeUnit.Milli) + " ms");
        Main.str_pi ="finished in "+ TimeUnit.convert(time, TimeUnit.Milli) + " ms";
        Main.score += TimeUnit.convert(time, TimeUnit.Milli);
        System.out.println(Main.str_pi);
        log.write(benchmark.getClass());

        benchmark.clean();
        log.close();


    }
}
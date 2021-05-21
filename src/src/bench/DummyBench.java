package bench;

import bench.IBenchmark;
import logging.ConsoleLogger;
import logging.ILogger;
import timing.ITimer;
import timing.Timer;

public class DummyBench implements IBenchmark {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILogger log = new ConsoleLogger();
        IBenchmark bench = new DummyBench();
        bench.initialize(100000);
        timer.start();
        bench.run();
        log.write("Finished in ", timer.stop(), "ns");

        log.close();

    }



    @Override
    public void run() {

    }

    @Override
    public void run(Object... objects) {

    }

    @Override
    public void initialize(Object... objects) {

    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void warmUp() {

    }
}
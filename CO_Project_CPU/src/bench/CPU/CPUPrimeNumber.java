package bench.CPU;

import GUI.Main;
import bench.IBenchmark;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CPUPrimeNumber implements IBenchmark {
    private int result;
    private boolean running;

    @Override
    public void initialize(Object... params) {
        this.result = 0;
    }

    @Override
    public void warmUp() {
        this.run(10000);
    }

    @Override
    public void run() {

    }

    @Override
    public void run(Object... options) {
        int size=(Integer)options[0];
        this.result=0;

        for (int i=1; i<size;i++)
            if (isPrime(i)) result++;
    }


    @Override
    public void cancel() {

    }

    @Override
    public void clean() {

    }


    private boolean isPrime(int x) {
        if (x == 1)
            return false;
        for (int i = 2; i < x; i++)
            if (x % i == 0)
                return false;
        return true;
    }
}


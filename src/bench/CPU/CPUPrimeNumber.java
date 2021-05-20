package bench.CPU;

import GUI.Main;
import bench.IBenchmark;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CPUPrimeNumber implements IBenchmark {
    private int result;
    private int no_of_digits;

    @Override
    public void run() {

    }

    @Override
    public void run(Object... options) {
        int size=(Integer)options[0];
        this.result=0;

        for (int i=1; i<size;i++)
            if (isPrime(i)) {
                result++;
            }
    }

    @Override
    public void initialize(Object... objects) {
        if (objects[0] instanceof Integer) {
            this.no_of_digits = ((Integer) objects[0]).intValue();
        }

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


    private boolean isPrime(int x) {
        if (x == 1)
            return false;
        for (int i = 2; i < x; i++)
            if (x % i == 0)
                return false;
        return true;
    }
}


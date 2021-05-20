package bench.CPU;

import GUI.Main;
import bench.IBenchmark;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CPUDigitsOfPi implements IBenchmark {

    private int no_of_digits;

    @Override
    public void run() {

    }

    @Override
    public void run(Object... objects) {
        int option = (Integer) objects[0];
        switch (option) {
            case 0 :
                this.bailey_borwein_plouffe();
                break;
            default:
                throw new IllegalArgumentException("Option must be 0 or 1!");

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
/**The reason this pi formula is so interesting is because it can be used to calculate the N-th digit of Pi (in base 16)
 *  without having to calculate all of the previous digits!**/
    private void bailey_borwein_plouffe() {
        BigDecimal pi = BigDecimal.ZERO;
        for (int k = 0; k < this.no_of_digits; k++) {
            BigDecimal a = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(16).pow(k), 30, RoundingMode.HALF_UP);
            BigDecimal aux1 = BigDecimal.valueOf(4).divide(BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(k)).add(BigDecimal.valueOf(1)), 30, RoundingMode.HALF_UP);
            BigDecimal aux2 = BigDecimal.valueOf(2).divide(BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(k)).add(BigDecimal.valueOf(4)), 30, RoundingMode.HALF_UP);
            BigDecimal aux3 = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(k)).add(BigDecimal.valueOf(5)), 30, RoundingMode.HALF_UP);
            BigDecimal aux4 = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(k)).add(BigDecimal.valueOf(6)), 30, RoundingMode.HALF_UP);
            BigDecimal b = aux1.subtract(aux2).subtract(aux3).subtract(aux4);
            pi = pi.add(a.multiply(b));
        }
        System.out.println("PI: " + pi);



    }
}

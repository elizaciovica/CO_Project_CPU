
package bench.CPU;

import bench.IBenchmark;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CPUDigitsOfPi implements IBenchmark {

    private int no_of_digits;
    private int[] A;
    private int array_size, nines, predigit;


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
            case 1:
                this.Spigot_algorithm();
                break;
            default:
                throw new IllegalArgumentException(" Option must be 0 or 1!");
        }

    }

    @Override
    public void initialize(Object... objects) {

        if (objects[0] instanceof Integer) {
            //for bailey borwein pouffe
            this.no_of_digits = ((Integer) objects[0]).intValue();

            //for spigot algorithm
            array_size = (int)(Math.floor(10*this.no_of_digits)+1);
            this.A = new int[array_size];
            for(int i = 0; i < array_size; i++) {
                this.A[i] = 2;
            }
            this.nines = 0;
            this.predigit = 0;

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
        this.run(0);

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
/**The algorithm generates the digits sequentially, one at a time, and does not use the digits after they are computed. **/
    private void Spigot_algorithm() {
        StringBuffer pi = new StringBuffer();

        for(int j = 1; j < this.no_of_digits+1; j++) {
            int q = 0; //quantient

            for(int i = array_size; i > 0; i--) {
                int r = 10 * A[i-1] + q*i;
                A[i-1] = r % (2*i-1);
                q = r/(2*i-1);
            }

            A[0] = q%10;
            q = q/10;
            if(q == 9) {
                this.nines++;
            }
            else if(q == 10) {
                pi.append(predigit+1);
                for(int k = 0; k < nines; k++) {
                    pi.append(0);
                }
                predigit = 0;
                nines = 0;
            }
            else {
                pi.append(predigit);
                predigit = q;
                if(nines != 0) {
                    for(int k = 0; k < nines; k++) {
                        pi.append(9);
                    }
                }
                nines = 0;
            }
        }
        pi.append(predigit);
        System.out.println("PI: " + pi);
    }
}

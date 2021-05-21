package bench.CPU;

import bench.IBenchmark;

import java.util.Random;

public class CPUFixedPoint implements IBenchmark {

    private int[] num;
    private int[] res;
    private int[] aux;
    private int size;
    int j,k,l;

    @Override
    public void run() {

    }

    @Override
    public void run(Object... options) {

        int opt = (Integer) options[0];
        switch (opt) {
            case 0:
                operationsTest();
                break;
            case 1:
                branchTest();
                break;
            case 2:
                arrayAcess();
                break;
            default:
                throw new IllegalArgumentException(" Option must be 0 or 1 or 2!");
        }


    }

    @Override
    public void initialize(Object... params) {

        size=((Integer)params[0]).intValue();

        if (size<5) size=5;

        res=new int[size];
        aux=new int[size];
        num=new int[size];
        Random rand=new Random();

        for (int i=0; i<size; i++) {
            num[i] = i;
            res[i] = 0;
            aux[i] = 0;
        }

        j=10; k=25; l=40;
    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void warmUp() {

        int warmSize= (int) Math.ceil(0.1*size)+4;

        for (int i=0; i<warmSize; i++) {
            j=num[1] *(k-j)*(l-k);
            k=num[3] * k - (l-j)*k;
            l=(l-k)*(num[2]+j);
            res[i]=j+k+l;
            num[i]=j*k*l;
        }

        for (int i=0; i<warmSize; i++) {

            if (j == 1) j = num[2];
            else if (j == 2) j = num[3];

            if (j>2) j=num[0];
            else j=num[1];

            if (j<1) j=num[1];
            else j=num[0];
        }

        for (int i=0; i<warmSize; i++) {
            aux[i]=res[i];
            res[i]=num[i];
            num[i]=res[i];
            aux[i]=res[i];
            res[i]=num[i];
            num[i]=res[i];
        }

    }


    private void operationsTest () {

        for (int i=2; i<size; i++) {
            j=num[1] *(k-j)*(l-k);
            k=num[3] * k - (l-j)*k;
            l=(l-k)*(num[2]+j);
            res[i-2]=j+k+l;
            res[i-2]=j*k*l;
        }
    }

    private void branchTest() {
        for (int i=0; i<size; i++) {

            if (j == 1) j = num[2];
            else if (j == 2) j = num[3];

            if (j>2) j=num[0];
            else j=num[1];

            if (j<1) j=num[1];
            else j=num[0];
        }
    }

    private void arrayAcess() {
        for (int i=0; i<size; i++) {
            aux[i]=res[i];
            res[i]=num[i];
            num[i]=res[i];
            aux[i]=res[i];
            res[i]=num[i];
            num[i]=res[i];
        }
    }

    public int getOps() {
        return 27;
    }
}
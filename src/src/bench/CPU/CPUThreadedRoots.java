package bench.CPU;

import bench.IBenchmark;

public class CPUThreadedRoots implements IBenchmark {

    private double result;
    private int size;
    private boolean running;

    @Override
    public void warmUp() {
        // detect number of cores: Runtime  availableProcessors();
        int no = Runtime.getRuntime().availableProcessors();
        this.run(no);
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException(
                "Method not implemented. Use run(Objects...) instead");
    }

    @Override
    public void run(Object... options) {
        this.result=0;
        // options[0] -> number of threads
        int nThreads = (Integer) options[0];

        Thread[] threads = new Thread[nThreads];

        // e.g. 1 to 10,000 on 4 threads = 2500 jobs per thread
        final int jobPerThread = this.size / nThreads;

        running = true; // flag used to stop all started threads
        // create a thread for each runnable (SquareRoot) and start it
        for (int i = 0; i < nThreads; ++i) {
            threads[i] = new Thread(new SquareRoot(i * jobPerThread + 1, (i + 1) * jobPerThread,this));
            threads[i].start();
        }

        // join threads
        for (int i = 0; i < nThreads; ++i) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(Object... params) {
        this.result = 0.0;
        this.size = (Integer) params[0];
    }

    @Override
    public void clean() {
    }

    @Override
    public void cancel() {
    }

    class SquareRoot implements Runnable {

        private int from, to;
        private final double precision = 1e-4; // fixed
        private double result = 0.0;
        CPUThreadedRoots callback;

        public SquareRoot(int from, int to, CPUThreadedRoots callback) {
            this.from = from;
            this.to = to;
            this.callback = callback;
        }

        @Override
        public void run() {
            // compute Newtonian square root on each number from i = 'from' to 'to', and also check 'running'
            // save (+=) each computed square root in the local 'result' variable

            for (int i = from; i <= to; i++)
                result += getNewtonian(i);


        }
        private double getNewtonian(double x) {
            double s = x;
            while (Math.abs(s * s - x) > precision)
                s = (x / s + s) / 2;
            return s;
        }

    }
}

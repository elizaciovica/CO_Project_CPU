package bench;

public interface IBenchmark {

    void run();
    void run(Object ...objects);
    void initialize(Object ...objects);
    void clean();
    void cancel();
    void warmUp();
}

package logging;

public interface ILogger {
    void write(long l);
    void write(String s);
    void write(Object ...objects);
    void close();

}

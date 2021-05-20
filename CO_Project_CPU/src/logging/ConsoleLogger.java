package logging;

public class ConsoleLogger implements ILogger{
    @Override
    public void write(long l) {
        System.out.println(l);

    }

    @Override
    public void write(String s) {
        System.out.println(s);

    }

    @Override
    public void write(Object... objects) {
        for(Object o : objects) {
            System.out.print(o.toString() + " ");
        }
        System.out.println();

    }

    @Override
    public void close() {

    }
}

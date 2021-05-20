package logging;

import java.io.*;

public class FileLogger implements ILogger {
    private PrintWriter writer;

    public FileLogger(String fullPath) {
        try {
            BufferedWriter logFile = new BufferedWriter(new FileWriter(
                    fullPath, false));
            writer = new PrintWriter(logFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
    @Override
    public void write(long l) {
        writer.println(String.valueOf(l));
    }

    @Override
    public void write(String s) {
        writer.println(s);

    }

    @Override
    public void write(Object... objects) {
        String s = "";
        for (Object o : objects)
            s += o.toString() + " ";
        writer.println(s);

    }

    @Override
    public void close() {
        if(writer != null)
            writer.close();

    }
}

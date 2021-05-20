package timing;

public class Timer implements ITimer {
    private long pauseTime, totalTime, elapsedTime;

    public Timer() {
        this.elapsedTime = 0;
        this.pauseTime = 0;
        this.totalTime = 0;
    }

    @Override
    public void start() {
        this.elapsedTime =System.nanoTime();
        this.totalTime = 0;

    }

    @Override
    public long stop() {
        this.totalTime += System.nanoTime() -this.elapsedTime;
        return this.totalTime;
    }

    @Override
    public void resume() {
        this.totalTime +=(this.pauseTime - this.elapsedTime);
        this.pauseTime = System.nanoTime();

    }

    @Override
    public long pause() {
        this.pauseTime = System.nanoTime();
        return this.pauseTime - this.elapsedTime;
    }
}

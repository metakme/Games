package engine;

public abstract class GameEngine {
    public long maxfps;
    public long maxups;
    public MainGameLoop mloop;
    
    public abstract void update();
    
    public abstract void render();
    
    public abstract void run ();

    long getMaxFps() {
        return maxfps;
    }

    long getMaxUps() {
        return maxups;
    }
    void setGameLoop (MainGameLoop mloop){
        this.mloop = mloop;
    }
}

package engine;

public class MainGameLoop {
    GameEngine game;
    
    private final long sleeptime;
    private final long deltatime;
    boolean running = true;
    double currentTime;
    double accumulator = 0.0;
    double newTime;
    double frameTime;
    long i = 0;
    long k = 0;
    public MainGameLoop(GameEngine game_logic) {
        this.game = game_logic;
        deltatime = (1000/game_logic.getMaxUps()) * 1000000;
        sleeptime = 1000/game_logic.getMaxFps();
    }
    
    public void run() throws InterruptedException {
        game.setGameLoop(this);
        game.run();
        currentTime = System.nanoTime();
        while (running) {
            newTime = System.nanoTime();
            frameTime = newTime - currentTime;
            currentTime = newTime;
            accumulator += frameTime;
            while (accumulator >= deltatime) {
                this.game.update();
                accumulator -= deltatime;
//                i++;
//                System.out.println(i);
            }
            this.game.render();
            Thread.sleep(sleeptime);
//            k++;
//            System.out.printf("upd%-10d rnd%-10d %n",i,k);
            
        }
    }
    public void stop(){
        System.out.println("loop stopped");
        running = false;
    }
}

package games;

import engine.GameEngine;
import engine.MainGameLoop;

public abstract class Game {
    public String name;
    public GameEngine game_logic;
    public MainGameLoop mloop;
    
    public Game (){
        
    }
    public Game (GameEngine game_logic){
        this.mloop = new MainGameLoop(game_logic);
    }
    public void run() throws InterruptedException{
        this.mloop.run();
    }
}

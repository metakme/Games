package games; 

import games.batandball.BatAndBall;
import games.hitme.HitMe;

public class MainClass { 

    public static void main(String[] args) throws InterruptedException { 
        Game[] games = {new BatAndBall(), new HitMe()};
        Menu mainmenu = new Menu(games);
        mainmenu.run();
        } 

} 
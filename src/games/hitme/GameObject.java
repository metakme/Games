package games.hitme;

import java.awt.Graphics2D;

public abstract class GameObject {

    HitMeScreen screen;
    int width;
    int height;

    public GameObject(HitMeScreen screen) {
        this.screen = screen;
    }
    public abstract void draw(Graphics2D g2d);
        
    
    public abstract void update();
    
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
}

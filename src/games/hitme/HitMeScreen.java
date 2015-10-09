package games.hitme;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public final class HitMeScreen extends JPanel {
    HitMeEngine engine;
    Background background;
    int width;
    int height;
    ArrayList<GameObject> projectiles = new ArrayList<>();
    ArrayList<Bird> birds = new ArrayList<>();
    ArrayList<GameObject> objects = new ArrayList<>();
    ArrayList<GameObject> toRemove = new ArrayList<>();
    
    public HitMeScreen(HitMeEngine engine,int width, int height) {
        super();
        this.engine = engine;
        setPreferredSize(new Dimension(width, height));
//        setFocusable(true);
//        requestFocusInWindow();
        this.width = width;
        this.height = height;
        background = new Background(this);
    }
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        background.draw(g2d);
        for(GameObject o : birds){
            o.draw(g2d);
        }
        for(GameObject o : projectiles){
            o.draw(g2d);
        }
        for(GameObject o : objects){
            o.draw(g2d);
        }
    }
    
    
    @Override
    public int getWidth(){
        return width;
    }
    
    @Override
    public int getHeight(){
        return height;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    HitMeEngine getEngine(){
        return engine;
    }
    
}

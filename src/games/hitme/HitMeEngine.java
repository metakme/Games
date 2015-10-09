package games.hitme;

import engine.GameEngine;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingUtilities;

class HitMeEngine extends GameEngine {
    int width = 900;
    int height = 300;
    Set<Integer> keys = new HashSet<>();
    HitMeScreen screen;
    public static String fileSepatator;
    
    public HitMeEngine() {
        this.maxfps = 60;
        this.maxups = 120;
        fileSepatator = System.getProperty("file.separator");
    }

    @Override
    public void update() {
        for (int i = 0; i < 6-screen.birds.size(); i++) {
        spawnBird();
        }
        screen.background.update();
        for(GameObject o : screen.objects){
            o.update();
        }
        for(GameObject o : screen.projectiles){
            o.update();
        }
        for(GameObject o : screen.birds){
            o.update();
        }
        
        for(GameObject o : screen.toRemove){
            screen.projectiles.remove(o);
            screen.objects.remove(o);
            screen.birds.remove(o);
        }
        
        
    }

    @Override
    public void render() {
        screen.repaint();
    }

    @Override
    public void run() {
        init();
        for (int i = 0; i < 6-screen.birds.size(); i++) {
        spawnBird();
        }
        spawnTank();
        
    }
    
    public void init(){
        screen = new HitMeScreen(this, width,height);
        JFrame window = new JFrame("HitMe!");
        window.setLocation(360,400);
        window.addKeyListener(
                new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        keys.add(e.getKeyCode());
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        keys.remove(e.getKeyCode());
                    }
                }
        );
        window.setContentPane(screen);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
        
    }
    public void spawnTank(){
        screen.objects.add(new Tank(screen));
    }
    public void spawnBird(){
        screen.birds.add(new Bird(screen, width));
    }
}

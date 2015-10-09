package games.hitme;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Tank extends GameObject {
    int posx;
    int posy;
    int GunAngle;
    Color color;
    BasicStroke stroke;
    BufferedImage imageBody;
    BufferedImage imageGun;
    BufferedImage Charge;
    BufferedImage ChargeFrame;
    boolean charging = false;
    double chargeMask = 0;
    public Tank(HitMeScreen screen) {
        super(screen);
        
        color = new Color(70,120,50);
        this.width = 60;
        this.height = 32;
        stroke = new BasicStroke(2);
        this.posx = 10;
        this.posy = screen.getHeight() - 40;
        try {
            imageBody = ImageIO.read(new File("resources"+HitMeEngine.fileSepatator+"Tank-0.png"));
            imageGun = ImageIO.read(new File("resources"+HitMeEngine.fileSepatator+"Gun-0.png"));
            Charge = ImageIO.read(new File("resources"+HitMeEngine.fileSepatator+"Charge-0.png"));
            ChargeFrame  = ImageIO.read(new File("resources"+HitMeEngine.fileSepatator+"ChargeFrame-0.png"));
        } catch (IOException ex) {
            Logger.getLogger(Tank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void draw(Graphics2D g2d){
        Graphics2D g2dcopy = (Graphics2D)g2d.create();
        g2dcopy.translate(posx, posy-height);
        g2dcopy.scale(2, 2);
        g2dcopy.rotate(Math.toRadians(-GunAngle), 27, 7);
        g2dcopy.drawImage(imageGun,27,6,null);
        g2dcopy.clipRect(46, 2, (int)chargeMask, 15);
        g2dcopy.drawImage(ChargeFrame,46,2,null);
        g2dcopy.drawImage(Charge,46,3,null);
        g2dcopy.setClip(null);
        g2dcopy.rotate(Math.toRadians(GunAngle), 27, 7);
        g2dcopy.drawImage(imageBody, 0, 0, null);
//        g2dcopy.translate(-posx, -(posy-height));
    }
    
    
    @Override
    public void update(){
        if(screen.getEngine().keys.contains(KeyEvent.VK_RIGHT)){
            posx += 1;
        }
        if(screen.getEngine().keys.contains(KeyEvent.VK_LEFT)){
            posx -= 1;
        }
        if(screen.getEngine().keys.contains(KeyEvent.VK_UP)&&GunAngle!=45){
            GunAngle +=1;
        }
        if(screen.getEngine().keys.contains(KeyEvent.VK_DOWN)&&GunAngle!=0){
            GunAngle -=1;
        }
        
        if(screen.getEngine().keys.contains(KeyEvent.VK_SPACE)&&chargeMask<32){
            chargeMask +=0.1;
            charging = true;
        }
        if(!screen.getEngine().keys.contains(KeyEvent.VK_SPACE)&&charging){
            charging = false;
            fire();
            chargeMask = 0;
        }
        
    }
    public void fire(){
        Projectile proj = new Projectile(screen, GunAngle, (int)chargeMask, posx+60, posy-20);
        screen.projectiles.add(proj);
    }
}

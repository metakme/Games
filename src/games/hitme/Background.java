package games.hitme;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;

class Background extends GameObject {

    Color top;
    Color bot;
    Color ground;
    double cloud1_x;
    double cloud2_x;
    double cloud3_x;

    public Background(HitMeScreen screen) {
        super(screen);
        width = screen.getWidth();
        height = screen.getHeight();
        top = new Color(40, 125, 245);
        bot = new Color(70, 200, 250);
        ground = new Color(140, 90, 40);
        cloud1_x = 10;
        cloud2_x = 300;
        cloud3_x = 700;

    }

    @Override
    public void draw(Graphics2D g2d) {

        GradientPaint gp = new GradientPaint(0, 0,
                top, 0, height, bot, true);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
        g2d.setPaint(ground);
        g2d.fillRect(0, height - 20, width, 20);

        g2d.setPaint(Color.YELLOW);
        g2d.fillOval(500, 20, 90, 90);

        g2d.setPaint(Color.WHITE);

        g2d.fillOval(-40, -50, 600, 100);
        g2d.fillOval(500, -50, 500, 80);
        g2d.fillOval(500, -10, 160, 50);

        g2d.fillOval((int) cloud2_x + 75, 55, 140, 60);
        g2d.fillOval((int) cloud2_x, 65, 160, 60);
        g2d.fillOval((int) cloud2_x + 75, 70, 180, 80);
        g2d.fillOval((int) cloud2_x + 185, 80, 110, 50);

        g2d.fillOval((int) cloud1_x + 25, 95, 80, 60);
        g2d.fillOval((int) cloud1_x, 105, 180, 70);
        g2d.fillOval((int) cloud1_x + 65, 80, 80, 80);

        g2d.fillOval((int) cloud3_x, 115, 100, 25);
        g2d.fillOval((int) cloud3_x + 55, 115, 80, 30);
        g2d.fillOval((int) cloud3_x + 35, 120, 160, 35);

        
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("arial",Font.BOLD, 15));
        g2d.drawString("left/right arrows: move --- up/down arrows: aim -- space: shoot", 10, height-4);

    }

    @Override
    public void update() {
        cloud1_x += 0.1;
        if (cloud1_x > width) {
            cloud1_x = -180;
        }

        cloud2_x += 0.1;
        if (cloud2_x > width) {
            cloud2_x = -300;
        }

        cloud3_x += 0.1;
        if (cloud3_x > width) {
            cloud3_x = -190;
        }
    }

}

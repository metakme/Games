package games.batandball;

import com.googlecode.lanterna.TerminalFacade;
import static com.googlecode.lanterna.TerminalFacade.createScreen;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.ScreenCharacterStyle;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;
import engine.GameEngine;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BatAndBallEngine extends GameEngine {

    private int misscount;
    int width = 75;
    int height = 25;
    Set<Integer> keys = new HashSet<>();
    Screen screen = createScreen(TerminalFacade.createSwingTerminal(width, height));
    List<GameObject> list = new ArrayList<>();
    List<BatPart> batparts = new ArrayList<>();

    public BatAndBallEngine() {
        this.maxfps = 60;
        this.maxups = 60;
    }

    @Override
    public void run() {
        spawnBat();
        spawnBall();
        screen.startScreen();
        ((SwingTerminal) (screen.getTerminal())).getJFrame().addKeyListener(
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
    }

    public Screen getScreen() {
        return this.screen;
    }

    @Override
    public void update() {
        if (isKeyPressed(KeyEvent.VK_ESCAPE)) {
            this.mloop.stop();
            screen.stopScreen();
        }

        if (!list.isEmpty()) {
            for (GameObject object : list) {
                object.update();
            }
        }
    }

    @Override
    public void render() {
        this.screen.clear();
        screen.putString(1, 0, " Controls: Esc = exit  Left/Right Arrow = move              Miss Count:" + misscount + "  ", Terminal.Color.BLACK, Terminal.Color.WHITE,ScreenCharacterStyle.Bold);

        if (!list.isEmpty()) {
            for (GameObject object : list) {
                object.draw();
            }
        }
        this.screen.refresh();
    }

    boolean isKeyPressed(int keyCode) {
        return keys.contains(keyCode);
    }

    int getHeight() {
        return this.height;
    }

    public void spawnBat() {
        list.add(new Bat(this));
    }

    public void spawnBall() {
        list.add(new Ball(this));
    }

    int getWidth() {
        return this.width;
    }

    void MissCountPP() {
        this.misscount++;
    }
}

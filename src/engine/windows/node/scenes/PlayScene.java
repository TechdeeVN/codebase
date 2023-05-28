package engine.windows.node.scenes;

import engine.windows.GameWindows;
import engine.windows.common.Position;
import engine.windows.node.component.GameButton;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayScene extends Scene {

    public PlayScene(GameWindows gameWindows) {
        super(gameWindows);

    }

    @Override
    protected void initScene() {
        this.eventListeners.add(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    gameWindows.popScene();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, gameWindows.getWidth(), gameWindows.getHeight());
        super.draw(g);
    }
}

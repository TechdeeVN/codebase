package engine.windows.node.scenes;

import engine.windows.GameWindows;
import engine.windows.common.Position;
import engine.windows.node.component.GameButton;
import engine.windows.node.listeners.SimpleMouseClickListener;

import java.awt.*;

public class MenuScene extends Scene {

    public MenuScene(GameWindows gameWindows) {
        super(gameWindows);
    }

    protected void initScene() {
        GameButton playButton = new GameButton(new Position(90, 320), "PLAY");
        listGameObject.add(playButton);

        GameButton exitButton = new GameButton(new Position(90, 450), "EXIT");
        listGameObject.add(exitButton);
        this.eventListeners.add(playButton.getMouseListener());
        this.eventListeners.add(exitButton.getMouseListener());

        playButton.setMouseClickListener(new SimpleMouseClickListener() {
            @Override
            public void onClick() {
                gameWindows.pushScene(new PlayScene(gameWindows));
            }
        });
        exitButton.setMouseClickListener(new SimpleMouseClickListener() {
            @Override
            public void onClick() {
                System.exit(0);
            }
        });
    }

    public void update() {
        super.update();
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, gameWindows.getWidth(), gameWindows.getHeight());
        super.draw(g);
    }
}

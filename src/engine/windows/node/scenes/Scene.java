package engine.windows.node.scenes;

import engine.windows.GameWindows;
import engine.windows.node.GameObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

abstract public class Scene {
    protected List<GameObject> listGameObject;
    protected GameWindows gameWindows;
    protected List<EventListener> eventListeners;
    private boolean initialized;

    public Scene(GameWindows gameWindows) {
        this.gameWindows = gameWindows;
        this.listGameObject = new ArrayList<>();
        this.eventListeners = new ArrayList<>();
        initialized = false;
    }

    private void initSceneInternal() {
        if (!initialized) {
            initialized = true;
            initScene();
            gameWindows.refreshSceneListeners();
        }
    }

    abstract protected void initScene();

    public void draw(Graphics g) {
        for (GameObject gameObject : listGameObject) {
            gameObject.draw(g);
        }
    }

    public void update() {
        initSceneInternal();
        for (GameObject gameObject : listGameObject) {
            gameObject.update();
        }
    }

    public List<EventListener> getEventListeners() {
        return eventListeners;
    }
}

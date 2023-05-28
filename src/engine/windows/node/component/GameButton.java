package engine.windows.node.component;

import engine.windows.common.Position;
import engine.windows.node.GameObject;
import engine.windows.node.listeners.SimpleMouseClickListener;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameButton extends GameObject {
    private final String text;
    private final MouseListener mouseListener;
    private final int width;
    private final int height;

    private boolean isPressed;

    private SimpleMouseClickListener mouseClickListener;

    public GameButton(Position position, String text) {
        super(position);
        this.text = text;
        this.width = 300;
        this.height = 100;
        mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (position.x < e.getX() && e.getX() < position.x + width
                        && position.y < e.getY() && e.getY() < position.y + height
                ) {
                    isPressed = true;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isPressed = false;
                if (position.x < e.getX() && e.getX() < position.x + width
                        && position.y < e.getY() && e.getY() < position.y + height
                ) {
                    triggerMouseClick();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
    }

    public void draw(Graphics g) {
        if (!isPressed) {
            g.setColor(Color.white);
            g.fillRect(position.x, position.y, width, height);
            g.setColor(Color.gray);
            g.fillRect(position.x + 10, position.y + 10, width - 10, height - 10);
            g.setColor(Color.lightGray);
            g.fillRect(position.x + 10, position.y + 10, width - 20, height - 20);
        } else {
            g.setColor(Color.lightGray);
            g.fillRect(position.x, position.y, width, height);
        }

        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.BOLD, 50));
        g.drawString(text, position.x + 80, position.y + 70);
    }

    public void triggerMouseClick() {
        if (mouseClickListener != null) {
            mouseClickListener.onClick();
        }
    }

    public MouseListener getMouseListener() {
        return mouseListener;
    }

    public void setMouseClickListener(SimpleMouseClickListener simpleMouseClickListener) {
        this.mouseClickListener = simpleMouseClickListener;
    }
}

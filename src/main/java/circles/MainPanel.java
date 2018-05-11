package circles;

import static java.lang.Math.*;

import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainPanel extends JPanel implements ActionListener {

    private final List<Circle> circles = new ArrayList<>();

    MainPanel() {
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(800, 600));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        setAntiAliasing((Graphics2D) graphics);

        for (Circle circle : circles) {
            // enable if collideWithOtherCircle(circle) commented
            //resizeCircle(circle);

            move(circle);
            paint(graphics, circle);
        }

    }

    private void resizeCircle(Circle circle) {
        if (circle.radius == 100) {
            circle.minimize = true;
        }

        if (circle.radius == 10) {
            circle.minimize = false;
        }

        if (circle.minimize == true) {
            circle.radius = circle.radius - 1;
        } else {
            circle.radius = circle.radius + 1;
        }
    }

    private void paint(Graphics graphics, Circle c) {
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setStroke(new BasicStroke(10F));
        g2d.setColor(c.color);
        g2d.drawOval(c.x - c.radius, c.y - c.radius, c.radius * 2, c.radius * 2);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        repaint();
    }

    public void addCircle(Circle shape) {
        circles.add(shape);
    }

    private void setAntiAliasing(Graphics2D graphics2D) {
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    private int collideWithBorders(Circle circle) {
        boolean isBottomCollision = (circle.y + Double.valueOf(circle.speed *  sin(toRadians(circle.angle))).intValue() + circle.radius) >= Main.MAX_HEIGHT - 30;
        boolean isTopCollision = (circle.y + Double.valueOf(circle.speed *  sin(toRadians(circle.angle))).intValue() - circle.radius) <= 30;
        boolean isLeftCollision = (circle.x + Double.valueOf(circle.speed * cos(toRadians(circle.angle))).intValue() - circle.radius) <= 30;
        boolean isRightCollision = (circle.x + Double.valueOf(circle.speed * cos(toRadians(circle.angle))).intValue() + circle.radius) >= Main.MAX_WIDTH - 30;

//        if (isBottomCollision && isLeftCollision) {
//            return 45;
//        }
//
//        if (isBottomCollision && isRightCollision) {
//            return 135;
//        }
//
//        if (isTopCollision && isLeftCollision) {
//            return 360 - 45;
//        }
//
//        if (isTopCollision && isRightCollision) {
//            return  360 - 90 - 45;
//        }

        if (isBottomCollision || isTopCollision) {
            return 360 - circle.angle;
        }

        if (isLeftCollision || isRightCollision) {
            return 180 - circle.angle;
        }

        return circle.angle;
    }

    private void move(Circle circle) {
        collideWithOtherCircle(circle);

        circle.angle = collideWithBorders(circle);
        int deltaX = Double.valueOf(circle.speed * cos(toRadians(circle.angle))).intValue();
        int deltaY = Double.valueOf(circle.speed *  sin(toRadians(circle.angle))).intValue();
        circle.x += deltaX;
        circle.y += deltaY;
    }


    private void collideWithOtherCircle(Circle c) {
        List<Circle> circles2 = new ArrayList<>(circles);
        circles2.remove(c);

        for (Circle c0 : circles2) {
            int deltaX = abs(c.x - c0.x);
            int deltaY = abs(c.y - c0.y);

            if ((deltaX * deltaX + deltaY * deltaY) <= (c.radius + c0.radius) * (c.radius + c0.radius)) {
               c.speed = c.speed * (-1);
            }
        }
    }
}

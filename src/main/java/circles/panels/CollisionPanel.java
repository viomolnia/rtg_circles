package circles.panels;

import static java.lang.Math.*;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import circles.utils.Circle;
import circles.utils.Const;
import circles.utils.Utils;

public class CollisionPanel extends Panel {

    @Override
    protected void paintCircles(Graphics graphics) {
        for (Circle circle : circles) {
            move(circle);
            Utils.paint(graphics, circle);
        }
    }

    private void move(Circle circle) {
        collideWithBorders(circle);
        collideWithOtherCircle(circle);

        circle.x = circle.x + circle.speed.x;
        circle.y = circle.y + circle.speed.y;
    }

    private void collideWithBorders(Circle circle) {
        boolean isBottomCollision = (circle.y + circle.radius) >= Const.MAX_HEIGHT;
        boolean isTopCollision = (circle.y - circle.radius) <= 0;
        boolean isLeftCollision = (circle.x - circle.radius) <= 0;
        boolean isRightCollision = (circle.x + circle.radius) >= Const.MAX_WIDTH ;

        if (isBottomCollision || isTopCollision) {
            circle.speed.y = -circle.speed.y;
            relocate(circle);
        }

        if (isLeftCollision || isRightCollision) {
            circle.speed.x = -circle.speed.x;
            relocate(circle);
        }
    }

    private void collideWithOtherCircle(Circle circle) {
        List<Circle> otherCircles = new ArrayList<>(circles);
        otherCircles.remove(circle);

        for (Circle otherCircle : otherCircles) {
            collision(circle, otherCircle);
        }
    }

    private void collision(Circle circle, Circle otherCircle) {
        double deltaX = abs(circle.x - otherCircle.x);
        double deltaY = abs(circle.y - otherCircle.y);

        if (Math.sqrt(deltaX * deltaX + deltaY * deltaY) - 15 <= (circle.radius + otherCircle.radius)) {

            double newVelX1 = getNewVelocityX(circle, otherCircle);
            double newVelY1 = getNewVelocityY(circle, otherCircle);

            double newVelX2 = getNewVelocityX(otherCircle, circle);
            double newVelY2 = getNewVelocityY(otherCircle, circle);

            circle.speed.x = newVelX1;
            circle.speed.y = newVelY1;

            otherCircle.speed.x = newVelX2;
            otherCircle.speed.y = newVelY2;

            relocate(circle);
            relocate(otherCircle);
        }
    }

    private double getNewVelocityX(Circle c1, Circle c2) {
        double newVelocityX = (c1.speed.x * (c1.mass - c2.mass) + (2 * c2.mass * c2.speed.x)) / (c1.mass + c2.mass);

        return newVelocityX;
    }

    private double getNewVelocityY(Circle c1, Circle c2) {
        double newVelocityY = (c1.speed.y * (c1.mass - c2.mass) + (2 * c2.mass * c2.speed.y)) / (c1.mass + c2.mass);

        return newVelocityY;
    }

    private void relocate(Circle circle) {
        circle.x = circle.x + circle.speed.x;
        circle.y = circle.y + circle.speed.y;
    }
}

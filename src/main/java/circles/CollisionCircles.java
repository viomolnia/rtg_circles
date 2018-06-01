package circles;

import static circles.utils.Const.*;
import static circles.utils.Utils.*;

import circles.panels.CollisionPanel;
import circles.utils.Circle;

public class CollisionCircles {

    public static void main(String[] args) {
        final CollisionPanel collisionPanel = new CollisionPanel();
        init(collisionPanel);
        setTimer(collisionPanel);
    }

    private static void init(CollisionPanel collisionPanel) {
        int minY = MAX_RADIUS + 20;
        int maxY = minY + MAX_RADIUS * 2;
        for (int i = 0; i < 2; i++) {

            int minX = MAX_RADIUS + 20;
            int maxX = minX + MAX_RADIUS * 2;
            for (int j = 0; j < 3; j++) {
                Circle circle = new Circle();

                circle.x = random(minX, maxX);
                circle.y = random(minY, maxY);

                circle.radius = random(MIN_RADIUS, MAX_RADIUS);
                circle.mass = circle.radius / 2;

                int red = random(0, 256);
                int green = random(0, 256);
                int blue = random(0, 256);
                circle.color = color(red, green, blue);

                circle.speed.x = random(-10, 10);
                circle.speed.y = random(-10, 10);

                minX = minX + MAX_RADIUS * 4;
                maxX = maxX + MAX_RADIUS * 4;
                collisionPanel.addCircle(circle);
            }

            minY = minY + MAX_RADIUS * 4;
            maxY = maxY + MAX_RADIUS * 4;
        }
    }
}

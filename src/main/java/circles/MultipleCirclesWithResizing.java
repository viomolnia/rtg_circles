package circles;

import static circles.utils.Utils.*;

import circles.panels.ResizingPanel;
import circles.utils.Circle;

public class MultipleCirclesWithResizing {

    public static void main(String[] args) {
        final ResizingPanel resizingPanel = new ResizingPanel();
        init(resizingPanel);
        setTimer(resizingPanel);
    }

    private static void init(ResizingPanel resizingPanel) {
        for (int i = 1; i < 10; i++) {
            Circle circle = new Circle();

            circle.x = random(50, 750);
            circle.y = random(50, 550);
            circle.radius = random(10, 50);
            circle.minimize = randomBoolean();
            circle.color = color(random(0, 256), random(0, 256), random(0, 256));

            resizingPanel.addCircle(circle);
        }
    }
}

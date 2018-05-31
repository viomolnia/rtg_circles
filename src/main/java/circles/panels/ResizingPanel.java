package circles.panels;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import circles.utils.Circle;
import circles.utils.Utils;

public class ResizingPanel extends Panel {

    public ResizingPanel() {
        super();
    }

    @Override
    protected void paintCircles(Graphics graphics) {

        for (Circle circle : circles) {

            resizeCircle(circle);

            Utils.paint(graphics, circle);
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

}

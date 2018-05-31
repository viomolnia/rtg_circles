package circles;

import static circles.utils.Utils.*;

import circles.panels.Panel;
import circles.utils.Circle;
import circles.utils.Utils;

public class SingleCircle {

    public static void main(String[] args) {
        final Panel panel = new Panel();
        init(panel);
        Utils.setTimer(panel);
    }

    //HINT
    // X: 0 - 800
    // Y: 0 - 600
    // radius: 0 - 100
    // color: 0 - 256

    private static void init(Panel panel) {
        Circle circle = new Circle();

        circle.x = 400;
        circle.y = 300;
        circle.radius = 50;
        circle.color = color(100, 200, 40);

        panel.addCircle(circle);
    }
}

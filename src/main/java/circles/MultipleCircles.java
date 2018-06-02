package circles;

import static circles.utils.Utils.*;

import circles.panels.Panel;
import circles.utils.Circle;

public class MultipleCircles {

    public static void main(String[] args) {
        final Panel panel = new Panel();
        init(panel);
        setTimer(panel);
    }

    //HINT
    // X: 0 - 800
    // Y: 0 - 600
    // radius: 0 - 100
    // color: 0 - 256

    private static void init(Panel panel) {
        Circle circle1 = new Circle();
        Circle circle2 = new Circle();
        Circle circle3 = new Circle();

        //circle-1
        circle1.x = 70;
        circle1.y = 90;
        circle1.radius = 40;
        circle1.color = color(100, 200, 40);

        //circle-2
        circle2.x = 300;
        circle2.y = 100;
        circle2.radius = 60;
        circle2.color = color(200, 40, 10);

        //circle-3
        circle3.x = 700;
        circle3.y = 300;
        circle3.radius = 80;
        circle3.color = color(150, 110, 80);

        panel.addCircle(circle1);
        panel.addCircle(circle2);
        panel.addCircle(circle3);
    }
}


// With loop
// for (int i = 1; i < 100; i++) {
//        Circle circle = new Circle();
//
//        circle.x = random(50, 750);
//        circle.y = random(50, 550);
//        circle.radius = random(10, 50);
//        circle.minimize = randomBoolean();
//        circle.color = color(random(0, 256), random(0, 256), random(0, 256));
//
//        resizingPanel.addCircle(circle);
// }

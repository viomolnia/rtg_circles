package circles;

import static circles.Randomizer.*;

import java.awt.Color;

class Circle {

    public int x;
    public int y;
    public int radius;
    public int angle;
    public double speed = 10;
    public Color color;
    public boolean minimize = false;

    Circle(int x, int y, int rad, int angle) {
        this.x = x;
        this.y = y;
        this.radius = rad;
        this.angle = angle;

        int red = randomInt(0, 255);
        int green = randomInt(0, 255);
        int blue = randomInt(0, 255);

        this.color = new Color(red, green, blue);
    }


}

package circles;

class Randomizer {

    static int randomInt(int min, int max) {
        int res = Double.valueOf(Math.random() * max).intValue();

        if (res < min) {
            return min;
        }

        return res;
    }

}

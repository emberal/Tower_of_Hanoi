package Hanoi.Draw;

public enum Colour { //Defines the different colours of the disks
    BLACK(0, 0, 0),
    BROWN(150, 75, 0),
    RED(255, 0, 0),
    BLUE(0, 0, 255),
    GREEN(0, 255, 0),
    PINK(255, 192, 203),
    PURPLE(128, 0, 128),
    YELLOW(255, 255, 0),
    ORANGE(255, 128, 0),
    LIGHT_BLUE(173, 216, 230);

    private final int R, G, B;

    Colour(int R, int G, int B) {
        this.R = R;
        this.G = G;
        this.B = B;
    }

    public int[] getRGB() {
        return new int[]{R, G, B};
    }
}

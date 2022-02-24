package tower.of.hanoi.game;

//The position of the disks on the board

public enum Position { //TODO
    LEFT(200),
    CENTER(400),
    RIGHT(600);

    private final int X_POS;
    public static final int DISTANCE = 200;

    Position(int X_POS) {
        this.X_POS = X_POS;
    }

    public int getX_POS() {
        return X_POS;
    }
}

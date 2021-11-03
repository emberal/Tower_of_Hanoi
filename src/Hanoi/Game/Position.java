package Hanoi.Game;

//The position of the disks on the board

public enum Position { //TODO
    LEFT(200),
    CENTER(400),
    RIGHT(600);

    private final int X_POS;

    Position(int X_POS) {
        this.X_POS = X_POS;
    }

    public int getX_POS() {
        return X_POS;
    }
}

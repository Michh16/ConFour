package dm550.ConFour;

public class XYCoordinate implements Coordinate {

    /** variables specifying horizontal position on the board */
    private int x;

    /** variable specifying vertical positoin on the board */
    private int y;

    /** constructor creating a Coordinate from x and y values */
    public XYCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public boolean checkBoundaries(int xSize, int ySize) {
        //TODO
        if (0 <= this.getX() && this.getX() <= (xSize-1) && 0 <= this.getY() && this.getY() <= (ySize-1)) {
            return true;
        }
        return false;
    }

    @Override
    public Coordinate shift(int dx, int dy) {
        //TODO
        Coordinate c;
        c = new XYCoordinate(getX()+dx,getY()+dy);
        return c;
    }

}

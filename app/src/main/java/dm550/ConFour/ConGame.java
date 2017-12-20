package dm550.ConFour;

/** main class creating a board and the GUI
 * defines the game play
 */
public class ConGame implements Game {

    /** currently active player */
    private int currentPlayer;

    /** total number of players */
    private int numPlayers;
    
    /** the board we play on */
    private ConBoard board;
    
    /** the gui for board games */
    private UserInterface ui;
    
    /** constructor that gets the number of players */
    public ConGame(int numPlayers) {
        this.currentPlayer = 1;
        this.numPlayers = numPlayers;
        this.board = new ConBoard(numPlayers);
    }

    @Override
    public String getTitle() {
        return this.numPlayers+"-way Connect Four";
    }

    @Override
    public void addMove(Coordinate pos) {
        this.board.addMove(pos, this.currentPlayer);
        if (this.currentPlayer == this.numPlayers) {
            this.currentPlayer = 1;
        } else {
            this.currentPlayer++;
        }
    }

    @Override
    public String getContent(Coordinate pos) {
        String result = "";
        int player = this.board.getPlayer(pos);
        if (player > 0) {
            result += player;
        }
        return result;
    }

    @Override
    public int getHorizontalSize() {
        return this.board.getxSize();
    }

    @Override
    public int getVerticalSize() {
        return this.board.getySize();
    }

    @Override
    public void checkResult() {
        int winner = this.board.checkWinning();
        if (winner > 0) {
            this.ui.showResult("Player "+winner+" wins!");
        } else if (this.board.checkFull()) {
            this.ui.showResult("This is a DRAW!");
        }
    }

    @Override
    public boolean isFree(Coordinate pos) {
        return this.board.isFree(pos);
    }

    @Override
    public void setUserInterface(UserInterface ui) {
        this.ui = ui;
        
    }
    
    public String toString() {
        return "Board before Player "+this.currentPlayer+" of "+this.numPlayers+"'s turn:\n"+this.board.toString();
    }

}

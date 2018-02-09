public class ChessBoardManager {

    private static ChessBoardManager instance = null;
    private ChessBoard chessBoard;

    private ChessBoardManager() {
        //This Exists to defeat instantiation
        chessBoard = new ChessBoard();
    }

    public static ChessBoardManager getInstance() {
        if (instance == null) {
            instance = new ChessBoardManager();
        }
        return instance;
    }

    public ChessBoard getChessBoard(){
        return this.chessBoard;
    }
}

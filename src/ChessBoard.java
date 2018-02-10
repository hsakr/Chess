import javafx.scene.image.Image;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;

import java.util.Vector;

public class ChessBoard extends TilePane implements Colors{

    private ChessSquare[] board;

    public ChessBoard(){
        board = new ChessSquare[64];
        initializeBoard();
    }

    public ChessSquare[] getBoard(){
        return this.board;
    }

    /*
     * Makes the chess board
     */
    private void initializeBoard(){
        this.setPrefColumns(8);
        this.setPrefRows(8);
        for(int i = 0; i <= 63; i++){ // Creating the chess squares
            ChessSquare square = new ChessSquare(i);
            this.getChildren().add(square);
            board[i] = square;
        }
        placePieces();
    }

    /*
     * Places the pieces on the board
     */
    private void placePieces(){
        placeRooks();
        placeKnights();
        placeBishops();
        placeQueens();
        placeKings();
        placePawns();
    }

    /*
     * Places the rooks in their initial positions
     */
    private void placeRooks(){
        board[0].getChildren().add(new Rook(new Image("Pieces/black_rook.png")));
        board[7].getChildren().add(new Rook(new Image("Pieces/black_rook.png")));
        board[56].getChildren().add(new Rook(new Image("Pieces/white_rook.png")));
        board[63].getChildren().add(new Rook(new Image("Pieces/white_rook.png")));
    }

    /*
     * Places the knights in their initial positions
     */
    private void placeKnights(){
        board[1].getChildren().add(new Knight(new Image("Pieces/black_knight.png")));
        board[6].getChildren().add(new Knight(new Image("Pieces/black_knight.png")));
        board[57].getChildren().add(new Knight(new Image("Pieces/white_knight.png")));
        board[62].getChildren().add(new Knight(new Image("Pieces/white_knight.png")));
    }

    /*
     * Places the Bishops in their initial positions
     */
    private void placeBishops(){
        board[2].getChildren().add(new Bishop(new Image("Pieces/black_bishop.png")));
        board[5].getChildren().add(new Bishop(new Image("Pieces/black_bishop.png")));
        board[58].getChildren().add(new Bishop(new Image("Pieces/white_bishop.png")));
        board[61].getChildren().add(new Bishop(new Image("Pieces/white_bishop.png")));
    }

    /*
     * Places the Queens in their initial positions
     */
    private void placeQueens(){
        board[3].getChildren().add(new Queen(new Image("Pieces/black_queen.png")));
        board[59].getChildren().add(new Queen(new Image("Pieces/white_queen.png")));
    }

    /*
     * Places the Kings in their initial positions
     */
    private void placeKings(){
        board[4].getChildren().add(new King(new Image("Pieces/black_king.png")));
        board[60].getChildren().add(new King(new Image("Pieces/white_king.png")));
    }

    /*
     * Places the Pawns in their initial positions
     */
    private void placePawns(){
        for(int i = 48; i < 56; i++){
            board[i].getChildren().add(new Pawn(new Image("Pieces/white_pawn.png")));
        }

        for(int i = 8; i < 16; i++){
            board[i].getChildren().add(new Pawn(new Image("Pieces/black_pawn.png")));
        }
    }

    public void colorSquares(){
        for (ChessSquare chessSquare : board){
            chessSquare.setSquareColor();
        }
    }
}

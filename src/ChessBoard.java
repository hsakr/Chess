import javafx.scene.image.Image;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;

public class ChessBoard extends TilePane implements Colors{
    public static final int squareLength = 80;
    private boolean startWhite = true;

    public ChessBoard(){
        initializeBoard();
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
        ChessSquare leftBlackRook = (ChessSquare) this.getChildren().get(0);
        ChessSquare rightBlackRook = (ChessSquare) this.getChildren().get(7);
        leftBlackRook.getChildren().add(new Rook(new Image("Pieces/black_rook.png"), black, 0));
        rightBlackRook.getChildren().add(new Rook(new Image("Pieces/black_rook.png"), black, 7));

        ChessSquare leftWhiteRook = (ChessSquare) this.getChildren().get(56);
        ChessSquare rightWhiteRook = (ChessSquare) this.getChildren().get(63);
        leftWhiteRook.getChildren().add(new Rook(new Image("Pieces/white_rook.png"), white, 56));
        rightWhiteRook.getChildren().add(new Rook(new Image("Pieces/white_rook.png"), white, 63));
    }

    /*
     * Places the knights in their initial positions
     */
    private void placeKnights(){
        ChessSquare leftBlackKnight = (ChessSquare) this.getChildren().get(1);
        ChessSquare rightBlackKnight = (ChessSquare) this.getChildren().get(6);
        leftBlackKnight.getChildren().add(new Knight(new Image("Pieces/black_knight.png"), black, 1));
        rightBlackKnight.getChildren().add(new Knight(new Image("Pieces/black_knight.png"), black, 6));

        ChessSquare leftWhiteKnight = (ChessSquare) this.getChildren().get(57);
        ChessSquare rightWhiteKnight = (ChessSquare) this.getChildren().get(62);
        leftWhiteKnight.getChildren().add(new Knight(new Image("Pieces/white_knight.png"), white, 57));
        rightWhiteKnight.getChildren().add(new Knight(new Image("Pieces/white_knight.png"), white, 62));

        ChessSquare leftWhiteRook1 = (ChessSquare) this.getChildren().get(27);
        leftWhiteRook1.getChildren().add(new Bishop(new Image("Pieces/black_queen.png"), black, 27));
    }

    /*
     * Places the Bishops in their initial positions
     */
    private void placeBishops(){
        ChessSquare leftBlackBishop = (ChessSquare) this.getChildren().get(2);
        ChessSquare rightBlackBishop = (ChessSquare) this.getChildren().get(5);
        leftBlackBishop.getChildren().add(new Bishop(new Image("Pieces/black_bishop.png"), black, 2));
        rightBlackBishop.getChildren().add(new Bishop(new Image("Pieces/black_bishop.png"), black, 5));

        ChessSquare leftWhiteBishop = (ChessSquare) this.getChildren().get(58);
        ChessSquare rightWhiteBishop = (ChessSquare) this.getChildren().get(61);
        leftWhiteBishop.getChildren().add(new Bishop(new Image("Pieces/white_bishop.png"), white, 58));
        rightWhiteBishop.getChildren().add(new Bishop(new Image("Pieces/white_bishop.png"), white, 61));
    }

    /*
     * Places the Queens in their initial positions
     */
    private void placeQueens(){
        ChessSquare whiteQueen = (ChessSquare) this.getChildren().get(59);
        ChessSquare blackQueen = (ChessSquare) this.getChildren().get(3);
        whiteQueen.getChildren().add(new Queen(new Image("Pieces/white_queen.png"), white, 59));
        blackQueen.getChildren().add(new Queen(new Image("Pieces/black_queen.png"), black, 3));
    }

    /*
     * Places the Kings in their initial positions
     */
    private void placeKings(){
        ChessSquare whiteKing = (ChessSquare) this.getChildren().get(60);
        whiteKing.getChildren().add(new King(new Image("Pieces/white_king.png"), white, 60));
        ChessSquare blackKing = (ChessSquare) this.getChildren().get(4);
        blackKing.getChildren().add(new King(new Image("Pieces/black_king.png"), black, 4));
    }

    /*
     * Places the Pawns in their initial positions
     */
    private void placePawns(){
        for(int i = 48; i < 56; i++){
            ChessSquare whitePawn = (ChessSquare) this.getChildren().get(i);
            whitePawn.getChildren().add(new Pawn(new Image("Pieces/white_pawn.png"), white, i));
        }

        for(int i = 8; i < 16; i++){
            ChessSquare blackPawn = (ChessSquare) this.getChildren().get(i);
            blackPawn.getChildren().add(new Pawn(new Image("Pieces/black_pawn.png"), black, i));
        }
    }
}

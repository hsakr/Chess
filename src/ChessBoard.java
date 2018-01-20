import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ChessBoard extends TilePane{
    public static final int squareLength = 80;
    public static final Color black = Color.BLACK;
    public static final Color white = Color.WHITE;
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
        for(int i = 1; i <= 64; i++){ // Coloring the board
            Rectangle square = new Rectangle(squareLength, squareLength);
            square.setFill(getSquareColor(i, startWhite));
            checkRowForColor(i);
            StackPane s = new StackPane(square);
            this.getChildren().add(s);
        }
        placePieces();
    }

    /**
     * Returns the color of the square at a certain position on the board
     * @param position
     * @param startWhite
     * @return
     */
    private Color getSquareColor(int position, boolean startWhite){
        if(startWhite && position % 2 != 0){
            return Color.WHITE;
        } else if(startWhite && position % 2 == 0){
            return Color.LIGHTGRAY;
        } else if( !startWhite && position % 2 != 0){
            return Color.LIGHTGRAY;
        } else {
            return Color.WHITE;
        }
    }

    /*
     * Checks which row we are in so that the program knows to start with which color
     */
    private void checkRowForColor(int position){
        if (startWhite && position % 8 == 0){
            startWhite = false;
        } else if(!startWhite && position % 8 == 0){
            startWhite = true;
        }
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
        StackPane leftBlackRook = (StackPane) this.getChildren().get(0);
        StackPane rightBlackRook = (StackPane) this.getChildren().get(7);
        leftBlackRook.getChildren().add(new Rook(new Image("Pieces/black_rook.png"), black, 0));
        rightBlackRook.getChildren().add(new Rook(new Image("Pieces/black_rook.png"), black, 7));

        StackPane leftWhiteRook = (StackPane) this.getChildren().get(56);
        StackPane rightWhiteRook = (StackPane) this.getChildren().get(63);
        leftWhiteRook.getChildren().add(new Rook(new Image("Pieces/white_rook.png"), white, 56));
        rightWhiteRook.getChildren().add(new Rook(new Image("Pieces/white_rook.png"), white, 63));
    }

    /*
     * Places the knights in their initial positions
     */
    private void placeKnights(){
        StackPane leftBlackKnight = (StackPane) this.getChildren().get(1);
        StackPane rightBlackKnight = (StackPane) this.getChildren().get(6);
        leftBlackKnight.getChildren().add(new Knight(new Image("Pieces/black_knight.png"), black, 1));
        rightBlackKnight.getChildren().add(new Knight(new Image("Pieces/black_knight.png"), black, 6));

        StackPane leftWhiteKnight = (StackPane) this.getChildren().get(57);
        StackPane rightWhiteKnight = (StackPane) this.getChildren().get(62);
        leftWhiteKnight.getChildren().add(new Knight(new Image("Pieces/white_knight.png"), white, 57));
        rightWhiteKnight.getChildren().add(new Knight(new Image("Pieces/white_knight.png"), white, 62));
    }

    /*
     * Places the Bishops in their initial positions
     */
    private void placeBishops(){
        StackPane leftBlackBishop = (StackPane) this.getChildren().get(2);
        StackPane rightBlackBishop = (StackPane) this.getChildren().get(5);
        leftBlackBishop.getChildren().add(new Bishop(new Image("Pieces/black_bishop.png"), black, 2));
        rightBlackBishop.getChildren().add(new Bishop(new Image("Pieces/black_bishop.png"), black, 5));

        StackPane leftWhiteBishop = (StackPane) this.getChildren().get(58);
        StackPane rightWhiteBishop = (StackPane) this.getChildren().get(61);
        leftWhiteBishop.getChildren().add(new Bishop(new Image("Pieces/white_bishop.png"), white, 58));
        rightWhiteBishop.getChildren().add(new Bishop(new Image("Pieces/white_bishop.png"), white, 61));
    }

    /*
     * Places the Queens in their initial positions
     */
    private void placeQueens(){
        StackPane whiteQueen = (StackPane) this.getChildren().get(59);
        StackPane blackQueen = (StackPane) this.getChildren().get(3);
        whiteQueen.getChildren().add(new Queen(new Image("Pieces/white_queen.png"), white, 59));
        blackQueen.getChildren().add(new Queen(new Image("Pieces/black_queen.png"), black, 3));
    }

    /*
     * Places the Kings in their initial positions
     */
    private void placeKings(){
        StackPane whiteKing = (StackPane) this.getChildren().get(60);
        whiteKing.getChildren().add(new King(new Image("Pieces/white_king.png"), white, 60));
        StackPane blackKing = (StackPane) this.getChildren().get(4);
        blackKing.getChildren().add(new King(new Image("Pieces/black_king.png"), black, 4));
    }

    /*
     * Places the Pawns in their initial positions
     */
    private void placePawns(){
        for(int i = 48; i < 56; i++){
            StackPane whitePawn = (StackPane) this.getChildren().get(i);
            whitePawn.getChildren().add(new Pawn(new Image("Pieces/white_pawn.png"), white, i));
        }

        for(int i = 8; i < 16; i++){
            StackPane blackPawn = (StackPane) this.getChildren().get(i);
            blackPawn.getChildren().add(new Pawn(new Image("Pieces/black_pawn.png"), black, i));
        }
    }
}

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import java.util.Vector;
public class Pawn extends ImageView implements ChessPiece  {

    private final Vector<Integer> movablePositions = new Vector<Integer>();
    private final boolean[] movablePositionsWithoutKill = {false, true, false}; // topleft, top, topright positions respectively
    private Image image;
    private Color color;
    private int xPosition, yPosition;

    public Pawn(Image image, Color color, int position){
        super(image);
        this.image = image;
        this.color = color;
        findPositionCoordinates(position);
    }

    /**
     * Returns the color of this instance
     * @return
     */
    @Override
    public Color getColor() {
        return this.color;
    }

    /**
     * Gets the x and y coordinates based on the position in ObservableList in tilePane
     * @param position
     */
    public void findPositionCoordinates(int position){
        yPosition = position / 8;
        double difference = position / 8.0;
        double fractionalPart = (difference - (int)difference) * 8;
        xPosition = (int)fractionalPart;
    }

    /**
     * Returns the x positional coordinate
     * @return
     */
    public int getXPosition(){
        return this.xPosition;
    }

    /**
     * Returns the y positional coordinate
     * @return
     */
    public int getYPosition(){
        return this.yPosition;
    }

    /*
     * Method called when a chess piece is selected
     *
     */
    public void pieceSelected(){
        ChessBoardManager chessBoardManager = ChessBoardManager.getInstance();
        ChessBoard chessBoard = chessBoardManager.getChessBoard();

        System.out.println("xPosition: " + xPosition + " yPosition: " + yPosition);

        int topPosition = getPositionFromCoordinates(xPosition,(color == white) ? yPosition - 1 : yPosition + 1);

        int topRightPosition = getPositionFromCoordinates((color == white) ? xPosition + 1 : xPosition - 1
                , (color == white) ? yPosition - 1 : yPosition + 1);

        int topLeftPosition = getPositionFromCoordinates((color == white) ? xPosition - 1: xPosition + 1
                , (color == white) ? yPosition - 1 : yPosition + 1);

        int[] movablePositionsToCheck = {topLeftPosition, topPosition, topRightPosition};
        findMovablePositions(movablePositionsToCheck, chessBoard);
        colorMovablePositions(chessBoard);
    }

    private void findMovablePositions(int[] movablePositions, ChessBoard chessBoard){
        for (int i = 0; i < movablePositions.length; i++){
            movablePosition(movablePositions[i], chessBoard, movablePositionsWithoutKill[i]);
        }
    }
    /**
     * Method converts x and y coordinates to position in Observablelist tilePane
     * @param xPosition
     * @param yPosition
     * @return
     */
    public int getPositionFromCoordinates(int xPosition, int yPosition){
        if(xPosition >= 8 || yPosition >= 8 || xPosition < 0 || yPosition < 0){
            return Integer.MAX_VALUE;
        }
        return (xPosition) + (yPosition * 8);
    }

    /**
     * Method that checks if the chess piece can move to a square
     * @param position
     * @return
     */
    private void movablePosition(int position, ChessBoard chessBoard, boolean canMoveWithoutKill){
        if (position >= 0 && position < 64){
            ChessSquare chessSquare = (ChessSquare)chessBoard.getChildren().get(position);
            if(checkSquareForPiece(chessSquare, canMoveWithoutKill)) {
                movablePositions.add(position);
            }
        }
    }

    /**
     * Helper method to moveablePosition to check whether a chess piece can move to a square that contains another chess piece
     * @param chessSquare
     * @return
     */
    private boolean checkSquareForPiece(ChessSquare chessSquare, boolean canMoveWithoutKill){
        if(chessSquare.getChildren().size() == 2){
            ChessPiece chessPiece = (ChessPiece)chessSquare.getChildren().get(1);
            if(chessPiece.getColor() != color){
                return true;
            } else {
                return false;
            }
        } else if(canMoveWithoutKill){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Colors movable positions yellow
     * @param chessBoard
     */
    private void colorMovablePositions(ChessBoard chessBoard){
        for(int position : movablePositions){
            ChessSquare chessSquare = (ChessSquare)chessBoard.getChildren().get(position);
            chessSquare.getSquare().setFill(yellow);
        }
    }
}

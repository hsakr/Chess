import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.Vector;

public abstract class ChessPiece extends ImageView implements Colors{
    protected Image image;
    protected Color color;
    protected int xPosition, yPosition;
    protected final Vector<Integer> movablePositions = new Vector<Integer>();

    public ChessPiece(Image image, int position){
        super(image);
        this.image = image;
        findColor();
        findPositionCoordinates(position);
    }

    /**
     * Returns the color of this instance
     * @return
     */
    public Color getColor() {
        return this.color;
    }

    private void findColor(){
        if (image.getUrl().contains("white")){
            this.color = white;
        } else {
            this.color = black;
        }
    }

    /**
     * Gets the x and y coordinates based on the position in ObservableList in tilePane
     * @param position
     */
    protected void findPositionCoordinates(int position){
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

    public abstract void pieceSelected();

    protected void findMovablePositions(int[] movablePositions, ChessBoard chessBoard){
        for (int i = 0; i < movablePositions.length; i++){
            movablePosition(movablePositions[i], chessBoard);
        }
    }

    /**
     * Method converts x and y coordinates to position in Observablelist tilePane
     * @param xPosition
     * @param yPosition
     * @return
     */
    protected int getPositionFromCoordinates(int xPosition, int yPosition){
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
    protected boolean movablePosition(int position, ChessBoard chessBoard){
        if (position >= 0 && position < 64){
            ChessSquare chessSquare = (ChessSquare)chessBoard.getChildren().get(position);
            if(checkSquare(chessSquare)) {
                movablePositions.add(position);
                return true;
            }
        }
        return false;
    }

    /**
     * Helper method to movablePosition to check whether a chess piece can move to a square that contains another chess piece
     * @param chessSquare
     * @return
     */
    protected boolean checkSquare(ChessSquare chessSquare){
        if(chessSquare.getChildren().size() == 2){
            ChessPiece chessPiece = (ChessPiece)chessSquare.getChildren().get(1);
            if(chessPiece.getColor() != color){
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    /**
     * Checks if the square at a position contains a chess piece
     * @param position
     * @param chessBoard
     * @return
     */
    protected boolean squareContainsPiece(int position , ChessBoard chessBoard){
        ChessSquare chessSquare = (ChessSquare)chessBoard.getChildren().get(position);
        if(chessSquare.getChildren().size() == 2){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Colors movable positions yellow
     * @param chessBoard
     */
    protected void colorMovablePositions(ChessBoard chessBoard){
        for(int position : movablePositions){
            ChessSquare chessSquare = (ChessSquare)chessBoard.getChildren().get(position);
            chessSquare.getSquare().setFill(yellow);
        }
    }
}

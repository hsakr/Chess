import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.awt.*;

public class King extends ImageView implements ChessPiece  {
    public static final Color black = Color.BLACK;
    public static final Color white = Color.WHITE;

    private Image image;
    private Color color;
    private int xPosition, yPosition;


    public King(Image image, Color color, int position){
        super(image);
        this.image = image;
        this.color = color;
        findCoordinatesFromPosition(position);
    }

    /**
     * Returns the color of this instance
     * @return
     */
    @Override
    public Color getColor(){
        return this.color;
    }

    /**
     * Gets the x and y coordinates based on the position in ObservableList in tilePane
     * @param position
     */
    public void findCoordinatesFromPosition(int position){
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

        int upPosition = getPositionFromCoordinates(xPosition,yPosition - 1);
        int downPosition = getPositionFromCoordinates(xPosition,yPosition + 1);
        int leftPosition = getPositionFromCoordinates(xPosition - 1, yPosition);
        int rightPosition = getPositionFromCoordinates(xPosition + 1, yPosition);
        int topRightPosition = getPositionFromCoordinates(xPosition + 1, yPosition - 1);
        int bottomRightPosition = getPositionFromCoordinates(xPosition + 1, yPosition + 1);
        int bottomLeftPosition = getPositionFromCoordinates(xPosition - 1, yPosition + 1);
        int topLeftPosition = getPositionFromCoordinates(xPosition - 1, yPosition - 1);
        int[] arrayOfPositions = {upPosition, downPosition, leftPosition, rightPosition, topRightPosition, bottomRightPosition, bottomLeftPosition, topLeftPosition};

        for(int position : arrayOfPositions){
            if (movablePosition(position, chessBoard)){
                ChessSquare chessSquare = (ChessSquare)chessBoard.getChildren().get(position);
                chessSquare.getSquare().setFill(Color.YELLOW);
            }
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
    private boolean movablePosition(int position, ChessBoard chessBoard){
        if (position >= 0 && position < 64){
            ChessSquare chessSquare = (ChessSquare)chessBoard.getChildren().get(position);
            if(checkSquareForPiece(chessSquare)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Helper method to moveablePosition to check whether a chess piece can move to a square that contains another chess piece
     * @param chessSquare
     * @return
     */
    private boolean checkSquareForPiece(ChessSquare chessSquare){
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
}

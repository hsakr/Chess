import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.awt.*;

public class King extends ChessPiece {

    public King(Image image){
        super(image);
    }

    /*
     * Method called when a chess piece is selected
     *
     */
    public void pieceSelected(int pieceSelectedPosition, int xPosition, int yPosition){
        this.pieceSelectedPosition = pieceSelectedPosition;
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
        int[] movablePositionsToCheck = {upPosition, downPosition, leftPosition, rightPosition, topRightPosition, bottomRightPosition, bottomLeftPosition, topLeftPosition};

        findMovablePositions(movablePositionsToCheck, chessBoard);
        colorMovablePositions(chessBoard);
    }
}

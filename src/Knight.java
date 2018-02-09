import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Knight extends ChessPiece {

    public Knight(Image image, int position){
        super(image, position);
    }

    /*
     * Method called when a chess piece is selected
     *
     */
    public void pieceSelected(){
        ChessBoardManager chessBoardManager = ChessBoardManager.getInstance();
        ChessBoard chessBoard = chessBoardManager.getChessBoard();

        System.out.println("xPosition: " + xPosition + " yPosition: " + yPosition);

        int topRightLPosition = getPositionFromCoordinates(xPosition + 1,yPosition - 2);
        int bottomRightLPosition = getPositionFromCoordinates(xPosition + 1,yPosition + 2);
        int bottomLeftLPosition = getPositionFromCoordinates(xPosition - 1,yPosition + 2);
        int topLeftLPosition = getPositionFromCoordinates(xPosition - 1,yPosition - 2);
        int []movablePositionsToCheck = {topRightLPosition, bottomRightLPosition, bottomLeftLPosition, topLeftLPosition};

        findMovablePositions(movablePositionsToCheck, chessBoard);
        colorMovablePositions(chessBoard);
    }
}

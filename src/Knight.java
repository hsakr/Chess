import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Knight extends ChessPiece {

    public Knight(Image image){
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

        int topRightLPosition = getPositionFromCoordinates(xPosition + 1,yPosition - 2);
        int bottomRightLPosition = getPositionFromCoordinates(xPosition + 1,yPosition + 2);
        int bottomLeftLPosition = getPositionFromCoordinates(xPosition - 1,yPosition + 2);
        int topLeftLPosition = getPositionFromCoordinates(xPosition - 1,yPosition - 2);
        int rightTopL = getPositionFromCoordinates(xPosition + 2,yPosition - 1);
        int rightBottomL = getPositionFromCoordinates(xPosition + 2,yPosition + 1);
        int leftTopL = getPositionFromCoordinates(xPosition - 2,yPosition + 1);
        int leftBottomL = getPositionFromCoordinates(xPosition - 2,yPosition -1);
        int []movablePositionsToCheck = {topRightLPosition, bottomRightLPosition, bottomLeftLPosition, topLeftLPosition, rightTopL, rightBottomL, leftTopL, leftBottomL};

        findMovablePositions(movablePositionsToCheck, chessBoard);
        colorMovablePositions(chessBoard);
    }
}

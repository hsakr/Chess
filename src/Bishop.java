import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Bishop extends ChessPiece {

    public Bishop(Image image, int position){
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

        int positionX = xPosition + 1;
        int positionY = yPosition - 1;
        while (positionX < 8 && positionY < 8){ // checks top right direction for movement
            int position = getPositionFromCoordinates(positionX, positionY);
            if (movablePosition(position, chessBoard)){
                if(squareContainsPiece(position, chessBoard)){
                    break;
                }
            } else {
                break;
            }
            positionX++;
            positionY--;
        }

        positionX = xPosition - 1;
        positionY = yPosition - 1;
        while (positionX < 8 && positionY < 8){ // checks top left direction for movement
            int position = getPositionFromCoordinates(positionX, positionY);
            if (movablePosition(position, chessBoard)){
                if(squareContainsPiece(position, chessBoard)){
                    break;
                }
            } else {
                break;
            }
            positionX--;
            positionY--;
        }

        positionX = xPosition + 1;
        positionY = yPosition + 1;
        while (positionX < 8 && positionY < 8){ // checks bottom right direction for movement
            int position = getPositionFromCoordinates(positionX, positionY);
            if (movablePosition(position, chessBoard)){
                if(squareContainsPiece(position, chessBoard)){
                    break;
                }
            } else {
                break;
            }
            positionX++;
            positionY++;
        }

        positionX = xPosition - 1;
        positionY = yPosition + 1;
        while (positionX < 8 && positionY < 8){ // checks bottom left direction for movement
            int position = getPositionFromCoordinates(positionX, positionY);
            if (movablePosition(position, chessBoard)){
                if(squareContainsPiece(position, chessBoard)){
                    break;
                }
            } else {
                break;
            }
            positionX--;
            positionY++;
        }
        colorMovablePositions(chessBoard);
    }
}

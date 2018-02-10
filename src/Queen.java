import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Queen extends ChessPiece {

    public Queen(Image image){
        super(image);
    }

    public void pieceSelected(int pieceSelectedPosition, int xPosition, int yPosition){
        this.pieceSelectedPosition = pieceSelectedPosition;
        ChessBoardManager chessBoardManager = ChessBoardManager.getInstance();
        ChessBoard chessBoard = chessBoardManager.getChessBoard();

        System.out.println("xPosition: " + xPosition + " yPosition: " + yPosition);

        for (int i = yPosition - 1; i >= 0; i--){ // checks upward direction for movement
            int position = getPositionFromCoordinates(xPosition, i);
            if (movablePosition(position, chessBoard)){
                if(squareContainsPiece(position, chessBoard)){
                    break;
                }
            } else {
                break;
            }
        }

        for (int j = yPosition + 1; j < 8; j++){ // checks downward direction for movement
            int position = getPositionFromCoordinates(xPosition, j);
            if (movablePosition(position, chessBoard)){
                if(squareContainsPiece(position, chessBoard)){
                    break;
                }
            } else {
                break;
            }
        }

        for (int k = xPosition + 1; k < 8; k++){ // checks downward direction for movement
            int position = getPositionFromCoordinates(k, yPosition);
            if (movablePosition(position, chessBoard)){
                if(squareContainsPiece(position, chessBoard)){
                    break;
                }
            } else {
                break;
            }
        }

        for (int l = xPosition - 1; l < 8; l--){ // checks downward direction for movement
            int position = getPositionFromCoordinates(l, yPosition);
            if (movablePosition(position, chessBoard)){
                if(squareContainsPiece(position, chessBoard)){
                    break;
                }
            } else {
                break;
            }
        }

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

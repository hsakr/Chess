import javafx.scene.paint.Color;

public interface ChessPiece extends Colors {
    public void pieceSelected();
    public Color getColor();
    public int getXPosition();
    public int getYPosition();
    //public void move();
}

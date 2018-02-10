import javafx.scene.paint.Color;

public class Player implements Colors{

    private String playerName;
    private Color playerColor;

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName(){
        return this.playerName;
    }

    public Color getPlayerColor() {
        return playerColor;
    }

    public void setPlayerColor(Color color){
        this.playerColor = color;
    }
}

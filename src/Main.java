import javafx.application.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.geometry.*;

public class Main extends Application {

    private BorderPane chessProgram = new BorderPane();
    private ChessBoard chessBoard = new ChessBoard();

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        chessProgram.setCenter(chessBoard);
        Scene scene = new Scene(chessProgram);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        startGame();
    }

    public void startGame(){

    }
}

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class HelloWorld extends Application {

    // private StickHero stickhero;
    // private Platform platform;
    // private Dragon dragon;
    // private ScoreBoard scoreboard;
    // private Stick stick;

    // static music music = new music();

    MediaPlayer mediaPlayer;


    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("homepage.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        controller.setMainWindow(primaryStage);
        primaryStage.setTitle("Fortress Legends");
        primaryStage.setScene(new Scene(root,800, 600));
        primaryStage.show();

    }

    

    public static void main(String[] args) {
        launch(args);
    }
}



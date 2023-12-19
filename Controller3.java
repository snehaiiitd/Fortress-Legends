import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller3 {

    private Stage mainw;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void setMainWindow(Stage mainw) {
        this.mainw = mainw;
    }

    @FXML
    private ImageView bg;

    @FXML
    private ImageView dragon1;

    @FXML
    private Label drcount;

    @FXML
    private Text levelcount;

    @FXML
    private Text pausetext;

    @FXML
    private Button restart;

    @FXML
    private Button resume;

    @FXML
    private Label score;

    @FXML
    private Label scoreboard;

    @FXML
    private ImageView sound;

    public void initialize() {
        dragon1.setImage(new Image(getClass().getResourceAsStream("/dragon1.png")));
        sound.setImage(new Image(getClass().getResourceAsStream("/sound.png")));
    }

    public void switchToGamePageRestart(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("gamepage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    
    public void switchToGamePageResume(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("gamepage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}

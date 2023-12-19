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

public class Controller2 {

    @FXML
    private Text bestscore;
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
    private Text gameover;

    @FXML
    private Text levelcount;

    @FXML
    private Button retry;

    @FXML
    private Button revive;

    @FXML
    private Label score;

    @FXML
    private Label score1;

    @FXML
    private Label score2;

    @FXML
    private Label scoreboard;

    @FXML
    private ImageView sound;

    @FXML
    private Text yourscore;

    private Controller1 controller1;

    // Method to set the reference to Controller1
    public void setController1(Controller1 controller1) {
        this.controller1 = controller1;
    }

    public void initialize() throws IOException{
        dragon1.setImage(new Image(getClass().getResourceAsStream("/dragon1.png")));
        sound.setImage(new Image(getClass().getResourceAsStream("/sound.png")));
        //score1.setText(controller1.getScore());
        
    }

    public void switchToGamePageRetry(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("gamepage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();

    }
    
    public void switchToGamePageRevive(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("gamepage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void setScore(){
    }
}


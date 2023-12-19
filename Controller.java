import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.Node;
import javafx.scene.Parent;

public class Controller {

    @FXML
    private ImageView bg;
    
    private Stage mainwindow;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void setMainWindow(Stage mainwindow) {
        this.mainwindow = mainwindow;
    }

    @FXML
    private ImageView castle1;

    @FXML
    private ImageView castle2;

    @FXML
    private ImageView castle3;

    @FXML
    private Text name;

    @FXML
    private ImageView bg1;

    @FXML
    private ImageView castle1new;

    @FXML
    private ImageView castle2new;

    @FXML
    private ImageView dragon;

    @FXML
    private ImageView dragon1;

    @FXML
    private Label drcount;

    @FXML
    private Text inst;

    @FXML
    private Label level;

    @FXML
    private ImageView Pause;

    @FXML
    private Label score;

    @FXML
    private Label scoreboard;

    @FXML
    private ImageView sound;

    @FXML
    private Rectangle stick;

    @FXML
    private ImageView warrior;

    @FXML
    private ImageView question;


    // Assume your images are in the same package as your Controller class
    private static final String IMAGE_PATH = "C:/Users/Sneha/Desktop/javafx";

    public void initialize() {

        castle1.setImage(new Image(getClass().getResourceAsStream("/castle1.png")));
        castle2.setImage(new Image(getClass().getResourceAsStream("/castle2.png")));
        castle3.setImage(new Image(getClass().getResourceAsStream("/castle3.png")));
        dragon1.setImage(new Image(getClass().getResourceAsStream("/dragon1.png")));
        sound.setImage(new Image(getClass().getResourceAsStream("/sound.png")));
        question.setImage(new Image(getClass().getResourceAsStream("/question.png")));
    }

    public void switchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("gamepage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}


import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.scene.input.MouseEvent;


import javafx.animation.RotateTransition;

import javafx.animation.Timeline;

import javafx.scene.transform.Rotate;


import javafx.scene.paint.Color;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;


interface CastleIterator {
    boolean hasNext();
    Rectangle next();
}

//decorator design pattern
interface DecoratorDesign {
    public void decorator();
}

public class Controller1 implements Initializable{

    @FXML
    private ImageView bg;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Stage stage1;
    private Scene scene1;
    private Parent root1;

    private Stage mainwindow;

    public void setMainWindow(Stage mainwindow) {
        this.mainwindow = mainwindow;
    }

    public double shiftd;

    @FXML
    public Rectangle castle1;

    @FXML
    public Rectangle castle2;

    @FXML
    private ImageView dragon;

    @FXML
    private ImageView dragon1;

    @FXML
    private Label drcount;

    @FXML
    private Text inst;

    private int isFunction = 0;

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
    public Rectangle stick,newStick;

    @FXML
    private Pane rootPane;
    private Scene scene2;
    int f = 0;

    private Timeline growAnimation;
    // private boolean isFirstMouseMovement = false;
    // private boolean isFirstMouseMovement1 = false;

    
    @FXML
    private ImageView warrior;
    private static final String IMAGE_PATH = "C:/Users/Sneha/Desktop/javafx";

    

    
    private StickHero stickhero;
    private Platform platform;
    private Dragon dragoncode;
    private ScoreBoard scoreboardcode;
    private Stick stickcode;
    private double valx;
    private double valy;
    private double newHeight;
    private boolean isFlipped = false;
    private int flag;

    private MediaPlayer backgroundMusicPlayer;
    private AudioClip gameOverSound;

    //iterator design pattern
    private CastleIterator castleIterator;

        // Inner class implementing the CastleIterator interface
    private class CastleIteratorI implements CastleIterator {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < rootPane.getChildren().size() && rootPane.getChildren().get(currentIndex) instanceof Rectangle;
        }

        @Override
        public Rectangle next() {
            if (hasNext()) {
                return (Rectangle) rootPane.getChildren().get(currentIndex++);
            }
            throw new NoSuchElementException("No more castles");
        }
    }

    // Method to iterate over castles
    private void iterateCastles() {
        while (castleIterator.hasNext()) {
            Rectangle castle = castleIterator.next();
            // Process each castle
        }
    }

    private static Controller1 instance;

    // private Controller1() {
    //     // Private constructor to prevent instantiation from outside the class
    // }

    public static Controller1 getInstance() {
        if (instance == null) {
            instance = new Controller1();
        }
        return instance;
    }

    public double getShiftd(){
        return shiftd;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bg.setImage(new Image(getClass().getResourceAsStream("/bg.jpg")));
        warrior.setImage(new Image(getClass().getResourceAsStream("/warrior.png")));
        dragon.setImage(new Image(getClass().getResourceAsStream("/dragon.png")));
        dragon1.setImage(new Image(getClass().getResourceAsStream("/dragon1.png")));
        sound.setImage(new Image(getClass().getResourceAsStream("/sound.png")));
        Pause.setImage(new Image(getClass().getResourceAsStream("/Pause.png")));
        flag = 0;

        // mediaPlayer.play();
        rootPane.requestFocus();
        code();


    }
    private void code(){
        growAnimation = new Timeline(
                new KeyFrame(Duration.millis(50), event -> growRectangle())
        );
        growAnimation.setCycleCount(Timeline.INDEFINITE); // Run the animation indefinitely

        // Add event handlers
        rootPane.setOnMousePressed(this::handleMousePressed);
        rootPane.setOnMouseReleased(this::handleMouseReleased);

    }

    private void handleMousePressed(MouseEvent event) {
        if (flag == 0){
            growAnimation.play();
        }
        else{
            decorator();

        }    
        
    }

    public void decorator(){
        Rotate rotate = new Rotate(
                            180,
                            warrior.getLayoutX() + warrior.getFitWidth()/2,
                            warrior.getLayoutY() + warrior.getFitHeight()
        );
        warrior.getTransforms().add(rotate);
        isFunction++;
    }

    private void handleMouseReleased(MouseEvent event) {
        // Stop the animation when the mouse is released
        growAnimation.stop();
        if (flag == 0){
               run(event);
        }
     
        flag = 1;
    }

    public void run(MouseEvent event){
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(stick);
        rotate.setDuration(Duration.millis(500));
        rotate.setCycleCount(1);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setByAngle(90);
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.play();
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(stick);
        translate.setDuration(Duration.millis(500));
        translate.setCycleCount(1);
        translate.setByX(newHeight/2);
        translate.setByY(newHeight/2);
        translate.setAutoReverse(false);
        translate.play();
        TranslateTransition translatep = new TranslateTransition();
        translatep.setNode(warrior);
        translatep.setDuration(Duration.millis(3000));
        translatep.setCycleCount(1);
        translatep.setByX(newHeight + 50);
        translatep.setAutoReverse(false);
        System.out.println("Inside handle mouse released");
        translatep.setOnFinished(event1 -> {
            if ((castle1.getLayoutX() + castle1.getWidth() + newHeight) < castle2.getLayoutX() || castle1.getLayoutX() + castle1.getWidth() + newHeight > castle2.getLayoutX() + castle2.getWidth()){
                TranslateTransition translatew = new TranslateTransition();
                translatew.setNode(warrior);
                translatew.setDuration(Duration.millis(1000));
                translatew.setCycleCount(1);
                translatew.setByY(5000);
                translatew.setAutoReverse(false);
                translatew.play();
            //     Duration delay = Duration.seconds(2);
            // Timeline timeline = new Timeline(new KeyFrame(delay, event -> switchScene()));
            // timeline.play();
                Duration delay = Duration.seconds(2);
                System.out.println("stick is short");
                // mediaPlayer.stop();
                // gameOverSound.play();
                Timeline timeline = new Timeline(new KeyFrame(delay, event2 -> {
                    try{
                        root = FXMLLoader.load(getClass().getResource("gameover.fxml"));
                        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    }catch (IOException i){
                        System.out.println("IO exception encountered");
                    }
                }));
                timeline.play();
            }else{
                TranslateTransition translatem = new TranslateTransition();
                translatem.setNode(warrior);
                translatem.setDuration(Duration.millis(1000));
                translatem.setCycleCount(1);
                translatem.setByX(castle2.getLayoutX() + castle2.getWidth() - castle1.getLayoutX() - castle1.getWidth() - newHeight - 50);
                translatem.setAutoReverse(false);
                translatem.play();
                int s = Integer.parseInt(score.getText());
                s++;
                score.setText(String.valueOf(s));
                shiftFrameAndCharacterBackward();
                
            }
        }); 
        translatep.play();
        
    }



    public void growRectangle() {

        double increaseHeight = 5;
        
        // newWidth = stick.getWidth() + increaseWidth;
        newHeight = stick.getHeight() + increaseHeight;
        stick.setHeight(newHeight);
        valy = stick.getLayoutY() - increaseHeight;
        stick.setLayoutY(valy);
        // stick.setLayoutX(castle2.getLayoutX());

    }

    private void addRandomRectangle(Pane pane) {
        // Specify the height
        double height = 500;

        // Generate random values for width and x layout
        Random random = new Random();
        double width = random.nextDouble() * 200 + 50;  // Random width between 50 and 250
        double xLayout = random.nextDouble() * 300 + 200;  // Random x layout within the pane
        double yLayout = castle2.getLayoutY();
        System.out.println(yLayout + "is the y layout");
        castle1 = castle2;
        // Create the ImageView
        castle2 = new Rectangle();  // Replace with your image path
        castle2.setWidth(width);
        castle2.setHeight(height);
        castle2.setLayoutX(xLayout);
        castle2.setLayoutY(yLayout);
        castle2.setFill(Color.web("#3b3d40"));
        castle2.setPickOnBounds(true);
        
        // Add the ImageView to the pane
        pane.getChildren().add(castle2);
        addRandomDragon(pane);
    }

    private void addRandomDragon(Pane pane) {
        double shiftDistance = castle2.getLayoutX();  // Adjust the distance as needed
        shiftd = shiftDistance;
        Timeline timeline1;
        timeline1 = new Timeline(new KeyFrame(Duration.millis(100),
             new KeyValue(dragon.layoutXProperty(), dragon.getLayoutX() - shiftDistance)));
        timeline1.play();
        double dragonWidth = 47;
        double dragonHeight = 49;
        timeline1.setOnFinished(event -> {
             rootPane.getChildren().remove(dragon);
        });
         // Adjust the range based on your specific requirements
        double minX = castle1.getLayoutX() + castle1.getWidth();
        double maxX = castle2.getLayoutX() - dragonWidth;
        double randomX = Math.random() * (maxX - minX) + minX;
        ImageView randomDragon = new ImageView(dragon.getImage());
        randomDragon.setLayoutX(randomX);
        randomDragon.setLayoutY(castle1.getLayoutY() - dragonHeight);
        randomDragon.setFitWidth(47);
        randomDragon.setFitHeight(49);
        
        rootPane.getChildren().remove(dragon);
        randomDragon.setOnMouseClicked(event -> {
            int currentScore = Integer.parseInt(drcount.getText());
            currentScore++;
            drcount.setText(String.valueOf(currentScore));
            
        });
        initializeNewStick();
        
    }

    private void addRandomDragonBetweenCastles() {
        
        removeDragons();
        ImageView dragon = new ImageView(new Image("/dragon1.png"));  // Replace with your dragon image path
        double dragonWidth = 47;
        double dragonHeight = 49;
        double minX = castle1.getLayoutX() + castle1.getWidth();
        double maxX = castle2.getLayoutX() - dragonWidth;
        double randomX = Math.random() * (maxX - minX) + minX;
        ImageView randomDragon = new ImageView(dragon.getImage());
        randomDragon.setLayoutX(randomX);
        randomDragon.setLayoutY(castle1.getLayoutY() - dragonHeight);
        randomDragon.setFitWidth(dragonWidth);
        randomDragon.setFitHeight(dragonHeight);

        randomDragon.setId("dragon"); 
        rootPane.getChildren().add(randomDragon);
        if (isFunction > 0){
            int d = Integer.parseInt(drcount.getText());
            d++;
            drcount.setText(String.valueOf(d));
        }
    }

    // private void removeDragons() {
    //     // Remove dragons that are out of the visible area
    //     Iterator<Node> iterator = rootPane.getChildren().iterator();
    //     while (iterator.hasNext()) {
    //         Node node = iterator.next();
    //         if (node instanceof ImageView && !isNodeVisible(node)) {
    //             iterator.remove();
    //         }
    //     }
    // }

    // private boolean isNodeVisible(Node node) {
    //     Bounds screenBounds = rootPane.localToScreen(rootPane.getBoundsInLocal());
    //     Bounds nodeBounds = node.localToScreen(node.getBoundsInLocal());

    //     return nodeBounds.getMaxX() >= screenBounds.getMinX() && nodeBounds.getMinX() <= screenBounds.getMaxX();
    // }    
    

    private void removeDragons() {
        // Remove dragons that are in the visible area
        Iterator<Node> iterator = rootPane.getChildren().iterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node instanceof ImageView && node.getId() != null && node.getId().equals("dragon") && isNodeVisible(node)) {
                iterator.remove();
            }
        }
    }
    
    private boolean isNodeVisible(Node node) {
        Bounds bounds = node.getBoundsInParent();
        return bounds.getMaxX() >= 0 && bounds.getMinX() <= rootPane.getWidth();
    }

    private void shiftFrameAndCharacterBackward() {
        double shiftDistance = castle2.getLayoutX();  // Adjust the distance as needed

        Timeline timeline;

        timeline = new Timeline(new KeyFrame(Duration.millis(100),
            new KeyValue(castle1.layoutXProperty(), castle1.getLayoutX() - shiftDistance)));

        timeline.play();

        timeline = new Timeline(new KeyFrame(Duration.millis(100),
            new KeyValue(castle2.layoutXProperty(), castle2.getLayoutX() - shiftDistance)));

        timeline.play();

        timeline = new Timeline(new KeyFrame(Duration.millis(100),
            new KeyValue(warrior.layoutXProperty(), warrior.getLayoutX() - shiftDistance)));

        timeline.play();

        timeline = new Timeline(new KeyFrame(Duration.millis(100),
            new KeyValue(stick.layoutXProperty(), stick.getLayoutX() - shiftDistance)));

        timeline.play();

        timeline = new Timeline(new KeyFrame(Duration.millis(100),
            new KeyValue(dragon.layoutXProperty(), dragon.getLayoutX() - shiftDistance)));

        timeline.play();

        addRandomDragonBetweenCastles();

        timeline.setOnFinished(event -> {
            rootPane.getChildren().remove(stick);
            rootPane.getChildren().remove(dragon);
            flag = 0;
            addRandomRectangle(rootPane); // Add new castle
        });

        
        // translateStick.play();
    }
    private void initializeNewStick() {
        
        // Create a new Stick instance
        stick = new Rectangle();

        System.out.println("\n" + castle1.getLayoutY() + "\n");
        
        // Set initial properties for the new stick
        stick.setWidth(6);
        stick.setLayoutY(castle1.getLayoutY()-stick.getWidth());
        newHeight = 10;
        stick.setHeight(newHeight);
        // stick.setLayoutY(stick.getLayoutY()-75);
        stick.setLayoutX(castle1.getWidth()+castle1.getLayoutX()-stick.getWidth());
        stick.setFill(Color.web("#3b3d40"));
    
        // Add the new stick to the scene
        rootPane.getChildren().add(stick);
        rootPane.setOnMousePressed(this::handleMousePressed);
        rootPane.setOnMouseReleased(this::handleMouseReleased);
        // code(); 
    }

    public void switchToPauseScreen(MouseEvent event3) throws IOException {
        root = FXMLLoader.load(getClass().getResource("pausescreen.fxml"));
        stage = (Stage)((Node)event3.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public String getScore(){
        return score.getText();
    }
    

    private void initializeGame() {
        // Game initialization logic
    }

    private StickHero createStickHero() { //composition relationship
        this.stickhero = new StickHero();
        return stickhero;
        // Stickhero creation logic
    }

    public StickHero getStickHero(){
        return stickhero;
    }

 
    private Platform createPlatform() { //composition relationship
        this.platform = new Platform();
        return platform;        
        // Platform creation logic
    }

    private Dragon createDragon() { //composition relationship
        this.dragoncode = new Dragon();
        return dragoncode;
        // Dragon creation logic
    }

    private ScoreBoard createScoreBoard() { //composition relationship
        this.scoreboardcode = new ScoreBoard();
        return scoreboardcode;
        // Scoreboard creation logic
    }
    private Stick createStick() { //composition relationship
        this.stickcode = new Stick();
        return stickcode;
        // Stick creation logic
    }

    public Platform getPlatform(){
        return platform;
    }

    public ImageView getDragon(){
        return dragon;
    }

    public Label getScoreBoard(){
        return scoreboard;
    }

    public Rectangle getStick(){
        return stick;
    }

}

abstract class Warrior{
    public abstract void stretchstick();
}

class StickHero extends Warrior {
    private double x;
    private double y;
    private double height;
    private int score1;
    private Stick stick1;


    public void move() {
        // Move stick-hero logic
    }

    public void killDragon(Dragon dragon) { //dependency relationship
        dragon.kill();
    }

    public double reachMidPoint(Platform p) { //dependency relationship
        return p.getmidpoint();
        // Flip stick-hero logic
    }
    public int revive(Dragon dragon){  //dependency relationship
        return dragon.getvalue();
    }
    public int getscore(){
        return this.score1;
    }

    @Override
    public void stretchstick() {
        this.stick1 = new Stick();
    }
}

class ScoreBoard{
    private double x;
    private double y;

    public int showScore(StickHero st){  //dependency relationship
        return st.getscore();
    }
}




class Stick{
    private double x;
    private double y;
    private int length;

    public void setLength(){
    }
    
}


class Platform {
    private double width;
    private double height;
    private double midpoint;

    public void flip() {
        
    }
    public double getmidpoint(){
        return this.midpoint;
    }
}


class Dragon {
    private double x;
    private double y;
    private int value;

    public void kill() {

    }
    public int getvalue(){
        return this.value;
    }
}
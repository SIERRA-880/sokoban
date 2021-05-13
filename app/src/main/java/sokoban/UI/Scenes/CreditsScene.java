package sokoban.UI.Scenes;

import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import sokoban.ScenesEnum;
import sokoban.UI.Widgets.BackButton;
import sokoban.UI.Widgets.Controller;
import sokoban.UI.Widgets.VideoBg;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Scene displaying the credentials
 */
public class CreditsScene extends BasicScene {

    /**
     *Constructor of CreditScene
     * @param stackPane Pane type object where other layouts will be placed on
     */
    public CreditsScene(StackPane stackPane) {
        super(stackPane);

        stackPane.setStyle("-fx-background-color: #000000;");

        // cursor
        try {
            Image image = new Image(new FileInputStream("build/resources/main/textures/Default/Menus/cursor_pointerFlat.png"));
            setCursor(new ImageCursor(image));
        } catch (FileNotFoundException e) {

            Controller.alert("Cursor skin file could not be loaded please check the file path in CreditsScene:39 ");
        }

        // credits 
        Font f = null;
        try {
            f = Font.loadFont(new FileInputStream("build/resources/main/textures/Default/Fonts/Kenney Rocket Square.ttf"), 20);
        } catch (FileNotFoundException e) {

            Controller.alert("Fonts file could not be loaded please check the file path in CreditsScene:43 ");
        }

        // gridPane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(20);



        //labels
        Label label = new Label("LINK COPIED !");
        label.setFont(f);
        label.setTextFill(Color.web("#A7F5F4"));
        label.setVisible(false);
        stackPane.getChildren().add(label);
        stackPane.setAlignment(label,Pos.TOP_CENTER);
        StackPane.setMargin(label,new Insets(200,0,0,0));

        Label l1 = new Label("Developers");
        l1.setFont(f);
        l1.setTextFill(Color.web("#A7F5F4"));
        grid.add(l1, 0, 0);

        Hyperlink link2 = new Hyperlink("SIERRA-880, tiramisu, Harbinger");
        link2.setOnAction(e ->{ label.setVisible(false);writeToClipboard("https://github.com/SIERRA-880/sokoban", null);
            label.setVisible(true);
            // stack Overflow: https://stackoverflow.com/questions/29487645/how-to-make-a-label-visible-for-a-certain-time-and-then-should-be-invisible-with
            PauseTransition visiblePause = new PauseTransition(
                    Duration.seconds(2)
            );
            visiblePause.setOnFinished(
                    event -> label.setVisible(false)
            );
            visiblePause.play();
        });
        link2.setTextFill(Color.web("#FFFFFF"));
        grid.add(link2, 1, 0);

        Label l3 = new Label("Video");
        l3.setFont(f);
        l3.setTextFill(Color.web("#A7F5F4"));
        grid.add(l3, 0, 1);

        Hyperlink link4 = new Hyperlink("youtube : Facta Non Verba Designs");
        link4.setOnAction(e ->{ writeToClipboard("https://www.youtube.com/watch?v=B02Q3cg2wtY", null);
        label.setVisible(true);
        PauseTransition visiblePause = new PauseTransition(
                Duration.seconds(2)
        );
        visiblePause.setOnFinished(
                event -> label.setVisible(false)
        );
        visiblePause.play();});
        link4.setTextFill(Color.web("#FFFFFF"));
        grid.add(link4, 1, 1);

        Label l5 = new Label("Music");
        l5.setFont(f);
        l5.setTextFill(Color.web("#A7F5F4"));
        grid.add(l5, 0, 2);

        Hyperlink link6 = new Hyperlink("youtube : DzGrimX");
        link6.setOnAction(e ->{ writeToClipboard("https://www.youtube.com/watch?v=L5pfhWye3UM", null);
                    label.setVisible(true);
                    PauseTransition visiblePause = new PauseTransition(
                            Duration.seconds(2)
                    );
                    visiblePause.setOnFinished(
                            event -> label.setVisible(false)
                    );
                    visiblePause.play();});
        link6.setTextFill(Color.web("#FFFFFF"));
        grid.add(link6, 1, 2);

        Label l7 = new Label("Levels sounds FX");
        l7.setFont(f);
        l7.setTextFill(Color.web("#A7F5F4"));
        grid.add(l7, 0, 3);

        Hyperlink link8 = new Hyperlink("OpenGameArt : Michel Baradari");
        link8.setOnAction(e -> {writeToClipboard("https://opengameart.org/content/9-sci-fi-computer-sounds-and-beeps", null);
            label.setVisible(true);
            PauseTransition visiblePause = new PauseTransition(
                    Duration.seconds(2)
            );
            visiblePause.setOnFinished(
                    event -> label.setVisible(false)
            );
            visiblePause.play();});
        link8.setTextFill(Color.web("#FFFFFF"));
        grid.add(link8, 1, 3);

        Label l9 = new Label("Textures");
        l9.setFont(f);
        l9.setTextFill(Color.web("#A7F5F4"));
        grid.add(l9, 0, 4);

        Hyperlink link10 = new Hyperlink("OpenGameArt : Jellybean");
        link10.setOnAction(e ->{ writeToClipboard("https://opengameart.org/content/top-down-2d-metal-box", null);
            label.setVisible(true);
            PauseTransition visiblePause = new PauseTransition(
                    Duration.seconds(2)
            );
            visiblePause.setOnFinished(
                    event -> label.setVisible(false)
            );
            visiblePause.play();});
        link10.setTextFill(Color.web("#FFFFFF"));
        grid.add(link10, 1, 4);

        Label l11 = new Label("Sounds FX");
        l11.setFont(f);
        l11.setTextFill(Color.web("#A7F5F4"));
        grid.add(l11, 0, 5);

        Hyperlink link12 = new Hyperlink("SoundCloud : Eko-in");
        link12.setOnAction(e ->{ writeToClipboard("https://soundcloud.com/user-534734056", null);
            label.setVisible(true);
            PauseTransition visiblePause = new PauseTransition(
                    Duration.seconds(2)
            );
            visiblePause.setOnFinished(
                    event -> label.setVisible(false)
            );
            visiblePause.play();});
        link12.setTextFill(Color.web("#FFFFFF"));
        grid.add(link12, 1, 5);

        Label l13 = new Label("Explosion sound");
        l13.setFont(f);
        l13.setTextFill(Color.web("#A7F5F4"));
        grid.add(l13, 0, 6);

        Hyperlink link14 = new Hyperlink("Marcelo Fernandez");
        link14.setOnAction(e ->{ writeToClipboard("https://soundcloud.com/marcelofernandezmusic", null);
            label.setVisible(true);
            PauseTransition visiblePause = new PauseTransition(
                    Duration.seconds(2)
            );
            visiblePause.setOnFinished(
                    event -> label.setVisible(false)
            );
            visiblePause.play();});
        link14.setTextFill(Color.web("#FFFFFF"));
        grid.add(link14, 1, 6);

        Label l14 = new Label("Custom cursor & font");
        l14.setFont(f);
        l14.setTextFill(Color.web("#A7F5F4"));
        grid.add(l14, 0, 7);

        Hyperlink link15 = new Hyperlink("Kenney Assets");
        link15.setOnAction(e ->{ writeToClipboard("https://kenney.nl/assets", null);
            label.setVisible(true);
            PauseTransition visiblePause = new PauseTransition(
                    Duration.seconds(2)
            );
            visiblePause.setOnFinished(
                    event -> label.setVisible(false)
            );
            visiblePause.play();});
        link15.setTextFill(Color.web("#FFFFFF"));
        grid.add(link15, 1, 7);

        Label l16 = new Label("Textures and GUI");
        l16.setFont(f);
        l16.setTextFill(Color.web("#A7F5F4"));
        grid.add(l16, 0, 8);

        Label l17 = new Label("Harbinger");
        l17.setTextFill(Color.web("#FFFFFF"));
        grid.add(l17, 1, 8);

        stackPane.getChildren().add(grid);
        StackPane.setAlignment(grid, Pos.CENTER);

        // backButton
        try {
            BackButton bbutton = new BackButton();
            bbutton.setOnAction(e -> {
                Controller.switchScene(ScenesEnum.VIDEOSCENE);
                VideoBg.playVplayer();
                VideoScene.playMplayer();
            });
            stackPane.getChildren().add(bbutton);
            StackPane.setAlignment(bbutton, Pos.TOP_LEFT);
            StackPane.setMargin(bbutton, new Insets(20.0, 0.0, 0.0, 20.0));
        } catch (FileNotFoundException e) {
            Controller.alert("The image of the back button could not be loaded please check the file path in the CreditScene");
        }
    }

    /**
     * Copy the given String to the OS clipboard
     * @param s the string to copy
     * @param owner null
     */
    public void writeToClipboard(String s, ClipboardOwner owner) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable transferable = new StringSelection(s);
        clipboard.setContents(transferable, owner);
    }

}

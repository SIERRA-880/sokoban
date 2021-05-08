package sokoban.UI.Widgets;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sokoban.Game;
import sokoban.ScenesEnum;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Optional;

public class Controller {

    public static void switchScene(ScenesEnum scene) {
        Game.pane = new StackPane();
        switch (scene) {
            case VIDEOSCENE:
                Game.window.setScene(Game.videoScene);
                break;
            case MENULVLSCENE:
                Game.menuLvlScene.refresh();
                Game.window.setScene(Game.menuLvlScene);
                break;
            case OPTIONSCENE:
                Game.window.setScene(Game.optionScene);
                break;
            case CREDITSSCENE:
                Game.window.setScene(Game.creditsScene);
                break;
            case LEVELSCENE:
                Game.levelScene.reset();
                Game.window.setScene(Game.levelScene);
                break;
            case ARCADESCENE:
                Game.window.setScene(Game.arcadeScene);
                break;
            case RANDOMLEVELSCENE:
                Game.randomLevelScene.reset();
                Game.window.setScene(Game.randomLevelScene);
                break;
            case BUILDERSCENE:
                Game.builderScene.refresh();
                Game.window.setScene(Game.builderScene);
                break;
            default:
                System.out.println("I told you we would make a mistake !");
                break;
        }
        Game.window.setMaximized(true);
        Game.window.setFullScreenExitHint("");
    }

    public static void alert(String message, ScenesEnum SCENE) {
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR, message);
        alert.setTitle("Loading image error");
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        ButtonType exit = new ButtonType("Exit");
        ButtonType back = new ButtonType("Back");
        // Button methodes
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get().equals(back)) {
            switchScene(SCENE);
        } else if (option.get().equals(exit)) {
            System.exit(0);
        }
        try {
            // Add corner icon
            stage.getIcons().add(new Image(new FileInputStream(("build/resources/main/textures/" +
                    "Default/Buttons/levelMenu/levelButton_1.png"))));
            // Add Stage icon
            alert.setGraphic(new ImageView(new Image(new FileInputStream("build/resources/main/textures/" +
                    "Default/Buttons/levelMenu/levelButton_1.png"))));
        }catch (FileNotFoundException e ){
            alert = new Alert(Alert.AlertType.ERROR, "The images for the alert could not be found in" +
                    " Controller.java");
            alert.setTitle("Loading image error");
            alert.show();

        }
        alert.show();

    }
}

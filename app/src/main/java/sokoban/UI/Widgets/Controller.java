package sokoban.UI.Widgets;

import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import sokoban.Game;
import sokoban.ScenesEnum;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Optional;

import static sokoban.Game.*;

public class Controller {
    public static AudioClip audioClip = new AudioClip(new File("build/resources/main/textures/" +
            Game.resourcePack + "/Sounds/menus/explosionSound.wav").toURI().toString());

    public static void switchScene(ScenesEnum scene) {
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
            case LOADSCENE:
                Game.window.setScene(Game.loadScene);
                break;
            default:
                System.out.println("I told you we would make a mistake !");
                break;
        }
        Game.window.setMaximized(true);

    }

    public static void alert(String message) {
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR, message);
        alert.setTitle("Loading image error");
        alert.getButtonTypes().clear();
        ButtonType exit = new ButtonType("Exit");
        alert.getButtonTypes().add(exit);
        // Button methodes

        Optional<ButtonType> option = alert.showAndWait();
        if (option.get().equals(exit)) {
            System.exit(0);
        }
        alert.show();
    }

    public static void setBrightness(Effect e) {
        videoScenePane.setEffect(e);
        menuLvlScenePane.setEffect(e);
        levelScenePane.setEffect(e);
        creditsScenePane.setEffect(e);
        optionScenePane.setEffect(e);
        arcadeScenePane.setEffect(e);
        randomLevelScenePane.setEffect(e);
        builderScenePane.setEffect(e);
        loadScenePane.setEffect(e);

    }

    public static void explosion(Scene scene) {
        audioClip.setVolume(OptionPane.slider.getValue()/100);
        try {
            Image image = new Image(new FileInputStream("build/resources/main/textures/" + Game.resourcePack + "/Menus/" +
                    "cursor_pointerFlat.png"));  //pass in the image path
            scene.setCursor(new ImageCursor(image));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("cursor problem");
        }

        scene.setOnMousePressed(event -> {
            try {
                audioClip.stop();
                Image image = new Image(new FileInputStream("build/resources/main/textures/" +
                        "" + Game.resourcePack + "/Cells/explosion.png"));
                scene.setCursor(new ImageCursor(image));
                audioClip.play();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        scene.setOnMouseReleased(event -> {
            try {
                Image image = new Image(new FileInputStream("build/resources/main/textures/" + Game.resourcePack + "/Menus/" +
                        "cursor_pointerFlat.png"));  //pass in the image path
                scene.setCursor(new ImageCursor(image));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("cursor problem");
            }
        });

    }

    public static void explosionNo(Scene scene) {
        audioClip.setVolume(0);

        scene.setOnMousePressed(null);
        scene.setOnMouseReleased(null);

    }

    public static void setExplosion(Boolean a) {
        if (a) {
            explosion(videoScene);
            explosion(menuLvlScene);
            explosion(levelScene);
            explosion(creditsScene);
            explosion(optionScene);
            explosion(arcadeScene);
            explosion(randomLevelScene);
            explosion(builderScene);
            explosion(loadScene);
        }else{
            explosionNo(videoScene);
            explosionNo(menuLvlScene);
            explosionNo(levelScene);
            explosionNo(creditsScene);
            explosionNo(optionScene);
            explosionNo(arcadeScene);
            explosionNo(randomLevelScene);
            explosionNo(builderScene);
            explosionNo(loadScene);
        }

    }

}

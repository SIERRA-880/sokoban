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

/**
 * Class that contains methods that the scenes have in common
 */
public class Controller {
    private final static AudioClip audioClip = new AudioClip(new File("build/resources/main/textures/" +
            Game.resourcePack + "/Sounds/menus/explosionSound.wav").toURI().toString());

    /**
     * Mehtode used to switch in between scenes
     *
     * @param scene that the stage will switch to
     */
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
                Game.levelScene.moveAgain();
                Game.window.setScene(Game.levelScene);
                break;
            case ARCADESCENE:
                Game.window.setScene(Game.arcadeScene);
                break;
            case RANDOMLEVELSCENE:
                Game.randomLevelScene.moveAgain();
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

    /**
     * Methode that generates Alerts if an exception was caught
     *
     * @param message text that is shown in the alert box
     */
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

    /**
     * Mehtode used to apply an effect to every scene m
     *
     * @param e the effec that changes the brightness
     */
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

    /**
     * Methode used to apply an Event that displays an explosion image as the cursor skin and plays an explosion sound upon clicking on a scene
     *
     * @param scene scene to which the effect will be applied to
     */
    public static void explosion(Scene scene) {
        audioClip.setVolume(OptionPane.getSliderVlue() / 100);
        try {
            Image image = new Image(new FileInputStream("build/resources/main/textures/" + Game.resourcePack + "/Menus/" +
                    "cursor_pointerFlat.png"));  //pass in the image path
            scene.setCursor(new ImageCursor(image));
        } catch (FileNotFoundException e) {
            alert("Cursor skin could not be loaded please check the path file at Controller:116");
        }

        scene.setOnMousePressed(event -> {
            try {
                audioClip.stop();
                Image image = new Image(new FileInputStream("build/resources/main/textures/" +
                        "" + Game.resourcePack + "/Cells/explosion.png"));
                scene.setCursor(new ImageCursor(image));
                audioClip.play();
            } catch (FileNotFoundException e) {
                alert("Image could not be loaded please check the path file at Controller:135");
            }
        });
        scene.setOnMouseReleased(event -> {
            try {
                Image image = new Image(new FileInputStream("build/resources/main/textures/" + Game.resourcePack + "/Menus/" +
                        "cursor_pointerFlat.png"));  //pass in the image path
                scene.setCursor(new ImageCursor(image));
            } catch (FileNotFoundException e) {
                alert("Image could not be loaded please check the path file at Controller:144");

            }
        });

    }

    /**
     * Methode that removes the explosion Event of a scene
     *
     * @param scene scene in which the removal of the explosion image and sound is needed
     */
    public static void explosionNo(Scene scene) {
        audioClip.setVolume(0);

        scene.setOnMousePressed(null);
        scene.setOnMouseReleased(null);

    }

    /**
     * Methode that applies either explosionNo or explosion
     *
     * @param a boolean that decides if the methode applies or removes the explosion Event
     */
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
        } else {
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

    /**
     * Methode to get the volume of the explosion
     *
     * @return the volume
     */
    public static double getAudioClipVolume() {
        return audioClip.getVolume();
    }

    /**
     * Methode that changes the volume of the explosion
     *
     * @param volume the new volume that will be set
     */
    public static void setAudioClipVolume(double volume) {
        audioClip.setVolume(volume);
    }
}

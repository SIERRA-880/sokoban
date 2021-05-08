package sokoban.UI.Scenes;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

import javafx.geometry.Pos;
import javafx.geometry.Insets;

import sokoban.UI.Widgets.BackButton;
import sokoban.UI.Widgets.Controller;
import sokoban.ScenesEnum;
import sokoban.UI.Widgets.VideoBg;
import sokoban.UI.Widgets.ImageButton;

import sokoban.Engine.Tools.Generation.*;
import sokoban.Game;

public class ArcadeScene extends BasicScene {

    public ArcadeScene(StackPane stackPane) {
        super(stackPane);

        // backButton
        BackButton bbutton = new BackButton();
        bbutton.setOnAction(e->{Controller.switchScene(ScenesEnum.VIDEOSCENE);
            VideoBg.Vplayer.play();
            VideoScene.Mplayer.play();});
        stackPane.getChildren().add(bbutton);
        StackPane.setAlignment(bbutton, Pos.TOP_LEFT);
        StackPane.setMargin(bbutton, new Insets(20.0, 0.0, 0.0, 20.0));

        // randomButton
        ImageButton rButton = new ImageButton("build/resources/main/textures/Default/Buttons/mainMenu/mainButton.png",
                                              "build/resources/main/textures/Default/Buttons/mainMenu/mainButtonOver.png");
        rButton.setText("Random");
        rButton.setStyle("-fx-font: 28 sans-serif-bold; -fx-text-fill: #A7F5F4;");

        rButton.setOnAction(e->mkRandom(10, 10));
        stackPane.getChildren().add(rButton);
        StackPane.setAlignment(rButton, Pos.CENTER_LEFT);
        StackPane.setMargin(rButton, new Insets(100.0, 0.0, 0.0, 20.0));

        // mapBuilder Button
        ImageButton builderButton = new ImageButton("build/resources/main/textures/Default/Buttons/mainMenu/mainButton.png",
                                              "build/resources/main/textures/Default/Buttons/mainMenu/mainButtonOver.png");
        builderButton.setText("Builder");
        builderButton.setStyle("-fx-font: 28 sans-serif-bold; -fx-text-fill: #A7F5F4;");

        builderButton.setOnAction(e->mkBuilder());
        stackPane.getChildren().add(builderButton);
        StackPane.setAlignment(builderButton, Pos.CENTER_RIGHT);
        StackPane.setMargin(rButton, new Insets(0.0, 20.0, 100.0, 0.0));
    }

    public void mkRandom(int width, int height) {
        Game.level = MapGenerator.generate(width, height, 2);
        Game.randomLevelScene.setOnKeyPressed(event -> Game.randomLevelScene.addKeyHandler(event));
        Game.randomLevelScene.map.showMap();
        Controller.switchScene(ScenesEnum.RANDOMLEVELSCENE);
    }

    public void mkBuilder() {
        Controller.switchScene(ScenesEnum.BUILDERSCENE);
    }
}

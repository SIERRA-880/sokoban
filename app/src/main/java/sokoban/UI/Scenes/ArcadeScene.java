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

import java.io.FileNotFoundException;

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
        try {
            ImageButton rButton = new ImageButton("build/resources/main/textures/Default/Buttons/mainMenu/mainButton.png",
                    "build/resources/main/textures/Default/Buttons/mainMenu/mainButtonOver.png");
            rButton.setText("Random");
            rButton.setStyle("-fx-font: 28 sans-serif-bold; -fx-text-fill: #A7F5F4;");

            rButton.setOnAction(e -> mkRandom(10, 10));
            stackPane.getChildren().add(rButton);
            StackPane.setAlignment(rButton, Pos.CENTER_LEFT);
            StackPane.setMargin(rButton, new Insets(100.0, 0.0, 0.0, 20.0));
        }catch (FileNotFoundException e){
            Controller.alert("The image of the randomButton could not be loaded please check the file path",
                    ScenesEnum.VIDEOSCENE);
        }

        // mapBuilder Button
        try {
            ImageButton builderButton = new ImageButton("build/resources/main/textures/Default/Buttons/mainMenu/mainButton.png",
                    "build/resources/main/textures/Default/Buttons/mainMenu/mainButtonOver.png");
            builderButton.setText("Builder");
            builderButton.setStyle("-fx-font: 28 sans-serif-bold; -fx-text-fill: #A7F5F4;");

            builderButton.setOnAction(e -> mkBuilder());
            stackPane.getChildren().add(builderButton);
            StackPane.setAlignment(builderButton, Pos.CENTER);
            StackPane.setMargin(builderButton, new Insets(0.0, 20.0, 100.0, 0.0));
        }catch (FileNotFoundException e){
            Controller.alert("The image of the Builder could not be loaded please check the file path",
                    ScenesEnum.VIDEOSCENE);
        }

        // load Button
        try {
            ImageButton loadButton = new ImageButton("build/resources/main/textures/Default/Buttons/mainMenu/mainButton.png",
                    "build/resources/main/textures/Default/Buttons/mainMenu/mainButtonOver.png");
            loadButton.setText("Load");
            loadButton.setStyle("-fx-font: 28 sans-serif-bold; -fx-text-fill: #A7F5F4;");
            loadButton.setOnAction(e -> mkBuilder());
            stackPane.getChildren().add(loadButton);
            StackPane.setAlignment(loadButton, Pos.CENTER);
            StackPane.setMargin(loadButton, new Insets(0.0, 0.0, 0.0, 1000.0));
        }catch (FileNotFoundException e){
            Controller.alert("The image of the Load button could not be loaded please check the file path",
                    ScenesEnum.VIDEOSCENE);
        }


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

package sokoban.UI.Scenes;

import javafx.scene.layout.StackPane;

import javafx.geometry.Pos;
import javafx.geometry.Insets;

import sokoban.UI.Widgets.BackButton;
import sokoban.UI.Widgets.Controller;
import sokoban.UI.Widgets.ImageButton;
import sokoban.Engine.Objects.Level;
import sokoban.Game;
import sokoban.ScenesEnum;

import sokoban.Engine.Tools.Generation.*;
import sokoban.Engine.Objects.*;

public class RandomLevelScene extends BasicScene {

    public RandomLevelScene(StackPane stackPane) {
        super(stackPane);

        // backButton
        BackButton bbutton = new BackButton();
        bbutton.setOnAction(e->Controller.switchScene(ScenesEnum.ARCADESCENE));
        stackPane.getChildren().add(bbutton);
        StackPane.setAlignment(bbutton, Pos.TOP_LEFT);
        StackPane.setMargin(bbutton, new Insets(20.0, 0.0, 0.0, 20.0));

        // start level
        ImageButton rButton = new ImageButton("build/resources/main/textures/Default/Buttons/mainMenu/mainButton.png",
                                              "build/resources/main/textures/Default/Buttons/mainMenu/mainButtonOver.png");
        rButton.setText("Start");
        rButton.setStyle("-fx-font: 28 sans-serif-bold; -fx-text-fill: #A7F5F4;");

        rButton.setOnAction(e->mkRandom(10, 10));
        stackPane.getChildren().add(rButton);
        StackPane.setAlignment(rButton, Pos.CENTER_LEFT);
        StackPane.setMargin(rButton, new Insets(100.0, 0.0, 0.0, 20.0));
    }

    public void mkRandom(int width, int height) {
        Level level = new Level();
        int[] pos = {0, 0};
        Player player = new Player(pos, "/Cells/player_down.png");
        World world = new World(width, height, player);
        world.setMap(MapGenerator.generate(width, height, 2));
        level.setWorld(world);
        level.setPlayer(player);
        Game.level = level;
        Game.levelScene.map.showMap();
        Controller.switchScene(ScenesEnum.LEVELSCENE);
    }
}

package sokoban.UI.Scenes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Pos;
import javafx.geometry.Insets;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;

import sokoban.UI.Widgets.Controller;
import sokoban.UI.Widgets.BackButton;
import sokoban.UI.Widgets.ImageButton;
import sokoban.UI.Widgets.BuilderButton;
import sokoban.Engine.Tools.WriteToXsb;
import sokoban.ScenesEnum;
import sokoban.CellsEnum;

public class BuilderScene extends BasicScene {

    private CellsEnum currentCell = CellsEnum.WALL;
    private StackPane stackPane;
    private String[][] map;
    private TextField saveText;

    public BuilderScene(StackPane stackPane) {
        super(stackPane);
        this.stackPane = stackPane;
        map = new String[15][15];

        // left pane
        VBox vPane = new VBox();
        vPane.setMaxWidth(64);
        vPane.maxHeightProperty().bind(vPane.widthProperty());

        // text input 
        saveText = new TextField();
        saveText.setPromptText("map name");
        stackPane.getChildren().add(saveText);

        StackPane.setAlignment(saveText, Pos.CENTER_RIGHT);
        StackPane.setMargin(saveText, new Insets(0.0, 200.0, -250.0, 1525.0));

        // save button
        ImageButton saveButton = new ImageButton("build/resources/main/textures/Default/Buttons/mainMenu/mainButton.png",
                                              "build/resources/main/textures/Default/Buttons/mainMenu/mainButtonOver.png");
        saveButton.setText("save");
        saveButton.setOnAction(e->save());
        stackPane.getChildren().add(saveButton);
        StackPane.setAlignment(saveButton, Pos.CENTER_RIGHT);
        StackPane.setMargin(saveButton, new Insets(400.0, 200.0, 0.0, 0.0));
            
        // cells buttons
        // ground
        ImageButton groundButton = new ImageButton("build/resources/main/textures/Default/Cells/ground.png", "build/resources/main/textures/Default/Cells/ground.png");
        groundButton.setOnAction(e->changeCell(CellsEnum.CELL));
        vPane.getChildren().add(groundButton);

        // empty
        ImageButton emptyButton = new ImageButton("build/resources/main/textures/Default/Cells/empty.png", "build/resources/main/textures/Default/Cells/empty.png");
        emptyButton.setOnAction(e->changeCell(CellsEnum.EMPTY));
        vPane.getChildren().add(emptyButton);

        // wall
        ImageButton wallButton = new ImageButton("build/resources/main/textures/Default/Cells/wall.png", "build/resources/main/textures/Default/Cells/wall.png");
        wallButton.setOnAction(e->changeCell(CellsEnum.WALL));
        vPane.getChildren().add(wallButton);

        // box
        ImageButton boxButton = new ImageButton("build/resources/main/textures/Default/Cells/box.png", "build/resources/main/textures/Default/Cells/box.png");
        boxButton.setOnAction(e->changeCell(CellsEnum.BOX));
        vPane.getChildren().add(boxButton);

        // target
        ImageButton targetButton = new ImageButton("build/resources/main/textures/Default/Cells/target.png", "build/resources/main/textures/Default/Cells/target.png");
        targetButton.setOnAction(e->changeCell(CellsEnum.TARGET));
        vPane.getChildren().add(targetButton);

        // player
        ImageButton playerButton = new ImageButton("build/resources/main/textures/Default/Cells/player_down.png", "build/resources/main/textures/Default/Cells/player_down.png");
        playerButton.setOnAction(e->changeCell(CellsEnum.PLAYER));
        vPane.getChildren().add(playerButton);

        // backButton
        BackButton bbutton = new BackButton();
        bbutton.setOnAction(e->Controller.switchScene(ScenesEnum.ARCADESCENE));

        // stackPane
        StackPane.setAlignment(bbutton, Pos.TOP_LEFT);
        StackPane.setMargin(bbutton, new Insets(20.0, 0.0, 0.0, 20.0));

        StackPane.setAlignment(vPane, Pos.CENTER_LEFT);
        StackPane.setMargin(vPane, new Insets(200.0, 0.0, 0.0, 20.0));

        stackPane.getChildren().addAll(vPane, bbutton);
        refresh();
    }

    public void refresh() {
        // map
        map = new String[15][15];
        // center pane
        GridPane gPane = new GridPane();
        gPane.setAlignment(Pos.CENTER);
        gPane.setMaxWidth(960);
        gPane.maxHeightProperty().bind(gPane.widthProperty());
        for (int i=0; i<15; i++) {
            for (int j=0; j<15; j++) {
                map[j][i] = " ";
                BuilderButton button = new BuilderButton("build/resources/main/textures/Default/Cells/ground.png", j, i);
                button.setOnAction(e->button.changeCell(currentCell, map));
                gPane.add(button, j, i, 1, 1);
            }
        }
        stackPane.getChildren().add(gPane);
    }

    public void changeCell(CellsEnum cell) {
        currentCell = cell;
    }

    public void save() {
        String mapString = "";
        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[0].length; j++) {
                mapString += map[i][j];
            }
        }
        WriteToXsb.write(saveText.getText(), mapString, map[0].length);
    }
}

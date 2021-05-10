package sokoban.UI.Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sokoban.Engine.Objects.World;
import sokoban.Engine.Tools.Generation.MapGenerator;
import sokoban.Game;
import sokoban.ScenesEnum;
import sokoban.UI.Widgets.BackButton;
import sokoban.UI.Widgets.Controller;
import sokoban.UI.Widgets.ImageButton;
import sokoban.UI.Widgets.VideoBg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ArcadeScene extends BasicScene {

    public ArcadeScene(StackPane stackPane) {
        super(stackPane);
        //font
        // credits
        Font font = null;
        try {
            font = Font.loadFont(new FileInputStream("build/resources/main/textures/Default/Fonts/Kenney Rocket Square.ttf"), 20);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Fonts file not found (CreditsScene:43)");
        }

        // backButton
        try {
            BackButton bbutton = new BackButton();
            bbutton.setOnAction(e -> {
                Controller.switchScene(ScenesEnum.VIDEOSCENE);
                VideoBg.Vplayer.play();
                VideoScene.Mplayer.play();
            });
            stackPane.getChildren().add(bbutton);
            StackPane.setAlignment(bbutton, Pos.TOP_LEFT);
            StackPane.setMargin(bbutton, new Insets(20.0, 0.0, 0.0, 20.0));
        } catch (FileNotFoundException e) {
            Controller.alert("The image of the back button could not be loaded please check the file path in ArcadeScene");
        }
        // randomButton
        try {
            ImageButton rButton = new ImageButton("build/resources/main/textures/" + Game.resourcePack + "/Buttons/mainMenu/mainButton.png",
                    "build/resources/main/textures/" + Game.resourcePack + "/Buttons/mainMenu/mainButtonOver.png");
            rButton.setText("Random");
            rButton.setStyle("-fx-font: 28 sans-serif-bold; -fx-text-fill: #A7F5F4;");

            rButton.setOnAction(e ->mkRandom());
            stackPane.getChildren().add(rButton);
            StackPane.setAlignment(rButton, Pos.CENTER);
            StackPane.setMargin(rButton, new Insets(0.0, 1000.0, 0.0, 0.0));
        } catch (FileNotFoundException e) {
            Controller.alert("The image of the randomButton could not be loaded please check the file path in the ArcadeScene");
        }

        // mapBuilder Button
        try {
            ImageButton builderButton = new ImageButton("build/resources/main/textures/" + Game.resourcePack + "/Buttons/mainMenu/mainButton.png",
                    "build/resources/main/textures/" + Game.resourcePack + "/Buttons/mainMenu/mainButtonOver.png");
            builderButton.setText("Builder");
            builderButton.setStyle("-fx-font: 28 sans-serif-bold; -fx-text-fill: #A7F5F4;");

            builderButton.setOnAction(e -> mkBuilder());
            stackPane.getChildren().add(builderButton);
            StackPane.setAlignment(builderButton, Pos.CENTER);
        } catch (FileNotFoundException e) {
            Controller.alert("The image of the Builder could not be loaded please check the file path in the ArcadeScene");
        }

        // load Button
        try {
            ImageButton loadButton = new ImageButton("build/resources/main/textures/" + Game.resourcePack + "/Buttons/mainMenu/mainButton.png",
                    "build/resources/main/textures/" + Game.resourcePack + "/Buttons/mainMenu/mainButtonOver.png");
            loadButton.setText("Load");
            loadButton.setStyle("-fx-font: 28 sans-serif-bold; -fx-text-fill: #A7F5F4;");
            loadButton.setOnAction(e -> load());
            stackPane.getChildren().add(loadButton);
            StackPane.setAlignment(loadButton, Pos.CENTER);
            StackPane.setMargin(loadButton, new Insets(0.0, 0.0, 0.0, 1000.0));
        } catch (FileNotFoundException e) {
            Controller.alert("The image of the Load button could not be loaded please check the file path in the ArcadeScene");
        }

        //Sliders for random button
        VBox sliderVBox = new VBox(sliderH(font), sliderW(font), sliderB(font));
        sliderVBox.setSpacing(30);
        sliderVBox.setFillWidth(false);
        stackPane.getChildren().add(sliderVBox);
        StackPane.setAlignment(sliderVBox, Pos.CENTER);
        StackPane.setMargin(sliderVBox, new Insets(600, 0, 0.0, 350.0));

        //info for random button
        VBox randomInfoBox= randomInfo(font);
        stackPane.getChildren().add(randomInfoBox);
        stackPane.setAlignment(randomInfoBox,Pos.TOP_LEFT);
        stackPane.setMargin(randomInfoBox,new Insets(200,0,0,300));

        //info for builder button
        VBox builderInfoBox= builderInfo(font);
        stackPane.getChildren().add(builderInfoBox);
        stackPane.setAlignment(builderInfoBox,Pos.CENTER);
        stackPane.setMargin(builderInfoBox,new Insets(0,0,450,30));

        //info for load button
        VBox laodInfoBox= loadInfo(font);
        stackPane.getChildren().add(laodInfoBox);
        stackPane.setAlignment(laodInfoBox,Pos.TOP_RIGHT);
        stackPane.setMargin(laodInfoBox,new Insets(200,250,0,0));

        //Combo box for load
        VBox loadComboBox = new VBox(loadCbox());
        loadComboBox.setMaxWidth(200);
        loadComboBox.setMaxHeight(200);
        stackPane.getChildren().add(loadComboBox);
        stackPane.setAlignment(loadComboBox,Pos.BOTTOM_RIGHT);
        stackPane.setMargin(loadComboBox,new Insets(0,350,200,0));
    }

    public void mkRandom() {
        Game.level = MapGenerator.generate(Game.genWidth, Game.genHeight, 2);
        Game.randomLevelScene.setOnKeyPressed(event -> Game.randomLevelScene.addKeyHandler(event));
        Game.randomLevelScene.map.showMap();
        Controller.switchScene(ScenesEnum.RANDOMLEVELSCENE);
    }

    public void mkBuilder() {
        Controller.switchScene(ScenesEnum.BUILDERSCENE);
    }

    public void load() {
        Game.level.loadLevel("custom");
        Game.levelScene.setOnKeyPressed(event -> Game.levelScene.addKeyHandler(event));
        Game.levelScene.map.showMap();
        Controller.switchScene(ScenesEnum.LEVELSCENE);
    }

    public VBox sliderH(Font f) {
        VBox vBox = new VBox();
        Slider slider = new Slider(5, 15, 1);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(1);
        Game.genHeight = (int) slider.getValue();
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            Game.genHeight = (int) slider.getValue();
            slider.setValue((int) slider.getValue());
        });
        VBox vBox1 = new VBox(slider);
        vBox1.setPrefWidth(300);
        Label label = new Label("HEIGHT OF THE MAP");
        label.setFont(f);
        label.setTextFill(Color.web("#FFFFFF"));
        vBox.getChildren().addAll(label, vBox1);
        vBox.setFillWidth(false);
        return vBox;

    }

    public VBox sliderW(Font f) {
        VBox vBox = new VBox();
        Slider slider = new Slider(5, 15, 1);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(1);
        Game.genWidth = (int) slider.getValue();
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            Game.genWidth = (int) slider.getValue();
            slider.setValue((int) slider.getValue());
        });
        System.out.println(Game.level.world.width);

        VBox vBox1 = new VBox(slider);
        vBox1.setPrefWidth(300);
        Label label = new Label("WIDTH OF THE MAP");
        label.setFont(f);
        label.setTextFill(Color.web("#FFFFFF"));
        vBox.getChildren().addAll(label, vBox1);
        vBox.setFillWidth(false);
        return vBox;
    }

    public VBox sliderB(Font f) {
        VBox vBox = new VBox();
        Slider slider = new Slider(1, 5, 1);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(1);
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            slider.setValue((int) slider.getValue());
        });
        VBox vBox1 = new VBox(slider);
        vBox1.setPrefWidth(300);
        Label label = new Label("NUMBER OF THE BOXES");
        label.setFont(f);
        label.setTextFill(Color.web("#FFFFFF"));
        vBox.getChildren().addAll(label, vBox1);
        vBox.setFillWidth(false);
        return vBox;
    }

    public VBox randomInfo(Font f) {
        Label label = new Label("\t    RANDOM:\nCreate a random map, you can modify the map's height,width and the number of boxes. ");
        return getvBox(f, label);

    }
    public VBox builderInfo(Font f) {
        Label label = new Label("\t    BUILDER :\n The ultimate creative mode where you can place all the elements of a map yourself!");
        return getvBox(f, label);

    }
    public VBox loadInfo(Font f) {
        Label label = new Label("\t  LOAD :\n Select and load the different kinds of maps you have created yourself.");
        return getvBox(f, label);

    }

    private VBox getvBox(Font f, Label label) {
        label.setFont(f);
        label.setTextFill(Color.web("#FFFFFF"));
        label.setWrapText(true);
        VBox vBox= new VBox(label);
        vBox.setMaxWidth(350);
        vBox.setMaxHeight(180);
        return vBox;
    }

    public ComboBox<String> loadCbox(){
        File folder = new File("build/resources/main/levels/");
        File[] listOfFiles = folder.listFiles();
        ComboBox<String> comboBox = new ComboBox<>();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                comboBox.getItems().add(file.getName());
            }
        }
        return  comboBox;
    }

}


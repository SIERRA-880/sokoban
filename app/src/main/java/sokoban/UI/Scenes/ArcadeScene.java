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

import javafx.event.*;

/**
 * Scene displaying the alternative game modes
 */

public class ArcadeScene extends BasicScene {

    private String selectedLevel;
    private boolean canLoad = false;

    /**
     *Constructor of ArcadeScene
     * @param stackPane Pane type object where other layouts will be placed on
     */
    public ArcadeScene(StackPane stackPane) {
        super(stackPane);


        //font
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
                VideoBg.playVplayer();
                VideoScene.playMplayer();
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

            rButton.setOnAction(e -> mkRandom());
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

            builderButton.setOnAction(e -> Controller.switchScene(ScenesEnum.BUILDERSCENE));
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
        StackPane.setMargin(sliderVBox, new Insets(600, 0, 0.0, 300));

        //info for random button
        VBox randomInfoBox = randomInfo(font);
        stackPane.getChildren().add(randomInfoBox);
        StackPane.setAlignment(randomInfoBox, Pos.TOP_LEFT);
        StackPane.setMargin(randomInfoBox, new Insets(200, 0, 0, 300));

        //info for builder button
        VBox builderInfoBox = builderInfo(font);
        stackPane.getChildren().add(builderInfoBox);
        StackPane.setAlignment(builderInfoBox, Pos.CENTER);
        StackPane.setMargin(builderInfoBox, new Insets(0, 0, 450, 30));

        //info for load button
        VBox laodInfoBox = loadInfo(font);
        stackPane.getChildren().add(laodInfoBox);
        StackPane.setAlignment(laodInfoBox, Pos.TOP_RIGHT);
        StackPane.setMargin(laodInfoBox, new Insets(200, 250, 0, 0));

        //Combo box for load
        VBox loadComboBox = new VBox(loadCbox());
        loadComboBox.setMaxWidth(200);
        loadComboBox.setMaxHeight(200);
        stackPane.getChildren().add(loadComboBox);
        StackPane.setAlignment(loadComboBox, Pos.BOTTOM_RIGHT);
        StackPane.setMargin(loadComboBox, new Insets(0, 350, 200, 0));
    }

    /**
     * Mehtode used to generate a random map,load it and display it when the random button is pressed
     */
    public void mkRandom() {
        Game.level = MapGenerator.generate(Game.genWidth, Game.genHeight, 2);
        Game.randomLevelScene.setOnKeyPressed(event -> Game.randomLevelScene.addKeyHandler(event));
        Game.randomLevelScene.map.showMap();
        Controller.switchScene(ScenesEnum.RANDOMLEVELSCENE);
    }

    /**
     * Methode used to load a map when the load button is pressed
     */

    public void load() {
        if (canLoad) {
            Game.level.loadLevel(selectedLevel);
            Game.loadScene.setOnKeyPressed(event -> Game.loadScene.addKeyHandler(event));
            Game.loadScene.map.showMap();
            Controller.switchScene(ScenesEnum.LOADSCENE);
        }
    }

    /**
     * Layout used to place the Slider controlling the hight of a random map
     * @param f Font type used to write the information about the slider
     * @return the layout
     */
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

    /**
     * Layout used to place the Slider controlling the width of a random map
     * @param f Font type used to write the information about the slider
     * @return the layout
     */

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

        VBox vBox1 = new VBox(slider);
        vBox1.setPrefWidth(300);
        Label label = new Label("WIDTH OF THE MAP");
        label.setFont(f);
        label.setTextFill(Color.web("#FFFFFF"));
        vBox.getChildren().addAll(label, vBox1);
        vBox.setFillWidth(false);
        return vBox;
    }

    /**
     * Layout used to place the Slider controling the number of boxes in a random map
     * @param f Font type used to write the information about the slider
     * @return the layout
     */

    public VBox sliderB(Font f) {
        VBox vBox = new VBox();
        Slider slider = new Slider(1, 5, 1);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(1);
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            slider.setValue((int) slider.getValue());
            Game.genBox = (int) slider.getValue();
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

    /**
     * Label used to contain the information of the random mode
     * @param f Font type used to write the information
     * @return getVbox()
     */
    public VBox randomInfo(Font f) {
        Label label = new Label("\t    RANDOM:\nCreate a random map, you can modify the map's height,width and the number of boxes. ");
        return getvBox(f, label);
    }
    /**
     * Label used to contain the information of the builder mode
     * @param f Font type used to write the information
     * @return  getVbox()
     */
    public VBox builderInfo(Font f) {
        Label label = new Label("\t    BUILDER :\n The ultimate creative mode where you can place all the elements of a map yourself!");
        return getvBox(f, label);
    }
    /**
     * Label used to contain the information of the load mode
     * @param f Font type used to write the information
     * @return getVbox()
     */

    public VBox loadInfo(Font f) {
        Label label = new Label("\t  LOAD :\n Select and load the different kinds of maps you have created yourself.");
        return getvBox(f, label);
    }

    /**
     * Methode used to creat the layout that contains information about the different gaming modes
     * @param f Font type used to write the information
     * @param label Label type containing information about a certain mode
     * @return VBox that containst {@param label} with {@param f} as font
     */
    private VBox getvBox(Font f, Label label) {
        label.setFont(f);
        label.setTextFill(Color.web("#FFFFFF"));
        label.setWrapText(true);
        VBox vBox = new VBox(label);
        vBox.setMaxWidth(350);
        vBox.setMaxHeight(180);
        return vBox;
    }

    /**
     * Methode used to create the comboBox containing the different loadable maps
     * @return a ComboBox
     */
    public ComboBox<String> loadCbox() {
        File folder = new File("build/resources/main/levels/save/");
        File[] listOfFiles = folder.listFiles();
        ComboBox<String> comboBox = new ComboBox<>();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                if (!(file.getName().equals("_")) && !(file.getName().equals("out1.xsb"))) {
                    comboBox.getItems().add(file.getName());
                }
            }
        }
        EventHandler<ActionEvent> event = e -> {
            selectedLevel = comboBox.getValue().replaceAll(".[^.]*$", "");
            canLoad = true;
        };
        comboBox.setOnAction(event);
        return comboBox;
    }
}

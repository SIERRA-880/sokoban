package sokoban.UI.Widgets;

import javafx.scene.layout.GridPane;
import sokoban.Game;
import sokoban.ScenesEnum;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static javafx.geometry.Pos.CENTER;

public class GridLvlButtons extends GridPane {

    private final String buttonSelected = "build/resources/main/textures/"+Game.resourcePack+"/Buttons/levelMenu/levelButtonOver_empty.png";
    private final String buttonUnselected = "build/resources/main/textures/"+Game.resourcePack+"/Buttons/levelMenu/levelButton_empty.png";
    private final String imageLocked = "build/resources/main/textures/"+Game.resourcePack+"/Buttons/levelMenu/levelButton_locker.png";

    /**
     * This widget is a grid of 15 LevelButtons.
     */
    public GridLvlButtons() {
        int[] lock = new int[15];

        File saves;
        try {
            String workingDirectory = System.getProperty("user.dir");
            String absoluteFilePath;
            absoluteFilePath = workingDirectory + File.separator + "build" + File.separator + "resources" + File.separator + "main" + File.separator + "appdata" + File.separator + "saves";
            Path dir = Paths.get(absoluteFilePath);
            saves = new File(absoluteFilePath);
            if (saves.exists()) {
                Scanner myReader = new Scanner(saves);
                int i = 0;
                while (myReader.hasNextLine()) {
                    String currentLine = myReader.nextLine();
                    lock[i] = Integer.parseInt(currentLine);
                    i++;
                }
                myReader.close();
            }
            else {
                lock[0] = 1;
                Files.writeString(dir, "1");
            }
        } catch (FileNotFoundException e) {
            Controller.alert("The images for the button in the GridLvlButton could not be loaded please " +
                            "check the file path");
        }
        catch (IOException e) {
            //HUGO JAI BESOIN DE TOI POUR SAVOIR QUOI METTRE ICI !!!!!!!!
            e.printStackTrace();
        }

        int a = 1;

        // for each button on the grid we assign a level number
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                LevelButton button=null;

                // here we check if the level has been completed or not 
                if (lock[a - 1]==a) {
                    try {
                        button = new LevelButton(buttonUnselected, buttonSelected, (a));
                        LevelButton finalButton = button;
                        button.setOnAction(e -> {
                            finalButton.setMap();
                            Game.levelScene.setOnKeyPressed(event -> Game.levelScene.addKeyHandler(event));
                            Game.levelScene.map.showMap();
                            Controller.switchScene(ScenesEnum.LEVELSCENE);

                        });
                        button.setText(a++ + "");
                    }catch (FileNotFoundException e){
                        Controller.alert("The image of the LevelButton could not be loaded please check the file path in the GridLvlButton");
                    }

                }
                else {
                    try {
                        button = new LevelButton(imageLocked, imageLocked, (a++));
                    }catch (FileNotFoundException e){
                        Controller.alert("The image of the Load button could not be loaded please check the file path in the ArcadeScene");
                    }
                }
                add(button, j, i);
            }
        }

        // grid options
        setHgap(69);
        setVgap(69);
        setAlignment(CENTER);
        setStyle("-fx-background-color: #000000;");
    }
}

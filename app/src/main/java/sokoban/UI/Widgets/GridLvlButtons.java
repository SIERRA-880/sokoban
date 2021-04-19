package sokoban.UI.Widgets;

import javafx.scene.layout.GridPane;
import sokoban.Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static javafx.geometry.Pos.CENTER;

public class GridLvlButtons extends GridPane {

    private final String buttonSelected = "build/resources/main/textures/Default/Buttons/levelMenu/levelButton_";
    private final String buttonUnselected = "build/resources/main/textures/Default/Buttons/levelMenu/levelButtonOver_";
    private final String imageLocked = "build/resources/main/textures/Default/Buttons/levelMenu/levelButton_locker.png";

    /**
     * This widget is a grid of 15 LevelButtons.
     */
    public GridLvlButtons() {
        int[] lock = new int[15];

        File saves = null;
        try {
            String workingDirectory = System.getProperty("user.dir");
            String absoluteFilePath = "";
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
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        int a = 1;

        // for each button on the grid we assign a level number
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                LevelButton button;
                String imageButtonSelected = buttonSelected + a + ".png";
                String imageButtonUnselected = buttonUnselected + a + ".png";

                // here we check if the level has been completed or not 
                if (lock[a - 1]==a) {
                    button = new LevelButton(imageButtonSelected, imageButtonUnselected, (a++));
                    button.setOnAction(e -> {
                        button.setMap();
                        Game.levelScene.setOnKeyPressed(event -> Game.levelScene.addKeyHandler(event));
                        Game.levelScene.map.showMap();
                        Controller.switchScene("LevelScene");
                    });
                }
                else {
                    button = new LevelButton(imageLocked, imageLocked, (a++));
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

package sokoban.Engine.Objects;

import sokoban.CellsEnum;

/**
 * Object representing the player
 */
public class Player extends MoveableCell {

    private char termTexture = '@';

    /**
     * @param pos Array of int containing coordinates (x, y)
     * @param texture String filepath of the player's png texture
     */
    public Player(int[] pos, String texture) {
        super(pos, CellsEnum.PLAYER, texture, false, false);
    }

    /**
     * Change the player's texture orientation
     * @param direction direction the player is moving
     */
    public void setTexture(String direction) {
        switch (direction) {
            case "up":
                texture = "build/resources/main/textures/Default/Cells/player_up.png";
                break;
            case "down":
                texture = "build/resources/main/textures/Default/Cells/player_down.png";
                break;
            case "right":
                texture = "build/resources/main/textures/Default/Cells/player_right.png";
                break;
            case "left":
                texture = "build/resources/main/textures/Default/Cells/player_left.png";
                break;
        }
    }

    /**
     * @return the character of the {@link sokoban.Engine.Objects.Cell}
     */
    @Override
    public char getTermTexture() {
        return termTexture;
    }
}

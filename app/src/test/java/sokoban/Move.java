package sokoban;

import sokoban.Engine.Objects.*;
import sokoban.CellsEnum;

import org.junit.Test;
import static org.junit.Assert.*;

public class Move {
    @Test public void testBoxGetTerm() {
        int[] pos = {0,0};
        Box box = new Box(pos, CellsEnum.BOX, "/Cells/box.png");
        assertEquals('$', box.getTermTexture());
    }

    /*
     * Check if a box being push is moved to the good position
     */
    @Test public void pushBox() {
        Level level = new Level();
        level.setLevel("test1");
        assertEquals(true,level.player.move("right", level.world));
    }

    /*
     * Check if a box being pushed against a wall stays at it's original position
     */
    @Test public void pushBoxOnWall() {
        Level level = new Level();
        level.setLevel("test1");
        assertEquals(false,level.player.move("down", level.world));
    }

    /*
     * Check if a player can walk into a wall
     */
    @Test public void goInWall() {
        Level level = new Level();
        level.setLevel("test1");
        level.player.move("left", level.world);
        int[] pos = {1,2};
        assertEquals(pos[0],level.player.getCellPos()[0]);
        assertEquals(pos[1],level.player.getCellPos()[1]);
    }

    /*
     * Check if player can move to an empty cell
     */
    @Test public void goInEmpty() {
        Level level = new Level();
        level.setLevel("test1");
        level.player.move("up", level.world);
        int[] pos = {1,1};
        assertEquals(pos[0],level.player.getCellPos()[0]);
        assertEquals(pos[1],level.player.getCellPos()[1]);
    }
}

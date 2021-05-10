package sokoban;

import sokoban.Engine.Objects.*;
import sokoban.Engine.Tools.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class Win {

    /*
     * Check if this game is a win. (all boxes on target)
     */
    @Test public void win1() {
        Level level = new Level();
        level.setLevel("test1");
        level.player.move("right", level.world);
        assertEquals(true,level.world.winCondition());
    }

    /*
     * Check if this game is a win. (all boxes on target)
     */
    @Test public void win2() {
        Level level = new Level();
        level.setLevel("test2");
        level.player.move("down", level.world);
        level.player.move("left", level.world);
        assertEquals(true,level.world.winCondition());
    }
    
    /*
     * Check if this game is a win. (all boxes on target)
     */
    @Test public void win3() {
        Level level = new Level();
        level.setLevel("map1");
        MovReplay.replay(level, "map1");
        assertEquals(true,XsbComparator.compare("build/resources/main/levels/save/out1.xsb", "build/resources/main/levels/solved1.xsb"));
    }
}

package sokoban;

import sokoban.Engine.Objects.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class Win {
    @Test public void win1() {
        Level level = new Level();
        level.setLevel("test1");
        level.player.move("right", level.world);
        assertEquals(true,level.world.winCondition());
    }

    @Test public void win2() {
        Level level = new Level();
        level.setLevel("test2");
        level.player.move("down", level.world);
        level.player.move("left", level.world);
        assertEquals(true,level.world.winCondition());
    }
}

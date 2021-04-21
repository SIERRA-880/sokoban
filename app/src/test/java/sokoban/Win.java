package sokoban;

import sokoban.Engine.Objects.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class Win {
    @Test public void win() {
        Level level = new Level();
        level.setLevel("test1");
        level.player.move("right", level.world);
        assertEquals(true,level.world.winCondition());
    }
}

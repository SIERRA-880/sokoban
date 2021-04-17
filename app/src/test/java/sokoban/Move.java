package sokoban;

import sokoban.Engine.Objects.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class Move {
    @Test public void testBoxGetTerm() {
        int[] pos = {0,0};
        Box box = new Box(pos, "/Cells/box.png");
        assertEquals('$', box.getTermTexture());
    }
}
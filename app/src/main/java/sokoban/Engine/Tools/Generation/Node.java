package sokoban.Engine.Tools.Generation;

public class Node {

    // f = g + h
    public double f;
    public double g;
    public double h;
    // i and j are the row/columns indexes of the parent node
    public int parent_i;
    public int parent_j;
}

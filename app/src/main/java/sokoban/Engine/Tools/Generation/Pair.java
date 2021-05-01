package sokoban.Engine.Tools.Generation;

public class Pair {

    public double first;
    public int[] second = new int[2];

    public Pair(double f, int i, int j) {
        first = f;
        second[0] = i;
        second[1] = j;
    }
}

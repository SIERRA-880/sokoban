package sokoban.Engine.Tools.Generation;

import sokoban.Engine.Objects.*;
import java.util.ArrayList;

public class PathFinder {

    public static boolean isDestination(int x1, int y1, int x2, int y2) {
        if (x1==x2 && y1==y2) {
            return true;
        }
        return false;
    }

    public static double calculateHValue(int row, int col, int[] end) {
        return ((double)Math.sqrt(Math.pow(row-end[0], 2) + Math.pow(col-end[1], 2)));
    }

    /**
     * This algorithm and the explanations for it can be found here :
     * https://www.geeksforgeeks.org/a-search-algorithm/
     */
    public static void find(World world, int[] start, int[] end) {

        final MatrixCase[][] matrix = world.getMap();
        final int width = matrix[0].length;
        final int height = matrix.length;

        // If the starting cell's position is out of range
        if (start[0]<0 || start[0]>width || start[1]<0 || start[1]>height) {
            throw new IndexOutOfBoundsException();
        }
        
        // If the ending cell's position is out of range
        if (end[0]<0 || end[0]>width || end[1]<0 || end[1]>height) {
            throw new IndexOutOfBoundsException();
        }
        
        // If the starting or ending cell is blocked
        if (world.searchCell(start).collisions() || world.searchCell(end).collisions()) {
            System.out.println("Starting or ending cell is blocked");
            return;
        }

        // If the starting and ending cell are the same
        if (start[0]==end[0] && start[1]==end[1]) {
            System.out.println("The starting cell is the ending cell");
            return;
        }

        // closed list
        boolean[][] closedList = new boolean[height][width];

        Node[][] nodeDetails = new Node[height][width];

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                nodeDetails[i][j] = new Node();
                nodeDetails[i][j].f = Double.MAX_VALUE;    
                nodeDetails[i][j].g = Double.MAX_VALUE;    
                nodeDetails[i][j].h = Double.MAX_VALUE;    
                nodeDetails[i][j].parent_i = -1;
                nodeDetails[i][j].parent_j = -1;
            }
        }

        // Initialising the parameters of the starting node
        int i = start[1];
        int j = start[0];
        nodeDetails[i][j].f = 0.0;
        nodeDetails[i][j].g = 0.0;
        nodeDetails[i][j].h = 0.0;
        nodeDetails[i][j].parent_i = i;
        nodeDetails[i][j].parent_j = j;

        // Create an open list of Pair
        ArrayList<Pair> openList = new ArrayList<Pair>();
        
        // First node
        openList.add(new Pair(0.0, i, j));
        boolean foundDest = false;

        while (!openList.isEmpty()) {
            Pair p = openList.get(0);
            openList.remove(0);
            i = p.second[0];
            j = p.second[1];
            closedList[i][j] = true;

            // Generating the 4 successor of this node
            double gNew, hNew, fNew;

            // First successor : up
            if (i-1>0) {
                // If the destination node is the same as the current successor
                int[] pos = {j, i-1};
                if (isDestination(j, i-1, end[0], end[1])) {
                    nodeDetails[i-1][j].parent_i = i;
                    nodeDetails[i-1][j].parent_j = j;
                    System.out.println("Ending cell found");
                    foundDest = true;
                    return;
                }
                // If the successor is already on the closed list or if it is blocked
                // ignore it. Else do the following
                else if (closedList[i-1][j] == false && world.searchCell(pos).collisions() == false) {
                    gNew = nodeDetails[i][j].g + 1.0;
                    hNew = calculateHValue(j, i-1, end);
                    fNew = gNew + hNew;

                    if (nodeDetails[i-1][j].f == Double.MAX_VALUE || nodeDetails[i-1][j].f>fNew) {
                        openList.add(new Pair(fNew, i-1, j));

                        // Update the details of this node
                        nodeDetails[i-1][j].f = fNew;
                        nodeDetails[i-1][j].g = gNew;
                        nodeDetails[i-1][j].h = hNew;
                        nodeDetails[i-1][j].parent_i = i;
                        nodeDetails[i-1][j].parent_j = j;
                    }
                }
            }

            // Second successor : south
            if (i+1<height) {
                // If the destination node is the same as the current successor
                int[] pos = {j, i+1};
                if (isDestination(j, i+1, end[0], end[1])) {
                    nodeDetails[i+1][j].parent_i = i;
                    nodeDetails[i+1][j].parent_j = j;
                    System.out.println("Ending cell found");
                    foundDest = true;
                    return;
                }
                // If the successor is already on the closed list or if it is blocked
                // ignore it. Else do the following
                else if (closedList[i+1][j] == false && world.searchCell(pos).collisions() == false) {
                    gNew = nodeDetails[i][j].g + 1.0;
                    hNew = calculateHValue(j, i+1, end);
                    fNew = gNew + hNew;

                    if (nodeDetails[i+1][j].f == Double.MAX_VALUE || nodeDetails[i+1][j].f>fNew) {
                        openList.add(new Pair(fNew, i+1, j));

                        // Update the details of this node
                        nodeDetails[i+1][j].f = fNew;
                        nodeDetails[i+1][j].g = gNew;
                        nodeDetails[i+1][j].h = hNew;
                        nodeDetails[i+1][j].parent_i = i;
                        nodeDetails[i+1][j].parent_j = j;
                    }
                }
            }

            // Third successor : left
            if (j-1>0) {
                // If the destination node is the same as the current successor
                int[] pos = {j-1, i};
                if (isDestination(j-1, i, end[0], end[1])) {
                    nodeDetails[i][j-1].parent_i = i;
                    nodeDetails[i][j-1].parent_j = j;
                    System.out.println("Ending cell found");
                    foundDest = true;
                    return;
                }
                // If the successor is already on the closed list or if it is blocked
                // ignore it. Else do the following
                else if (closedList[i][j-1] == false && world.searchCell(pos).collisions() == false) {
                    gNew = nodeDetails[i][j].g + 1.0;
                    hNew = calculateHValue(j-1, i, end);
                    fNew = gNew + hNew;

                    if (nodeDetails[i][j-1].f == Double.MAX_VALUE || nodeDetails[i][j-1].f>fNew) {
                        openList.add(new Pair(fNew, i, j-1));

                        // Update the details of this node
                        nodeDetails[i][j-1].f = fNew;
                        nodeDetails[i][j-1].g = gNew;
                        nodeDetails[i][j-1].h = hNew;
                        nodeDetails[i][j-1].parent_i = i;
                        nodeDetails[i][j-1].parent_j = j;
                    }
                }
            }
            
            // Fourth successor : right
            if (j+1<width) {
                // If the destination node is the same as the current successor
                int[] pos = {j+1, i};
                if (isDestination(j+1, i, end[0], end[1])) {
                    nodeDetails[i][j+1].parent_i = i;
                    nodeDetails[i][j+1].parent_j = j;
                    System.out.println("Ending cell found");
                    foundDest = true;
                    return;
                }
                // If the successor is already on the closed list or if it is blocked
                // ignore it. Else do the following
                else if (closedList[i][j+1] == false && world.searchCell(pos).collisions() == false) {
                    gNew = nodeDetails[i][j].g + 1.0;
                    hNew = calculateHValue(j+1, i, end);
                    fNew = gNew + hNew;

                    if (nodeDetails[i][j+1].f == Double.MAX_VALUE || nodeDetails[i][j+1].f>fNew) {
                        openList.add(new Pair(fNew, i, j+1));

                        // Update the details of this node
                        nodeDetails[i][j+1].f = fNew;
                        nodeDetails[i][j+1].g = gNew;
                        nodeDetails[i][j+1].h = hNew;
                        nodeDetails[i][j+1].parent_i = i;
                        nodeDetails[i][j+1].parent_j = j;
                    }
                }
            }
        }

        if (foundDest==false) {
            System.out.println("Failed to find the destination");
            return;
        }
        else if (foundDest==true) {
            System.out.println("Destination found");
        }
    }
}

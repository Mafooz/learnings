package org.example.Model;

import org.example.WinStrategy.IWinStrategy;

import java.util.ArrayList;

public class Grid {
    private int size;
    ArrayList<ArrayList<Box>> grid;
    IWinStrategy winStrategy;

    public ArrayList<ArrayList<Box>> getGrid() {
        return grid;
    }

    public int getSize() {
        return size;
    }

    public Grid(int size) {
        this.size = size;
        grid = new ArrayList<ArrayList<Box>>();
        for (int i=0;i<size;i++) {
            ArrayList<Box> temp = new ArrayList<>();
            for(int j=0;j<size;j++) {
                temp.add(new Box(null));
            }
            grid.add(temp);
        }
    }

    public boolean allFilled() {
        for (ArrayList<Box> boxes : grid) {
            for (Box box : boxes) {
                if (box.getToken()==null) {
                    return false;
                }
            }
        }
        return true;
    }
    public void print() {
        for (ArrayList<Box> boxes: grid) {
            for (Box box: boxes) {
                System.out.print((box.getToken()==null?"_":box.getToken().val) + " ");
            }
            System.out.println();
        }
    }
}

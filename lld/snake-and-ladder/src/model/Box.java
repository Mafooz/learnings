package model;

public class Box {
    private int currVal;
    private int jmpRow;
    private int jmpCol;

    public Box() {
        jmpCol = -1;
        jmpRow = -1;
    }

    public void setCurrVal(int currVal) {
        this.currVal = currVal;
    }

    public int getCurrVal() {
        return currVal;
    }

    public void setJump(int jmpRow, int jmpCol) {
        this.jmpRow = jmpRow;
        this.jmpCol = jmpCol;
    }
    public int getJmpRow() {
        return jmpRow;
    }
    public int getJmpCol() {
        return jmpCol;
    }
}

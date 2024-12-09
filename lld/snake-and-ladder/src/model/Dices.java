package model;

public class Dices {
    private final Dice[] dices;

    public Dices(int totalDice) {
        dices = new Dice[totalDice];
    }

    public int getRollValue() {
        int ans=0;
        for (Dice dice: dices) {
            ans += dice.getRandomValue();
        }
        return ans;
    }
}

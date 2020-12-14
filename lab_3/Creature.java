package lab_3;

public abstract class Creature {
    public static double rangeInBounds(int min, int max){
        return Math.random()*(max-min)+min;
    }
}

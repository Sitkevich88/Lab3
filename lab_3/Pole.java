package lab_3;

import java.util.Objects;

public final class Pole{
    public Pole(boolean dirty, boolean sticky){
        System.out.printf("> Столб:\n\tКоординаты:\tx = %.3f\ty = %.3f\tz = %.3f\n",getX(),getY(),getZ());
        System.out.printf("\tВысота:\t%.3f\n",height);
        System.out.println("\tСостояние:\tГрязный - "+dirty+"\tЛипкий - "+sticky);
        this.dirty = dirty;
        this.sticky = sticky;
    }
    private static int numberOfObjects = 0;
    static{
        numberOfObjects += 1;
    }
    private static double rangeInBounds(int min, int max){
        return Math.random()*(max-min)+min;
    }
    private final double x = rangeInBounds(-10,10);
    private final double y = rangeInBounds(-10,10);
    private final double z = 0;
        public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double getZ(){
        return z;
    }
    private final double height = rangeInBounds(3,8);
    private final boolean dirty;
    private final boolean sticky;


    public double getHeight(){
        return height;
    }
    public static int getNumberOfObjects(){return numberOfObjects;}
    public boolean isDirty(){return dirty;}
    public boolean isSticky(){return sticky;}

    @Override
    public String toString() {
        return "Pole{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", height=" + height +
                ", dirty=" + dirty +
                ", sticky=" + sticky +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pole pole = (Pole) o;
        return Double.compare(pole.x, x) == 0 &&
                Double.compare(pole.y, y) == 0 &&
                Double.compare(pole.z, z) == 0 &&
                Double.compare(pole.height, height) == 0 &&
                dirty == pole.dirty &&
                sticky == pole.sticky;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, height, dirty, sticky);
    }
}

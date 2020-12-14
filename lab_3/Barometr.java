package lab_3;

import java.util.Objects;

public class Barometr{
    private double x;
    private double y;
    private double z;
    public Barometr(Pole pole) {
        x = pole.getX();
        y = pole.getY();
        z = pole.getHeight();
        System.out.printf("> Барометр:\n\tКоординаты:\tx = %.3f\ty = %.3f\tz = %.3f\n",x,y,z);
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double getZ(){
        return z;
    }

    @Override
    public String toString() {
        return "Barometr{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Barometr barometr = (Barometr) o;
        return Double.compare(barometr.x, x) == 0 &&
                Double.compare(barometr.y, y) == 0 &&
                Double.compare(barometr.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
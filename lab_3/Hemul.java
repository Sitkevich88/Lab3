package lab_3;

import java.util.Objects;

public class Hemul extends Creature implements HemulActions {
    private Location location;
    private HemulStatus hemulStatus;
    private int energy = 10;
    public void setEnergy(int energy){
        this.energy=energy;
    }
    Fear fear;
    public void coward() {
        fear = new Fear();
        hemulStatus= HemulStatus.СТРАШНО;
        System.out.println("> Хемуль:\n\t"+hemulStatus+" перетрусил");

    }

    public Hemul(Location location){
        this.location = location;
        skirts = new Skirts();
        System.out.printf("> Хемуль:\n\tКоординаты:\tx = %.3f\ty = %.3f\tz = %.3f\n",x,y,z);
        System.out.println("\tСостояние:\tЛокация - "+location);
    }
    private Skirts skirts;
    public SkirtsStatus getSkirtStatus(){
        return skirts.skirtsStatus;
    }

    private class Skirts{
        Skirts(){skirtsStatus = SkirtsStatus.ОПУЩЕНЫ;}
        SkirtsStatus skirtsStatus;
        public void pickUp(){
            skirtsStatus = SkirtsStatus.ПОДНЯТЫ;
            System.out.println("> Хемуль:\n\tЮбки:\t"+skirtsStatus);
        }

        @Override
        public String toString() {
            return "Skirts{" +
                    "skirtsStatus=" + skirtsStatus +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Skirts skirts = (Skirts) o;
            return skirtsStatus == skirts.skirtsStatus;
        }

        @Override
        public int hashCode() {
            return Objects.hash(skirtsStatus);
        }
    }

    private double x = rangeInBounds(10,20);
    private double y = rangeInBounds(10,20);
    private double z = 0;
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double getZ(){
        return z;
    }
    public void lookAround(Pole pole) {
        System.out.println("> Хемуль:\n\tоглядывается");
        lookForEscape(pole);
    }
    public void lookForEscape(Pole pole) {
        System.out.println("> Хемуль:\n\tищет куда бы убраться восвояси");
        if  (Pole.getNumberOfObjects()!=0){
            System.out.println("> Хемуль:\n\tнашёл выход");
            location= Location.У_СТОЛБА;
            x = pole.getX();
            y = pole.getY();
            z = pole.getZ();
            System.out.println("> Хемуль:\n\tтеперь "+location);
        }
    }
    public void pickUpSkirts() {
        skirts.pickUp();
    }
    public void climb(Pole pole){
        if (location == Location.У_СТОЛБА && getSkirtStatus() == SkirtsStatus.ПОДНЯТЫ){
            location= Location.НА_СТОЛБЕ;
            System.out.println("> Хемуль:\n\t"+location);
        }
        if (pole.isDirty()){energy--;}
        if (pole.isSticky()){energy--;}
        if (hemulStatus == HemulStatus.СТРАШНО){ fear.giveSuperHemulPower(this); }
        if (energy==100){
            z=pole.getHeight();
            location= Location.НА_ВЕРХУ_СТОЛБА;
            System.out.println("> Хемуль:\n\t"+location);
        }
    }
    public void sitDown() {
        if (location!= Location.НА_СТОЛБЕ) {
            System.out.println("> Хемуль:\n\tсел");
        }
    }
    public void holdOnTo(Barometr barometr){
        if (barometr.getX()==x && barometr.getY()==y && barometr.getZ()==z){
            System.out.println("> Хемуль:\n\tдержится за барометр");
        }
    }
    public void shiver(){System.out.println("> Хемуль:\n\tтрясётся");}

    @Override
    public String toString() {
        return "Hemul{" +
                "location=" + location +
                ", hemulStatus=" + hemulStatus +
                ", energy=" + energy +
                ", fear=" + fear +
                ", skirts=" + skirts +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hemul hemul = (Hemul) o;
        return energy == hemul.energy &&
                Double.compare(hemul.x, x) == 0 &&
                Double.compare(hemul.y, y) == 0 &&
                Double.compare(hemul.z, z) == 0 &&
                location == hemul.location &&
                hemulStatus == hemul.hemulStatus &&
                fear.equals(hemul.fear) &&
                skirts.equals(hemul.skirts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, hemulStatus, energy, fear, skirts, x, y, z);
    }
}
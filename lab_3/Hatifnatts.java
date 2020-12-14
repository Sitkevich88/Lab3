package lab_3;

import java.util.Objects;

public class Hatifnatts extends Creature implements HatifnattsActions {

    private Location location;
    private Paws paws;
    private Faces faces;
    private int loudness;
    private int numberOfHatifnatts = (int)rangeInBounds(200,300);
    private HatifnattsStatus hatifnattsStatus;
    private double x = rangeInBounds(31,35);
    private double y = rangeInBounds(31,35);
    private double z = 0;
    public Hatifnatts(Location location){
        this.location = location;
        hatifnattsStatus = HatifnattsStatus.ШЕРЕНГА_ЗА_ШЕРЕНГОЙ;
        paws = new Paws();
        faces = new Faces();
        System.out.printf("> Хатифнатты:\n\tКоординаты:\tx = %.3f\ty = %.3f\tz = %.3f\tКолличество - %d\n",x,y,z,numberOfHatifnatts);
        System.out.println("\tСостояние:\tЛокация - "+location);
    }
    public void hear(boolean heard){
        if (heard){
            System.out.println("> Хатифнатты:\n\tуслышали Хемуля и ушли");
            System. exit(0);
        } else{
            System.out.println("> Хатифнатты:\n\tне слышали Хемуля");
        }
    }
    public void hiss(){
        System.out.println("> Хатифнатты:\n\tШшш-шшш-шшш-шшш!");
    }
    public void swingPaws(){paws.move(MovableStatus.ИМИ_РАЗМАХИВАЮТ);}
    public void surround(Hemul hemul){
        hatifnattsStatus= HatifnattsStatus.КОЛЬЦОМ;
        System.out.println("> Хатифнатты:\n\tокружили Хемуля "+hatifnattsStatus);
    }

    private class Paws {
        private MovableStatus pawsStatus;
        private Paws(){
            pawsStatus = MovableStatus.НЕПОДВИЖНЫ;
        }
        public void move(MovableStatus pawsStatus){
            this.pawsStatus= pawsStatus;
            System.out.println("> Хатифнатты:\n\tЛапы:\t"+pawsStatus);
        }

        @Override
        public String toString() {
            return "Paws{" +
                    "pawsStatus=" + pawsStatus +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Paws paws = (Paws) o;
            return pawsStatus == paws.pawsStatus;
        }

        @Override
        public int hashCode() {
            return Objects.hash(pawsStatus);
        }
    }

    private class Faces{
        private MovableStatus facesStatus;
        private Faces(){ facesStatus = MovableStatus.НЕПОДВИЖНЫ; }
        public void move(MovableStatus facesStatus){
            this.facesStatus = facesStatus;
            System.out.println("> Хатифнатты:\n\tЛица "+facesStatus);
        }

        @Override
        public String toString() {
            return "Faces{" +
                    "facesStatus=" + facesStatus +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Faces faces = (Faces) o;
            return facesStatus == faces.facesStatus;
        }

        @Override
        public int hashCode() {
            return Objects.hash(facesStatus);
        }
    }



    public void takeAStepTowards(Hemul hemul) {
        double xHem = hemul.getX();
        double yHem = hemul.getY();
        double deltX = xHem-x;
        double deltY = yHem-y;
        x +=deltX/(Math.sqrt(Math.pow(deltX,2)+Math.pow(deltY,2)));
        y +=deltY/(Math.sqrt(Math.pow(deltX,2)+Math.pow(deltY,2)));
        System.out.println("> Хатифнатты:\n\tсделали шаг в сторону Хемуля "+hatifnattsStatus);
    }
    public void flash(Location loc, int loudness){
        this.loudness=loudness;
        location = loc;
        numberOfHatifnatts+= (int)rangeInBounds(5,20);
        this.loudness = loudness;
        faces.move(MovableStatus.НЕПОДВИЖНЫ);
        System.out.println("> Хатифнатты:\n\t"+location+" с громкостью "+loudness+" мелькают всё новые и новые");
        System.out.println("\tНовое колличество:\t"+numberOfHatifnatts);
    }
    public void move(Hemul hemul, int loudness){
        this.loudness=loudness;
        System.out.println("> Хатифнатты:\n\tгромкость "+loudness);
        int n = (int)Math.round(Math.random()*(5)+3);
        for (int i=0;i<n;i++){
            takeAStepTowards(hemul);
        }
        System.out.println("> Хатифнатты:\n\tв итоге сделали "+n+" шагов в сторону Хемуля "+hatifnattsStatus);
    }

    @Override
    public String toString() {
        return "Hatifnatts{" +
                "location=" + location +
                ", paws=" + paws +
                ", faces=" + faces +
                ", loudness=" + loudness +
                ", numberOfHatifnatts=" + numberOfHatifnatts +
                ", hatifnattsStatus=" + hatifnattsStatus +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hatifnatts that = (Hatifnatts) o;
        return loudness == that.loudness &&
                numberOfHatifnatts == that.numberOfHatifnatts &&
                Double.compare(that.x, x) == 0 &&
                Double.compare(that.y, y) == 0 &&
                Double.compare(that.z, z) == 0 &&
                location == that.location &&
                paws.equals(that.paws) &&
                faces.equals(that.faces) &&
                hatifnattsStatus == that.hatifnattsStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, paws, faces, loudness, numberOfHatifnatts, hatifnattsStatus, x, y, z);
    }
}
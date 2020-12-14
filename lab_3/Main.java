package lab_3;

public class Main{
    public static void main(String[] args){
        Pole pole = new Pole(true, true);
        Hemul hemul = new Hemul(Location.В_ТОЧКЕ_СТАРТА);
        Hatifnatts hatifnatts = new Hatifnatts(Location.ЗА_ДЕРЕВЬЯМИ);
        Barometr barometr = new Barometr(pole);
        hatifnatts.hear(false);
        hatifnatts.takeAStepTowards(hemul);
        hatifnatts.hiss();
        hatifnatts.swingPaws();
        hemul.coward();
        hemul.lookAround(pole);
        hatifnatts.surround(hemul);
        hatifnatts.flash(Location.МЕЖДУ_ДЕРЕВЬЯМИ, 0);
        hatifnatts.move(hemul,0);
        hemul.pickUpSkirts();
        hemul.climb(pole);
        hemul.sitDown();
        hemul.shiver();
        hemul.holdOnTo(barometr);
    }
}

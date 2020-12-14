package lab_3;

public class Fear implements AbleToGiveEnergy {
    public void giveSuperHemulPower(Hemul hemul){
        hemul.setEnergy(100);
        System.out.println("> Страх:\n\tпридаёт Хемулю нехемульскую силу");
    }
    @Override
    public String toString() {
        return "Fear{" +
                '}';
    }
}

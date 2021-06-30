import java.util.HashMap;
import java.util.Map;

public class Fonctions {

    private double fonctionMath(String fonc,double x) throws ExceptFoncInrouvable{

        switch (fonc){
            case "sin":
                return Math.sin(x);

            case "cos":
                return Math.cos(x);

            case "tan":
                return Math.tan(x);
            case "abs":
                return Math.abs(x);
            case "sqrt":
                return Math.sqrt(x);

            case "log":
                return Math.log(x);

            default:
                throw new ExceptFoncInrouvable(fonc);


        }

    }
}

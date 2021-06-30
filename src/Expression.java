import javax.lang.model.type.NullType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Expression implements Analiseur {
    private String exp;
    private HashMap<String,Double> tableSymbole;
    Expression(String exp,HashMap<String,Double> tableSymbole)throws ExpresExcept{
        this.exp=exp;
        this.tableSymbole=tableSymbole;

    }
    public double analiser()
    throws ExpresExcept{

            return evaluate(this.exp,this.tableSymbole);



    }
}

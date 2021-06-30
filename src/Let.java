import java.util.HashMap;

public class Let extends Commande{

    private HashMap<String,Double> tableSymbole;
    Let(Expression exp,String var,HashMap<String,Double> table){
        super(exp);
        tableSymbole=table;


    }
    public void Action(Variable var){

        try {
            tableSymbole.put(var.getVarName(),getResultat());
        } catch (ExpresExcept e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println("Expression Erroné");
        }

    }

}

import java.util.HashMap;
import java.util.Map;

public class LigneCmd {
    private String cmd;
    private Expression exp;
    private Variable var;
    private HashMap<String,Double> tableSymbole;
    LigneCmd(HashMap<String,Double> table) {
        tableSymbole=table;


    }
    public void EvalLigne(String l) throws ExceptCmd,ExpresExcept{
        cmd = l.split(" ")[0];

        if (!cmd.equals("let") && !cmd.equals("print")){
            throw new ExceptCmd();
        }

        if(this.cmd.equals("let") )
        {
            try {
                String tempExp = l.split(" ")[1];
                if (!tempExp.contains("=")){
                    throw new ExpresExcept("Expression Eronne");
                }
               var = new Variable(tempExp.split("=")[0]);
                exp=new Expression(tempExp.split("=")[1],tableSymbole);

                Let letter = new Let(exp,tempExp.split("=")[0],tableSymbole);
                letter.Action(var);
                System.out.println("Ok");
            }
            catch (IndexOutOfBoundsException e){
                System.out.println("Expression errone");
            }
            catch (ExpresExcept e){
                System.out.println(e.getMessage());
            }
            catch (ExceptNomVar e){
                System.out.println(e.getMessage());
            }

        }
        else if(this.cmd.equals("print"))
        {
            try {
                exp=new Expression(l.split(" ")[1],tableSymbole);
            }
            catch (ExpresExcept e){
                System.out.println(e.getMessage());
            }


            Print printer = new Print(exp);
            printer.Action();
        }
    }
}

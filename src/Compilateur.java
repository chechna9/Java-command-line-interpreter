import java.util.HashMap;
import java.util.Map;

public class Compilateur {
        private HashMap<String,Double> tableSymbole ;
        private LigneCmd cmd;
        Compilateur(){
                tableSymbole = new HashMap<String,Double>();
                tableSymbole.put("pi",Math.PI);
                cmd = new LigneCmd(tableSymbole);
        }
        public void Complie(String l){
                try {
                        cmd.EvalLigne(l);
                }
                catch (ExceptCmd e){
                        System.out.println(e.getMessage());
                }
                catch (ExpresExcept e){
                        System.out.println(e.getMessage());
                }

        }
}

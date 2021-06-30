import java.util.ArrayList;
import java.util.Arrays;

public class Variable {
    private String varName;
    Variable(String varName)throws ExceptNomVar{
        ArrayList<Character> alphabet=new ArrayList<Character>(Arrays.asList('A','B','C' ,'D','E','F','G','H','I','J','K','L','M', 'N','O' , 'P', 'Q' , 'R' , 'S', 'T' , 'U', 'V', 'W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'));


            if (!alphabet.contains(varName.charAt(0))) {
                throw new ExceptNomVar();
            }
            this.varName=varName;


    }

    public String getVarName() {
        return varName;
    }
}

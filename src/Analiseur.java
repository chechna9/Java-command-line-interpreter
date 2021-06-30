import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
class functionresult
{
    public int pos;
    public Double resultat;
}
public interface Analiseur {
     default Double evaluate(String expression , HashMap<String, Double> variable)
             throws ExpresExcept{
        List<String> listfunc = Arrays.asList("sin", "cos", "tan", "sqrt","abs","log");
        char[] tokens = expression.toCharArray();
        int cpt;
        // Stack for numbers: 'values'
        Stack<Double> values = new
                Stack<Double>();

        // Stack for Operators: 'ops'
        Stack<Character> ops = new
                Stack<Character>();

        for (int i = 0; i < tokens.length; i++) {

            // Current token is a
            // whitespace, skip it
            if (tokens[i] == ' ')
                continue;
            cpt = 0;

            // Current token is a number,
            // push it to stack for numbers
            if ((tokens[i] >= '0' &&
                    tokens[i] <= '9') || tokens[i] == '.') {

                StringBuffer sbuf = new
                        StringBuffer();
                if (tokens[i] == '.') {
                    i++;
                    String chaine = values.get(values.size() - 1).toString();
                    values.pop();
                    cpt = chaine.length() - 2;

                    while ((i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == ' ') {
                        i++;
                        cpt++;
                    }
                    cpt++;
                    String doublenumber = expression.substring(i - cpt, i).replaceAll(" ", "");
                    values.push(Double.parseDouble(doublenumber));
                }

                // There may be more than one
                // digits in number
                else {
                    while (i < tokens.length &&
                            tokens[i] >= '0' &&
                            tokens[i] <= '9')
                        sbuf.append(tokens[i++]);
                    values.push(Double.parseDouble(sbuf.
                            toString()));

                }

                // right now the i points to
                // the character next to the digit,
                // since the for loop also increases
                // the i, we would skip one
                // token position; we need to
                // decrease the value of i by 1 to
                // correct the offset.
                i--;
            }

            // Current token is an opening brace,
            // push it to 'ops'
            else if (tokens[i] == '(')
                ops.push(tokens[i]);

                // Closing brace encountered,
                // solve entire brace
            else if (tokens[i] == ')') {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(),
                            values.pop(),
                            values.pop()));
                ops.pop();
            }

            // Current token is an operator.
            else if (tokens[i] == '+' ||
                    tokens[i] == '-' ||
                    tokens[i] == '*' ||
                    tokens[i] == '/') {
                // While top of 'ops' has same
                // or greater precedence to current
                // token, which is an operator.
                // Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() &&
                        hasPrecedence(tokens[i],
                                ops.peek()))
                    values.push(applyOp(ops.pop(),
                            values.pop(),
                            values.pop()));

                // Push current token to 'ops'.
                ops.push(tokens[i]);
            } else if (tokens[i] >= 'a' && tokens[i] <= 'z') {
                int compteur = i;
                while ((i < tokens.length && tokens[i] >= 'a' && tokens[i] <= 'z')) {
                    i++;}

                String func = expression.substring(compteur, i);
                if(listfunc.contains(func)){
                    compteur = 1;
                    functionresult B = verefierfunc(func, expression, i,listfunc,variable);

                    i=B.pos;
                    values.push(B.resultat);}
                else{Double x;
                    if (variable.containsKey(func) ){x = variable.get(func);
                        values.push(x);
                        //ops.pop();

                        i--;
                    }
                    else{throw new ExpresExcept("Fonction ou Variable introuvable");}
                }


            }
        }


        // Entire expression has been
        // parsed at this point, apply remaining
        // ops to remaining values


        while (!ops.empty()) {
            values.push(applyOp(ops.pop(),
                    values.pop(),
                    values.pop()));
        }

        // Top of 'values' contains
        // result, return it

        Double res = values.pop();

        return res;
    }

    // Returns true if 'op2' has higher
    // or same precedence as 'op1',
    // otherwise returns false.
    default functionresult verefierfunc(String fonc, String express, int position,List<String> listfunc ,HashMap<String, Double> variable) {
        char[] expression = express.toCharArray();
        Double result= 0.0;
        int compteur = 1;

        if (expression[position] == '(') {

            int indice = position;
            position++;
            while (compteur != 0 && position < express.length()) {
                if (expression[position] == '(') compteur++;
                if (expression[position] == ')') compteur--;
                position++;
            }
            String nvexp= express.substring(indice, position).replaceAll(" ","");
            try {
                if (fonc.equals("sin")) {
                    result  = Math.sin(evaluate(nvexp,variable));

                } else if (fonc.equals("cos")) {
                    result = Math.cos(evaluate(nvexp ,variable));

                } else if (fonc.equals("tan")) {
                    result = Math.tan(evaluate(nvexp,variable));

                } else if (fonc.equals("sqrt")) {
                    result  = Math.sqrt(evaluate(nvexp,variable));

                }
                else if (fonc.equals("abs")) {
                    result = Math.abs(evaluate(nvexp, variable));
                }
                else if (fonc.equals("log")) {
                    result = Math.log(evaluate(nvexp, variable));
                }
            }

        catch (ExpresExcept e) {
            System.out.println(e.getMessage());
        }

        }
        functionresult A = new functionresult();
        A.pos=position;
        A.resultat=result;

        return A;
    }




    default boolean hasPrecedence(
            char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') &&
                (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    // A utility method to apply an
    // operator 'op' on operands 'a'
    // and 'b'. Return the result.
    default Double applyOp(char op,
                                 Double b, Double a)
    {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException(
                            "Cannot divide by zero");
                return a / b;
        }
        return 0.00;
    }
}

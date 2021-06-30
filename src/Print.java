public class Print extends Commande{
    Print(Expression exp){
        super(exp);

    }
    public void Action(){
        try {
            System.out.println(getResultat());
        }
        catch (ExpresExcept e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println("Expression Erroné");
        }
    }
}
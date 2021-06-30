public class Commande {
    private Expression expression;
    private double resultat;

    Commande(){}
    Commande(Expression exp){
        this.expression=exp;
    }
    public double getResultat() throws ExpresExcept{

        try {
            resultat= expression.analiser();
        } catch (ExpresExcept expresExcept) {
            throw new ExpresExcept("Fonction ou Variable introuvable");
        }
        return resultat;
    }
}

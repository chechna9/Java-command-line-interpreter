//Exception qui gere le nom de la variable
public class ExceptNomVar extends Exception {
    @Override
    public String getMessage() {
        return "Le nom de variable doit commence par une lettre";
    }
}

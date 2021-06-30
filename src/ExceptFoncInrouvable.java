public class ExceptFoncInrouvable extends Exception{
    private String s;
    ExceptFoncInrouvable(String s){
        this.s=s;
    }
    @Override
    public String getMessage() {
        return "La fonction "+s+" est introuvable";
    }
}

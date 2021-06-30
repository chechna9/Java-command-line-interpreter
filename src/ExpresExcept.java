public class ExpresExcept extends Exception{
    private String s;
    ExpresExcept(String s){
        this.s=s;
    }
    @Override
    public String getMessage() {
        return s;
    }
}

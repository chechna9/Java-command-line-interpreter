public class LigneCmd {
    private String cmd;
    private Expression exp;
    private Variable var;
    LigneCmd(String l) throws ExceptCmd {
        String tempCmd = l.split(" ")[0];
        if (tempCmd != "let" || tempCmd != "print"){
            throw new ExceptCmd();
        }
        this.cmd=tempCmd;
        if(this.cmd == "let")
        {

        }
        else if(this.cmd == "print")
        {

        }


    }
}

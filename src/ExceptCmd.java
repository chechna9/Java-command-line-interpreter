public  class  ExceptCmd  extends Exception{
    //Exception qui gere le nom de la variable
        @Override
        public String getMessage() {
            return "Cette commande n'existe pas ' on a que deux commande let * pour declarer une variable *  print * pour affiher une expression * ";
        }


}

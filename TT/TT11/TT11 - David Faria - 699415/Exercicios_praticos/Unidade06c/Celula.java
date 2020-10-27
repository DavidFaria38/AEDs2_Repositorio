public class Celula{
    public int elemento;
    public Celula prox;

    public Celula(){ this(0);}
   
    public Celula(int value){
        this.elemento = value;
        this.prox = null;
    } // end celula()
} // end class Celula


class Celula {
    public String elemento; // Elemento inserido na celula.
    public boolean vivo;
    public int killCount;
    public Celula prox; // Aponta a celula prox.
    public Celula ant; // Aponta a celula prox.

    /**
     * Construtor da classe.
     */
    public Celula() {
        this("", false);
    }

    /**
     * Construtor da classe.
     * 
     * @param elemento int inserido na celula.
     */
    public Celula(String elemento, boolean vivo) {
        this.elemento = elemento;
        this.vivo = vivo;
        this.killCount = 0;
        this.prox = null;
        this.ant = null;
    }

    public void killCountUp(int x){
        this.killCount ++;
    }
    public void murdered(){
        this.vivo = false;
    }
}

class Lista {
    private Celula primeiro;
    private Celula ultimo;

    /**
     * Construtor da classe que cria uma lista sem elementos (somente no cabeca).
     */
    public Lista() {
        primeiro = new Celula();
        ultimo = primeiro;
    }

    /**
     * Insere um elemento na ultima posicao da lista.
     * 
     * @param x int elemento a ser inserido.
     */
    public Celula inserirFim(String x, boolean vivo) {
        ultimo.prox = new Celula(x,vivo);
        ultimo.prox.ant = ultimo;
        ultimo = ultimo.prox;

        return ultimo;
    }

    public void swap(Celula a, Celula b){
        Celula tmp = new Celula();
        tmp.elemento = a.elemento;
        tmp.killCount = a.killCount;
        tmp.vivo = a.vivo;
       
        a.elemento = b.elemento;
        a.killCount = b.killCount;
        a.vivo = b.vivo;
        
        b.elemento = tmp.elemento;
        b.killCount = tmp.killCount;
        b.vivo = tmp.vivo;

        tmp = null;
    }

    public void ordenar(){
        for(Celula i = ultimo.ant; i != primeiro; i = i.ant){
            for(Celula j = primeiro.prox; j != i.prox; j = j.prox){
                if(j.elemento.compareTo(j.prox.elemento) > 0){
                    // System.out.println("." + j.elemento + " " + j.prox.elemento);
                    swap(j, j.prox);
                }
            }
        }
    }

    /**
     * Mostra os elementos da lista separados por espacos.
     */
    public void mostrarKillers() {
        System.out.println("HALL OF MURDERERS");
     
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            if(i.vivo == true){
                System.out.println(i.elemento + " " + i.killCount);
                // System.out.println(i.elemento + " " + i.killCount + " " + i.vivo);
            }
        }
    }
    
    public void mostrar() {
        System.out.println("mostrar lista");
     
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
           System.out.println(i.elemento + " " + i.killCount + " " + i.vivo);
        }
    }

    public boolean pesquisar_personagem(String x) {
        boolean resp = false;
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            if (i.elemento.compareTo(x) == 0) {
                resp = true;
                i = ultimo;
            }
        }
        return resp;
    }
    
    public boolean isPersonagemVivo(String x) {
        boolean resp = false;
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            if ((i.elemento.compareTo(x) == 0) && (i.vivo == true)) {
                resp = true;
                i = ultimo;
            }
        }
        return resp;
    }

    public Celula getPersonagem(String x) {
        Celula resp = new Celula();
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            if ((i.elemento.compareTo(x) == 0) && (i.vivo == true)) {
                resp = i;
                i = ultimo;
            }
        }
        return resp;
    }
}


/**
 * Q2
 */
public class Q2 {
    
    public static boolean isFim(String str){
        return (str.compareTo("FIM") == 0);
    }

    public static void getInput(Lista murderList){
        String input = MyIO.readLine();
        
        while(!isFim(input)){
            
            String split[] = input.split(" ");
            while((split[0].length() > 10) || (split[1].length() > 10)){
                input = MyIO.readLine();
                split = input.split(" ");
            }

            if(murderList.pesquisar_personagem(split[0]) == true){
                
                if(murderList.isPersonagemVivo(split[0]) == true){
                    Celula killer = murderList.getPersonagem(split[0]);
                    killer.killCountUp(1);

                    // System.out.printf("\nkd de %s up %d\n", split[0], killer.killCount);

                    if(murderList.pesquisar_personagem(split[1]) == true){
                        Celula victim = murderList.getPersonagem(split[1]);
                        victim.murdered();

                        // System.out.printf("%s(1) killed %s(1)\n", split[0], split[1]);
                        // System.out.println(split[1] + " dead: " + victim.vivo);
                    } else{
                        Celula victim = murderList.inserirFim(split[1], false);

                        // System.out.printf("%s(1) killed %s(0)\n", split[0], split[1]);
                        // System.out.println(split[1] + " dead: " + victim.vivo);
                    }
                }
            } else {
                Celula killer = murderList.inserirFim(split[0], true);
                killer.killCountUp(1);
                // System.out.printf("\nkd de %s up %d\n", split[0], killer.killCount);
                
                if(murderList.pesquisar_personagem(split[1]) == true){
                    
                    Celula victim = murderList.getPersonagem(split[1]);
                    victim.murdered();
                    
                    // System.out.printf("%s(0) killed %s(1) \n", split[0], split[1]);
                    // System.out.println(split[1] + " dead: " + victim.vivo);
                } else{
                    
                    Celula victim = murderList.inserirFim(split[1], false);

                    // System.out.printf("%s(0) killed %s(0)\n", split[0], split[1]);
                    // System.out.println(split[1] + " dead: " + victim.vivo);
                }
            }
            // System.out.println("\n====================================" + input);
            // murderList.mostrar();
            // System.out.println("====================================\n");
            input = MyIO.readLine();
        }
    }
        
    public static void main(String arg[]){
        Lista murderList = new Lista();
        
            
        getInput(murderList);
        murderList.ordenar();
        murderList.mostrarKillers();
        // murderList.mostrar();
        // System.out.println("antes\n");
        // System.out.println("\ndps\n");
        // murderList.mostrar();
    }
}
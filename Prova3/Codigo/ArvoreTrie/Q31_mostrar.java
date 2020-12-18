public void mostrar(){
    System.out.println("\n================================");
    mostrar(raiz, "");
    System.out.println("================================\n");
} // end mostrar()
private void mostrar(Celula cell, String str){
    boolean jaEntrou = false;
    int countFolha = 0;
    if(hasFilhoMoreThanOneFilho(cell)){
        
        for(int i = 65; i < 91; i++){ // pocura dentro de uma tabela hash todas as letrar maiusculas
            if(cell.tabela[i] != null){ // caso exista uma celula dentro da tabela hash
                if(jaEntrou == false){ 
                    str += cell.elemento;
                    jaEntrou = true;
                } // end if
                if((cell.isFolha == true) && (countFolha == 0)){
                    System.out.println(str);
                    countFolha++;
                }
                
                mostrar(cell.tabela[i], str);
            } // end if
        } // end for
    } else{
        str += cell.elemento;
        System.out.println(str);
    } // end else
} // end mostrar()

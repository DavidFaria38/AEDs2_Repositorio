// Leia o nome de um arquivo contendo uma mensagem criptografada com o Ciframento de César (k = 3), descriptografe a mensagem e mostre-a na tela

class tt02Q09{

    /**
     * - Metodo que le conteudo de arquivo.
     * @param fileName - nome do arquivo a ser aberto
     * @return         - String com conteudo do arquivo aberto
     */
    static String readFile(String fileName){
        String text = "";
        Arq.openRead(fileName);

        while(Arq.hasNext()){
            text += Arq.readLine();    
            text += "\n";
        } 
        Arq.close();
        return text;
    } // end readFile()    
   
    /**
     * - Metodo para fazer o ciframento de cesar em uma String
     * @param str - String a ser manipulada
     * @param key - quantida de casas a serem "puladas"
     * @retun     - String ja cifrada
     */
    static String undo_CifraCesar(String str, int key){
        String decifrado = "";

        for(int i = 0; i < str.length(); i++)
            decifrado += (char)(str.charAt(i) - key);

        return decifrado;
    } // end cifraCesar()

    public static void main(String []arg){
        String readFileName  = MyIO.readLine();
        String text = "";
        int key = 3;

        text = readFile(readFileName);
        text = undo_CifraCesar(text, key);        

        MyIO.println(text); 
    } // end main()
}

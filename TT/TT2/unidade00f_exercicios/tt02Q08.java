// Leia o nome de um arquivo e mostre na tela o conteúdo desse arquivo criptografado usando o ciframento de César (k = 3)

class tt02Q08{

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
    * - Metodo que escreve conteudo em arquivo.
    * @param fileName - nome do arquivo a ser manipulado
    * @param text     - String com conteudo a ser arquivado
    */
    static void writeFile(String fileName, String text){
        Arq.openWrite(fileName);

        Arq.print(text);
        Arq.close();
    } // end writeFile()

    /**
     * - Metodo para fazer o ciframento de cesar em uma String
     * @param str - String a ser manipulada
     * @param key - quantida de casas a serem "puladas"
     * @retun     - String ja cifrada
     */
    static String cifraCesar(String str, int key){
        String cifrado = "";

        for(int i = 0; i < str.length(); i++)
            cifrado += (char)(str.charAt(i) + key);

        return cifrado;
    } // end cifraCesar()

    public static void main(String []arg){
        String readFileName  = MyIO.readLine();
        String writeFileName = MyIO.readLine();
        String text = "";
        int key = 3;

        text = readFile(readFileName);
        text = cifraCesar(text, key);        

        writeFile(writeFileName, text); 
    } // end main()
}

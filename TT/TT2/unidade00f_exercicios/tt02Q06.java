// Leia o nome de dois arquivos, abra o primeiro, converta seu conteúdo para letra maiúscula e salve o no segundo

class tt02Q06{
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

    public static void main(String []arg){
        String readFileName  = MyIO.readLine();
        String writeFileName = MyIO.readLine();
        String text = "";

        text = readFile(readFileName);
        text = text.toUpperCase();
        writeFile(writeFileName, text); 
    } // end main()
}

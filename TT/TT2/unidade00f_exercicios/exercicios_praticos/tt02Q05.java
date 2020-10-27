// Leia o nome de dois arquivos e copie o conteúdo do primeiro para o último

class tt02Q05{
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
        writeFile(writeFileName, text); 
    } // end main()
}

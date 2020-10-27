// Leia o nome de um arquivo e mostre seu conteúdo na tela

class tt02Q03{
    
    static String readFile(String fileName){
        String text = "";
        Arq.openRead(fileName);

        while(Arq.hasNext()){
            text += Arq.readLine();    
            text += "\n";
        } 
        Arq.close();
        return text;
    } // end writeFile()    
    
    public static void main(String []arg){
        String fileName = MyIO.readLine();
        String text = "";

        text += readFile(fileName);
        MyIO.println(text);
        
    } // end main()
}

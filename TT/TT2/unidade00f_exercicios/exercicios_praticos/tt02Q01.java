// Faça um programa que abre um arquivo e cria uma cópia

class tt02Q01{
    
    static void readCopy(String readFile, String copyFile){
        String strCopy = "";
        Arq.openRead(readFile);
        
        while(Arq.hasNext() == true){
            strCopy += Arq.readLine();
            strCopy += "\n";
        } // end while()
        Arq.close();

        Arq.openWrite(copyFile);
        Arq.print(strCopy);
        Arq.close();
    } // end readCopy()

    public static void main(String []arg){
        String readFileName = "original";
        String copyFileName = "copia";
        readCopy(readFileName, copyFileName);
    } // end main()
}

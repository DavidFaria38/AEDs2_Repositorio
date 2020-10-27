// Leia o nome de um arquivo e uma frase e salve essa frase nesse arquivo
import java.io.*;

class tt02Q02{
    
    static void writeFile(String fileName, String text) throws IOException{
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        raf.writeBytes(text);
        raf.close();
    } // end writeFile()    
    
    public static void main(String []arg) throws IOException {
        String fileName = MyIO.readLine();
        String text     = MyIO.readLine();

        writeFile(fileName, text);
        
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        MyIO.println(raf.readLine());
        raf.close();
    } // end main()
}

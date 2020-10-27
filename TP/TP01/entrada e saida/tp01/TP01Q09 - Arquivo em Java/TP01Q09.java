import java.io.*;

class TP01Q09{
	
	/**
	 * - Metodo que le um valor inteiro(n) e em seguida le outros n valores double, e os grava em um arquivo .txt
	 */
	static void write(int nDouble) throws Exception{
//		int nDouble = MyIO.readInt();
		double temp;
		RandomAccessFile raf = new RandomAccessFile("numDouble.txt", "rw");
		
		for(int i = 0; i < nDouble; i++)
			raf.writeDouble(MyIO.readDouble());
		
//		raf.seek(0);
//		for(int i = 0; i < nDouble; i++)
//			MyIO.println(raf.readDouble());
		raf.close();

	} // end write()

	static void readUpsideDown(int nDouble) throws Exception{
		RandomAccessFile raf = new RandomAccessFile("numDouble.txt", "r");
		
		double temp;
		for(int i = 0; i < nDouble; i++){
			raf.seek((nDouble - i - 1) * 8);
			temp = raf.readDouble();
			if(temp % 1 == 0)
				MyIO.println((int)temp);
			else
				MyIO.println(temp);
//			MyIO.println(raf.readDouble());
		} 

		raf.close();
	} // end readUpsideDown()

	public static void main(String []arg) throws Exception{
		int nDouble = MyIO.readInt();
		write(nDouble);
		readUpsideDown(nDouble);
	} // end main()
}

import java.util.Random;

class TP01Q04{
	
	static boolean isFIM(String str){
		return(str.length() >= 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I'  && str.charAt(2) == 'M' );
	}

	static void alteracaoAleatoria(){
		char toBeChanged, changeTo;
        String str = MyIO.readLine();
	    String newStr = "";
        Random rand = new Random();
        rand.setSeed(4);

        while(!isFIM(str)){
            toBeChanged = (char)('a' + (Math.abs(rand.nextInt()) % 26));
            changeTo    = (char)('a' + (Math.abs(rand.nextInt()) % 26));
            
            for(int i = 0; i < str.length(); i++){            
                if(str.charAt(i) == toBeChanged)
                    newStr += changeTo;
                else
                    newStr += str.charAt(i);
            } // end for()
            //MyIO.println(toBeChanged + " => " + changeTo + "\n" + str + "\n" + newStr);
            MyIO.println(newStr);
            newStr = "";
            str = MyIO.readLine();
        } // end while()
    } // end alteracaoAleatoria()

	public static void main(String []arg){
		alteracaoAleatoria();
	}
}

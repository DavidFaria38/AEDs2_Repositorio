import java.net.*;
import java.io.*;

class TP01Q08 {

    /**
      * - Se String for igual a "FIM" retonar true.
      * @param str - String a ser manipulada
      */
    static boolean isFIM(String str) {
        return (str.length() >= 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
    } // end isFIM()
    
    /**
      * - Transforma documento HTML em uma String.
      * @param pageURL - URL da pagina 
      * @return        - String contendo pagina HTML
      */
    static String getHTML(String pageURL) throws Exception {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String html = "", line;
		
        try{
            url = new URL(pageURL);
            is = url.openStream(); // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                html += line;
            }
        }catch (MalformedURLException mue) {
            mue.printStackTrace();
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try{
            is.close();
        }catch (IOException ioe) {}

		byte[] byteHTML = html.getBytes();
		String html2 = new String(byteHTML, "ISO-8859-1");
        
		return html2;
    } // end getHTML()
    

    /**
      * - Retorna todo conteudo que estiver entre < >.
      * @param str   - String contendo o documento HTML
      * @param index - index onde esta o primeiro < de uma tag
      */
    static String getTag(String str, int index){
        String tag = "";
        while(str.charAt(index) != '>'){
            tag += str.charAt(index);
            index++;
        } // end while

        // pegar o ultimo '>'
        tag += str.charAt(index);
        
        return tag;
    } // end getTag()

    /**
      * - print da quantidade de cada instacia de caractere dentro da pagina HTML.
      * @param xi       - Array de quantidade de cada instancia. 
      * @param nameXi   - Array de caracteres
      * @param pageName - Nome da pagina
      */
	static void printXi(int[] xi, String pageName){
        System.out.print("a(" + xi[0] + ") e(" + xi[1] + ") i(" + xi[2] + ") o(" + xi[3] + ") u(" + xi[4] +") á(" + xi[5] + ") é(" + xi[6] + ") í(" + xi[7] + ") ó(" + xi[8] + ") ú(" + xi[9] + ") à(" + xi[10] + ") è(" + xi[11] + ") ì(" + xi[12] + ") ò(" + xi[13] + ") ù(" + xi[14] + ") ã(" + xi[15] + ") õ(" + xi[16] + ") â(" + xi[17] + ") ê(" + xi[18] + ") î(" + xi[19] + ") ô(" + xi[20] + ") û(" + xi[21] + ") "); 
		System.out.print("consoante(" + xi[22] + ") <br>(" + xi[23] + ") <table>(" + xi[24] + ") " + pageName);
	     MyIO.println("");
     } // end printXi()

    /**
      * - Reseta o contador de intancias do elementos desejados
      */
    static void resetXi(int[] xi){
        for(int i = 0; i < xi.length; i++)
            xi[i] = 0;
    } // end resetXi()

    /**
      * - Retorna true se tag for igual a "<br>".
      * @param tag - String de caracteres a ser verificada
      */
    static boolean isBr(String tag){
	return(tag.length() == 4 && tag.charAt(0) == '<' && tag.charAt(1) == 'b' && tag.charAt(2) == 'r' && tag.charAt(3) == '>');
    } // end isBr()

    /**
      * - Retorna true se tag for igual a "<table>".
      * @param tag - String de caracteres a ser verificada
      */
    static boolean isTable(String tag){
	return(tag.length() == 7 && tag.charAt(0) == '<' && tag.charAt(1) == 't' && tag.charAt(2) == 'a' && tag.charAt(3) == 'b' && tag.charAt(4) == 'l' && tag.charAt(5) == 'e' && tag.charAt(6) == '>');
    } // end isTable()

    /**
      * - Recebe a primeira instancia do sinal maior e verifica se a tag e` uma tag br ou table.
      * @param str   - String que contendo o conteudo da pagina html
      * @param xi    - Array de inteiro contendo a quantidade de instancias dos elementos desejados
      * @param index - index do sinal maior
      */
    static int isBrTable(String str, int[] xi, int index){
	    int skip = 0;
        String tag = getTag(str, index);
        
        if(isBr(tag)){
            xi[23] += 1;
            skip = 4;
        }
        else if(isTable(tag)){
            xi[24] += 1;
            skip = 7;
        }
        return skip;
    } // end isBrTable()
    
    /**
      * - Na String contendo a pagina HTML, procura por todos os elementos desejados.
      * @param html - String contendo a pagina html
      * @param xi   - Array de inteiro contendo a quantidade das instancias dos elementos desejados
      */
    static void showHtml(String html, int[] xi){
        for(int i = 0; i < html.length(); i++){
            if(html.charAt(i) == '<' && html.charAt(i + 1) != '/')
                i += isBrTable(html, xi, i);
			
            if(html.charAt(i) == 'a')
                xi[0] += 1;
            else if(html.charAt(i) == 'e')
                xi[1] += 1;
            else if(html.charAt(i) == 'i')
                xi[2] += 1;
            else if(html.charAt(i) == 'o')
                xi[3] += 1;
            else if(html.charAt(i) == 'u')
                xi[4] += 1;
            else if(html.charAt(i) == 'á')
                xi[5] += 1;
            else if(html.charAt(i) == 'é')
                xi[6] += 1;
            else if(html.charAt(i) == 'í')
                xi[7] += 1;
            else if(html.charAt(i) == 'ó')
                xi[8] += 1;
            else if(html.charAt(i) == 'ú')
                xi[9] += 1;
            else if(html.charAt(i) == 'à')
                xi[10] += 1;
            else if(html.charAt(i) == 'è')
                xi[11] += 1;
            else if(html.charAt(i) == 'ì')
                xi[12] += 1;
            else if(html.charAt(i) == 'ò')
                xi[13] += 1;
            else if(html.charAt(i) == 'ù')
                xi[14] += 1;
            else if(html.charAt(i) == 'ã')
                xi[15] += 1;
            else if(html.charAt(i) == 'õ')
                xi[16] += 1;
            else if(html.charAt(i) == 'â')
                xi[17] += 1;
            else if(html.charAt(i) == 'ê')
                xi[18] += 1;
            else if(html.charAt(i) == 'î')
                xi[19] += 1;
            else if(html.charAt(i) == 'ô')
                xi[20] += 1;
            else if(html.charAt(i) == 'û')
                xi[21] += 1;
            else if(html.charAt(i) >= 'a' && html.charAt(i) <= 'z')
                xi[22] += 1;
        } // end 
    } // end showHtml()


    public static void main(String[] arg) throws Exception {
        String pageURL, pageName, html = "";
        boolean loop = true;
        int[] xi = new int[25];
//        char[] nameXi = new char[22];
//        initNameXi(nameXi);

        while(loop) {
            pageName = MyIO.readLine();
            if(isFIM(pageName) == false){
                pageURL = MyIO.readLine();

                html = getHTML(pageURL);
                showHtml(html, xi);
                printXi(xi, pageName); 
                resetXi(xi);
            }else
                loop = false;
        } // end while
    } // end main()
}

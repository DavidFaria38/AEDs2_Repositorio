class Exer01{
	static boolean findInt(int[] array, int find){
		boolean resp = false;
        int n = array.length;
		int dir = n -1, esq = 0, meio = 0;

        meio = (esq + dir)/2;
        while(esq < dir){
            if(find > array[meio]){
                esq = meio + 1;
            }
            else{
                dir = meio;
            }
            meio = (esq + dir)/2;
        }

        if(find == array[meio]){
            resp = true;
        }

		return resp;	
	}

    static void readArray(int[] array){
        for(int i = 0; i < array.length; i++)
            array[i] = MyIO.readInt();
    }

	public static void main(String []arg){
		int len, find;

        len = MyIO.readInt("");
        int[] array = new int[len];
        readArray(array);

        find = MyIO.readInt("");

        MyIO.println(findInt(array, find));
        // for(int i= 0; i < array.length; i++)
        //     MyIO.println(array[i]);
	}    
}

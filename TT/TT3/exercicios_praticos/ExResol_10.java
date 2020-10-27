class ExResol_10 {
	// 3n + 2n^2
	static void a(int n) {
		int a = 0, b = 0, c = 0;

		for (int i = 0; i < n; i++)
			a--;b--;c--;

		int e = 0, f = 0;

		for (int j = 0; j < n; j++) {
			for (int k = 0; k < 2; k++)
				e--;f--;
		}
	}

	// 5n + 4n^3
	static void b(int n) {
		int i = 0, j, k;
		int[] _5n = new int[5];

		while (i < n) {
			i++;
			for (j = 0; j < _5n.length; j++)
				_5n[j]--;
		}

		int[] _4n3 = new int[4];

		for(i = 0; i < n; i++)
			for(j = 0; j < n; j++)
				for(k = 0; k < _4n3.length; k++)
					_4n3[k]--;

		// vizualizacao de subtracoes realizadas
		int soma1 = 0, soma2 = 0;
		for (j = 0; j < _5n.length; j++)
			soma1 += _5n[j];
		for (j = 0; j < _4n3.length; j++)
			soma2 += _4n3[j];
		System.out.println(soma1 + " " + soma2);
	}
	
	// lg(n) + n
	static void c(int n) {
		int lgn = 0;
		for(int i = n; i > 1; i/= 2)
			lgn--;

		for(int j = n; j > 0; j--){}
	}

	// 2n^3 + 5
	static void d(int n) {
		int _2n3 = 0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				for(int k = 0; k < n; k++)
					_2n3--;

		int i = 5; 
		while(i > 0){
			i--;
		}
	}

	// 9n^4 + 5n^2 + n/2
	static void e(int n) {
		int _9n4 = 0;
		
		for(int i = 0; i < Math.pow(n, 4); i++)
			for(int j = 0; j < 9; j++)
				_9n4--;

		int _5n2 = 5 * (int)Math.pow(n, 2);
		while(_5n2 > 0)
			_5n2--;

		int n2 = n/2;
		while(n2 > 0)
			n2--;
	}

	// lg(n) + 5 lg(n)
	static void f(int n) {
		int lgn = 0;
		for(int i = n; i > 1; i/= 2)
			lgn--;

		int _5lgn = 0;
		for(int i = 0; i < 5; i++)
			for(int j = n; j > 1; j/= 2)
				_5lgn--;

	}

	public static void main(String[] arg) {
		int option, n = 8;

		do {
			option = MyIO.readInt("option: ");
			switch (option) {
				case 0:
					option = 0;
					break;
				case 1:
					a(n);
					break;
				case 2:
					b(n);
					break;
				case 3:
					c(n);
					break;
				case 4:
					d(n);
					break;
				case 5:
					e(n);
					break;
				case 6:
					f(n);
					break;

				default:
					break;
			}
		} while (option != 0);
	}
}

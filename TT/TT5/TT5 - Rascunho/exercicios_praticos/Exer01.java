class Exer01{

	static double somatorioPA(double a, double b, int n){
		// formula: ((2a + bn)(n + 1))/2
		return( ((a*2 + b*n)*(n + 1))/2 );
	} // end somatorioPA()

	public static void main(String []arg){
		
		double a = MyIO.readDouble();
		double b = MyIO.readDouble();
		int n = MyIO.readInt();
		
		double soma = somatorioPA(a, b, n);	
		
		System.out.println(soma);
	} // end main()
}

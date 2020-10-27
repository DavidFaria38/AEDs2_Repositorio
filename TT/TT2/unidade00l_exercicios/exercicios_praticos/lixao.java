// TT02Q02

// Faça também uma classe Lixao contendo um método main sendo que esse terá dois objetos do tipo retângulo e chamará os métodos desenvolvidos na classe retângulo

class lixao{
    
    public static void main(String []arg){
        Retangulo rec1, rec2;

        rec1 = new Retangulo(10, 5);
        rec2 = new Retangulo(50, 2);

        MyIO.println("Rec1: B = " + rec1.getBase() + " | H = " + rec1.getAltura());
        MyIO.println("Area      = " + rec1.getArea());
        MyIO.println("Perimetro = " + rec1.getPerimetro());
        MyIO.println("Diagonal  = " + rec1.getDiagonal());
        
        MyIO.println(" ");

        MyIO.println("Rec2: B = " + rec2.getBase() + " | H = " + rec2.getAltura());
        MyIO.println("Area      = " + rec2.getArea());
        MyIO.println("Perimetro = " + rec2.getPerimetro());
        MyIO.println("Diagonal  = " + rec2.getDiagonal());

         
    } // end main()
}

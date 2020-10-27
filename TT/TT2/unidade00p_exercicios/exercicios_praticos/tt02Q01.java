// Faça um programa que leia três números reais representando os lados de um triângulo e informe se seu triângulo é Equilátero, Isósceles ou Escaleno

class tt02Q01{

    static boolean isIsoceles(double l1, double l2, double l3){
        return((l1 == l2 && l2 != l3) || (l3 == l2 && l2 != l1) || (l1 == l3 && l3 != l2));
    } // end isIsoceles

    public static void main(String []arg){
        double l1 = MyIO.readDouble();
        double l2 = MyIO.readDouble();
        double l3 = MyIO.readDouble();

        if(l1 == l2 && l2 == l3)
            MyIO.println("Triangulo Equilatero");
        else if(isIsoceles(l1, l2, l3))
            MyIO.println("Triangulo Isoceles");
        else
            MyIO.println("Triangulo Escaleno");
    } // end main()
}

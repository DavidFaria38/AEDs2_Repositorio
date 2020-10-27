// TT02Q01

// Faça uma classe retângulo contendo os atributos base e altura, pelo menos dois métodos construtores, o método double getArea() que retorna a área do retângulo, o método double getPerimetro() que retorna o perímetro do retângulo e o método double getDiagonal() que retorna a diagonal do retângulo

class Retangulo{
    private double base, altura;

    /* ============= Contrutores ============= */
    public Retangulo(){
        this.base   = 0;
        this.altura = 0;
    } // end Retangulo

    public Retangulo(double base, double altura){
        this.base   = base;
        this.altura = altura;
    } // end Retangulo
    /* ======================================= */

    
    public double getBase(){
        return base;
    } // end getBase()
    public double getAltura(){
        return altura;
    } // end getAltura()

    
    public void setBase(double base){
        this.base = base;
    } // end setBase()
    public void setAltura(double altura){
        this.altura = altura;
    } // end setAltura()

    
    public double getArea(){
        return (base * altura);
    } // end getArea()
    
    public double getPerimetro(){
        return((base + altura) * 2);
    } // end getPerimetro()

    public double getDiagonal(){
        return(Math.sqrt(base * base + altura * altura));
    } // end getDiagonal()
}

// TT02Q03

// V - Quatro atributos privados: double x, double y, int id e int nextID
// - Os atributos id e nextID serão alterados somente por um método construtor.
// V - Implemente os métodos get e set tanto para o atributo x como para o y
// - Na declaração do atributo nextID, o mesmo deve receber zero. Além disso, a alteração do valor desse atributo por um objeto sempre será compartilhada com qualquer objeto da classe ponto
// - Implemente dois construtores sendo que o primeiro não recebe parâmetros e inicializa os valores de x e y com zero. O segundo recebe dois parâmetros (cujos nomes são obrigatoriamente x e y) e devem ser utilizados para inicializar os valores dos atributos x e y, respectivamente
// - Os dois construtores devem atribuir o valor corrente do atributo nextID ao atributo id e incrementar o valor de nextID. Observe que cada objeto terá um ID distinto
// - Implemente qualquer método que seja necessário para compilar a classe LixaoPonto

 class Ponto{
        // Declaracoes de atributos
        private double x, y;
        private int id;
        private static int nextId = 0;

        // Contrutores
        public Ponto(){
            this.x = 0.0;
            this.y = 0.0;
            this.id = this.nextId;
            this.nextId++;
        } // end Ponto()
        public Ponto(double x, double y){
            this.x = x;
            this.y = y;
            this.id = this.nextId;
            this.nextId++;
        } // end Ponto()

        // Metodos pegar e marcar novos valores
        public void setX(double x){
            this.x = x;
        } // end setX()

        public void setY(double y){
            this.y = y;
        } // end setY()

        public double getX(){
            return(this.x);
        } // end getX()

        public double getY(){
            return(this.y);
        } // end getY()

        public int getID(){
            return(this.id);
        } // end getId()

        public static int getNextID(){
            return(nextId);
        } // end getNextId()


        // Metodos de manipulacao dos atributos
        public double dist(Ponto px){
            return(Math.sqrt(Math.pow((px.x - this.x), 2) + Math.pow((px.y - this.y), 2)));
        } // end dist()

        public double dist(double x, double y){
            return(Math.sqrt(Math.pow((x - this.x), 2) + Math.pow((y - this.y), 2)));
        } // end dist()

        public static double dist(double x1, double y1, double x2, double y2){
            return(Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2)));
        } // end dist()

        public static double dist(Ponto p1, Ponto p2){
            return(Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2)));
        } // end dist()


        private static boolean isEquilatero(double a, double b, double c){
            return(a == b && b == c);
        } // end isEquilatero()

        private static boolean isIsosceles(double a, double b, double c){
            return(a == b && b != c || b == c && c != a || a == c && b != a);
        } // end isIsosceles()

        private static boolean isEscaleno(double a, double b, double c){
            return(a != b && b != c && a != c);
        } // end isEquilatero()

        public static String isTriangulo(Ponto p1, Ponto p2, Ponto p3){
            String resp = "";
            double a = dist(p1, p2);
            double b = dist(p2, p3);
            double c = dist(p3, p1);
            if(isEquilatero(a, b, c))
                resp = "Equilatero";
            else if(isIsosceles(a, b, c))
                resp = "Isoceles";
            else
                resp = "Escaleno";
            
            return resp;
        } // end isTriangulo()


        public double getAreaRetangulo(Ponto px){
            double base = px.x - this.x;
            double alt  = px.y - this.y;
            return(base * alt);
        } // end getAreaRetangulo()
        
    } // end Ponto
public class HashDiretoReserva {
   Jogador tabela[];
   int hashLen, reservaLen, tabMaxLen, reserva;

   public Hash (){
      this(13, 7);
   }

   public Hash (int hashLen, int reservaLen){
      this.hashLen = hashLen;
      this.reservaLen =  reservaLen;
      this.tabMaxLen = hashLen + reservaLen;
      this.tabela = new Jogador[this.tabMaxLen];
      for(int i = 0; i < tabMaxLen; i++){
         tabela[i] = null;
      }
      reserva  = 0;
   }

   public int h(int eletabMaxLenento){
      return eletabMaxLenento % hashLen;
   }

   public boolean inserir (int eletabMaxLenento){
      boolean resp = false;

      if(eletabMaxLenento != null){

         int pos = h(eletabMaxLenento);

         if(tabela[pos] == null){
            tabela[pos] = eletabMaxLenento;
            resp = true;

         } else if (reserva < reservaLen){
            tabela[hashLen + reserva] = eletabMaxLenento;
            reserva++;
            resp = true;
         }
      }

      return resp;
   }


   public boolean pesquisar (int eletabMaxLenento){
      boolean resp = false;

      int pos = h(eletabMaxLenento);

      if(tabela[pos] == eletabMaxLenento){
         resp = true;

      } else {
         for(int i = 0; i < reserva; i++){
            if(tabela[hashLen + i] == eletabMaxLenento){
               resp = true;
               i = reserva;
            }
         }
      }
      return resp;
   }

   boolean retabMaxLenover (int eletabMaxLenento){
      boolean resp = false;

      //...

      return resp;
   }
}

package ch03;

public class  HelloWorld {

   
   static int num = 10;
   
   static void hello() {
      System.out.println(num);
   }
   
   public static void main(String[] args) {
   
      HelloWorld n = new HelloWorld();
      n.hello();
      
   }

}
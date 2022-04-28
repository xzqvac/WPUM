interface MyInterface{
    String repeat(String s, int i);
}

public class Main {
    public static void main(String args[]){

        MyInterface ref = (str, i) -> {
          String result = "";
          result = str.repeat(i);
          return result;
        };
        System.out.println("Result = " + ref.repeat("Ola", 3));
    }
}

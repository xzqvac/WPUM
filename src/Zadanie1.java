import java.util.Arrays;

public class Zadanie1 {
    public static void main(String[] args) {
        for(int i = 1; i <= 100; i++){
            String word = "";
            if(i % 3 == 0){
                word += "trzy";
            }
            if(i % 5 == 0){
                word += "piec";
            }
            if(i % 7 == 0){
                word += "siedem";
            }
            if (i % 11 == 0) {
                word += "jedenascie";
            }
            if (word.length() == 0)
                System.out.println(i);
            else
                System.out.println(word);
        }
    }
}


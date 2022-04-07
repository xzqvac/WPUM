import java.util.HashMap;

public class Zadanie1Lista2 {
    public static String convertToRoman(int number){
        HashMap<Integer, String> dictionary = new HashMap<Integer, String>();
        dictionary.put(1, "I");
        dictionary.put(5, "V");
        dictionary.put(10, "X");
        dictionary.put(50, "L");
        dictionary.put(100, "C");
        dictionary.put(500, "D");
        dictionary.put(1000,"M");

        String result = "";
        while(number > 0){
            int temp = number;
            int count = 0;
            while (temp > 10){
                temp /= 10;
                count++;
            }
            if(temp >= 1 && temp <= 3){
                int num = (int) Math.pow(10, count);
                for(int i = 0; i < temp; ++i){
                    result += dictionary.get(num);
                }
                number -= num * temp;
            }
            else if(temp >= 6 && temp <= 8) {
                int num = (int) (5 * Math.pow(10, count));
                result += dictionary.get(num);
                number -= num;
            }
            else{
                int num = (int) (temp * Math.pow(10, count));
                result += dictionary.get(num);
                number -= num;
            }
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(convertToRoman(3338));
    }
}

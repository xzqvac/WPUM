import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Zadanie4 {
        static int missingNumber(int[] array){
            int max = 0, missing = array.length;
            for(int x : array){
                if( x > max){
                    max = x;
                }
            }
            int length = max + 1;
            int [] temp = new int[length];

            for (int i = 0; i < array.length; i++) {
                int number = array[i];
                temp[number]++;
            }

            for (int i = 0; i < length; i++) {
                if (temp[i] == 0) {
                    return i;
                }
            }
            return array.length;
        }

        public static void main(String[] args){
            int[] intArray = {0,1,2,3};
            System.out.println(missingNumber(intArray));

        }
}

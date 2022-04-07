import java.util.HashMap;
public class Zadanie2Lista2 {
    public static int convertFromRoman(String number) {
    HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
        dictionary.put("I", 1);
        dictionary.put("V", 5);
        dictionary.put("X", 10);
        dictionary.put("L", 50);
        dictionary.put("C", 100);
        dictionary.put("D", 500);
        dictionary.put("M", 1000);
        int occI = number.length() - number.replace("I", "").length();
        int occX = number.length() - number.replace("X", "").length();
        int occC = number.length() - number.replace("C", "").length();
        int occM = number.length() - number.replace("M", "").length();
        int numLen = number.length();
        if (occI > 3 || occX > 3 || occC > 3 || occM > 3 ){
            System.out.println("Podałeś nieprawidłowy zapis. Zwróć uwagę na maksymalną ilość znaków I, X, C, M");
            return 0;
        }

        for (int i = 0; i < numLen - 1; i++){
            var znak = number.charAt(i);
            String znakS = Character.toString(znak);
            var kolejny = number.charAt(i + 1);
            String kolejnyS = Character.toString(kolejny);
            dictionary.get(Character.toString(znak));
            if (znak == 'V' && kolejny == 'V'){
                System.out.println("Podales nieprawidlowy zapis. Zwróć uwagę, że litera V nie może stać obok L i D i siebie samej");
                return 0;
            }
            else if (znak == 'L' && kolejny == 'L'){
                System.out.println("Podales nieprawidlowy zapis. Zwróć uwagę, że litera L nie może stać obok V i D i siebie samej");
                return 0;
            }
            else if (znak == 'D' && kolejny == 'D'){
                System.out.println("Podales nieprawidlowy zapis. Zwróć uwagę, że litera D nie może stać obok L i V i siebie samej");
                return 0;
            }
        }
       if (numLen >= 3){
            for(int j = numLen; j >= 2; --j){
                char preCh = number.charAt(j - 1);
                String preS = Character.toString(preCh);
                char pre2Ch = number.charAt(j - 2);
                String pre2S = Character.toString(pre2Ch);
                char pre3Ch = number.charAt(j - 3);
                String pre3S = Character.toString(pre3Ch);
                if(dictionary.get(pre2S).equals(dictionary.get(pre3S)))
                    if(dictionary.get(preS) > dictionary.get(pre2S)){
                        System.out.println("Podałeś nieprawidłowy zapis. Nie może wystąpić tyle znaków poprzedzających");
                        return 0;
                    }
            }
        }
        for(int k = 0; k >= numLen - 1; k++) {
            char jeden = number.charAt(k + 1);
            String jedenS = Character.toString(jeden);
            char dwa = number.charAt(k);
            String dwaS = Character.toString(dwa);
            if (dictionary.get(jedenS) > dictionary.get(dwaS)) {
                if (dwa == 'I' && (jeden == 'L' || jeden == 'C' || jeden == 'D' || jeden == 'M')){
                    System.out.println("Podales nieprawidlowy zapis. Zle zmniejszasz I");
                    return 0;
                }
                else if (dwa == 'X' && (jeden == 'V' || jeden == 'X' || jeden == 'D' || jeden == 'M')){
                    System.out.println("Podales nieprawidlowy zapis. Zle zmniejszasz X");
                    return 0;
                }
                else if (dwa == 'C' && (jeden != 'V' || jeden != 'X' || jeden != 'L' || jeden != 'C')){
                    System.out.println("Podales nieprawidlowy zapis. Zle zmniejszasz C");
                    return 0;
                }
                else if (dwa == 'V' || dwa == 'L' || dwa == 'D' || dwa == 'M'){
                    System.out.println("Podales nieprawidlowy zapis. Tymi liczbami nie mozna zmniejszać");
                    return 0;
                }
            }
        }
        int result = 0;
        int previous_number = 0;
        for(int l = numLen - 1; l >= 0; l--){
            char zn = number.charAt(l);
            String znS = Character.toString(zn);
            if(dictionary.get(znS) >= previous_number){
                result += dictionary.get(znS);
            }
            else{
                result -= dictionary.get(znS);
            }
            previous_number = dictionary.get(znS);
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(convertFromRoman("I"));
    }
}

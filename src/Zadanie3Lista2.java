public class Zadanie3Lista2 {
    public static Boolean isCyclic(String numberS){
        double len = numberS.length();
        int numberI = Integer.parseInt(numberS);
        double b = 10;
        double c = (Math.pow(b, len) - 1)/(len + 1);
        System.out.println(c);

        return c == numberI;
    }
    public static void main(String[] args) {
        System.out.println(isCyclic("142857"));
    }
}

import java.util.*;

public class DPOKillerList {

    //Metode utility untuk menggunakan huruf kapital pada setiap nama                   private static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String[]> incidents = new ArrayList<>();

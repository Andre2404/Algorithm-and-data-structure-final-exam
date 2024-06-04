import java.util.*;

public class DPOKillerList {

    //Metode utility untuk menggunakan huruf kapital pada setiap nama                   
    private static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String[]> incidents = new ArrayList<>();
        
    // Input data
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) break;
            String[] names = line.split(" ");
            // Menggunakan huruf Kapital di setiap huruf Pertama setiap nama
            for (int i = 0; i < names.length; i++) {
                names[i] = capitalizeFirstLetter(names[i]);
            }
            incidents.add(names);
        }
        scanner.close();

     // Maps to store the count of killings and victims
        Map<String, Integer> killerCount = new HashMap<>();
        Set<String> victims = new HashSet<>();


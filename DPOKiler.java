import java.util.*;

public class DPOKillerList {

    //Metode utility untuk menggunakan huruf kapital pada setiap nama                   
    private static String capital(String input) {
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
                names[i] = capital(names[i]);
            }
            incidents.add(names);
        }
        scanner.close();

     // Map untuk insiden dan korban
        Map<String, Integer> killerCount = new HashMap<>();
        Set<String> victims = new HashSet<>();

    // memproses tiap insiden
        for (String[] incident : incidents) {
            String killer = incident[0];
            String victim = incident[1];

            killerCount.put(killer, killerCount.getOrDefault(killer, 0) + 1);
            victims.add(victim);
        }
        
    // menghilangkan pembunuh yang juga menjadi korban pembunuhan 
        Iterator<String> iterator = killerCount.keySet().iterator();
        while (iterator.hasNext()) {
            String killer = iterator.next();
            if (victims.contains(killer)) {
                iterator.remove();
            }
        }


    // mengurutkan pembunuh berdasarkan nama
        List<String> killers = new ArrayList<>(killerCount.keySet());
        Collections.sort(killers);
        
    // Output
        System.out.println("DAFTAR PENCARIAN ORANG KASUS PEMBUNUHAN");
        for (String killer : killers) {
            System.out.println(killer + " " + killerCount.get(killer));
        }
    }
}

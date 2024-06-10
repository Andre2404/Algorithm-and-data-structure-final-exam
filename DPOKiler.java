import java.util.*;

public class DPOKillerList {

    // Metode utility untuk menggunakan huruf kapital pada setiap nama
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
        int lineCount = 0;
        while (scanner.hasNextLine() && lineCount < 1000) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) break;
            String[] names = line.split(" ");
            
            if (names.length == 2) {
                if (names[0].length() <= 10 && names[1].length() <= 10) {
                    // Menggunakan huruf kapital di setiap huruf pertama setiap nama
                    names[0] = capital(names[0]);
                    names[1] = capital(names[1]);
                    incidents.add(names);
                    lineCount++;
                } else {
                    System.out.println("Nama harus tidak lebih dari 10 karakter. Silakan coba lagi.");
                }
            } else {
                System.out.println("Masukkan format 'nama pembunuh nama korban'.");
            }
        }
        scanner.close();

        if (lineCount == 0) {
            System.out.println("Minimal harus ada satu baris input.");
            return;
        }

        // Map untuk insiden dan korban
        Map<String, Integer> killerCount = new HashMap<>();
        Set<String> victims = new HashSet<>();

        // Memproses tiap insiden
        for (String[] incident : incidents) {
            String killer = incident[0];
            String victim = incident[1];

            killerCount.put(killer, killerCount.getOrDefault(killer, 0) + 1);
            victims.add(victim);
        }

        // Menghilangkan pembunuh yang juga menjadi korban pembunuhan
        killerCount.keySet().removeIf(victims::contains);

        // Mengurutkan pembunuh berdasarkan nama
        List<String> killers = new ArrayList<>(killerCount.keySet());
        Collections.sort(killers);

        // Output
        System.out.println("DAFTAR PENCARIAN ORANG KASUS PEMBUNUHAN");
        for (String killer : killers) {
            System.out.println(killer + " " + killerCount.get(killer));
        }
    }
                }

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestRepeatingCharacterReplacementBruteForce {
    String s;
    int k;
    FastReader reader = new FastReader();

    static class FastReader {
        BufferedReader b;
        StringTokenizer st; 

        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(b.readLine());
                } catch (IOException e) {
                    e.printStackTrace(); 
                }
            }
            return st.nextToken();
        }

        int nextInt() { 
            return Integer.parseInt(next()); 
        }
    }

    public void leerDatos() {
        s = reader.next(); // Cadena s
        k = reader.nextInt(); // Cantidad máxima de reemplazos permitidos
    }

    public void resuelve() {
        if (s == null || s.length() == 0) {
            System.out.println(0);
            return;
        }

        int n = s.length();
        int maxLen = 0;

        // Fuerza bruta O(n^2): probar todas las subcadenas posibles
        for (int i = 0; i < n; i++) {
            int[] count = new int[26];
            int maxFreq = 0;
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                count[c - 'A']++;
                maxFreq = Math.max(maxFreq, count[c - 'A']);

                int length = j - i + 1;
                // Caracteres a reemplazar = longitud - frecuencia máxima
                int replacements = length - maxFreq;

                if (replacements <= k) {
                    maxLen = Math.max(maxLen, length);
                }
            }
        }

        System.out.println(maxLen);
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacementBruteForce solver = new LongestRepeatingCharacterReplacementBruteForce();
        solver.leerDatos();
        solver.resuelve();
    }   
}
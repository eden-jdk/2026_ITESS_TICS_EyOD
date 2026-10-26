import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestRepeatingCharacterReplacementOptimal {
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

        int[] count = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;

        // Ventana deslizante O(n)
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            count[c - 'A']++;
            maxFreq = Math.max(maxFreq, count[c - 'A']);

            // Si los caracteres a reemplazar superan a k, contraer la ventana por la izquierda
            while ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // Actualizar la longitud máxima de la subcadena válida
            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println(maxLen);
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacementOptimal solver = new LongestRepeatingCharacterReplacementOptimal();
        solver.leerDatos();
        solver.resuelve();
    }   
}
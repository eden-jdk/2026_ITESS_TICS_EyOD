import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ValidAnagramBruteForce {
    String s, t;
    FastReader reader = new FastReader();

    static class FastReader {
        BufferedReader b;
        StringTokenizer s; 

        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (s == null || !s.hasMoreElements()) {
                try {
                    s = new StringTokenizer(b.readLine());
                } catch (IOException e) {
                    e.printStackTrace(); 
                }
            }
            return s.nextToken();
        }
    }

    public void leerDatos() {
        s = reader.next(); // Primera cadena
        t = reader.next(); // Segunda cadena
    }

    public void resuelve() {
        // Si las longitudes son distintas, no pueden ser anagramas
        if (s.length() != t.length()) {
            System.out.println("false");
            return;
        }

        boolean esAnagrama = true;
        char[] tChars = t.toCharArray();
        boolean[] visitado = new boolean[t.length()];

        // Fuerza bruta O(n^2): buscar cada carácter de s en t mediante bucles anidados
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean encontrado = false;
            for (int j = 0; j < t.length(); j++) {
                if (!visitado[j] && tChars[j] == c) {
                    visitado[j] = true;
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                esAnagrama = false;
                break;
            }
        }

        System.out.println(esAnagrama ? "true" : "false");
    }

    public static void main(String[] args) {
        ValidAnagramBruteForce solver = new ValidAnagramBruteForce();
        solver.leerDatos();
        solver.resuelve();
    }   
}
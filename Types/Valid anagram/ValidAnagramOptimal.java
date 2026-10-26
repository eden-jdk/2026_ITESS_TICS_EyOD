import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ValidAnagramOptimal {
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
        // Si las longitudes son distintas, no son anagramas
        if (s.length() != t.length()) {
            System.out.println("false");
            return;
        }

        int[] frecuencia = new int[26];

        // Recorremos ambas cadenas a la vez para contar frecuencias
        for (int i = 0; i < s.length(); i++) {
            frecuencia[s.charAt(i) - 'a']++;
            frecuencia[t.charAt(i) - 'a']--;
        }

        // Verificamos que todas las frecuencias sean cero
        boolean esAnagrama = true;
        for (int count : frecuencia) {
            if (count != 0) {
                esAnagrama = false;
                break;
            }
        }

        System.out.println(esAnagrama ? "true" : "false");
    }

    public static void main(String[] args) {
        ValidAnagramOptimal solver = new ValidAnagramOptimal();
        solver.leerDatos();
        solver.resuelve();
    }   
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IsSubsequenceOptimal {
    String s, t;
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
    }

    public void leerDatos() {
        s = reader.next(); // Cadena s a buscar
        t = reader.next(); // Cadena t base
    }

    public void resuelve() {
        int i = 0, j = 0;
        int n = s.length();
        int m = t.length();

        // Recorremos ambas cadenas con dos punteros O(m)
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        // Si i recorrió toda la cadena s, entonces s es subsecuencia de t
        if (i == n) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static void main(String[] args) {
        IsSubsequenceOptimal solver = new IsSubsequenceOptimal();
        solver.leerDatos();
        solver.resuelve();
    }   
}
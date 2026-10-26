import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IsSubsequenceBruteForce {
    String s, t;
    FastReader reader = new FastReader();
    boolean encontrado = false;

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

    // Fuerza bruta recursiva explorando todas las subsecuencias O(2^m)
    private void generarSubsecuencias(int index, String actual) {
        if (encontrado) return;
        if (actual.equals(s)) {
            encontrado = true;
            return;
        }
        if (index == t.length() || actual.length() > s.length()) {
            return;
        }

        // Opción 1: Incluir el carácter actual de t
        generarSubsecuencias(index + 1, actual + t.charAt(index));
        // Opción 2: No incluir el carácter actual de t
        generarSubsecuencias(index + 1, actual);
    }

    public void resuelve() {
        if (s.isEmpty()) {
            System.out.println("true");
            return;
        }
        generarSubsecuencias(0, "");
        System.out.println(encontrado ? "true" : "false");
    }

    public static void main(String[] args) {
        IsSubsequenceBruteForce solver = new IsSubsequenceBruteForce();
        solver.leerDatos();
        solver.resuelve();
    }   
}
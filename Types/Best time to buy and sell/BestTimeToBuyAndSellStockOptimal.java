import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BestTimeToBuyAndSellStockOptimal {
    int n;
    int[] prices;
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

        int nextInt() { 
            return Integer.parseInt(next()); 
        }
    }

    public void leerDatos() {
        n = reader.nextInt(); // Tamaño del arreglo (número de días)
        prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = reader.nextInt();
        }
    }

    public void resuelve() {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        // Recorrido lineal en O(n) actualizando el mínimo y la ganancia máxima
        for (int i = 0; i < n; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        System.out.println(maxProfit);
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockOptimal solver = new BestTimeToBuyAndSellStockOptimal();
        solver.leerDatos();
        solver.resuelve();
    }   
}
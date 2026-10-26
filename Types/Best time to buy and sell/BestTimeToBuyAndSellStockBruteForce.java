import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BestTimeToBuyAndSellStockBruteForce {
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
        int maxProfit = 0;

        // Fuerza bruta O(n^2): probar cada par de días (comprar en i, vender en j con j > i)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        System.out.println(maxProfit);
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockBruteForce solver = new BestTimeToBuyAndSellStockBruteForce();
        solver.leerDatos();
        solver.resuelve();
    }   
}
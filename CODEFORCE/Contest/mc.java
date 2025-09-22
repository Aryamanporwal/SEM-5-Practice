package CODEFORCE.Contest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class mc {

    static class DSU {
        int[] parent;

        public DSU(int n) {
            parent = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
        }

        // Finds the representative (root) of the set containing i, with path compression.
        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]);
        }

        // Merges the sets containing i and j.
        // Here it's used to mark a position as used by pointing it to the next one.
        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
            }
        }
    }

    /**
     * Solves a single test case.
     */
    public static void solve() {
        int n = fs.nextInt();
        int[] ans = new int[2 * n + 1];
        
        // DSU tracks available slots. Size is 2n+2 to have a sentinel at the end.
        // find(i) gives the next available slot at or after index i.
        DSU dsu = new DSU(2 * n + 2);

        // Place numbers greedily from n down to 1.
        for (int x = n; x >= 1; x--) {
            // Start searching for the first position 'p' from the beginning.
            int p = dsu.find(1);
            
            while (true) {
                // Calculate the position for the second occurrence.
                int q = p + x;
                
                // If q is out of bounds, we can't place x starting at p.
                if (q > 2 * n) {
                    // This block should ideally not be reached as a solution is guaranteed.
                    break;
                }
                
                // Find the root of q to check if it's available.
                int q_root = dsu.find(q);
                
                if (q_root == q) { // If q is available
                    ans[p] = x;
                    ans[q] = x;
                    
                    // Mark p and q as used by unioning them with the next index.
                    dsu.union(p, p + 1);
                    dsu.union(q, q + 1);
                    break; // Found a spot for x, move to the next number.
                } else {
                    // q is not available. The next candidate for p must be after the current one.
                    // The DSU lets us jump over the used slots efficiently.
                    p = dsu.find(p + 1);
                }
            }
        }

        // Print the result.
        PrintWriter out = new PrintWriter(System.out);
        for (int i = 1; i <= 2 * n; i++) {
            out.print(ans[i] + " ");
        }
        out.println();
        out.flush();
    }
    
    // Fast I/O infrastructure
    static FastScanner fs = new FastScanner();

    public static void main(String[] args) {
        int t = fs.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    // A class for faster input reading.
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
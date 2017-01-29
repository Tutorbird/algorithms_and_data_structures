import java.util.*;
import java.io.*;
import java.lang.Math;

public class tree_height {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeHeight {
		int n;
		int parent[];
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
		}

		int computeHeight() {
      int[] heights = new int[parent.length];
			int maxHeight = 0;
			
			for(int i = 0; i < parent.length; i++) {
				if (parent[i] != -1) {
					int height = 2;
					int temp = parent[i];
					while(parent[temp] != -1) {
						if(heights[temp] != 0) {
							height += heights[temp] - 1;
							break;
						} else {
							temp = parent[temp];
							height++;
						}
					}

					System.out.println(Arrays.toString(heights));
					heights[i] = height;
					maxHeight = Math.max(maxHeight, height);

				}
			}

			return maxHeight;
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}

import java.io.*;
import java.util.StringTokenizer;

class Thread {
    private int idx = 0;
    private long start = 0;
    public my_thread(int idx, long start) {

        this.idx = idx;
        this.start = start;
    }
    
    int getIndex(){
        return this.idx;
    }
    
    long getStartTime(){
        return this.start;
    }

}

public class JobQueue {
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] start_time;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + start_time[i]);
        }
    }

    private void assignJobs() {

        Comparator<my_thread> Order = new Comparator<my_thread>() {


            public int compare(Thread o1, Thread o2) {

                long o1_start = o1.getStartTime();
                long o2_start = o2.getStartTime();
                int o1_idx = o1.getIndex();
                int o2_idx = o2.getIndex();

                if(o1_start != o2_start){
                    return (int)(o1_start - o2_start);
                }

                else{
                    return o1_idx - o2_idx;
                }


            }
        };

        Queue<my_thread> priorityQueue = new PriorityQueue<my_thread>(numWorkers,Order);

        assignedWorker = new int[jobs.length];
        start_time = new long[jobs.length];

        for(int i =0 ;i<numWorkers;i++)
            priorityQueue.add(new my_thread(i,0));

        for (int i = 0; i < jobs.length; i++) {
            int duration = jobs[i];

            assignedWorker[i] = priorityQueue.peek().getIndex();
            start_time[i] = priorityQueue.peek().getStartTime();
            priorityQueue.poll();
            priorityQueue.add(new my_thread(assignedWorker[i], start_time[i] + duration));


        }
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}

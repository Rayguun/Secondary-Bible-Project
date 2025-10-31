public class Main {
    public static void main(String[] args) {
        long generation1 = 7700000000L;
        long generation2 = generation1 / 2;

        long yearCount = 0;
        long[] ageBuckets = new long[73]; 
        ageBuckets[18] = 13; 

        while (true) {
            yearCount = yearCount + 1;

            long[] newBuckets = new long[73];
            long newDisciples = 0;

            for (int age = 72; age >= 1; age--) {
                long count = ageBuckets[age - 1];

                newBuckets[age] = count;

                if (age >= 18 && age % 3 == 0) {
                    newDisciples += count * 2;
                }
            }

            newBuckets[18] += newDisciples;
            ageBuckets = newBuckets;

            long totalDisciples = 0;
            for (long count : ageBuckets) {
                totalDisciples += count;
            }

            System.out.println("Year " + yearCount + " - Total Disciples: " + totalDisciples);

            if (totalDisciples > generation1 && totalDisciples > generation2) {
                break;
            }
        }
    }
}
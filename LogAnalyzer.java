/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    private int[] people;
    private int[] vacant;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;
    
    /*
     * Question 1: The busiest times of the day are at 10am, 2pm and 6pm.
     * Question 4: 5 times: "private int[] hourCounts", "hourCounts = new int[24]","hourCounts[hour]++",
     *                      "for(int hour = 0; hour < hourCounts.length; hour++", "System.out.println
     *                       (hour + ": " + hourCounts[hour])"
     *                       A pair of square brackets is used with the variable 4 out of 5 times.
     * Question 5: []int counts; -> int[] counts;
     *             
     *             private boolean[] occupied;
     *                  occupied = new boolean[5000];
     * Question 6: double[] readings;
     *                  readings = new double[60];
     *             String[] urls;
     *                  urls = new Sring[90];
     *             TicketMachine[] machines;
     *                  machines = new TicketMachine[5];
     * Question 7: 0 String objects, it is only making an array capable of holding 20 Strings
     * Question 8: double[] prices = new double(50); -> double[]prices = new double[50];
     * Question 9: If we use "<=" instead of "<", it will give us n error because it surpasses the index.
     *             It goes to index 24 instead of staying at 23.
     */

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        int hour = 0;
        while(hour < hourCounts.length) {
            System.out.println(hour + ": " + hourCounts[hour]);
            hour++;
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
}

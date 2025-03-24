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
     * Question 17: The first hour that has the same value.
     */
    
    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer(String filename)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader(filename);
    }
    
    public int busiestHour()
    {
        int busiest = -1;
        int busiestHour = 0;
        
        for(int hour = 0; hour < hourCounts.length; hour++)
        {
            if (hourCounts[hour] > busiest)
            {
                busiest = hourCounts[hour];
                busiestHour = hour;
            }
        }
        
        return busiestHour;
    }
    
    public int quietestHour()
    {
        int quietest = -1;
        int quietestHour = 0;
        
        for(int hour = 0; hour < hourCounts.length; hour++)
        {
            if (hourCounts[hour] < quietest)
            {
                quietest = hourCounts[hour];
                quietestHour = hour;
            }
        }
        
        return quietestHour;
    }
    
    /**
     * Print all the values in the marks array that are greater than mean.
     * @param marks An array of marks values.
     * @param mean The mean (average) mark.
     */
    public void printGreater(double[] marks, double mean)
    {
        for(int index = 0; index < marks.length; index++)
        {
            if(marks[index] > mean)
            {
                System.out.println(marks[index]);
            }
        }
    }
    
    /**
     * Return the number of accesses recorded in the log file.
     */
    public int numberOfAcceses()
    {
        int total = 0;
        for (int hour = 0; hour < hourCounts.length; hour++)
        {
            total = total + hourCounts[hour];
        }
        //Add the value in each element of hourCounts to // total. ...
        return total;
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

public class Communities {
    

    // Racial Demographics
    static final int RD_BLACK              = 0;
    static final int RD_NATIVE_AMERICAN    = 1;
    static final int RD_ASIAN              = 2;
    static final int RD_NATIVE_HAWAIAN     = 3;
    static final int RD_TWO_OR_MORE        = 4;
    static final int RD_WHITE              = 5;
    static final int RD_HISP_OR_LATINO     = 6;
    static final int RD_OTHER              = 7;

    // Age
    static final int AGE_UNDER_10      = 8;
    static final int AGE_10_TO_64      = 9;
    static final int AGE_OVER_64       = 10;

    static final int TOTAL_POPULATION  = 11;

    // health
    static final int HLT_FLOOD_RISK    = 12;
    static final int HLT_FIRE_RIST     = 13;
    static final int HLT_PM2_5         = 14;
    static final int HLT_ASTHMA        = 15;
    static final int HLT_DIABETES      = 16;
    static final int HLT_HEART_DISEASE = 17;
    static final int HLT_LIFE_EXPECT   = 18;

    // economics
    static final int ECON_UNEMPLOYEMENT = 19;
    static final int ECON_LOW_INCOME    = 20;
    static final int ECON_DISADVANTAGED = 21;

    /*
     * ******* DO NOT EDIT ********
     * 
     * Reads a file and stores the data into a 2D array
     * of doubles in the same order that the data appear in
     * the file.
     * 
     * See the file format in the assignment description.
     * 
     * @return the data array containing the file's information.
     */
    public static double[][] readDataFromFile (String dataFile) {

        StdIn.setFile(dataFile);                        // opens the file to read
        String[] line = StdIn.readLine().split(","); 
        int nbrCommunities = Integer.parseInt(line[0]);
        
        // create the array to hold the data
        double[][] cData = new double[nbrCommunities][22];

        for ( int c = 0; c < nbrCommunities; c++ ) {

            // Each line contains the data for ONE community.
            // Reads one line, extracting each comma separated field.
            String[] oneCommunity = StdIn.readLine().split(","); 

            // Store the data into the array
            // racial demographics
            cData[c][RD_BLACK]           = Double.parseDouble(oneCommunity[RD_BLACK]);
            cData[c][RD_NATIVE_AMERICAN] = Double.parseDouble(oneCommunity[RD_NATIVE_AMERICAN]);
            cData[c][RD_ASIAN]           = Double.parseDouble(oneCommunity[RD_ASIAN]);
            cData[c][RD_NATIVE_HAWAIAN]  = Double.parseDouble(oneCommunity[RD_NATIVE_HAWAIAN]);
            cData[c][RD_TWO_OR_MORE]     = Double.parseDouble(oneCommunity[RD_TWO_OR_MORE]);
            cData[c][RD_WHITE]           = Double.parseDouble(oneCommunity[RD_WHITE]);
            cData[c][RD_HISP_OR_LATINO]  = Double.parseDouble(oneCommunity[RD_HISP_OR_LATINO]);
            cData[c][RD_OTHER]           = Double.parseDouble(oneCommunity[RD_OTHER]);

            // age
            cData[c][AGE_UNDER_10] = Double.parseDouble(oneCommunity[AGE_UNDER_10]);
            cData[c][AGE_10_TO_64] = Double.parseDouble(oneCommunity[AGE_10_TO_64]);
            cData[c][AGE_OVER_64]  = Double.parseDouble(oneCommunity[AGE_OVER_64]);

            cData[c][TOTAL_POPULATION] = Double.parseDouble(oneCommunity[TOTAL_POPULATION]);

            // health
            cData[c][HLT_FLOOD_RISK] = Double.parseDouble(oneCommunity[HLT_FLOOD_RISK]);
            cData[c][HLT_FIRE_RIST]  = Double.parseDouble(oneCommunity[HLT_FIRE_RIST]);
            cData[c][HLT_PM2_5]      = Double.parseDouble(oneCommunity[HLT_PM2_5]);
            cData[c][HLT_ASTHMA]      = Double.parseDouble(oneCommunity[HLT_ASTHMA]);
            cData[c][HLT_DIABETES]      = Double.parseDouble(oneCommunity[HLT_DIABETES]);
            cData[c][HLT_HEART_DISEASE] = Double.parseDouble(oneCommunity[HLT_HEART_DISEASE]);
            cData[c][HLT_LIFE_EXPECT]      = Double.parseDouble(oneCommunity[HLT_LIFE_EXPECT]);

            cData[c][ECON_UNEMPLOYEMENT] = Double.parseDouble(oneCommunity[ECON_UNEMPLOYEMENT]);
            cData[c][ECON_LOW_INCOME]    = Double.parseDouble(oneCommunity[ECON_LOW_INCOME]);
            cData[c][ECON_DISADVANTAGED] = Double.parseDouble(oneCommunity[ECON_DISADVANTAGED]);
        }
        return cData;
    }

    public static double getPM25Level(double[][] data, int community) 
    {
        return data[community][HLT_PM2_5];
    }

    public static double findAverageLifeExpectancy(double[][] data) 
    {
        
        double nums = 0;
        for(int i = 0; i < data.length; i++)
         {
            nums += data[i][HLT_LIFE_EXPECT];
         }
        return nums / data.length;
    }    
    public static double highestPopulationWithHealthIssue (double[][] data, char healthIssue) 
    {

        double high = 0;
        int index = switch (healthIssue) 
        {
            case 'A' -> HLT_ASTHMA;
            case 'D' -> HLT_DIABETES;
            case 'H' -> HLT_HEART_DISEASE;
            default -> -1;
        };

        for(double[] community : data)
         {
            if (community[index] > high) 
            {
                high = community[index];
            }
        }
        return high;
    }

    public static int numberOfCommunities (double[][] data, int columnIndex, double percentageThreshold, boolean isDisadvantage) 
    {
        int count = 0; 
        int test = 4;
        for(double[] community : data) 
        {
            if ((community[columnIndex] >= percentageThreshold / 100) && (!isDisadvantage || (community[ECON_DISADVANTAGED] == 1))) 
            {
                count++;
                test++;
            }
        }
        return count;
    }
    public static double largestRacialDemographic(double[][] data, int community) 
    {

        double big = 0;
        for(int i = 0; i <= RD_OTHER; i++) 
        { 
            if (data[community][i] > big) 
            {
                big = data[community][i];
            }
        }
        return big * 100; // This is  to make it a percentage
    }


    public static int mostPopulatedDisadvantagedWithLowIncome(double[][] data) 
    {
        int index = -1;
        double largestPopulation = 0;
        for(int i = 0; i < data.length; i++) 
        {
            if (data[i][ECON_LOW_INCOME] == 1 && data[i][ECON_DISADVANTAGED] == 1 && data[i][TOTAL_POPULATION] > largestPopulation) 
            {
                largestPopulation = data[i][TOTAL_POPULATION];
                index = i;
            }
        }
        return index;
    }
    public static void main (String[] args) {

        double[][] data = readDataFromFile("SampleCommunitiesData.csv");
        
        int community = 12;

        StdOut.printf("\nPM 2.5 Level (community %d): %.2f\n", community, getPM25Level(data, community));
        StdOut.printf("Avg Life expectancy: %.2f years\n", findAverageLifeExpectancy(data));

        StdOut.printf("Community with higest cases of heart disease: %.0f cases\n", highestPopulationWithHealthIssue(data, 'H'));
        StdOut.printf("Community with higest cases of diabetes: %.0f cases\n", highestPopulationWithHealthIssue(data, 'D'));  
        StdOut.printf("Community with higest cases of asthma: %.0f cases\n", highestPopulationWithHealthIssue(data, 'A'));  

        StdOut.printf("Number of communities: %d\n", numberOfCommunities(data, RD_BLACK, 10, false));

        community = 4;
        StdOut.printf("Largest demographic (community %d): %.2f percent\n",community, largestRacialDemographic(data, community));

        StdOut.printf("Most populated community with low income: %d\n", mostPopulatedDisadvantagedWithLowIncome(data));
    }
}

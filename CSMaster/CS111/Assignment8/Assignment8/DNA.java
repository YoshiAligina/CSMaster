import java.util.ArrayList;

/**
 * DNA is the carrier of genetic information of living things and
 * has many applications in today's age.
 * What are some of these applications?
 * We can use DNA to tell us useful information about offspring's parentage
 * and relatives.
 * 
 * DNA is made up of a sequence of protein molecules called nucleotides.
 * Some portions are the same for all humans and some are more distinct based on parentage.
 * 
 * To identify parents and relatives we can look at STRs (Short Tandem Repeats)
 * within the DNA sequence.
 * STRs are short DNA segments that repeat back-to-back in DNA squences numerous times.
 * 
 * ex. AGATAGATAGATACGTACGT Here you see the STR called AGAT repeated 3
 * times following by the STR called ACGT repeated twice.
 * 
 * By using multiple STRs we can find more specific information.
 * 
 * @author Seth Kelley
 * @author Aastha Gandhi
 */

public class DNA {

    // These two instance variables are initialized and populated by 
    // createDatabaseOfProfiles() and readSTRsOfInterest()
    private Profile[] database;       // Holds all of the profile objects.
    private String[]  STRsOfInterest; // Holds all of the STRs as Strings we are interested in looking for.
                                      // These STRs are going to be used to process the DNA of everyone in the database.

    /**
     * Initialize the array of Profile objects and the STRs of interest.
     * 
     * @param databaseFile The file containing all of the names and their DNA sequences
     * @param strsFile     The file with all the STRs of interest
     */
    public DNA (String databaseFile, String STRsFile) {

        /*** DO NOT EDIT ***/
        createDatabaseOfProfiles(databaseFile); // Calls createDatabase method to initialize the database array
        readSTRsOfInterest(STRsFile);           // Calls readAllSTRs method to initialize the allSTRs array
    }

    /**
     * Creates and populates the database array with profiles from input file, filename.
     * 
     * Each profile includes a persons' name and two DNA sequences.
     *
     * Input file format:
     *  - 1 line containing an integer, p, with the number of profiles/people in the file
     *  - for each p profile in the file:
     *      - 1 line containing the person’s name
     *      - 1 line containing the first sequence of STRs that comes from one parent
     *      - 1 line containing the second sequence of STRs that comes from the other parent
     *
     * Approach:
     *  1. Create the database array to hold the profiles (don’t forget about the instance variables)
     *  2. Read the number of profiles from the input file
     *  3. Read the profile information from the input file
     *  4. for each person in the file:
     *      a. creates a Profile object with the information from file (see input file format below)
     *      b. insert the newly created profile into the next position in the database array
     *
     * You can use StdIn.readInt() to read 1 (one) integer from the file.
     * You can use StdIn.readString() to read 1 (one) String from the file.
     * StdIn.setFile() opens the file filename for reading.
     * 
     * 
     * @param filename The input file containing the person's name and DNA sequences
     */
    public void createDatabaseOfProfiles (String filename) {

        StdIn.setFile(filename); // DO NOT remove this line, keep it as the first line in the method.
        int files = StdIn.readInt();
        database = new Profile[files];

        for (int i = 0; i < files; i++) 
        {
            String name = StdIn.readString();
            String sequence1 = StdIn.readString();
            String sequence2 = StdIn.readString();
            database[i] = new Profile(name, null, null, sequence1, sequence2); // STRs are set to null initially
        }


    }

    /**
     * Creates and populates the STRsOfInterest array with STRs from the input file, filename.
     * 
     * Input file format:
     *  - 1 line containing an integer, s, with the number of STRs in the file
     *  - for each s in the file:
     *      - 1 line containing the STR
     * 
     * Approach:
     *  1. Create the STRsOfInterest array to hold the STRs (don't forget about the instance variable)
     *  2. Read the number of STRs from the input
     *  3. for each STR in the file:
     *      a. insert into STRsOfInterest array
     *
     * You can use StdIn.readInt() to read 1 (one) integer from the file.
     * You can use StdIn.readString() to read 1 (one) String from the file.
     * StdIn.setFile() opens the file filename for reading.
     * 
     * 
     * @param filename The input file containing all the STRs
     */
    public void readSTRsOfInterest (String filename) {

        StdIn.setFile(filename); // DO NOT remove this line, keep as the first line in the method.
        int numSTRs = StdIn.readInt();
        STRsOfInterest = new String[numSTRs];

        for (int i = 0; i < numSTRs; i++) 
        {
            STRsOfInterest[i] = StdIn.readString();
        }

    }

    /**
     * Creates and return the profile for the unknown DNA sequence from the input file, filename.
     * 
     * Input file format:
     *  - first line containing a DNA sequence
     *  - second line containing a DNA sequence
     * 
     * Approach:
     *  1. Set the profile name to "Unknown" because they are currently unknown
     *  2. Set the S1_STRs and S2_STRs to NULL
     *  3. Set sequence1 to the first line of the file
     *  4. Set sequence2 to the second line of the file
     *  5. Return the Profile object
     * 
     * 
     * @param filename The input file for the unknown DNA sequence
     * @return         Returns a Profile object for the unknown DNA sequence
     */
    public Profile createUnknownProfile (String filename) {

        StdIn.setFile(filename); // DO NOT remove this line, keep as the first line in the method.
        String sequence1 = StdIn.readString();
        String sequence2 = StdIn.readString();
        return new Profile("Unknown", null, null, sequence1, sequence2);

    }

    /**
     * Given a DNA sequence and a singular STR,
     * this method finds the longest number of consecutive repeats that STR appears
     * in the sequence and then returns an STR object with:
     *      - the STR name
     *      - longest number of consecutive repeats.
     * 
     * Approach:
     *  1. Set new STR with parameters STR and 0 as numberOfRepeats
     *  2. Check if the STR is longer than the sequence
     *  3. Traverse through the sequence checking for repeating STRs
     *  4. Return the STR object
     * 
     * 
     * @param sequence The DNA sequence (String) to be looked at
     * @param STR      The STR (String) to look for in the DNA sequence
     * @return         The STR object with the name and longest number of repeats
     */
    public STR findSTRInSequence (String sequence,String STR ) {
        int maxCount = 0;
        int currentCount = 0;
        int index = 0;

        while ((index = sequence.indexOf(STR, index)) != -1) 
        {
            currentCount = 0;
            while (sequence.startsWith(STR, index)) 
            {
                currentCount++;
                index += STR.length();
            }
            maxCount = Math.max(maxCount, currentCount);
        }

        return new STR(STR, maxCount);
    }

    /**
     * Takes a profile and String[] and populates then adds the STRs[] to the profile.
     * 
     * Approach:
     *  1. Populate some new S1_STRs and S2_STRs arrays by traversing the allSTR[]
     *  2. Use setter method to set S1_STR and S2_STR to profile
     * 
     * NOTE: use the findSTRInSequence method
     * 
     * @param profile The profile of the that the method will compute the STRs array for
     * @param allSTRs The list of STRs to be looked for in the profiles DNA sequences
     */
    public void createProfileSTRs ( Profile profile, String[] allSTRs ) {

        STR[] S1_STRs = new STR[allSTRs.length];
        STR[] S2_STRs = new STR[allSTRs.length];

        for (int i = 0; i < allSTRs.length; i++) 
        {
            S1_STRs[i] = findSTRInSequence(profile.getSequence1(), allSTRs[i]);
            S2_STRs[i] = findSTRInSequence(profile.getSequence2(), allSTRs[i]);
        }

        profile.setS1_STRs(S1_STRs);
        profile.setS2_STRs(S2_STRs);
    }

    /**
     * Creates and updates the STRs for each profile in the database.
     * 
     * Approach:
     *  1. Similar strategy used in createDatabaseOfProfiles and readAllSTRsOfInterest methods
     * 
     * NOTEL use the createProfileSTRs method
     */
    public void createDatabaseSTRs() {

        for (Profile profile : database) {
            createProfileSTRs(profile, STRsOfInterest);
        }
    }

    /**
     * Compares two STR arrays to determines if they are identical.
     * 
     * Two STR arrays are identical if for every i in the array, the objects 
     * at s1[i] and s2[i] contain the same information. 
     *      - s1[0] matches s2[0], and
     *      - s1[1] matches s2[1], and so on
     * 
     * Approach:
     *  1. Check if s1[0] is identical to (matches) s2[0]
     *  2. Check if s1[1] is identical to (matches) s2[1] etc etc
     * 
     * NOTE: Assume s1 and s2 are the same length.
     * 
     * @param s1 STR array from one profile.
     * @param s2 STR array from another profile.
     * @return Returns true if the objects in the arrays are a complete match, otherwise false
     */
    public boolean identicalSTRs ( STR[] s1, STR[] s2 )
    {
        if (s1.length != s2.length) 
        {
            return false;
        }

        for (int i = 0; i < s1.length; i++) 
        {
            if (!s1[i].equals(s2[i]))
             {
                return false;
            }
        }

        return true;
    }

    /**
     * Searches through the database for profiles whose S1 matches the unknownProfilesS1_STRs
     * 
     * Approach:
     *  1. Initalize an ArrayList
     *  2. for each profile in the database whose sequence1 matches unknownProfilesS1_STRs:
     *      a. add to ArrayList
     *  3. Return the ArrayList
     * 
     * NOTE: use identicalSTRs() to compare two profiles
     * 
     * @param unknownProfileS1_STRs The sequence1 STRs of the person the method is searching for.
     * @return                      Returns an ArrayList with all matching profile(s). It will return 
     *                              an empty ArrayList if no match is found.
     */
    public ArrayList<Profile> findMatchingProfiles ( STR[] unknownProfileS1_STRs )
     {
        ArrayList<Profile> matched = new ArrayList<>();

        for (Profile profile : database)
         {
            if (identicalSTRs(profile.getS1_STRs(), unknownProfileS1_STRs))
             {
                matched.add(profile);
            }
        }

        return matched;
    }

    /**
     * A punnet square is a simple way of discovering all of the potential combinations of 
     * genotypes that can occur in children, given the genotypes of their parents.
     * 
     * This method acts as a punnet square checker to check if all the STRs in 
     * the array match between the parents and offspring for any one square in the
     * punnet square.
     * 
     * This method used in the findPossibleParents method. 
     *
     * @param firstParent                The STRs of one parent
     * @param inheritedFromFirstParent   The one pairing of STRs for the offspring
     * @param secondParent               The STRs of the other parent
     * @param inheritedFromSecondParent  The second pairing of STRs for the offspring
     * @return Returns true if:
     *           - the STRs from the first parent matches the offspring STRs inherited from the first parent.
     *           AND
     *          - the STRs from the second parent matches the offspring STRs inherited from the second parent.
     */
    public boolean punnetSquare(STR[] firstParent,  STR[] inheritedFromFirstParent, 
                                STR[] secondParent, STR[] inheritedFromSecondParent) {

        /* DO NOT EDIT */

        for ( int i = 0; i < firstParent.length; i++ ) {

            if (!(firstParent[i].equals(inheritedFromFirstParent[i]) && secondParent[i].equals(inheritedFromSecondParent[i]))) {
                return false; // Returns false if there is a discrepency
            }
        }
        return true; 
    }

    /**
     * Looks at the STR sequences of any given person and tries to find the
     * potential relatives (parents) of that person based on their STR sequences.
     * 
     * This method is already written for you but DOES NOT WORK AS INTENDED!!
     * YOU MUST FIX THE CODE
     * 
     * @param S1_STRs  The first list of STRs contained by the offspring that one
     *                 parent passed down
     * @param S2_STRs  The second list of STRs contained by the offspring that the
     *                 other parent passed down
     * @return         Returns the array of profiles that are related
     */
    public ArrayList<Profile> findPossibleParents(STR[] S1_STRs, STR[] S2_STRs) {
        ArrayList<Profile> possibleParent1 = new ArrayList<>();
        ArrayList<Profile> possibleParent2 = new ArrayList<>();
    

        for (Profile profile : database) 
        {
            if (identicalSTRs(profile.getS1_STRs(), S1_STRs))
             {
                possibleParent1.add(profile);
            }
            if (identicalSTRs(profile.getS2_STRs(), S2_STRs)) 
            {
                possibleParent2.add(profile);
            }
        }
    
        ArrayList<Profile> parentList = new ArrayList<>();

        for (Profile parent1 : possibleParent1) 
        {
            for (Profile parent2 : possibleParent2) 
            {
                if (!parent1.equals(parent2)) 
                { 
                    if (punnetSquare(parent1.getS1_STRs(), S1_STRs, parent2.getS2_STRs(), S2_STRs))
                     {
                        parentList.add(parent1);
                        parentList.add(parent2);
                    } 
                    else if (punnetSquare(parent1.getS2_STRs(), S2_STRs, parent2.getS1_STRs(), S1_STRs)) 
                    {
                        parentList.add(parent1);
                        parentList.add(parent2);
                    }
                }
            }
        }
    
        return parentList;
    }

    /**
     * Getter for the database/profiles instance variable
     * 
     * @return The database instance variable
     */
    public Profile[] getDatabase() {

        /* DO NOT EDIT */
        return database;
    }

    /**
     * Getter for allSTRs instance variable
     * 
     * @return The allSTRs instance variable
     */
    public String[] getSTRsOfInterest() {

        /* DO NOT EDIT */
        return STRsOfInterest;
    }
}
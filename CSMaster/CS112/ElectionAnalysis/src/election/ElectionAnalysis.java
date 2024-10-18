package election;

/* 
 * Election Analysis class which parses past election data for the house/senate
 * in csv format, and implements methods which can return information about candidates
 * and nationwide election results. 
 * 
 * It stores the election data by year, state, then election using nested linked structures.
 * 
 * The years field is a Singly linked list of YearNodes.
 * 
 * Each YearNode has a states Circularly linked list of StateNodes
 * 
 * Each StateNode has its own singly linked list of ElectionNodes, which are elections
 * that occured in that state, in that year.
 * 
 * This structure allows information about elections to be stored, by year and state.
 * 
 * @author Colin Sullivan
 */
public class ElectionAnalysis {
    private YearNode years;
    public YearNode years() {
        return years;
    }
    /*
     * Read through the lines in the given elections CSV file
     * 
     * Loop Though lines with StdIn.hasNextLine()
     * 
     * Split each line with:
     * String[] split = StdIn.readLine().split(",");
     * Then access the Year Name with split[4]
     * 
     * For each year you read, search the years Linked List
     * -If it is null, insert a new YearNode with the read year
     * -If you find the target year, skip (since it's already inserted)
     * 
     * If you don't find the read year:
     * -Insert a new YearNode at the end of the years list with the corresponding year.
     * 
     * @param file String filename to parse, in csv format.
     */
    public void readYears(String file) { // chat ive been doing this for like 40 hours...
      StdIn.setFile(file); // Set the file to read from
      while (StdIn.hasNextLine())
       {
          String[] split = StdIn.readLine().split(","); // Split the line by commas to get the year
          int year = Integer.parseInt(split[4]);
          if (years == null) { // If the years list is empty, insert the first year
            years = new YearNode(year); // Create a new year node
        } 
        else // If the years list isn't empty
        {
            YearNode newYear = years; // Start at the head of the years list
            while (newYear.getNext() != null) 
            { // Loop through the years list
                if (newYear.getYear() == year) 
                {
                    break; // Year already exists
                }
                newYear = newYear.getNext(); // Move to the next year
            }
            if (newYear.getYear() != year) 
            { // If the year doesn't exist, insert it
                newYear.setNext(new YearNode(year));
            }}}}
    /*
     * Read through the lines in the given elections CSV file
     * 
     * Loop Though lines with StdIn.hasNextLine()
     * 
     * Split each line with:
     * String[] split = StdIn.readLine().split(",");
     * Then access the State Name with split[1] and the year with split[4]
     * 
     * For each line you read, search the years Linked List for the given year.
     * 
     * In that year, search the states list. If the target state exists, continue
     * onto the next csv line. Else, insert a new state node at the END of that year's
     * states list (aka that years "states" reference will now point to that new node).
     * Remember the states list is circularly linked.
     * 
     * @param file String filename to parse, in csv format.
     */
    public void readStates(String file) {
      StdIn.setFile(file);
      while (StdIn.hasNextLine()) 
      { // Loop through the lines in the file
          String[] split = StdIn.readLine().split(",");
          int year = Integer.parseInt(split[4]);
          String state = split[1].trim();  // don't need, can scrap <3
          YearNode yearNode = years;// Start at the head of the years list
          while (yearNode != null && yearNode.getYear() != year) 
          { // Find the year node
              yearNode = yearNode.getNext(); // Move to the next year
          }   
          if (yearNode != null) 
          {
              StateNode tail = yearNode.getStates();   // Find the tail of the states list
              boolean found = false;
              if (tail != null)
               { // If the states list isn't empty
                  StateNode newState = tail.getNext();  
                  do {
                      if (newState.getStateName().equalsIgnoreCase(state)) 
                      { // Check if the state already exists
                          found = true; // If it does, break
                          break;
                      }
                      newState = newState.getNext(); // Move to the next state
                  } while (newState != tail.getNext());  // Loop until we reach the tail again
              }
              if (!found) // If the state doesn't exist then what 
              {
                  StateNode newState = new StateNode(state, null);  // Create new state node.
                    System.out.print(state);
                  if (tail == null) 
                  { // If the states list is empty, insert the new state
                      newState.setNext(newState); 
                      yearNode.setStates(newState); // erm what the sigma
                  } 
                  else
                  { //else insert the new state at the end of the list
                      newState.setNext(tail.getNext());  
                      tail.setNext(newState); 
                      yearNode.setStates(newState);  
                  }}}}}
    /*
     * Read in Elections from a given CSV file, and insert them in the
     * correct states list, inside the correct year node.
     * 
     * Each election has a unique ID, so multiple people (lines) can be inserted
     * into the same ElectionNode in a single year & state.
     * 
     * Before we insert the candidate, we should check that they dont exist already.
     * If they do exist, instead modify their information new data.
     * 
     * The ElectionNode class contains addCandidate() and modifyCandidate() methods for you to use.
     * 
     * @param file String filename of CSV to read from
     */
    public void readElections(String file) {
      StdIn.setFile(file);
      while (StdIn.hasNextLine()) 
      { // Loop through the lines in the file

        String[] split = StdIn.readLine().split(",");
        int year = Integer.parseInt(split[4]);
        String state = split[1];
        int raceID = Integer.parseInt(split[0]);
        boolean senate = split[3].equals("U.S. Senate");
        String canName = split[5];
        String party = split[6];
        int votes = Integer.parseInt(split[7]);
        boolean winner = split[8].equalsIgnoreCase("true");
        int officeID = Integer.parseInt(split[2]);

        YearNode yearNode = years; // Start at the head of the years list
        while (yearNode != null && yearNode.getYear() != year) 
        { // Find the year node
            yearNode = yearNode.getNext();
        }
        if (yearNode != null)
         { // If the year node exists then find the state node
            StateNode stateNode = yearNode.getStates();
            StateNode start = stateNode; 
            do { // Loop through the states list
                if (stateNode.getStateName().equals(state)) 
                { // Find the state node
                    break; // If the state node exists, break
                }
                stateNode = stateNode.getNext();
            } while (stateNode != start);  // Loop until we reach the start again
            if (stateNode != null)
             {
                if (stateNode.getElections() == null) 
                { // If the elections list is empty, insert the new election
                    ElectionNode newElection = new ElectionNode(
                        raceID, senate, officeID, new int[0], new String[0], -1, null // Create a new election node
                    );
                    newElection.addCandidate(canName, votes, party, winner);
                    stateNode.setElections(newElection);
                } 
                else 
                {
                    ElectionNode election = stateNode.getElections();
                    ElectionNode electionFinal = null; // Track the last election node

                    while (election != null && election.getRaceID() != raceID)
                    { // chat is this real.
                        electionFinal = election;
                        election = election.getNext();
                    }
                    if (election != null) 
                    {
                        // Check if the candidate  exists
                        if (election.isCandidate(canName)) 
                        {
                            election.modifyCandidate(canName, votes, party); // If they do, modify their information
                        } 
                        else 
                        {
                            election.addCandidate(canName, votes, party, winner); // If they don't, add them to the election
                        }
                    } 
                    else
                    {
                        ElectionNode newElection = new ElectionNode(
                            raceID, senate, officeID, new int[0], new String[0], -1, null // Create a new election node
                        );
                        newElection.addCandidate(canName, votes, party, winner);
                        if (electionFinal != null) 
                        {
                            electionFinal.setNext(newElection);  // Insert the new election at the end of the list
                        }
                        else 
                        { 
                            // erm.... I'm not sure what to do here .. fingers crossed i guess <3
                        }}}}}}}
    /*
     * DO NOT EDIT
     * 
     * Calls the next method to get the difference in voter turnout between two
     * years
     * 
     * @param int firstYear First year to track
     * 
     * @param int secondYear Second year to track
     * 
     * @param String state State name to track elections in
     * 
     * @return int Change in voter turnout between two years in that state
     */
    public int changeInTurnout(int firstYear, int secondYear, String state) {
        // DO NOT EDIT
        int last = totalVotes(firstYear, state);
        int first = totalVotes(secondYear, state);
        return last - first;
    }
    /*
     * Given a state name, find the total number of votes cast
     * in all elections in that state in the given year and return that number
     * 
     * If no elections occured in that state in that year, return 0
     * 
     * Use the ElectionNode method getVotes() to get the total votes for any single
     * election
     * 
     * @param year The year to track votes in
     * 
     * @param stateName The state to track votes for
     * 
     * @return avg number of votes this state in this year
     */
    public int totalVotes(int year, String stateName) { // if this is wrong, I'm going to cry
      YearNode yearNode = years;
      while (yearNode != null) // idk this has put me off of voting
       {
          if (yearNode.getYear() == year) 
          { // Find the year node
              break;
          }
          yearNode = yearNode.getNext(); // Move to the next year
      }
      if (yearNode == null) // I'm going to cry
      {
          return 0; // If the year node doesn't exist, return 0
      }
      StateNode stateNode = yearNode.getStates(); // Find the state node
      do {
          if (stateNode.getStateName().equalsIgnoreCase(stateName)) 
          {
              break; // If the state node exists, break
          }
          stateNode = stateNode.getNext();
      } while (stateNode != yearNode.getStates()); // Loop until we reach the start again
      if (stateNode == null) 
      {
          return 0;
      }
      int totalVotes = 0;
      ElectionNode election = stateNode.getElections(); // Find the election node
      while (election != null) // am i cooked?
      { // Loop through the elections list
          totalVotes += election.getVotes();  // Add the votes from each election
          election = election.getNext();
      }
      return totalVotes; // Return the total votes
  }
    /*
     * Given a state name and a year, find the average number of votes in that
     * state's elections in the given year
     * 
     * @param year The year to track votes in
     * 
     * @param stateName The state to track votes for
     * 
     * @return avg number of votes this state in this year
     */
    public int averageVotes(int year, String stateName) {
      YearNode yearNode = years;
      while (yearNode != null) 
      {
        if (yearNode.getYear() == year) 
        {
            break; // Find the year node
        }
        yearNode = yearNode.getNext();
      }
      if (yearNode == null) 
      { // If the year node doesn't exist, return 0
          return 0;
      }
      StateNode stateNode = yearNode.getStates();
      do { // Find the state node
          if (stateNode.getStateName().equalsIgnoreCase(stateName)) 
          { // If the state node exists, then break
              break;
          }
          stateNode = stateNode.getNext();
      } while (stateNode != yearNode.getStates()); // Loop until we reach the start again
      if (stateNode == null) 
      {
          return 0; 
      }
      int totalVotes = 0;
      int electionCount = 0; // Track the number of elections
      ElectionNode election = stateNode.getElections();
      while (election != null) 
      { // Loop through the elections list
          totalVotes += election.getVotes(); 
          electionCount++;
          election = election.getNext(); // Move to the next election
          // System.out.println(electionCount);
      }
      if (electionCount == 0) 
      {
          return 0; 
      }
      return totalVotes / electionCount; // Return the average votes
  }
    /*
     * Given a candidate name, return the party they most recently ran with
     * 
     * Search each year node for elections with the given candidate
     * name. Update that party each time you see the candidates name and
     * return the party they most recently ran with
     * 
     * @param candidateName name to find
     * 
     * @return String party abbreviation
     */
    public String candidatesParty(String candidateName) {
      String latestParty = null; // Track the latest party
      YearNode yearNode = years; 
      while (yearNode != null) 
      {
          StateNode stateNode = yearNode.getStates(); // Find the state node
          if (stateNode != null) 
          { 
              StateNode head = stateNode; 
              do {
                  ElectionNode election = stateNode.getElections(); 
                  while (election != null) 
                  {
                      if (election.isCandidate(candidateName)) 
                      {  // Check if the candidate exists
                        latestParty = election.getParty(candidateName);
                      }
                      election = election.getNext(); // Move to the next election
                  }
                  stateNode = stateNode.getNext(); 
              } while (stateNode != head); // Loop until we reach the start again
          }
          yearNode = yearNode.getNext(); //screaming crying sobbing 
      }  
      return latestParty != null ? latestParty : null; // Return the latest party
  }}  
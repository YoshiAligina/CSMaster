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

    // Reference to the front of the Years SLL
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
    public void readYears(String file) {
      StdIn.setFile(file);
      while (StdIn.hasNextLine())  // This will read the file line by line.
      {
          String[] split = StdIn.readLine().split(","); // This will split the line by commas.
          int year = Integer.parseInt(split[4]); // This will get the year from the line and set it to year. 
          
          if (years == null) 
          {
              years = new YearNode(year); // This will insert a new YearNode with the year if years is null.
          } 
          else 
          {
              YearNode current = years;
              while (current.getNext() != null && current.getYear() != year) // This will loop through the years list until it finds the year or reaches the end.
              {
                  current = current.getNext();
              }
              if (current.getYear() != year) // This will insert a new YearNode at the end of the years list with the corresponding year if the year is not found.
              {
                  current.setNext(new YearNode(year));
              }
          }
      }
  }

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
      while (StdIn.hasNextLine())  // This will read the file line by line.
      {
        String[] split = StdIn.readLine().split(","); // This will split the line by commas.
        String stateName = split[1]; // This will get the state name from the line.
        int year = Integer.parseInt(split[4]); // This will get the year from the line and set it to year. 
        
        YearNode yearNode = years;
        while (yearNode != null && yearNode.getYear() != year) // This will loop through the years list until it finds the year or reaches the end.
         {
            yearNode = yearNode.getNext();
        }
        
        if (yearNode != null) 
        { //chat is this real ...
            if (yearNode.getStates() == null)
             {
                yearNode.setStates(new StateNode(stateName, null)); // This will insert a new StateNode with the state name if the states list is null.
            } else {
                StateNode current = yearNode.getStates();
                do {
                    if (current.getStateName().equals(stateName))
                     {
                        break;
                    }
                    if (current.getNext() == yearNode.getStates()) 
                    {
                        current.setNext(new StateNode(stateName, null)); // This will insert a new StateNode at the end of the states list with the state name if the state is not found.
                        current.getNext().setNext(yearNode.getStates());
                        break;
                    }
                    current = current.getNext();
                } 
                while (current != yearNode.getStates());
            }
        }
    }
}

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
      {
        String[] split = StdIn.readLine().split(",");
        int raceId = Integer.parseInt(split[0]);
        String stateAbbrev = split[1];
        int year = Integer.parseInt(split[4]);
        String candidateName = split[5];
        String ballotParty = split[6];
        int votes = Integer.parseInt(split[7]);
        boolean isWinner = Boolean.parseBoolean(split[8]); // This initialises a bunch of stuff !!!! 

        YearNode yearNode = years;
        while (yearNode != null && yearNode.getYear() != year) 
        {
          yearNode = yearNode.getNext(); // This will loop through the years list until it finds the year or reaches the end.
        }
        if (yearNode != null) 
        {
          // Find the correct StateNode
          StateNode stateNode = yearNode.getStates(); // This will get the states list for the year.
          if (stateNode != null) 
          {
            do 
            {
              if (stateNode.getStateName().equals(stateAbbrev))
              {
                break; // This will break the loop if the state is found.
              }
              stateNode = stateNode.getNext(); // This will loop through the states list until it finds the state or reaches the end.
            } 
            while (stateNode != yearNode.getStates());

            if (stateNode != null && stateNode.getStateName().equals(stateAbbrev)) 
            {
              ElectionNode electionNode = stateNode.getElections();
              ElectionNode previousElection = null;
              while (electionNode != null && electionNode.getRaceID() != raceId) // This will loop through the elections list until it finds the election or reaches the end.
              {
                previousElection = electionNode;
                electionNode = electionNode.getNext();
              }

              if (electionNode == null) 
              {
                electionNode = new ElectionNode(raceId, isWinner, votes, null, split, votes, previousElection); // This will create a new ElectionNode if it doesn't exist.
                if (previousElection == null) 
                {
                  stateNode.setElections(electionNode); // This will set the election to the new election if the previous election is null.
                } 
                else 
                {
                  previousElection.setNext(electionNode); // This will set the next election to the new election if the previous election is not null.
                }
              }
              electionNode.addCandidate(candidateName, votes, ballotParty, isWinner); // This will add the candidate to the election.
            }
          }
        }
      }
    }
        
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
    public int totalVotes(int year, String stateName) {
      YearNode yearNode = years;
      while (yearNode != null && yearNode.getYear() != year) 
      {
          yearNode = yearNode.getNext(); // This will loop through the years list until it finds the year or reaches the end.
      }
      
      if (yearNode == null) 
      {
          return 0; // This will return 0 if the year is not found.
      }
      StateNode stateNode = yearNode.getStates();
      if (stateNode != null)
       {
          do { // This will loop through the states list until it finds the state or reaches the end.
              if (stateNode.getStateName().equals(stateName)) 
              {
                  break;
              }
              stateNode = stateNode.getNext();
          } while (stateNode != yearNode.getStates()); // This will loop through the states list until it finds the state or reaches the end.
          
          if (stateNode != null && stateNode.getStateName().equals(stateName)) // This will return the total votes for the state if the state is found.
          {
              int totalVotes = 0;
              ElectionNode election = stateNode.getElections();
              while (election != null)  // This will loop through the elections list until it reaches the end.
              {
                  totalVotes += election.getVotes(); // This will add the votes from the election to the total votes.
                  election = election.getNext(); // This will move to the next election.
              }
              return totalVotes; // This will return the total votes for the state.
          }
      }
      return 0; // This will return 0 if the state is not found.
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
      while (yearNode != null && yearNode.getYear() != year) 
      {
          yearNode = yearNode.getNext(); // This will loop through the years list until it finds the year or reaches the end.
      }
      if (yearNode == null) 
      {
          return 0; // This will return 0 if the year is not found.
      }
      StateNode stateNode = yearNode.getStates();
      if (stateNode != null)
       {
          do
           {
              if (stateNode.getStateName().equals(stateName)) 
              {
                  break; // This will break the loop if the state is found.
              }
              stateNode = stateNode.getNext();
          } 
          while (stateNode != yearNode.getStates());
          
          if (stateNode != null && stateNode.getStateName().equals(stateName)) // This will return the average votes for the state if the state is found.
          {
              int totalVotes = 0;
              int electionCount = 0;
              ElectionNode election = stateNode.getElections(); // This will get the elections list for the state.
              while (election != null) // This will loop through the elections list until it reaches the end.
              {
                  totalVotes += election.getVotes();
                  electionCount++;
                  election = election.getNext(); // This will move to the next election.
              } // This will add the votes from the election to the total votes and increment the election count.
              return electionCount > 0 ? totalVotes / electionCount : 0; // This will return the average votes for the state.
          }
      }
      return 0; 
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
      YearNode yearNode = years;
      String recentParty = null;
      return recentParty;
    }
}
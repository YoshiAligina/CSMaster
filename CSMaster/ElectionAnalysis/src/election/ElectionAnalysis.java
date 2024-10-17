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
    public void readYears(String file) {
      StdIn.setFile(file);
      while (StdIn.hasNextLine()){   // This will read the file line by line.
          String[] split = StdIn.readLine().split(","); // This will split the line by commas.
          int year = Integer.parseInt(split[4]); // This will get the year from the line and set it to year. 
          
          if (years == null) {
              years = new YearNode(year); // This will insert a new YearNode with the year if years is null.
          } 
          else {
              YearNode current = years;
              while (current.getNext() != null && current.getYear() != year){  // This will loop through the years list until it finds the year or reaches the end.
                  current = current.getNext();
              }
              if (current.getYear() != year) { // This will insert a new YearNode at the end of the years list with the corresponding year if the year is not found.
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
    
        while (StdIn.hasNextLine()) {
            String[] split = StdIn.readLine().split(",");
            int year = Integer.parseInt(split[4]);
            String state = split[1];
    
            YearNode yearNode = years;
            while (yearNode != null && yearNode.getYear() != year) {
                yearNode = yearNode.getNext();
            }
    
            if (yearNode != null) {
                StateNode current = yearNode.getStates();
                boolean found = false;
    
                if (current != null) {
                    do {
                        if (current.getStateName().equals(state)) {
                            found = true;
                            break;
                        }
                        current = current.getNext();
                    } while (current != yearNode.getStates());
                } else {
                    StateNode newState = new StateNode(state, null);
                    newState.setNext(newState);
                    yearNode.setStates(newState);
                    current = newState;
                    found = true;
                }
    
                if (!found) {
                    StateNode newState = new StateNode(state, null);
                    if (yearNode.getStates() == null) { 
                        newState.setNext(newState); // Circular link to itself
                        yearNode.setStates(newState);
                    } else {
                        StateNode head = yearNode.getStates();
                        StateNode tail = head;
    
                        // Traverse to find the tail (which links back to head)
                        while (tail.getNext() != head) {
                            tail = tail.getNext();
                        }
    
                        tail.setNext(newState); // Insert the new node after the tail
                        newState.setNext(head); // Link new node back to the head
                    }
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
        while (StdIn.hasNextLine()) {
            String[] split = StdIn.readLine().split(",");
            int year = Integer.parseInt(split[4]);
            String state = split[1];
            int raceID = Integer.parseInt(split[0]);
            int officeID = Integer.parseInt(split[2]);
            boolean senate = split[3].equals("U.S. Senate");
            String canName = split[5];
            String party = split[6];
            int votes = Integer.parseInt(split[7]);
            boolean winner = split[8].equalsIgnoreCase("true");
    
            YearNode yearNode = years;
            while (yearNode != null && yearNode.getYear() != year) {
                yearNode = yearNode.getNext();
            }
            if (yearNode != null) {
                StateNode stateNode = yearNode.getStates();
                do {
                    if (stateNode.getStateName().equals(state)) break;
                    stateNode = stateNode.getNext();
                } while (stateNode != yearNode.getStates());
                if (stateNode != null) {
                    ElectionNode election = stateNode.getElections();
                    if (election == null) {
                        ElectionNode newElection = new ElectionNode(raceID, senate, officeID, new int[0], new String[0], -1, null);
                        newElection.setRaceID(raceID);
                        newElection.setoOfficeID(officeID);
                        newElection.setSenate(senate);
                        newElection.addCandidate(canName, votes, party, winner);
                        stateNode.setElections(newElection);
                    } 
                    boolean found = false;
                    while (election != null) {
                        if (election.getRaceID() == raceID) {
                            if (!election.isCandidate(canName)) {
                                election.addCandidate(canName, votes, party, winner);
                            } else {
                                election.modifyCandidate(canName, votes, party);
                            }
                            found = true;
                            break;
                        }
                        election = election.getNext();
                    }
                    if (!found) {
                        // Create a new ElectionNode and add it to the state's election list
                        ElectionNode newElection = new ElectionNode(
                            raceID, senate, 0, new int[0], new String[0], -1, null
                        );
                        newElection.addCandidate(canName, votes, party, winner);
                        if (stateNode.getElections() == null) {
                            stateNode.setElections(newElection); // First election in the state
                        } else {
                            election = stateNode.getElections();
                            while (election.getNext() != null) {
                                election = election.getNext();
                            }
                            election.setNext(newElection); // Append new election at the end
                        }
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
        YearNode currentYear = years;
        while (currentYear != null) {
            if (currentYear.getYear() == year) {
                break;
            }
        currentYear = currentYear.getNext();
    }
        // If the year is not found, return 0
        if (currentYear == null) {
            return 0;
        }
        StateNode currentState = currentYear.getStates();
        // Traverse the StateNode circular linked list to find the specified state
        if (currentState != null) {
            do {
                if (currentState.getStateName().equals(stateName)) {
                    break;
                }
                currentState = currentState.getNext();
            } while (currentState != currentYear.getStates());
        } 
        // If the state is not found, return 0
        if (currentState == null) {
            return 0;
        }
        ElectionNode currentElection = currentState.getElections();
        int totalVotes = 0;
        while (currentElection != null) {
            totalVotes += currentElection.getVotes();
            currentElection = currentElection.getNext();
        }
        return totalVotes;
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
        YearNode currentYear = years;
        while (currentYear != null) {
            if (currentYear.getYear() == year) {
                break;
            }
            currentYear = currentYear.getNext();
        }
        // If the year is not found, return 0
        if (currentYear == null) {
            return 0;
        }
        StateNode currentState = currentYear.getStates();
        if (currentState != null) {
            do {
                if (currentState.getStateName().equals(stateName)) {
                    break;
                }
                currentState = currentState.getNext();
            } while (currentState != currentYear.getStates());
        }
        // If the state is not found, return 0
        if (currentState == null) {
            return 0;
        }
        ElectionNode currentElection = currentState.getElections();
        int totalVotes = 0;
        int electionCount = 0;
        while (currentElection != null) {
            totalVotes += currentElection.getVotes();
            electionCount++;
            currentElection = currentElection.getNext();
        }
        if (electionCount == 0) {
            return 0; 
        }
        return totalVotes / electionCount;    
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
        String latestParty = null;
        YearNode yearNode = years; // Start with the first year node
        while (yearNode != null) {
            StateNode stateNode = yearNode.getStates(); // Get the states for the current year
            if (stateNode != null) {
                StateNode head = stateNode; // Keep track of the start of the state list
                do {
                    ElectionNode election = stateNode.getElections(); // Get elections in the current state
                    while (election != null) {
                        if (election.isCandidate(candidateName)) { // Check if the candidate exists in the election
                            latestParty = election.getParty(candidateName); // Update party to the most recent one found
                        }
                        election = election.getNext(); // Move to the next election
                    }
                    stateNode = stateNode.getNext(); // Move to the next state
                } while (stateNode != head); // Continue until back to the start of the circular state list
            }
            yearNode = yearNode.getNext(); // Move to the next year
        }
        return latestParty != null ? latestParty : "Not found"; // Return the latest party, or "Not found"
    }
    
}
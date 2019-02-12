package edu.up.cs371.soccer_application;

import android.util.Log;

import edu.up.cs371.soccer_application.soccerPlayer.SoccerPlayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Soccer player database -- presently, all dummied up
 * 
 * @author *** put your name here ***
 * @version *** put date of completion here ***
 *
 */
public class SoccerDatabase implements SoccerDB {
    HashMap<String,SoccerPlayer> hashes = new HashMap<String,SoccerPlayer>(100);

    /**
     * add a player
     *
     * @see SoccerDB#addPlayer(String, String, int, String)
     */
    @Override
	public boolean addPlayer(String firstName, String lastName,
			int uniformNumber, String teamName) {
        String fullname = firstName +  " " + lastName;
        SoccerPlayer newPlayer = new SoccerPlayer(firstName, lastName, uniformNumber, teamName);
        if(hashes.containsKey(fullname) == false){
            hashes.put(fullname, newPlayer);
            return true;
        }
        else{
            return false;
        }

	}

    /**
     * remove a player
     *
     * @see SoccerDB#removePlayer(String, String)
     */
    @Override
    public boolean removePlayer(String firstName, String lastName) {
        String fullName = firstName +" "+ lastName;
        if(hashes.containsKey(fullName)){
            hashes.remove(fullName);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * look up a player
     *
     * @see SoccerDB#getPlayer(String, String)
     */
    @Override
	public SoccerPlayer getPlayer(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;
        if(hashes.containsKey(fullName)){
            return hashes.get(fullName);

        }
        else{
            return null;
        }

    }

    /**
     * increment a player's goals
     *
     * @see SoccerDB#bumpGoals(String, String)
     */
    @Override
    public boolean bumpGoals(String firstName, String lastName) {
        String fullName = firstName+" "+lastName;
        if(hashes.containsKey(fullName)){
            SoccerPlayer somePlayer = hashes.get(fullName);
            somePlayer.bumpGoals();
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * increment a player's assists
     *
     * @see SoccerDB#bumpAssists(String, String)
     */
    @Override
    public boolean bumpAssists(String firstName, String lastName) {
        String fullName = firstName+" "+lastName;
        if(hashes.containsKey(fullName)){
            SoccerPlayer somePlayer = hashes.get(fullName);
            somePlayer.bumpAssists();
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * increment a player's shots
     *
     * @see SoccerDB#bumpShots(String, String)
     */
    @Override
    public boolean bumpShots(String firstName, String lastName) {
        String fullName = firstName+" "+lastName;
        if(hashes.containsKey(fullName)){
            SoccerPlayer somePlayer = hashes.get(fullName);
            somePlayer.bumpShots();
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * increment a player's saves
     *
     * @see SoccerDB#bumpSaves(String, String)
     */
    @Override
    public boolean bumpSaves(String firstName, String lastName) {
        String fullName = firstName+" "+lastName;
        if(hashes.containsKey(fullName)){
            SoccerPlayer somePlayer = hashes.get(fullName);
            somePlayer.bumpSaves();
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * increment a player's fouls
     *
     * @see SoccerDB#bumpFouls(String, String)
     */
    @Override
    public boolean bumpFouls(String firstName, String lastName) {
        String fullName = firstName+" "+lastName;
        if(hashes.containsKey(fullName)){
            SoccerPlayer somePlayer = hashes.get(fullName);
            somePlayer.bumpFouls();
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * increment a player's yellow cards
     *
     * @see SoccerDB#bumpYellowCards(String, String)
     */
    @Override
    public boolean bumpYellowCards(String firstName, String lastName) {
        String fullName = firstName+" "+lastName;
        if(hashes.containsKey(fullName)){
            SoccerPlayer somePlayer = hashes.get(fullName);
            somePlayer.bumpYellowCards();
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * increment a player's red cards
     *
     * @see SoccerDB#bumpRedCards(String, String)
     */
    @Override
    public boolean bumpRedCards(String firstName, String lastName) {
        String fullName = firstName+" "+lastName;
        if(hashes.containsKey(fullName)){
            SoccerPlayer somePlayer = hashes.get(fullName);
            somePlayer.bumpRedCards();
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * tells the number of players on a given team
     *
     * @see SoccerDB#numPlayers(String)
     */
    @Override
    // report number of players on a given team (or all players, if null)
	public int numPlayers(String teamName) {

        int count = 0;
        if(teamName == null){
            return hashes.size();
        }
        else{
           Collection<SoccerPlayer> myCollection = hashes.values();
           for(SoccerPlayer player : myCollection){
               if(player.getTeamName().equals(teamName)){
                   count++;

               }
            }
        }
        return count;
	}

    /**
     * gives the nth player on a the given team
     *
     * @see SoccerDB#playerNum(int, String)
     */
	// get the nTH player
	@Override
    public SoccerPlayer playerNum(int idx, String teamName) {
        int count = 0;
        Collection<SoccerPlayer> myCollection = hashes.values();
        if(teamName == null) {
            for (SoccerPlayer player : myCollection) {
                if (count == idx) {
                    return player;
                }
                count++;
            }
        }
        else{
                for(SoccerPlayer player : myCollection){
                    if(player.getTeamName().equals(teamName)){
                        if(count == idx){
                            return player;
                        }
                    }
                    count++;
                }
            }
            return null;
    }

    /**
     * reads database data from a file
     *
     * @see SoccerDB#readData(java.io.File)
     */
	// read data from file
    @Override
	public boolean readData(File file) throws FileNotFoundException {
        if(file == null){
            return false;
        }
        Scanner sc = null;
        sc = new Scanner(file);
        while(sc.hasNextLine()){
            String s = sc.next();
            System.out.println(s);

        }
        return true;

        //return file.exists();
	}

    /**
     * write database data to a file
     *
     * @see SoccerDB#writeData(java.io.File)
     */
	// write data to file
    @Override
	public boolean writeData(File file) throws FileNotFoundException {
        if(file == null){
            return false;
        }
        PrintWriter writer = new PrintWriter(file);
        //writer.println(logString("testing"));
        int count = 0;
        Collection<SoccerPlayer> myCollection = hashes.values();
        for(SoccerPlayer s : myCollection){
            writer.println(logString(s.getFirstName()));
            writer.println(logString(s.getLastName()));
            writer.println(logString(s.getTeamName()));
            writer.println(logString("" +s.getAssists()));
            writer.println(logString(""+s.getFouls()));
            writer.println(logString(""+s.getGoals()));
            writer.println(logString(""+s.getRedCards()));
            writer.println(logString(""+s.getSaves()));
            writer.println(logString(""+s.getShots()));
            writer.println(logString(""+s.getUniform()));
            writer.println(logString(""+s.getYellowCards()));
        }
        writer.close();
        return true;

	}

    /**
     * helper method that logcat-logs a string, and then returns the string.
     * @param s the string to log
     * @return the string s, unchanged
     */
    private String logString(String s) {
        Log.i("write string", s);
        return s;
    }

    /**
     * returns the list of team names in the database
     *
     * @see edu.up.cs371.soccer_application.SoccerDB#getTeams()
     */
	// return list of teams
    @Override
	public HashSet<String> getTeams() {
        return new HashSet<String>();
	}

}

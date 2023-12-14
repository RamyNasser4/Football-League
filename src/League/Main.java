package League;

import League.GUI.GUI;
import League.Match.Match;
import League.Person.Coach.Coach;
import League.Person.Player.*;
import League.Person.Referee.Referee;
import League.Stadium.Stadium;
import League.Team.Team;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class Main {
    public static void ReadFiles(League league){
        //Read Coaches
        ArrayList<Coach> coaches = new ArrayList<>();
        try {
            BufferedReader ReadCoach = new BufferedReader(new FileReader("Coaches.txt"));
            while (ReadCoach.ready()){
                String coach = ReadCoach.readLine();
                String[] coachInfo = coach.split("\t");
                Coach newCoach = new Coach(coachInfo[0],Integer.parseInt(coachInfo[1]),Integer.parseInt(coachInfo[2]),coachInfo[3],Integer.parseInt(coachInfo[4]));
                coaches.add(newCoach);
            }
        }catch (IOException exp){
            System.out.println("Coaches file not found");
        }
        //Read Referees
        ArrayList<Referee> referees = new ArrayList<>();
        try {
            BufferedReader ReadReferee = new BufferedReader(new FileReader("Referees.txt"));
            while (ReadReferee.ready()){
                String referee = ReadReferee.readLine();
                String[] refereeInfo = referee.split("\t");
                Referee newReferee = new Referee(refereeInfo[0],Integer.parseInt(refereeInfo[1]),Integer.parseInt(refereeInfo[2]),Integer.parseInt(refereeInfo[3]),Integer.parseInt(refereeInfo[4]));
                referees.add(newReferee);
            }
        }catch (IOException exp){
            System.out.println("Referees file not found");
        }
        //Read Stadiums
        ArrayList<Stadium> stadiums = new ArrayList<>();
        try {
            BufferedReader ReadStadium = new BufferedReader(new FileReader("Stadiums.txt"));
            while (ReadStadium.ready()){
                String stadium = ReadStadium.readLine();
                String[] stadiumInfo = stadium.split("\t");
                Stadium newStadium = new Stadium(stadiumInfo[0],stadiumInfo[1],Integer.parseInt(stadiumInfo[2]));
                stadiums.add(newStadium);
            }
        }catch (IOException exp){
            System.out.println("Stadiums file not found");
        }
        //Read Teams
        ArrayList<Team> teams = new ArrayList<>();
        try {
            BufferedReader ReadTeam = new BufferedReader(new FileReader("Teams.txt"));
            int TeamsCount = 1;
            while (ReadTeam.ready()){
                ArrayList<Player> players = new ArrayList<>();
                Player TeamCaptain = new Player();
                try {
                    BufferedReader ReadTeamPlayers = new BufferedReader(new FileReader("Team"+TeamsCount+".txt"));
                    while (ReadTeamPlayers.ready()){
                        String player = ReadTeamPlayers.readLine();
                        String[] playerInfo = player.split("\t");
                        if(playerInfo[0].equals("Forward")){
                            Forward newPlayer = new Forward(playerInfo[1],
                                    Integer.parseInt(playerInfo[2]),
                                    Integer.parseInt(playerInfo[3]),
                                    playerInfo[4],Integer.parseInt(playerInfo[5]),
                                    Double.parseDouble(playerInfo[6]),
                                    Integer.parseInt(playerInfo[7]),
                                    Integer.parseInt(playerInfo[8]),
                                    Integer.parseInt(playerInfo[9]),
                                    Integer.parseInt(playerInfo[10]),
                                    Integer.parseInt(playerInfo[11]),
                                    Integer.parseInt(playerInfo[12]),
                                    Boolean.parseBoolean(playerInfo[13]));
                            if (newPlayer.getCaptain()){
                                TeamCaptain = new Forward(newPlayer);
                            }
                            players.add(newPlayer);
                        }else if (playerInfo[0].equals("Midfielder")){
                            Midfielder newPlayer = new Midfielder(playerInfo[1],
                                    Integer.parseInt(playerInfo[2]),
                                    Integer.parseInt(playerInfo[3]),
                                    playerInfo[4],Integer.parseInt(playerInfo[5]),
                                    Double.parseDouble(playerInfo[6]),
                                    Integer.parseInt(playerInfo[7]),
                                    Integer.parseInt(playerInfo[8]),
                                    Integer.parseInt(playerInfo[9]),
                                    Integer.parseInt(playerInfo[10]),
                                    Integer.parseInt(playerInfo[11]),
                                    Integer.parseInt(playerInfo[12]),
                                    Boolean.parseBoolean(playerInfo[13]));
                            if (newPlayer.getCaptain()){
                                TeamCaptain = new Midfielder(newPlayer);
                            }
                            players.add(newPlayer);
                        }else if (playerInfo[0].equals("Defender")){
                            Defender newPlayer = new Defender(playerInfo[1],
                                    Integer.parseInt(playerInfo[2]),
                                    Integer.parseInt(playerInfo[3]),
                                    playerInfo[4],Integer.parseInt(playerInfo[5]),
                                    Double.parseDouble(playerInfo[6]),
                                    Integer.parseInt(playerInfo[7]),
                                    Integer.parseInt(playerInfo[8]),
                                    Integer.parseInt(playerInfo[9]),
                                    Integer.parseInt(playerInfo[10]),
                                    Integer.parseInt(playerInfo[11]),
                                    Integer.parseInt(playerInfo[12]),
                                    Integer.parseInt(playerInfo[13]),
                                    Boolean.parseBoolean(playerInfo[14]));
                            if (newPlayer.getCaptain()){
                                TeamCaptain = new Defender(newPlayer);
                            }
                            players.add(newPlayer);
                        }else{
                            Goalkeeper newPlayer = new Goalkeeper(playerInfo[1],
                                    Integer.parseInt(playerInfo[2]),
                                    Integer.parseInt(playerInfo[3]),
                                    playerInfo[4],Integer.parseInt(playerInfo[5]),
                                    Double.parseDouble(playerInfo[6]),
                                    Integer.parseInt(playerInfo[7]),
                                    Integer.parseInt(playerInfo[8]),
                                    Integer.parseInt(playerInfo[9]),
                                    Integer.parseInt(playerInfo[10]),
                                    Integer.parseInt(playerInfo[11]),
                                    Integer.parseInt(playerInfo[12]),
                                    Integer.parseInt(playerInfo[13]),
                                    Boolean.parseBoolean(playerInfo[14]));
                            if (newPlayer.getCaptain()){
                                TeamCaptain = new Goalkeeper(newPlayer);
                            }
                            players.add(newPlayer);
                        }
                    }
                }catch (IOException exp){
                    System.out.println("Team " + TeamsCount + " file not found");
                }
                Coach TeamCoach = new Coach();
                for (Coach coach : coaches){
                    if (coach.getTeamID() == TeamsCount){
                        TeamCoach = new Coach(coach);
                    }
                }
                String team = ReadTeam.readLine();
                String[] teamInfo = team.split("\t");
                Team newTeam = new Team(teamInfo[0],
                        players,
                        TeamCaptain,
                        TeamCoach,
                        null,
                        Integer.parseInt(teamInfo[1]),
                        Integer.parseInt(teamInfo[2]),
                        Integer.parseInt(teamInfo[3]));
                teams.add(newTeam);
                ++TeamsCount;
            }
        }catch (IOException exp){
            System.out.println("Teams file not found");
        }
        //Read Matches
        ArrayList<Match> matches = new ArrayList<>();
        try {
            BufferedReader ReadMatch = new BufferedReader(new FileReader("Matches.txt"));
            while (ReadMatch.ready()){
                String match = ReadMatch.readLine();
                String[] matchInfo = match.split("\t");
                String team1Name = matchInfo[1];
                String team2Name = matchInfo[2];
                Team team1 = new Team();
                Team team2 = new Team();
                for (Team team : teams){
                    if (team.getName().equals(team1Name)){
                        team1 = new Team(team);
                    }else if (team.getName().equals(team2Name)){
                        team2 = new Team(team);
                    }
                }
                Team[] MatchTeams = new Team[2];
                MatchTeams[0] = team1;
                MatchTeams[1] = team2;
                String refereeName = matchInfo[3];
                Referee MatchReferee = new Referee();
                for (Referee referee : referees){
                    if (referee.getPersonName().equals(refereeName)){
                        MatchReferee = new Referee(referee);
                    }
                }
                String stadiumName = matchInfo[5];
                Stadium MatchStadium = new Stadium();
                for (Stadium stadium : stadiums){
                    if (stadium.getStadiumName().equals(stadiumName)){
                        MatchStadium = new Stadium(stadium);
                    }
                }
                try {
                    Match newMatch = new Match(matchInfo[0],new SimpleDateFormat("dd/MM/yyyy").parse(matchInfo[0]),MatchTeams,MatchReferee,matchInfo[4],MatchStadium,Integer.parseInt(matchInfo[6]),Integer.parseInt(matchInfo[7]));
                    MatchStadium.matches.add(newMatch);
                }catch (ParseException exp){
                    System.out.println("Invalid date");
                }
            }
        }catch (IOException exp){
            System.out.println("Matches files not found");
        }
    }
    public static void WriteFiles(League league){

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI());
    }
}
package mainPackage;

import League.GUI.GUI;
import League.League;
import League.Match.Match;
import League.Person.Coach.Coach;
import League.Person.Player.*;
import League.Person.Referee.Referee;
import League.Stadium.Stadium;
import League.Team.Team;

import javax.swing.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {
    public static void ReadFiles(League league){

        //Read Coaches
        ArrayList<Coach> coaches = new ArrayList<>();
        BufferedReader ReadCoach = null;
        try {
            ReadCoach = new BufferedReader(new FileReader("Coaches.txt"));
            while (ReadCoach.ready()){
                String coach = ReadCoach.readLine();
                String[] coachInfo = coach.split("\t");
                Coach newCoach = new Coach(coachInfo[0],Integer.parseInt(coachInfo[1]),Integer.parseInt(coachInfo[2]),coachInfo[3],coachInfo[4]);
                coaches.add(newCoach);
            }
        }catch (IOException exp){
            System.out.println("Coaches file not found");
        }finally {
            if (ReadCoach!= null){
                try {
                    ReadCoach.close();
                }catch (IOException exp){
                    System.out.println("Couldn't close coaches file");
                }
            }
        }
        //Read Referees
        ArrayList<Referee> referees = new ArrayList<>();
        BufferedReader ReadReferee = null;
        try {
            ReadReferee = new BufferedReader(new FileReader("Referees.txt"));
            while (ReadReferee.ready()){
                String referee = ReadReferee.readLine();
                String[] refereeInfo = referee.split("\t");
                Referee newReferee = new Referee(refereeInfo[0],Integer.parseInt(refereeInfo[1]),Integer.parseInt(refereeInfo[2]),Integer.parseInt(refereeInfo[3]),Integer.parseInt(refereeInfo[4]));
                referees.add(newReferee);
            }
        }catch (IOException exp){
            System.out.println("Referees file not found");
        }finally {
            if (ReadReferee!= null){
                try {
                    ReadReferee.close();
                }catch (IOException exp){
                    System.out.println("Couldn't close referees file");
                }
            }
        }
        league.setReferees(referees);
        //Read Stadiums
        ArrayList<Stadium> stadiums = new ArrayList<>();
        BufferedReader ReadStadium = null;
        try {
            ReadStadium = new BufferedReader(new FileReader("Stadiums.txt"));
            while (ReadStadium.ready()){
                String stadium = ReadStadium.readLine();
                String[] stadiumInfo = stadium.split("\t");
                Stadium newStadium = new Stadium(stadiumInfo[0],stadiumInfo[1],Integer.parseInt(stadiumInfo[2]));
                stadiums.add(newStadium);
            }

        }catch (IOException exp){
            System.out.println("Stadiums file not found");
        }finally {
            if (ReadStadium!= null){
                try {
                    ReadStadium.close();
                }catch (IOException exp){
                    System.out.println("Couldn't close stadiums file");
                }
            }
        }
        league.setStadiums(stadiums);
        //Read Teams
        ArrayList<Team> teams = new ArrayList<>();
        BufferedReader ReadTeam = null;
        try {
            ReadTeam = new BufferedReader(new FileReader("Teams.txt"));
            while (ReadTeam.ready()){
                ArrayList<Player> players = new ArrayList<>();
                Player TeamCaptain = null;
                BufferedReader ReadTeamPlayers = null;
                String team = ReadTeam.readLine();
                String[] teamInfo = team.split("\t");
                Coach TeamCoach = null;
                for (Coach coach : coaches){
                    if (coach.getTeamName().equals(teamInfo[0])){
                        TeamCoach = coach;
                    }
                }
                try {
                    ReadTeamPlayers = new BufferedReader(new FileReader(teamInfo[0]+"Players.txt"));
                    while (ReadTeamPlayers.ready()){
                        String player = ReadTeamPlayers.readLine();
                        String[] playerInfo = player.split("\t");
                        if(playerInfo[0].equals("Forward")){
                            //PlayerName - PlayerAge - PlayerSalary - PlayerTeam
                            // - PlayerNumber - PlayerScore - PlayerRank - GoalsScored
                            // - Assists - noOfYellowCards - noOfRedCards - shots - Boolean isCaptain
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
                                TeamCaptain = newPlayer;
                            }
                            players.add(newPlayer);
                        }else if (playerInfo[0].equals("Midfielder")){
                            //PlayerName - PlayerAge - PlayerSalary - PlayerTeam
                            // - PlayerNumber - PlayerScore - PlayerRank - GoalsScored
                            // - Assists - noOfYellowCards - noOfRedCards - keyPasses - Boolean isCaptain
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
                                TeamCaptain = newPlayer;
                            }
                            players.add(newPlayer);
                        }else if (playerInfo[0].equals("Defender")){
                            //PlayerName - PlayerAge - PlayerSalary - PlayerTeam
                            // - PlayerNumber - PlayerScore - PlayerRank - GoalsScored
                            // - Assists - noOfYellowCards - noOfRedCards - tackles - cleanSheets
                            // - Boolean isCaptain
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
                                TeamCaptain = newPlayer;
                            }
                            players.add(newPlayer);
                        }else{
                            //PlayerName - PlayerAge - PlayerSalary - PlayerTeam
                            // - PlayerNumber - PlayerScore - PlayerRank - GoalsScored
                            // - Assists - noOfYellowCards - noOfRedCards - saves - cleanSheets
                            // - Boolean isCaptain
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
                                TeamCaptain = newPlayer;
                            }
                            players.add(newPlayer);
                        }
                    }
                }catch (IOException exp ){
                    System.out.println(teamInfo[0]+ " file not found");
                }
                catch(ArrayIndexOutOfBoundsException exp){

                }
                finally {
                    if (ReadTeamPlayers!= null){
                        try {
                            ReadTeamPlayers.close();
                        }catch (IOException exp){
                            System.out.println("Couldn't close " + teamInfo[0]+ "Players file");
                        }
                    }
                }
                Team newTeam = new Team(teamInfo[0],
                        players,
                        TeamCaptain,
                        TeamCoach,
                        new ArrayList<>(),
                        Integer.parseInt(teamInfo[1]),
                        Integer.parseInt(teamInfo[2]),
                        Integer.parseInt(teamInfo[3]));
                teams.add(newTeam);
            }
            league.setTeams(teams);
        }catch (IOException exp){
            System.out.println("Teams file not found");
        }finally {
            if (ReadTeam!= null){
                try {
                    ReadTeam.close();
                }catch (IOException exp){
                    System.out.println("Couldn't close teams file");
                }
            }
        }
        //Read Matches
        ArrayList<Match> matches = new ArrayList<>();
        BufferedReader ReadMatch = null;
        try {
            ReadMatch = new BufferedReader(new FileReader("Matches.txt"));
            while (ReadMatch.ready()){
                String match = ReadMatch.readLine();
                String[] allMatchesInfo = match.split(",");
                String[] matchInfo = allMatchesInfo[0].split("\t");
                String team1Name = matchInfo[1];
                String team2Name = matchInfo[2];
                Team team1 = new Team();
                Team team2 = new Team();
                for (Team team : teams){
                    if (team.getName().equals(team1Name)){
                        team1 = league.searchTeam(team1Name);
                    }else if (team.getName().equals(team2Name)){
                        team2 = league.searchTeam(team2Name);
                    }
                }
                Team[] MatchTeams = new Team[2];
                MatchTeams[0] = team1;
                MatchTeams[1] = team2;
                String refereeName = matchInfo[3];
                Referee MatchReferee = new Referee();
                for (Referee referee : referees){
                    if (referee.getPersonName().equals(refereeName)){
                        MatchReferee = referee;
                    }
                }
                String stadiumName = matchInfo[5];
                Stadium MatchStadium = new Stadium();
                for (Stadium stadium : stadiums){
                    if (stadium.getStadiumName().equals(stadiumName)){
                        MatchStadium = stadium;
                    }
                }
                ArrayList<Player> team1Scorers = new ArrayList<>();
                ArrayList<Player> team2Scorers = new ArrayList<>();
                ArrayList<Player> team1Assisters = new ArrayList<>();
                ArrayList<Player> team2Assisters = new ArrayList<>();
                int Team1Score = -1;
                int Team2Score = -1;
                if (!matchInfo[4].isEmpty()){
                    String[] scorers = allMatchesInfo[1].split("\t");
                    for (String scorerName : scorers){
                        if(scorerName.startsWith("Team1:")){
                            Player scorer = team1.searchPlayer(scorerName.substring(6));
                            team1Scorers.add(scorer);
                        }else if (scorerName.startsWith("Team2:")){
                            Player scorer = team2.searchPlayer(scorerName.substring(6));
                            team2Scorers.add(scorer);
                        }
                    }
                    String[] assisters = allMatchesInfo[2].split("\t");
                    System.out.println(Arrays.toString(assisters));
                    for (String assisterName : assisters){
                        if(assisterName.startsWith("Team1:")){
                            Player assister = team1.searchPlayer(assisterName.substring(6));
                            team1Assisters.add(assister);
                        }else if (assisterName.startsWith("Team2:")){
                            Player assister = team2.searchPlayer(assisterName.substring(6));
                            team2Assisters.add(assister);
                        }
                    }
                    try {
                        Team1Score = Integer.parseInt(matchInfo[4].split("-")[0]);
                        Team2Score = Integer.parseInt(matchInfo[4].split("-")[1]);
                    }catch (Exception exp){
                        Team1Score = -1;
                        Team2Score = -1;
                    }
                }
                try {
                    Match newMatch = new Match(matchInfo[0],MatchTeams,MatchReferee,matchInfo[4],MatchStadium,Team1Score,Team2Score,team1Scorers,team1Assisters,team2Scorers,team2Assisters);
                    MatchStadium.matches.add(newMatch);
                    team1.AddMatch(newMatch);
                    team2.AddMatch(newMatch);
                    matches.add(newMatch);
                }catch (Exception exp){
                    System.out.println("Invalid date");
                }
            }
            league.setMatches(matches);
        }catch (IOException exp){
            System.out.println("Matches files not found");
        }finally {
            if (ReadMatch!= null){
                try {
                    ReadMatch.close();
                }catch (IOException exp){
                    System.out.println("Couldn't close matches file");
                }
            }
        }
    }
    public static void WriteFiles(League league){
        //Write Coaches
        BufferedWriter WriteCoach = null;
        try {
            WriteCoach = new BufferedWriter(new FileWriter("Coaches.txt"));
            for (Team team : league.getTeams()){
                try {
                    WriteCoach.write(team.getCoach().writeCoach());
                    WriteCoach.write("\n");
                }catch (NullPointerException exp){
                    System.out.println("Team has no coach");
                }
            }
        }catch (IOException exp){
            System.out.println("Coaches file not found");
        }finally {
            if (WriteCoach!=null){
                try {
                    WriteCoach.close();
                }catch (IOException exp){
                    System.out.println("Couldn't close coaches file");
                }
            }
        }
        //Write Referees
        BufferedWriter WriteReferees = null;
        try {
            WriteReferees = new BufferedWriter(new FileWriter("Referees.txt"));
            for (Referee referee : league.referees){
                WriteReferees.write(referee.WriteReferee());
                WriteReferees.write("\n");
            }
        }catch (IOException exp){
            System.out.println("Referees file not found");
        }finally {
            if (WriteReferees!=null){
                try {
                    WriteReferees.close();
                }catch (IOException exp){
                    System.out.println("Couldn't close referees file");
                }
            }
        }
        //Write Stadiums
        BufferedWriter WriteStadiums = null;
        try {
            WriteStadiums = new BufferedWriter(new FileWriter("Stadiums.txt"));
            for (Stadium stadium : league.stadiums){
                WriteStadiums.write(stadium.WriteStadium());
                WriteStadiums.write("\n");
            }
        }catch (IOException exp){
            System.out.println("Stadiums file not found");
        }finally {
            if (WriteStadiums!=null){
                try {
                    WriteStadiums.close();
                }catch (IOException exp){
                    System.out.println("Couldn't close stadiums file");
                }
            }
        }
        //Write Teams
        BufferedWriter WriteTeams = null;
        try {
            WriteTeams = new BufferedWriter(new FileWriter("Teams.txt"));
            for (Team team : league.getTeams()){
                WriteTeams.write(team.WriteTeam());
                WriteTeams.write("\n");
                BufferedWriter WriteTeamPlayers = null;
                try {
                    WriteTeamPlayers = new BufferedWriter(new FileWriter(team.getName() + "Players.txt"));
                    for (Player player : team.Players){
                        if (player instanceof Forward){
                            Forward forward = (Forward) player;
                            WriteTeamPlayers.write(forward.WriteForward());
                        }else if(player instanceof Midfielder){
                            Midfielder midfielder = (Midfielder) player;
                            WriteTeamPlayers.write(midfielder.WriteMidfielder());
                        }else if(player instanceof Defender){
                            Defender defender = (Defender) player;
                            WriteTeamPlayers.write(defender.WriteDefender());
                        }else{
                            Goalkeeper goalkeeper = (Goalkeeper) player;
                            WriteTeamPlayers.write(goalkeeper.WriteGoalkeeper());
                        }
                        WriteTeamPlayers.write("\n");
                    }
                }catch (IOException exp){
                    System.out.println(team.getName() + "Players file not found");
                }finally {
                    if (WriteTeamPlayers!=null){
                        try {
                            WriteTeamPlayers.close();
                        }catch (IOException exp){
                            System.out.println("Couldn't close "+ team.getName() + "Players file");
                        }
                    }
                }
            }
        }catch (IOException exp){
            System.out.println("Teams file not found");
        }finally {
            if (WriteTeams != null){
                try {
                    WriteTeams.close();
                }catch (IOException exp){
                    System.out.println("Couldn't close teams file");
                }
            }
        }
        //Write Matches
        BufferedWriter WriteMatches = null;
        try {
            WriteMatches = new BufferedWriter(new FileWriter("Matches.txt"));
            for (Match match : league.matches){
                WriteMatches.write(match.WriteMatch());
                WriteMatches.write("\n");
            }
        }catch (IOException exp){
            System.out.println("Matches file not found");
        }finally {
            if (WriteMatches!=null){
                try {
                    WriteMatches.close();
                }catch (IOException exp){
                    System.out.println("Couldn't close matches file");
                }
            }
        }
    }
    public static void matchesMenu(League league,Scanner input){
        while (true){
            System.out.println("MATCHES MENU : ");
            System.out.println("1- Add Match");
            System.out.println("2- Search for a match by date");
            System.out.println("3- Display all matches");
            System.out.println("4- Back to main menu");
            int choice = input.nextInt();
            if (choice == 1){
                System.out.println("Enter Match Date : (dd/MM/yyyy)");
                String date = input.next();
                SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date matchDate = null;
                try {
                    matchDate = DateFormat.parse(date);
                }catch (ParseException exp){
                    System.out.println("Invalid Date");
                }
                System.out.println("Enter Team 1");
                Team team1 = null;
                while (true){
                    for (Team team : league.getTeams()){
                        System.out.println(team.getTeam_ID() + "- " + team.getName());
                    }
                    int Team1Choice = input.nextInt();
                    Team searched = league.searchTeam(Team1Choice);
                    if (searched != null){
                        team1 = searched;
                        break;
                    }
                }
                Team team2 = null;
                while (true){
                    for (Team team : league.getTeams()){
                        System.out.println(team.getTeam_ID() + "- " + team.getName());
                    }
                    int Team2Choice = input.nextInt();
                    Team searched = league.searchTeam(Team2Choice);
                    if (searched != null && searched!= team1){
                        team2 = searched;
                        break;
                    }
                }
                Team[] matchTeams = new Team[2];
                matchTeams[0] = team1;
                matchTeams[1] = team2;
                System.out.println("Choose Match Referee : ");
                Referee matchReferee = null;
                while (true){
                    for (Referee referee : league.getReferees()){
                        System.out.println(referee.getRefereeID() + "- " + referee.getPersonName());
                    }
                    int RefereeChoice = input.nextInt();
                    Referee searched = league.searchReferee(RefereeChoice);
                    if (searched != null){
                        matchReferee = searched;
                        break;
                    }
                }
                System.out.println("Choose Match Stadium : ");
                Stadium matchStadium = null;
                while (true){
                    for (Stadium stadium : league.getStadiums()){
                        System.out.println(stadium.getStadiumID() + "- " + stadium.getStadiumName());
                    }
                    int StadiumChoice = input.nextInt();
                    Stadium searched = league.searchStadium(StadiumChoice);
                    if (searched != null && searched.CheckAvailability(date)){
                        matchStadium = searched;
                        break;
                    }
                }
                Date now = new Date();
                String matchScore = "";
                try {
                    if (matchDate.before(now)){
                        System.out.print("Enter Match Score : ");
                        matchScore = input.next();
                    }
                }catch (NullPointerException exp){

                }
                Match newMatch = new Match(date,matchTeams,matchReferee,matchScore,matchStadium);
                league.AddMatch(newMatch);
                matchStadium.AddMatch(newMatch);
                team1.AddMatch(newMatch);
                team2.AddMatch(newMatch);
            } else if (choice == 2) {
                System.out.print("Enter Date : ");
                String searchDate = input.next();
                ArrayList<Match> searchedMatches = league.Display_match_ByDateFN(searchDate);
                for (Match match : searchedMatches){
                    //display matches
                }
            } else if (choice == 3) {
                //display all matches
            } else if (choice == 4) {
                break;
            }
        }

    }
    public static void playersMenu(League league,Scanner input,Team currentTeam,Player currentPlayer){
        while (true){
            System.out.println("PLAYER MENU :");
            System.out.println("1- Update Name");
            System.out.println("2- Update ID");
            System.out.println("3- Update Number");
            System.out.println("4- Update Age");
            System.out.println("5- Update Score");
            System.out.println("6- Update Rank");
            System.out.println("7- Delete player");
            System.out.println("8- Display player Info");
            System.out.println("9- Back to Team Menu");
            int choice = input.nextInt();
            if (choice == 1){
                System.out.print("Enter Player Name : ");
                input.nextLine();
                String PlayerName = input.nextLine();
                currentPlayer.setPersonName(PlayerName);
            } else if (choice == 2) {
                System.out.print("Enter Player ID : ");
                int PlayerID = input.nextInt();
                currentPlayer.setPlayerId(PlayerID);
            } else if (choice == 3) {
                System.out.print("Enter Player Number : ");
                int PlayerNumber = input.nextInt();
                currentPlayer.SetPlayerNumber(PlayerNumber);
            } else if (choice == 4) {
                System.out.print("Enter Player Age : ");
                int PlayerAge = input.nextInt();
                currentPlayer.setPersonAge(PlayerAge);
            } else if (choice == 5) {
                System.out.print("Enter Player Score : ");
                double PlayerScore = input.nextDouble();
                currentPlayer.SetPlayerScore(PlayerScore);
            } else if (choice == 6) {
                System.out.print("Enter Player Rank : ");
                int PlayerRank = input.nextInt();
                currentPlayer.SetPlayerRank(PlayerRank);
            } else if (choice == 7) {
                currentTeam.deletePlayer(currentPlayer.GetPlayerId());
                break;
            } else if (choice == 8) {
                //display Player info
            } else if (choice == 9) {
                break;
            }
        }

    }
    public static void teamMenu(League league,Scanner input,Team currentTeam){
        while (true){
            System.out.println("TEAM MENU :");
            System.out.println("1- Add Player");
            System.out.println("2- Search for a Player");
            System.out.println("3- Display Players");
            System.out.println("4- Display Team Info");
            System.out.println("5- Display Team Matches");
            System.out.println("6- Edit Team Name");
            System.out.println("7- Delete Team");
            System.out.println("8- Update Coach");
            System.out.println("9- Back to Teams Menu");
            int choice = input.nextInt();
            if (choice == 1){
                System.out.println("Enter Player Info:");
                System.out.print("Player Name:");
                input.nextLine();
                String PlayerName = input.nextLine();
                System.out.print("Player Age: ");
                int PlayerAge = input.nextInt();
                System.out.print("Player Number");
                int PlayerNumber = input.nextInt();
                System.out.print("Enter Player Position (Forward/Midfielder/Defender/Goalkeeper) : ");
                input.nextLine();
                String PlayerPosition;
                while (true){
                    PlayerPosition = input.nextLine();
                    if (PlayerPosition.equalsIgnoreCase("forward") ||
                            PlayerPosition.equalsIgnoreCase("midfielder") ||
                            PlayerPosition.equalsIgnoreCase("defender") ||
                            PlayerPosition.equalsIgnoreCase("goalkeeper")){
                        break;
                    }else {
                        System.out.println("Invalid Input");
                    }
                }
                System.out.println("Is this player a captain?(y/n)");
                boolean isCaptain;
                while (true){
                    String answer = input.next();
                    if (answer.toLowerCase().startsWith("y")){
                        isCaptain = true;
                        break;
                    }else if (answer.toLowerCase().startsWith("n")){
                        isCaptain = false;
                        break;
                    }else {
                        System.out.println("Invalid input");
                    }
                }
                Player newPlayer = null;
                if (PlayerPosition.equalsIgnoreCase("forward")){
                    newPlayer = new Forward(PlayerName,PlayerAge,0,currentTeam.getName(),PlayerNumber,0,0,0,0,0,0,0,isCaptain);
                } else if (PlayerPosition.equalsIgnoreCase("midfielder")) {
                    newPlayer = new Midfielder(PlayerName,PlayerAge,0,currentTeam.getName(),PlayerNumber,0,0,0,0,0,0,0,isCaptain);
                } else if (PlayerPosition.equalsIgnoreCase("defender")) {
                    newPlayer = new Defender(PlayerName,PlayerAge,0,currentTeam.getName(),PlayerNumber,0,0,0,0,0,0,0,0,isCaptain);
                }else {
                    newPlayer = new Goalkeeper(PlayerName,PlayerAge,0,currentTeam.getName(),PlayerNumber,0,0,0,0,0,0,0,0,isCaptain);
                }
                currentTeam.addPlayer(newPlayer);
            } else if (choice == 2) {
                System.out.println("Enter Player Name :");
                input.nextLine();
                String PlayerName = input.nextLine();
                Player searched = currentTeam.searchPlayer(PlayerName);
                try {
                    if (searched != null){
                        playersMenu(league,input,currentTeam,searched);
                    }else {
                        throw new NullPointerException();
                    }
                }catch (NullPointerException exp){
                    System.out.println("Player not found");
                }
            } else if (choice == 3) {
                //display players
            } else if (choice == 4) {
                //display team info
            } else if (choice == 5) {
                //display team matches
            } else if (choice == 6) {
                System.out.println("Enter New Team Name");
                input.nextLine();
                String TeamName = input.nextLine();
                currentTeam.setName(TeamName);
                for (Player player : currentTeam.getPlayers()){
                    player.SetPlayerTeam(TeamName);
                }
            } else if (choice == 7) {
                league.DeleteTeam(currentTeam.getName());
                break;
            } else if (choice == 8) {
                System.out.println("Enter Coach Name :");
                input.nextLine();
                String CoachName = input.nextLine();
                System.out.println("Enter Coach Age");
                int CoachAge = input.nextInt();
                Coach newCoach = new Coach(CoachName,CoachAge,0,"",currentTeam.getName());
                currentTeam.setCoach(newCoach);
            } else if (choice == 9) {
                break;
            }
        }
    }
    public static void teamsMenu(League league,Scanner input){
        while (true){
            System.out.println("TEAMS MENU :");
            System.out.println("1- Add Team");
            System.out.println("2- Search for a Team");
            System.out.println("3- Display Teams");
            System.out.println("4- Display teams by goals");
            System.out.println("5- Display teams by avg age");
            System.out.println("6- Display teams by points");
            System.out.println("7- Back to the main menu");
            int choice = input.nextInt();
            if (choice == 1){
                System.out.println("Enter Team Info :");
                System.out.println("Team Name: ");
                input.nextLine();
                String TeamName = input.nextLine();
                Team newTeam = new Team(TeamName,new ArrayList<>(),null,null,new ArrayList<>(),0,0,0);
                league.AddTeam(newTeam);
            }else if (choice == 2){
                System.out.print("Enter team info :");
                input.nextLine();
                String TeamName = input.nextLine();
                Team searched = league.searchTeam(TeamName);
                try {
                    if (searched != null){
                        teamMenu(league,input,searched);
                    }else {
                        throw new NullPointerException();
                    }
                }catch (NullPointerException exp){
                    System.out.println("Team not found");
                }
            }else if (choice == 3){
                //league.getTeams().
            } else if (choice == 4) {
                //display teams by goals
            } else if (choice == 5) {
                //display teams by avg age
            } else if (choice == 6) {
                //display teams by points
            } else if (choice == 7) {
                break;
            }
        }
    }
    public static void mainMenu(League league){
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("Select one of the following choices : ");
            System.out.println("1- Teams Menu");
            System.out.println("2- Matches Menu");
            System.out.println("3- Stats Menu");
            System.out.println("4- Add Referee");
            System.out.println("5- Add Stadium");
            System.out.println("6- Exit");
            int choice = input.nextInt();
            if (choice == 1){
                teamsMenu(league,input);
            }else if (choice == 2){
                matchesMenu(league,input);
            } else if (choice == 3) {
                //stats menu
            }else if(choice == 4){
                System.out.print("Enter Referee Name :");
                input.nextLine();
                String RefereeName = input.nextLine();
                System.out.print("Enter Referee Age :");
                int RefereeAge = input.nextInt();
                Referee newReferee = new Referee(RefereeName,RefereeAge,0,0,0);
                league.AddReferee(newReferee);
            } else if (choice == 5) {
                System.out.println("Enter Stadium Name :");
                input.nextLine();
                String StadiumName = input.nextLine();
                System.out.println("Enter Stadium location :");
                input.nextLine();
                String StadiumLocation = input.nextLine();
                System.out.print("Enter Stadium capacity");
                int StadiumCapacity = input.nextInt();
                Stadium newStadium = new Stadium(StadiumName,StadiumLocation,StadiumCapacity,new ArrayList<>());
                league.AddStadium(newStadium);
            } else if (choice == 6) {
                break;
            }
        }
    }
    public static void main(String[] args) {
        League league = new League();
        ReadFiles(league);
        SwingUtilities.invokeLater(() -> new GUI(league));
        //mainMenu(league);
        //WriteFiles(league);
    }
}
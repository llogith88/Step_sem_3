package week5_assignments;



import java.util.Arrays;

public class FantasyLeagueAutoDraft implements Comparable<FantasyLeagueAutoDraft> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public FantasyLeagueAutoDraft(String name, int matchesPlayed,
                                  double battingAverage, boolean injured) {

        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(FantasyLeagueAutoDraft other) {

        return Double.compare(other.battingAverage, this.battingAverage);
    }

    static String draftAndRank(FantasyLeagueAutoDraft[] players) {

        int count = 0;

        for (FantasyLeagueAutoDraft player : players) {

            if (isDraftable(player.matchesPlayed)
                    || isDraftable(player.matchesPlayed, player.injured)) {
                count++;
            }
        }

        FantasyLeagueAutoDraft[] draftablePlayers =
                new FantasyLeagueAutoDraft[count];

        int index = 0;

        for (FantasyLeagueAutoDraft player : players) {

            if (isDraftable(player.matchesPlayed)
                    || isDraftable(player.matchesPlayed, player.injured)) {

                draftablePlayers[index] = player;
                index++;
            }
        }

        Arrays.sort(draftablePlayers);

        String result = "";

        for (int i = 0; i < draftablePlayers.length; i++) {

            result = result + (i + 1) + ". " + draftablePlayers[i].name;

            if (i < draftablePlayers.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        FantasyLeagueAutoDraft[] players = {
                new FantasyLeagueAutoDraft("Virat", 15, 48.0, false),
                new FantasyLeagueAutoDraft("Rahul", 7, 55.0, false),
                new FantasyLeagueAutoDraft("Sameer", 3, 60.0, false),
                new FantasyLeagueAutoDraft("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}
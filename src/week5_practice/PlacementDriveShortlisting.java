package week5_practice;



import java.util.Arrays;

public class PlacementDriveShortlisting implements Comparable<PlacementDriveShortlisting> {

    private String name;
    private double cgpa;
    private int codingScore;

    public PlacementDriveShortlisting(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    private double compositeScore() {
        return cgpa * 10 + codingScore * 0.5;
    }

    @Override
    public int compareTo(PlacementDriveShortlisting other) {

        return Double.compare(
                other.compositeScore(),
                this.compositeScore()
        );
    }

    static String shortlistAndRank(
            PlacementDriveShortlisting[] candidates) {

        int count = 0;

        // Count eligible candidates
        for (PlacementDriveShortlisting candidate : candidates) {

            if (isEligible(candidate.cgpa)
                    || isEligible(candidate.cgpa, candidate.codingScore)) {
                count++;
            }
        }

        // Create array containing only eligible candidates
        PlacementDriveShortlisting[] shortlisted =
                new PlacementDriveShortlisting[count];

        int index = 0;

        for (PlacementDriveShortlisting candidate : candidates) {

            if (isEligible(candidate.cgpa)
                    || isEligible(candidate.cgpa, candidate.codingScore)) {

                shortlisted[index] = candidate;
                index++;
            }
        }

        // Sort using compareTo()
        Arrays.sort(shortlisted);

        String result = "";

        for (int i = 0; i < shortlisted.length; i++) {

            result = result
                    + (i + 1)
                    + ". "
                    + shortlisted[i].name
                    + " ("
                    + shortlisted[i].compositeScore()
                    + ")";

            if (i < shortlisted.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        PlacementDriveShortlisting[] candidates = {

                new PlacementDriveShortlisting(
                        "Aisha", 8.2, 40),

                new PlacementDriveShortlisting(
                        "Rohit", 6.8, 65),

                new PlacementDriveShortlisting(
                        "Meena", 6.0, 90),

                new PlacementDriveShortlisting(
                        "Karan", 7.5, 20)
        };

        System.out.println(
                shortlistAndRank(candidates)
        );
    }
}
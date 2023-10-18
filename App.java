import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;

public class App {

    public static String getBrideName()
    {
        Scanner brideScan = new Scanner(System.in);
        System.out.println("Enter the name of the bride: ");
        String brideName = brideScan.nextLine();
        return brideName;
    }

    public static String getGroomName()
    {
        Scanner groomScan = new Scanner(System.in);
        System.out.println("Enter the name of the groom: ");
        String groomName = groomScan.nextLine();
        return groomName;
    }

    public static int getTotalGuests()
    {
        Scanner guestScan = new Scanner(System.in);
        System.out.println("Enter the number of guests attending the wedding: ");
        int totalGuests = guestScan.nextInt();
        return totalGuests;
    }

    public static double getSqrFootage()
    {
        Scanner sqrFootScan = new Scanner(System.in);
        System.out.println("Enter the square footage of the wedding location: ");
        double sqrFootage = sqrFootScan.nextDouble();
        return sqrFootage;
    }

    public static ArrayList<String> getDJSongs()
    {
        ArrayList<String> djSongs = new ArrayList<String>();
        boolean isDone = false;
        Scanner djSongScan = new Scanner(System.in);

        while(!isDone)
        {
            System.out.println("Are you done entering songs?");
            String response = djSongScan.nextLine();

            if (response.equalsIgnoreCase("yes"))
            {
                isDone = true;
            }
            else
            {
                System.out.println("Enter the song name to be added to the dj's playlist: ");
                String djSong = djSongScan.nextLine();
                djSongs.add(djSong);
            }
        }
        return djSongs;
    }

    public static int getGuestsPerSqrFoot(int totalGuests, double sqrFootage)
    {
        int guestsPerSqrFoot = (int)sqrFootage / totalGuests;
        return guestsPerSqrFoot;
    }


    public static void main(String[] args) {

        String brideName = getBrideName();
        String groomName = getGroomName();
        int totalGuests = getTotalGuests();
        double sqrFootage = getSqrFootage();
        ArrayList<String> djSongs = getDJSongs();
        int guestsPerSqrFoot = getGuestsPerSqrFoot(totalGuests, sqrFootage);

        try
        {
            PrintWriter pw = new PrintWriter("wedding.txt");
            pw.println("Bride's name: " + brideName);
            pw.println("Groom's name: " + groomName);
            pw.println("Guest total: " + totalGuests);
            pw.println("Square footage of wedding venue: " + sqrFootage);
            pw.println("DJ's song list: " + djSongs);
            pw.println("Guests per square foot: " + guestsPerSqrFoot);
            pw.close();

            Scanner fileScan = new Scanner(new File("wedding.txt"));

            while (fileScan.hasNextLine())
            {
                System.out.println(fileScan.nextLine());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
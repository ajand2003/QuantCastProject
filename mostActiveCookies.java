import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class mostActiveCookies {
    public static void main(String[] args) throws FileNotFoundException {
        boolean isValidInput = true;

        if (args.length != 4 || args[2] != "-d") {
            isValidInput = false;
        }
        String date = "" + args[3];
        if(isValidInput) {
            File f = new File("" + args[1]);
            Scanner s = new Scanner(f);
            HashMap<String,Integer> map = new HashMap<>();

            int lines = 0;
            while (s.hasNextLine()) {
                lines++;
            }
            ArrayList<String> cookiesList = new ArrayList<>();
            for(int i = 0; i < lines; i++) {
                String temp = s.nextLine();
                String ip = temp.split(",",2)[0];
                String temp2 =  temp.split(",",2)[1];
                String tempDate = temp2.split("T")[0];
                if(!tempDate.equals(date)) {
                    continue;
                }
                else {
                    cookiesList.add(ip);
                }
            }

            for(int i = 0; i < cookiesList.size(); i++) {
                if(map.get(cookiesList.get(i)) == 0) {
                    map.put(cookiesList.get(i), 1);
                } else {
                    map.put(cookiesList.get(i), map.get(cookiesList.get(i)) + 1);
                }
            }
            int max = 0;

            for(int i = 0; i < cookiesList.size(); i++) {
                max = Math.max(max, map.get(cookiesList.get(i)));
            }
            for(int i = 0; i < cookiesList.size(); i++) {
                if (map.get(cookiesList.get(i)) == max) {
                    System.out.println(map.get(cookiesList.get(i)));
                }
            }
            s.close();
        }

    }
}

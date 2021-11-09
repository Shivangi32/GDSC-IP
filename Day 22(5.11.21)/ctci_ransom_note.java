import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {
    // Write your code here
    if(note.size()>magazine.size())
    {
        System.out.println("No");
        return;
    }
    HashMap<String,Integer>hm=new HashMap<>();
    for(int i=0;i<magazine.size();i++)
    {
        String s=magazine.get(i);
        if(hm.containsKey(s))
        {
            hm.put(s,hm.get(s)+1);
        }
        else
            hm.put(s,1);
    }
    boolean flag=true;
    for(int i=0;i<note.size();i++)
    {
        String s=note.get(i);
        if(hm.containsKey(s))
        {
            hm.put(s,hm.get(s)-1);
        }
        else
        {
            System.out.println("No");
            return;
        }
        if(hm.get(s)==0)
          hm.remove(s);
    }
    System.out.println("Yes");
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "));

        List<String> note = Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "));

        Result.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}

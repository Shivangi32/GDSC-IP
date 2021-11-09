import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */
    static PriorityQueue<Integer>left;
    static PriorityQueue<Integer>right;
    public static void add(int num)
    {
        if(right.size()>0 && num>right.peek())
          right.add(num);
        else
          left.add(num);
        if(left.size()-right.size()==2)
          right.add(left.remove());
        if(right.size()-left.size()==2)
          left.add(right.remove());
    }
    
    public static double median(){
        
        if(left.size()==right.size())
        {
            return (left.peek()+right.peek())/2.0;
        }
        if(left.size()>right.size())
          return left.peek();
        return right.peek();
    }
    public static List<Double> runningMedian(List<Integer> a) {
     // Write your code here
        left=new PriorityQueue<>(Collections.reverseOrder());
        right=new PriorityQueue<>();
        List<Double>ans=new ArrayList<>();
        for(int i=0;i<a.size();i++)
        {
            add(a.get(i));
            double m=median();
            ans.add(m);
        }
        return ans;
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Double> result = Result.runningMedian(a);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

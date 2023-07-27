//import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
        try {
            //String inputPath = args[0];
            //Scanner sc = new Scanner(new FileReader(inputPath));
            //String data = sc.nextLine();
        	//String data = "[[0, 7], [1, 4], [3, 1], [6, 4]]";
        	String data = "[[0, 7], [10, 4], [12, 2], [12, 1], [7, 5]]";
            int[][] in = parseTwoDimensionalArray(data);

            Solution solution = new Solution();
            int[][] res = solution.SJF(convert(in));
            System.out.println(Arrays.deepToString(res));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<Process> convert(int[][] res) {
        List<Process> ans = new ArrayList<>(res.length);
        for (int i = 0; i < res.length; i++) {
            Process process = new Process(i, res[i][0], res[i][1]);
            ans.add(process);
        }

        return ans;
    }

    private static int[][] parseTwoDimensionalArray(String str) {
        str = str.replaceAll("\\[", "");
        str = str.replaceAll("]", "");
        String[] split = str.split(", ");

        int[][] res = new int[split.length / 2][2];
        int cnt = 0;

        for (int i = 0; i < split.length - 1; i += 2) {
            res[cnt][0] = Integer.parseInt(split[i]);
            res[cnt][1] = Integer.parseInt(split[i+1]);
            cnt++;
        }

        return res;
    }

}

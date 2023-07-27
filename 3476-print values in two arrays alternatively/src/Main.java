import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        try {
            /*
        	String inputPath = args[0];
            Scanner sc = new Scanner(new FileReader(inputPath));
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            String[] s1 = str1.substring(str1.indexOf('[') + 1, str1.indexOf(']')).split(",");
            String[] s2 = str2.substring(str2.indexOf('[') + 1, str2.indexOf(']')).split(",");
            int[] arr1 = new int[s1.length];
            int[] arr2 = new int[s2.length];

            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = Integer.parseInt(s1[i]);
            }
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = Integer.parseInt(s2[i]);
            }*/
        	
        	int[] arr1 = {1, 3, 5};
        	int[] arr2 = {2, 4, 6};

            Solution solution = new Solution(arr1, arr2);
            new Thread(solution::printArr1).start();
            new Thread(solution::printArr2).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
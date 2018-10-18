import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author LiuYiMing
 * @date 2018/8/9 13:46
 * @describe：
 */
public class Test {

    public static void main(String[] args) throws IOException {

        /*FileInputStream inputStream = new FileInputStream("e://1.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String str = null;
        while((str = bufferedReader.readLine()) != null)
        {

            System.out.println(str);
        }

        //close
        inputStream.close();
        bufferedReader.close();*/
        /*String s = readFile("e://1.txt");
        System.out.println(s);*/

       /* BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("e://1.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("e://2.txt"));

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        bufferedReader.close();
        bufferedWriter.close();*/
        String s = readFile("e://1.txt", "e://3.txt");
        System.out.println(s);

    }

    public static String readFile(String readerFileName,String writerFileName) {
        StringBuffer sb = new StringBuffer("");
        FileReader input = null;
        FileWriter output = null;
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            input = new FileReader(readerFileName);
            output = new FileWriter(writerFileName);
            reader = new BufferedReader(input);
            writer = new BufferedWriter(output);
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
                writer.write(line);
                writer.newLine();
                writer.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != input) {
                try {
                    input.close();
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
   /* public static void bubble(int a[], int n) {
        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }
    }
    public static void bubbleSrot(int a[], int n) {
        for (int i = n; i >= 1; i--) {
            bubble(a, n);
        }
    }*/
}
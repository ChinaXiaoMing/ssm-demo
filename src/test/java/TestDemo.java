import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * @Descript 测试环境
 * @Author fuyuanming
 * @Date 2018-05-17 14:45:41
 * @Version 1.0
 */
public class TestDemo {

    public static void main(String[] args) throws IOException {
        String dirPath = "F:" + File.separator + "test";
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        File file = new File(dirPath + File.separator + "input.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        writeToFile(input, bufferedWriter);
        //输入0结束
        while (!"0".equals(input)) {
            input = bufferedReader.readLine();
            writeToFile(input, bufferedWriter);
        }
        bufferedReader.close();
        bufferedWriter.close();
    }

    private static void writeToFile(String input, BufferedWriter bufferedWriter) throws IOException {
        System.out.println(input);
        if ("\\".equals(File.separator)) {  //window系统下换行
            input = input + "\r\n";
        } else { //linux下换行
            input = input + "\n";
        }
        bufferedWriter.write(input);
    }

}

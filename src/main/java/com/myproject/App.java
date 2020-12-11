package com.myproject;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
//        demoInputOutput();
//       demoReadWrite();
        encodeDemo();
    }

    public static void demoInputOutput() {
        try (InputStream inputStream = new FileInputStream("D:/test.txt");
             OutputStream outputStream = new FileOutputStream("test.txt", true)) {
            byte[] buffer = new byte[4096];
            int result = inputStream.read(buffer);
            while (result != -1) {
                outputStream.write(buffer, 0, result);
                result = inputStream.read(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void demoReadWrite() throws Exception {
        Reader reader = new FileReader("pom.xml");
        Writer writer = new FileWriter("test2.xml");

        char[] buffer = new char[4096];
        int c = reader.read(buffer);
        while (c != -1) {
            writer.write(buffer, 0, c);
            c = reader.read(buffer);
        }
        reader.close();
        writer.close();
    }

    public static void encodeDemo() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("D://Java/java_io/example/test2.xml");
        Reader fileReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = bufferedReader.readLine();
        while (line != null) {
            System.out.println(line);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        fileReader.close();
        fileInputStream.close();
    }
}

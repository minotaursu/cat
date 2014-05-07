package com.minotaur.tools;

import java.io.*;

/**
 * Created by xu.sux on 14-2-27.
 */
public class PomFormat {

    private static final String D_BEGIN_S = "<dependencies>";
    private static final String D_END_S = "</dependencies>";
    private static final String E_BEGIN_S = "<exclusions>";
    private static final String E_END_S = "</exclusions>";

    private static final String D_BEGIN = "<dependency>";
    private static final String D_END = "</dependency>";
    private static final String E_BEGIN = "<exclusion>";
    private static final String E_END = "</exclusion>";

    public static void analyzeDependency(File file) throws IOException {
        FileReader fileReader =new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter =new FileWriter(new File(file.getPath()+".bal"));
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.equals("")) {

            } else {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
//                bufferedWriter.write("\r\n");
            }
        }
        if(bufferedWriter!=null){
            bufferedWriter.close();
        }
        if(fileWriter!=null){
            fileWriter.close();
        }
        if(bufferedReader!=null){
            bufferedReader.close();
        }
        if(fileReader!=null){
            fileReader.close();
        }
    }

    public static void main(String[] args) throws IOException {
        File file =new File("D:\\workspace\\im\\pom.xml");
        analyzeDependency(file);
    }
}

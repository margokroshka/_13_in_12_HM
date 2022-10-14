import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> docs = new ArrayList<>();
        Set<String> docums = new HashSet<>();
        Writer writer = null;
//        for (int i = 0; i < 3; i++) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(true) {
                String str = br.readLine();
                if(str != "0") {
                    docums.add(br.readLine());
                    docs.add(br.readLine());
                    docums.addAll(docs);

                    writer = new FileWriter("txt");
                    for (String line : docs) {
                        writer.write(line);
                        writer.write(System.getProperty("line.separator"));
                    }
                    writer.close();
                } else {
                    System.out.println("стоп");
                    break;
                }
            }
//            docums.add(sc.nextLine());
//            docs.add(sc.nextLine());
//            docums.addAll(docs);
//
//            writer = new FileWriter("txt");
//            for (String line : docs) {
//                writer.write(line);
//                writer.write(System.getProperty("line.separator"));
//            }
//            writer.flush();


//        }


        File Test = new File("txt");
        File fileTXT = new File(Test, "txt");

        String s = "";
        try {
            readSmallFile();
        } catch (IOException exx) {
        }
        System.out.println(s);


    }

    public static void readSmallFile() throws IOException {
        Path path = Paths.get("txt");
        List<String> strings = Files.readAllLines(path);
        BufferedWriter valid = new BufferedWriter(new FileWriter("Test txt"));
        BufferedWriter no_valid = new BufferedWriter(new FileWriter("NoValid"));

        for (String s : strings) {
            try {
                Util.process(s);
                Util.process1(s);
                valid.append(s).append("\n");

            } catch (ExceptionLength | ExceptionStart e) {
                no_valid.append(s).append("\n");
                System.out.println(e.getMessage());
            }
            valid.close();
            no_valid.close();
        }
    }
}


//    public static void whenBufferedWriter() throws IOException{
//        String str="Hello";
//        BufferedWriter writer=new BufferedWriter(new FileWriter("Test txt"));
//        writer.write(str);
//        writer.append(" c");
//        writer.close();
//    }
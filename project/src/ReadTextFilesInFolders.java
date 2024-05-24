import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadTextFilesInFolders {
        public static void main(String[] args) {
            // Provide the path to the parent directory
//            Scanner copyDirectory=new Scanner(System.in);
//            System.out.println("Please enter the path of the directory");
            //copyDirectory.nextLine();
            String parentDirectory = "C:\\Users\\tesfa\\IdeaProjects\\Final_project_DS\\src\\11";

            try {
                // Call the method to read text files in the parent directory and its subdirectories
                List<File> files = new ArrayList<>();
                readTextFiles(parentDirectory, files);

                // Process the files list as needed
                for (File file : files) {
                    System.out.println("Reading file: " + file.getAbsolutePath());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            stringList();
           // Map<parentDirectory,stringList()> amap = new HashMap<>();

        }


        private static void readTextFiles(String directory, List<File> fileList) {
            File folder = new File(directory);
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        fileList.add(file);
                    } else if (file.isDirectory()) {
                        readTextFiles(file.getAbsolutePath(), fileList);
                    }
                }
            }
            stringList();



        }
    public static void stringList(){

            String fileName = "C:\\DS_final_project\\11\\111.txt"; // Replace with the path to your .txt file

            ArrayList<String> lines = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        String[] stringArray = lines.toArray(new String[0]);

        // Print the contents of the ArrayList
//        String [] countingWords=new String[1000];
//        int [] word=new int [1000];
//        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
//            String line;
//            int i=0;
//            while ((line = reader.readLine()) != null) {
//                String [] parts=line.split("");
//                countingWords[i]=parts[0];
//                word[i]=Integer.parseInt(parts[i]);
//                i++;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        }


    }





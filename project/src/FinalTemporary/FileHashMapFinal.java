package FinalTemporary;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FileHashMapFinal {
    public static void main(String[] args) {
        // Specify the parent folder path
        String parentFolderPath = "C:\\DS_final_project\\";

        // Create a File object for the parent folder
        File parentFolder = new File(parentFolderPath);

        // Check if the folder exists and is a directory
        if (parentFolder.exists() && parentFolder.isDirectory()) {
            // Create a HashMap to store the folder names and file contents
            HashMap<String, ArrayList<String>> fileHashMap = new HashMap<>();

            // Get the list of subfolders in the parent folder
            File[] subfolders = parentFolder.listFiles(File::isDirectory);

            // Iterate through the subfolders
            if (subfolders != null && subfolders.length > 0) {
                for (File subfolder : subfolders) {
                    // Get the name of the subfolder
                    String folderName = subfolder.getName();

                    // Create an ArrayList to store the file contents
                    ArrayList<String> fileContents = new ArrayList<>();

                    // Get the list of files in the subfolder
                    File[] files = subfolder.listFiles();

                    // Iterate through the files in the subfolder
                    if (files != null && files.length > 0) {
                        for (File file : files) {
                            // Read the file contents
                            String content = readFileContent(file);
                            // Add the file content to the ArrayList
                            fileContents.add(content);
                        }
                    }

                    // Add the subfolder and file contents to the HashMap
                    fileHashMap.put(folderName, fileContents);
                }
            }

            // Print the HashMap
            for (String key : fileHashMap.keySet()) {
                System.out.println(key + " ---> " + fileHashMap.get(key));

                // Iterate through the file contents
                ArrayList<String> fileContents = fileHashMap.get(key);
                for (String content : fileContents) {
                    // Count words and sentences
                    int wordCount = countWords(content);
                    int sentenceCount = countSentences(content);

                    // Print the results
                    System.out.println("File content: " + content);
                    System.out.println("Word count: " + wordCount);
                    System.out.println("Sentence count: " + sentenceCount);
                    System.out.println();
                }
            }

            // Count words and sentences in the parent folder text
            String parentFolderText = readFileContent(parentFolder);
            int parentFolderWordCount = countWords(parentFolderText);
            int parentFolderSentenceCount = countSentences(parentFolderText);

            // Print the results for the parent folder text
            System.out.println("Parent folder text: " + parentFolderText);
            System.out.println("Word count in parent folder: " + parentFolderWordCount);
            System.out.println("Sentence count in parent folder: " + parentFolderSentenceCount);
        }
    }

    // Helper method to read file content
    private static String readFileContent(File file) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line);
                contentBuilder.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    // Method to count the number of words in a text
    private static int countWords(String text) {
        String[] words = text.split("\\s+");
        return words.length;
    }

    // Method to count the number of sentences in a text
    private static int countSentences(String text) {
        String[] sentences = text.split("[.!?]+");
        return sentences.length;
    }

}


//-----------------------------------------------------//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//
//public class FileHashMapFinal {
//    public static void main(String[] args) {
//        // Create a HashMap to store the folder names and file contents
//        HashMap<String, ArrayList<String>> fileHashMap = new HashMap<>();
//
//        // Specify the parent folder path
//        String parentFolderPath = "C:\\DS_final_project\\";
//
//        // Create a File object for the parent folder
//        File parentFolder = new File(parentFolderPath);
//
//        // Check if the folder exists and is a directory
//        if (parentFolder.exists() && parentFolder.isDirectory()) {
//            // Get the list of subfolders in the parent folder
//            File[] subfolders = parentFolder.listFiles(File::isDirectory);
//
//            // Iterate through the subfolders
//            if (subfolders != null && subfolders.length > 0) {
//                for (File subfolder : subfolders) {
//                    // Get the name of the subfolder
//                    String folderName = subfolder.getName();
//
//                    // Create an ArrayList to store the file contents
//                    ArrayList<String> fileContents = new ArrayList<>();
//
//                    // Get the list of files in the subfolder
//                    File[] files = subfolder.listFiles();
//
//                    // Iterate through the files in the subfolder
//                    if (files != null && files.length > 0) {
//                        for (File file : files) {
//                            // Read the file contents
//                            String content = readFileContent(file);
//                            // Add the file content to the ArrayList
//                            fileContents.add(content);
//                        }
//                    }
//
//                    // Add the subfolder and file contents to the HashMap
//                    fileHashMap.put(folderName, fileContents);
//                }
//            }
//        }
//
//        // Print the HashMap
//        for (String key : fileHashMap.keySet()) {
//            System.out.println(key + " ---> " + fileHashMap.get(key));
//        }
//    }
//
//    // Helper method to read file content
//    private static String readFileContent(File file) {
//        StringBuilder contentBuilder = new StringBuilder();
//        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                contentBuilder.append(line);
//                contentBuilder.append(System.lineSeparator());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return contentBuilder.toString();
//    }
//    private static int countWords(String text) {
//        String[] words = text.split("\\s+");
//        return words.length;
//    }
//
//    // Method to count the number of sentences in a text
//    private static int countSentences(String text) {
//        String[] sentences = text.split("[.!?]+");
//        return sentences.length;
//    }
//}


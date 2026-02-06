import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    public static String getHangmanWord(ArrayList<String> wordlist){
        int num = ((int)(Math.random()*80))+1;
        return wordlist.get(num);
    }
    public static ArrayList<String> setLetterList(String word){
        ArrayList<String> letterList = new ArrayList<>();
        for(int i=0; i<word.length(); i++){
            letterList.add(word.substring(i, i+1));
        }
        return letterList;
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
    public static void main(String[] args){
        ArrayList<String> fileData= getFileData("src/data");
        String x = getHangmanWord(fileData);
        System.out.println(x);
        ArrayList<String> chosenLetterList = new ArrayList<>();
        chosenLetterList = setLetterList(x);
        System.out.println(chosenLetterList);
        String letterPlacement = "[ ";
        for(int i=0; i<x.length(); i++){
            letterPlacement+="___ ";
        }
        letterPlacement+="]";
        System.out.println(letterPlacement);
        
    }
}
package _structs;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Iterator;
public class BrailleReader {
    private static final int WORD_CAPACITY = 10;
    private static HashMap<Character, String> dictionary = new HashMap<Character, String>();
    private static LinkedList<String []> braille = new LinkedList<String []>();
    // change this to the filePath braille.txt is saved in
    static String fileName = "D:\\Java_Practice\\Data-Structures\\_structs\\braille.txt";
    static Scanner inputReader = new Scanner(System.in);
    public static void init(){
        File braille = new File(fileName);
        try{
            Scanner fileReader = new Scanner(braille);
        
            String letter = "";
            while(fileReader.hasNextLine()){

                letter = fileReader.nextLine();
                dictionary.put(letter.charAt(0), letter.substring(1));
            }
            fileReader.close();
        }catch(FileNotFoundException e){
            
        }           
    }
    private static String [] translateWord(String englishWord){
        String temp = "";
        englishWord = englishWord.toUpperCase();
        for(int i = 0; i < englishWord.length(); i++){

           String brailleLetter = dictionary.get(englishWord.charAt(i));
           
            temp += brailleLetter;
        }
        return temp.replaceAll("\\|","\s").split("#");
    }
    public static String[] getInput(){
      

        return inputReader.nextLine().split("\s");
        
    }
    private static void translate(String [] sentence){
        
        for(String s: sentence){
            braille.add(translateWord(s));
        }
        int braillePiece = 0;
        for(int i = 0; i < 3; i++){
            Iterator<String[]> iterator = braille.iterator();
            while(iterator.hasNext()){
                
                System.out.printf("%s", iterator.next()[braillePiece]);
               
            }
            braillePiece++;
            System.out.println();
        }
    }
    public static void main(String[] args) {
        BrailleReader.init();
        String[] input = new String[WORD_CAPACITY]; 
        while(true){
           input = getInput();
           if(input[0].equalsIgnoreCase("exit")){
               System.out.println("Goodbye");
                System.exit(0);
           }
           translate(input);


       }
        
    }
        
}
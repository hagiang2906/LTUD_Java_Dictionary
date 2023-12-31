/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.dictionary;


import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Main {
     static Scanner keyboard = new Scanner(System.in);
     private static String slangPath = config.getSlangPath();
    private static String historyPath = config.getHistoryPath();
    public static void Pause(){
        System.out.println("Press Any Key To Continue...");
        new java.util.Scanner(System.in).nextLine();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        var  SlangMaps = new SlangMaps();
         SlangMaps.readFromFile(slangPath);
        String out = "";
        while(!"e".equals(out)){
            System.out.println("1. Find with slang word !");
            System.out.println("2. Find with definition");
            System.out.println("3. Show history");
            System.out.println("4. Add new slang word");
            System.out.println("5. Edit slang word");
            System.out.println("6. Delete slang word");
            System.out.println("7. Back up origin");
            System.out.println("8. Random slang word");
            System.out.println("9. Game of slang word");
            System.out.println("10. Game of definition");
            System.out.println("11. Exit");
            System.out.print("Enter your choose: ");
            int choose =Integer.parseInt( keyboard.nextLine());
            switch (choose) {
                case 1:
                    System.out.print("Your slang word: ");
                    String key = keyboard.nextLine();
                    SlangWord value = SlangMaps.searchBySlang(key);
                    if(!(value == null)){
                        history.addHistory(key + " : " + value + "\n",historyPath );
                        System.out.println(value);
                    }
                    else{
                        System.out.println("No definition founded !!");
                    }
                    break;
                case 2:
                    System.out.print("Your definition: ");
                    String def = keyboard.nextLine();
                    List<SlangWord> keySet = SlangMaps.searchByDefinition(def);
                    System.out.println("Slang word of " + def + " is: ");
                    for(SlangWord slang: keySet){
                        history.addHistory(slang + " : " + slang.getDefinition(),historyPath);
                        System.out.println(slang);
                    }
                    break;
                case 3:
                    System.out.print("Your history: ");
                    history.ShowHistory();
                    break;
                case 4:
                    System.out.print("Enter slang word: ");
                    String slangKey = keyboard.nextLine();
                    System.out.print("Enter definition: ");
                    String slangDef = keyboard.nextLine();
                    SlangMaps.addSlandWord(slangKey,slangDef);
                    break;
                case 5:
                    System.out.print("Enter slang word you want to edit: ");
                    String editKey = keyboard.nextLine();
                    System.out.print("Enter definition of slang word: ");
                    String editDef = keyboard.nextLine();
                    SlangMaps.editSlangWord(editKey,editDef);
                    break;
                case 6:
                    System.out.print("Slang word you want to delete: ");
                    String deleteKey = keyboard.nextLine();
                    SlangMaps.deleteSlangWord(deleteKey);
                    break;
                case 7:
                    SlangMaps.backUp();
                    break;
                case 8:
                    System.out.println("Your slang word is: ");
                    String randomKey = SlangMaps.randomSlangWord();
                    System.out.println(randomKey + "   :   " + SlangMaps.getByKey(randomKey));
                    break;
                case 9:
                    SlangMaps.slangGame();
                    break;
                case 10:
                    SlangMaps.slangGameDefinition();
                    break;
                case 11:
                    out = "e";
                    break;
                default:
                     System.out.println("Something wrong!");
                    break;
            }
            Pause();
        }
    }
    
}

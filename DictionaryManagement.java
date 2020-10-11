package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class DictionaryManagement {

    private static Scanner scan = new Scanner(System.in);
    private static Dictionary my_words = new Dictionary();
    public Dictionary getMy_words() {
        return my_words;
    }

    public static void insertFromCommandline() {
        System.out.println("number_words is");
        int number_word = scan.nextInt();
        scan.nextLine();

        String input_word_target="";
        String input_word_explain = " ";
       for(int i= 0; i < number_word; i++) {

           System.out.println("word_target is");
           input_word_target=scan.nextLine();
           System.out.println("word_explain is");
           input_word_explain = scan.nextLine();
           my_words.word[i] = new Word(input_word_target,input_word_explain);
       }
    }
    public void insertFromFile() throws Exception {
        File My_Dictionary = new File("dic.txt");
        BufferedReader dic = new BufferedReader(new FileReader(My_Dictionary));
        int number_words = 0;
        String get = "";
        while((get = dic.readLine())!=null){
            String []get_words = get.split("\t",2);//ham split ko the su dung khi get = null len dua vao if
            //System.out.println(get_words[0]+" "+get_words[1]);
            getMy_words().word[number_words] = new Word(get_words[0],get_words[1]);
            number_words++;
        }
        dic.close();
    }
    public void dictionaryLookup(String input) throws Exception{
        System.out.println("the word,you want to look up:");
        input = scan.nextLine();
        for (Word a : my_words.word)
            if (input.equalsIgnoreCase(a.getWord_target())==true) {
                System.out.println("word's explain is " + a.getWord_explain());
            }
            else System.out.println("ko tim thay");
    }
    public String dictionarylook(String input)throws Exception {
        System.out.println("the word,you want to look up:");
        //input = scan.nextLine();
        for (Word a : my_words.word)
            if (input.equalsIgnoreCase(a.getWord_target())==true) {
                System.out.println("word's explain is ");
                return a.getWord_explain();
            }
        return "false;";
    }
    public static void addWord(Word new_word)throws Exception {//static de ham sua giu lieu bien cuc bo
        for (int i=0; i<my_words.word.length;i++) {
            if (new_word.getWord_target().equalsIgnoreCase(my_words.word[i].getWord_target())==true) {
                System.out.println("this word is in the dictionary");
                return;
            } else if (my_words.word[i].getWord_target().equalsIgnoreCase("\0")==true) {
                my_words.word[i] = new Word(new_word);
                break;
            }
            else {
                continue;
            }
        }
    }
    public static void delete(Word new_word)throws Exception {
        for (int i=0; i<my_words.word.length;i++) {
            if (new_word.getWord_target().equalsIgnoreCase(my_words.word[i].getWord_target())==true) {
                my_words.word[i]=my_words.word[i+1];
                return;
            } else if (my_words.word[i].getWord_target().equalsIgnoreCase("\0")==true) {
                System.out.println("this word is not in the dictionary");
                break;
            }
            else {
                continue;
            }
        }
        my_words.number_words--;
    }
    public static void repair(Word new_word,int pos)throws Exception {//static de ham sua giu lieu bien cuc bo
        my_words.word[pos-1] = new Word(new_word);
    }
    public static void dictionaryExportToFile()throws Exception {
        File My_Dictionary = new File("Dictionary_out.txt");
        FileWriter fw = new FileWriter(My_Dictionary);
        for (Word i: my_words.word) {
            fw.write(i.getWord_target());
            fw.write("\t");
            fw.write(i.getWord_explain());
            fw.write("\n");
        }
        fw.close();
    }
}

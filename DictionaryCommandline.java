package sample;
import java.util.Scanner;

public class DictionaryCommandline {
    DictionaryManagement dic = new DictionaryManagement();
    public void showAllWords() {
        int No=0;
        System.out.println("No\tEnglish\tVietnamese");
        for (Word i : dic.getMy_words().word){
            if (i.getWord_target() != "\0"){
                No++;
                System.out.println(No + "\t" + i.getWord_target() + "\t" + i.getWord_explain());
            }
        }
    }
    public void dictionaryBasic() {
        DictionaryManagement dic1 = new DictionaryManagement();
        showAllWords();
    }
    public void dictionaryAdvanced()throws Exception {
        dic.insertFromFile();
        showAllWords();
        String kaka = " ";
        dic.dictionaryLookup(kaka);
    }
    public void dictionarySearcher(String input) throws Exception{
        System.out.println("the word,you want to look up:");
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        int count=0;
        String []cout = new String[dic.getMy_words().number_words];
        for (int i = 0; i < dic.getMy_words().number_words; i++) {
            // System.out.println(my_words.word[i].getWord_target().substring(0,input.length()));
            if (input.equalsIgnoreCase(dic.getMy_words().word[i].getWord_target().substring(0,input.length()))==true){
                cout[count] = dic.getMy_words().word[i].getWord_target();
                System.out.println(cout[count]);
                count++;
            }
        }

    }
    public String[] dictionarySearch(String input)throws Exception {
        int count=0;
        String []cout = new String[dic.getMy_words().number_words];
        for (int i = 0; i < dic.getMy_words().number_words; i++) {
            if (input.equalsIgnoreCase(dic.getMy_words().word[i].getWord_target().substring(0,input.length()))==true){
                cout[count] = dic.getMy_words().word[i].getWord_target();
                count++;
            }
        }
        return cout;
    }

    public static void main(String[] args) throws Exception{
        DictionaryCommandline dic = new DictionaryCommandline();
        dic.dictionaryAdvanced();
    }
}

package code.code150.question126;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void findLadders() throws Exception {
        Solution solution = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        List<List<String>> ans = solution.findLadders(beginWord, endWord, Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        for (List<String> an : ans) {
            System.out.println(an.toString());
        }
    }

    @Test
    public void findLadders1() throws Exception {
        Solution solution = new Solution();
        String beginWord = "magic";
        String endWord = "pearl";
        List<List<String>> ans = solution.findLadders(beginWord, endWord, Arrays.asList("flail","halon","lexus","joint","pears","slabs","lorie","lapse","wroth","yalow","swear","cavil","piety","yogis","dhaka","laxer","tatum","provo","truss","tends","deana","dried","hutch","basho","flyby","miler","fries","floes","lingo","wider","scary","marks","perry","igloo","melts","lanny","satan","foamy","perks","denim","plugs","cloak","cyril","women","issue","rocky","marry","trash","merry","topic","hicks","dicky","prado","casio","lapel","diane","serer","paige","parry","elope","balds","dated","copra","earth","marty","slake","balms","daryl","loves","civet","sweat","daley","touch","maria","dacca","muggy","chore","felix","ogled","acids","terse","cults","darla","snubs","boats","recta","cohan","purse","joist","grosz","sheri","steam","manic","luisa","gluts","spits","boxer","abner","cooke","scowl","kenya","hasps","roger","edwin","black","terns","folks","demur","dingo","party","brian","numbs","forgo","gunny","waled","bucks","titan","ruffs","pizza","ravel","poole","suits","stoic","segre","white","lemur","belts","scums","parks","gusts","ozark","umped","heard","lorna","emile","orbit","onset","cruet","amiss","fumed","gelds","italy","rakes","loxed","kilts","mania","tombs","gaped","merge","molar","smith","tangs","misty","wefts","yawns","smile","scuff","width","paris","coded","sodom","shits","benny","pudgy","mayer","peary","curve","tulsa","ramos","thick","dogie","gourd","strop","ahmad","clove","tract","calyx","maris","wants","lipid","pearl","maybe","banjo","south","blend","diana","lanai","waged","shari","magic","duchy","decca","wried","maine","nutty","turns","satyr","holds","finks","twits","peaks","teems","peace","melon","czars","robby","tabby","shove","minty","marta","dregs","lacks","casts","aruba","stall","nurse","jewry","knuth"));
        for (List<String> an : ans) {
            System.out.println(an.toString());
        }
    }

}
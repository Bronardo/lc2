package Runners;

import com.lc1.*;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.*;
import javax.json.spi.JsonProvider;
import javax.json.stream.JsonParser;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args){
        //60. Permutation Sequence
        //permutationSequence();
        //65. Valid Number
        //validNumber();
        //96	Unique Binary Search Trees
        //uniqueBinarySearchTrees();
        //126. Word Ladder II need to be fixded
        wordLadderII();
//        //130
//        surroundedRegionsRunner();
        //149. Max Points on a Line
        //maxPointsonaLine();
        //174 Dungeon Game
        //dungeonGame();
        //222	Count Complete Tree Nodes   
        //countCompleteTreeNodes();
        //275 H-Index II
        //hIndex2();
        //287. Find the Duplicate Number
        //findtheDuplicateNumber();
        //420. Strong Password Checker
        //strongPasswordChecker();
        //564 Find the Closest Palindrome
        //findClosestPalindrom();
        //787 Cheapest Flights Within K Stops
        //CheapestFlightsWithinKStops787 solve = new CheapestFlightsWithinKStops787();
        //1044	Longest Duplicate Substring
        //longestDuplicateSubstring();
        //1489. Find Critical and Pseudo-Critical Edges in Minimum Spanning Tree

        /*
        int n = 3;
        int[][] edges = {{0,1,100},{1,2,100},{0,2,500}};
        int src = 0;
        int dst = 2;
        int k = 0;
     */
//
//        int n = 4;
//        int[][] edges = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
//        int src = 0;
//        int dst = 3;
//        int k = 1;
/*
        int n = 3;
        int[][] edges = {{0,1,100},{1,2,100},{0,2,500}};
        int src = 0;
        int dst = 2;
        int k = 0;
*/

       // System.out.println(solve.solution1(n, edges, src,  dst,  k));
        //System.out.println(solve.solution2(n, edges, src,  dst,  k));
        //System.out.println(solve.solution4(n, edges, src,  dst,  k));
/*
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for(int[] i: edges){
            pq.add(i);
        }
        while(pq.peek()!=null){
            System.out.println(Arrays.toString(pq.poll()));
        }
    */
//        int[] A = {-4,-1,0,3,10};
//        int[] temp  = new int[A.length];
//        for(int i=0;i<A.length;i++){
//            temp[i] = (int)Math.pow(A[i],2);
//        }
//        Arrays.sort((temp));
//        System.out.println( temp.toString());
//        String s = "1..1.1.1";
//        ValidateIPAddress val = new ValidateIPAddress();
//        System.out.println(val.validIPAddress(s));
//        int a=4;
//        int b  = a%2 ==0? 1:2;
//        System.out.println(b);
//        String c = "a";
//        c= c+b+b+Integer.parseInt("1");
//        System.out.println(c+b);
//        char d = '3';
//        System.out.println((c+b).indexOf(d));
//        String e ="hello";
//        String f = e;
//        System.out.println(e.hashCode());
//        System.out.println(f.hashCode());

    }

    private static void findtheDuplicateNumber() {
        FindtheDuplicateNumber s = new FindtheDuplicateNumber();
        int[] in = {1,3,4,2,2};
        System.out.println(s.findDuplicate(in));
    }

    private static Object fileReaderArray(String url, int mode){
        //mode:1.Array, 2. 2d Array
        String line ="";
        File myObj = new File(url);
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                line = myReader.nextLine();
                System.out.println("line:"+line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        String[] rows = line.substring(1,line.length()-2).split("\\[");
        System.out.println("rows:"+Arrays.deepToString(rows));
        
        return null;
    }

    private static void surroundedRegionsRunner(){
        char[][] in3;
        String line ="";
        try {
            File myObj = new File("Java/resrc/temp1");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                line = myReader.nextLine();
                System.out.println("line:"+line);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String[] rows = line.substring(1,line.length()-2).split("\\[");
        System.out.println("rows:"+Arrays.deepToString(rows));
        int rowN = rows.length-1;
        int columN = (rows[1].length()-1)/4;
        char[][] in4 = new char[rowN][columN];
        for(int i=0;i<rowN;i++){
            for(int j =0;j<columN;j++){
                in4[i][j] = rows[i+1].charAt(j*4+1);
            }
        }
        System.out.println(Arrays.deepToString(in4));
//        char[][] in = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
//        char[][] in2={
//        {'O','O','O','O','X','X'},
//        {'O','O','O','O','O','O'},
//        {'O','X','O','X','O','O'},
//        {'O','X','O','O','X','O'},
//        {'O','X','O','X','O','O'},
//        {'O','X','O','O','O','O'}};
        SurroundedRegions run = new SurroundedRegions();
        run.solve(in4);
//        char[][] a = new char[1][1];
//        a[0][0] = 'a';
//        char[][] b = a;
//        b[0][0] = 'b';
//        System.out.println("a is :"+a[0][0]);
//        System.out.println("b is :"+b[0][0]);
//        a[0][0] = 'a';
//        System.out.println("a is :"+a[0][0]);
//        System.out.println("b is :"+b[0][0]);

    }
    private static void hIndex2(){
        HIndexII sol = new HIndexII();
    }
    private static void findClosestPalindrom(){
        FindtheClosestPalindrome sol = new FindtheClosestPalindrome();
        String in = "1805170081";
        System.out.println(sol.solve2(in));
    }
    private static void strongPasswordChecker(){
        StrongPasswordChecker sol = new StrongPasswordChecker();
        String in   = "aaaaabbbb1234567890ABA";
        String in2  = "AAAAAABBBBBB123456789a";
        System.out.println(sol.strongPasswordChecker3(in));
    }
    private static void longestDuplicateSubstring(){
        LongestDuplicateSubstring run = new LongestDuplicateSubstring();
        String in1 = "banana";
        String in2 = "moplvidmaagmsiyyrkchbyhivlqwqsjcgtumqscmxrxrvwsnjjvygrelcbjgbpounhuyealllginkitfaiviraqcycjmskrozcdqylbuejrgfnquercvghppljmojfvylcxakyjxnampmakyjbqgwbyokaybcuklkaqzawageypfqhhasetugatdaxpvtevrigynxbqodiyioapgxqkndujeranxgebnpgsukybyowbxhgpkwjfdywfkpufcxzzqiuglkakibbkobonunnzwbjktykebfcbobxdflnyzngheatpcvnhdwkkhnlwnjdnrmjaevqopvinnzgacjkbhvsdsvuuwwhwesgtdzuctshytyfugdqswvxisyxcxoihfgzxnidnfadphwumtgdfmhjkaryjxvfquucltmuoosamjwqqzeleaiplwcbbxjxxvgsnonoivbnmiwbnijkzgoenohqncjqnckxbhpvreasdyvffrolobxzrmrbvwkpdbfvbwwyibydhndmpvqyfmqjwosclwxhgxmwjiksjvsnwupraojuatksjfqkvvfroqxsraskbdbgtppjrnzpfzabmcczlwynwomebvrihxugvjmtrkzdwuafozjcfqacenabmmxzcueyqwvbtslhjeiopgbrbvfbnpmvlnyexopoahgmwplwxnxqzhucdieyvbgtkfmdeocamzenecqlbhqmdfrvpsqyxvkkyfrbyolzvcpcbkdprttijkzcrgciidavsmrczbollxbkytqjwbiupvsorvkorfriajdtsowenhpmdtvamkoqacwwlkqfdzorjtepwlemunyrghwlvjgaxbzawmikfhtaniwviqiaeinbsqidetfsdbgsydkxgwoqyztaqmyeefaihmgrbxzyheoegawthcsyyrpyvnhysynoaikwtvmwathsomddhltxpeuxettpbeftmmyrqclnzwljlpxazrzzdosemwmthcvgwtxtinffopqxbufjwsvhqamxpydcnpekqhsovvqugqhbgweaiheeicmkdtxltkalexbeftuxvwnxmqqjeyourvbdfikqnzdipmmmiltjapovlhkpunxljeutwhenrxyfeufmzipqvergdkwptkilwzdxlydxbjoxjzxwcfmznfqgoaemrrxuwpfkftwejubxkgjlizljoynvidqwxnvhngqakmmehtvykbjwrrrjvwnrteeoxmtygiiygynedvfzwkvmffghuduspyyrnftyvsvjstfohwwyxhmlfmwguxxzgwdzwlnnltpjvnzswhmbzgdwzhvbgkiddhirgljbflgvyksxgnsvztcywpvutqryzdeerlildbzmtsgnebvsjetdnfgikrbsktbrdamfccvcptfaaklmcaqmglneebpdxkvcwwpndrjqnpqgbgihsfeotgggkdbvcdwfjanvafvxsvvhzyncwlmqqsmledzfnxxfyvcmhtjreykqlrfiqlsqzraqgtmocijejneeezqxbtomkwugapwesrinfiaxwxradnuvbyssqkznwwpsbgatlsxfhpcidfgzrc";
        String in ="bedddcdebeeabbaebbeeecbdaeebdeecbcaccdadbbebbcceeaabcaeaabbcabbeaaaabbbebcdabcacecdeaccbaedadcebddcecdbbddddcaebbacdbeeaecdebdacbcecebeaaaecbeebcddecabbdcbcaaacbcbcdeddeebeddecbccbbdeecdccbebdeccadabaaccaccbcabcdadaecbcbebbdacbcddeddaceecaebaaebdceaabbbbddedcbddceebcddbccceabbccbedaaebddabcbdeebdceabacdabbcbaceecbcaedeaabcecbbcdcbecbadbceeaddcdebabebdcdacebddccaeeabecbbddbeeeeabcaedddcaaeeeabdeddbabecaeebcbdabadceeebbaaeeaedeceaabccebddeeebcbaeebabdabcdbeedecbccedebcbbdaabbecacdcbdddeddaaeaaedcaecabaaeebbedeedcaaedbabcabbcccbbadeeabcdcecadabcaeeadcbeebaaaebdadcdeebdbeeeecdbbdecadbebaacabaeaabdaedcdbdaecaaadbbaabaecdebcbeeddbedbabdbbbedadaeecdbeebbbbadcddbedcadecedcdaaedeedeeebddbedaaeebababbdedcedebbdbeaccaeeaccdbacbdbaccdaedabcbabbcaeeddadeebecaeccaabacebabceaaaecaccbbcbbbddaaaeaeeacccbabcdcbcbbbddccabedbdceacbdbeaacabdaadbbcdacbacbeeaccecdbcbcadaddcdddddacaeeeeedeedbecdacbdcccdaabcebeacabbeccaccaddebeaadaedcadaecebddcabecaceebbabbbeeaadcacaaeeacadedbdcadbeacedcbabacdecbbdbbbdceecdbaedebbcedcdebbabdcabeecdaeaccecdedddabcadedebbbebedabbdadeaeeddbbceabbbbbebecbbcdbdeabbbacbaeedecbebbecbabaabaabeaceddaeaccccaddabbacdcdccbbecbcaebdabddaebecdedccddacbaedbdbeddccadcaaeaaaeaebbacdbedccdbcebbadcdbdaaeadbcacccaeadeecdeedbceebdcbabbdbebddcaeeedebbebbdbbdbdaceadabeabecededaddcaadeccebbdcdaedabdadecccdbcedbcdeeaaecabbcecbecdbabdaabdbdacaaccdeddbdbbeeeeaeeedaacddcedabdbbdaabdcdabbeeeeebbbcdaceeaccbdedebacadbebebecdcebbeadabccbedeadcdcacdcbacecebbbeebadddbdddaaeaececeaeecbdbdcbbcbdbcdceadeaabdcdcccdccdeeacadebcdecededbaeabdcceaebaeaddbeaaacedabcecedececdabdebebddaaccdabeeedaeadbabdbcbcedecbecdecbbcbbbcdeaccdedbcbbaeccdeacecabdedbadadddebdcdacddcbaacdabdddbccdddbebbcebbbbcbbbbdbdabdaaeceadedbaedadcabbaeaebddbcdeebcaebccdeaadceeacddabdcabdbbcadabbccabdbbaaaacbbbeaaeaaeeebdcaaeccbcbacdbbdcdcededbaedccdaadeaccdbeaadabbcccbbddaaaebadeabdaaacecceadacbaedbdedbcaebccaebcdadbbedbaccebacadabbedcddbcedddbedeeaedecaccaabdaeaadecdaccabebebbccebebaaaedabcddcbdeabbedaecdcbbcccbcebebbdccccdadeddbeaaccbdaeccebbacebccabbdbeacecbabddbbbecbcebebddadeaedeadbbdceacabdaeceaaeecacbbecdecebbcccbdbbdccdccebbbdaaccbdbbecbacdbaccaeedadcbecebbaaeaeeaabcceebccecaabceacdbaadccdcedeeeaadacbbeecaeebbddcacddcadcddcbecdbbbaddacaacdabbcecdecadecbaaceecbdebbdcbabacabeaacedceececcadcbcdbebcacaaaeccbbcecbbbecadcbababdaccaedcbaacaeabdcdcddbebbdeaeaaeedceedeabdcccbaaddcabcecedaccbdeccceacaacaddabddddebedeeccdcaecbbcdaadbeadddbeecdddabbedbddaeaaeecdccdddbdcacbdbdaabeeadecbbbbaccdaceccdcceeebdcaedceadbdcdddbceaadacceddbadbeebdbdbddaeadddbdebacecabbbddadaacdcdccdbadccdeedaebbdcbceebcacdaeaadeacbdadbdebbbbbaeacdaecabeeeadbbddebcddcedeeaacbabbdacdaeddbabececeedeeeabccaccabbbedcbeadbcceaccceadbdaabbdebeeaeedcebbacaaaadceddbabaebeeddcbdeecccbadecabcecbcedebdadcdddedbeaebadcbcdcdbecabcdaeeabbecaacccdeebeeeccebbabdaccecbeceadbddacabecdbaeceecccededbddccaedccdcebdecdaddbedeaeaecbadbcebcddbaedaaddccaaabccbeaabebbdcceedacebbacddeaeadaabadddbcdddcdbaeeeadbbeacbeebadbdbadeedbccdadcebadbebaabdbaeeededdeddcdeeaacacceaeaebebdceedadddabbbdddecabbcbdebaeaaeaabadeaaddacacbebbdeabdceaecdbbaeadebaeddcdcaeddaacdabcaebdaedddbaebcdbabeededdbbbcedcbbabdbaeaabbcbbaaedddbdbdcabdaaccacebaddccbcbcbdccedaaeedcccbbddbeeeedccbaaeedaacccdccadeebcbbeeeeababbcadcadbadedaacbbedecdabacbebcbeaeacdabbaebabeeabcbeabcbbddbacedbdacbdbabedeeebbbdbacdecdceaeecaedeabbdbdaaebcbbccceacbaadebbcbceeeadadccbbdaadcbcecabbadabeacedcbaebdddecdeebcbbadcbaaaacbccbecabbcbbbaacedaedbadceebdbcdaaadadbebcdcaccedaeededebaddedbacbbddeeecaebcddebcddcceeecdaebdecccecbbebcacaaedcecadcbdaecbebaadbacdbceecccaedccbbddaeedebacdaccbedabaaadbddcabedcedaaadaeecedddbdcbccacedbdadeecedeadebaebccccdaeccebcbdaecbeedcddeddabcdaccdbecebcdebbbbbdbcbbeddbdadbbcceaaedeeedcabddddacbbddbddebcddbdabaabadbaddbdabdadcbccadeaeccadbecedbbadcdcedaceaaacadcdebcccbeaacdeebbbcbddcaadcaeddaccbebcbbbebbdeeedadbdabeacbcddaddcacacbdbdeadbdadbdedebdcadcebbccaedeebcdcbdeaeedcbadeebeaedddcbddbaeaeeeebbcbaeccceecdaecdbdacebeadeeaddcebabccaacaadabeeacbacbdebedabbacabceebbadcdccbacbcadbbbadadabaadbdacbcccdecdcceeeaebadddcbceeebeeecbebcdaecccbdcbebdcdecdbeabacadaccebbbdbaedadbedcbeeeaeccaeecabbecabaceacbeccbbbddcdbeedaecdeabaecbdcaddcacdbeeccdaedecbdacebdabdeeeebbbeadccecbdebedaadcbeddceceacecbecdaabceadeeadedeeeabdaabeacdeacadbbbedbdbbadababcbacabbcbcabcbbacdacbacbccdbddeebccdedebaccaaadccbddcedddabacccbdeabeaaecaabddeeacadeecebeddaebaebbeedeaecacadbedeebdacbdecdaecedbcabdadddebabcabbbdbddbaecaeccdbcbdaddaeebbadeecbbeebecaeaabddedadccdacbacdcbcaaaeeacaccdedaaeeebedecadcacedeadedcdaaebbecedabaebeedbbbbbcbddbeadcadcbdacebdaaabbbadeddcaadeadbddedaadaababeabeccceadaeedbcdcdbadcaccceacbddcceeddadeeddaddebbaecbbaeddebeaabbeccaedacdcdbcbcccbaacecaaacddaebbeeaeaabebacecdabadceedeaaceaddceeedaeacbbadcaeddcdbccddececaebbcbcbeccdaaddcdbbdedaadacdbbabbbcbbcdbaddcaaddeeabecbcecbcdbbcbbeeddeedecceceeadcdccbeecbddadbccdabbdceaaeeadaededabdcbccddaabcaeddeacaaabdcceedebbeadddddcdbdbcdbddeecaacdccbddecacdaadedcaeeedbbcecaeacbcdddbabcdedccbbddebcbacbeebdbbcedadbceecddcbbacbeeadbadcbceebadabbddeddbecabdddabedccdbedcaebdeebbbacdeebecebcadabcceeeabeebddcdcaedececcecdbaacceeccadecaacbaecdeecbebeaadcdbdedaabdcbedaecddcbcbdbbeaeaecbaeabddaeccaabbccdbbeaebeabcaaccecaeadcdccaeeccbedbebadbecdccaaaadbeacaacbbbcdacbeeceaceceaadbdccdcbaecebbebcebdbcdbabaecbdaacbbdacdeecbdbdacecdaeecccccaccaabccebbeaaceeaebbbceeaaeedeacdcbbcbeacaedeeacacdbadeebcaecceadaadddbaaaaaccadedccbccdaaaabaccdedddaeeeaadddddabaadcbeabcdbcabdebdedaccbdaaaabbccedaebdccdeeabdbccbdaaaaabbbdddaaecdececcdabdddebddadceaedcaddeabcdbacdcdeadeebdecdbaebdcbdadeceecdbccbaceeebdbbeacaabbeedbccdaddccbababebbdbcddceccbccccbdcebeadedeeaceadabbccbebadbabeeaebcbbeebcbdadadabadedabddbeebddcdedbedbabdaaaabdedbddccdcbdacedbbeadecbadacbcecbcdaceeaaaebdaebaeeacebccbcbedddeeaeacadaecccaecdcbbaabcdebebbdbdeadcadecdaebddbedbddeeddccbddadcecdccdadaadabdbeaedadbccbceaabebeaeaeacddecbddcccbdacdcaddbaccbaecceeccaeceadeeaaddaddaaaabcebececcebdddecacbebdcbcbeeebbabbcebcbdcabbdaeaacbbbebeacabbaaaabedcebbbbadcebccccaeddcbededdbcabeeedbcabbbbdaccceadaeccacaaeececaeeaebcccdccedabeaddababbcaecaddbcaccdacdcadbddcdcbcbdbaadbcdddadabeececbaddebbeadbcdaebececcabaacbcaddadacebbebebcebeabebaedbdcddebdaeeccbdeedceceabeadbecbdacdcaabcdaeedcebbdabbeacccebbaadaadecddbbeadbccdadadcdbcadbcddeaaaabeaedccdcccacdaeccccaecddbeddbceabdbecdddcacdbaebcedccaacbdeeabddedceacebeeadadecbbaccbacbdaebecbdbacecbbedaeabddbeeedcdbbcceecccedcbbeebcbeaeadedeeedabdcdcbbcbcccaadbebbabecbdcceadeccceddacabdbcdbbecbcededaccbbbebbdccaecddbcdecdcbdddbcdacbbcbdabdacbbebadbaedebeeeabdbbdbdbaeecbbcebbeacddcdabccbcbccbceebcbaadaaedcdccceaaebeaeccabcdeeeaacaaecadaeeaedebaecbcacedccaaeaccddeaaabdcedbdecabeaabaccaaabbbceaeccedeacdcbabbdaadebdbdcbcbeddcaaccabeaccdedcebcbdccbabcdcadececcbcdbceabbebcdaecddacaabceabcdbedddecabbcbaceedbdbacbebbeaddcabbdbedadbaeecdeedbdbbebbdcaadcbbaadbdedbdddacbccbdbbedbaddddedcdbdabecacccdcbabddbdbedbbcababbbdaccbcdbdcdecdecceacacbecadecbabbdacccebeeaabeedbadeccccebaeabcdeaacbbccbeeabbaddbeaadccdcaaadceeaeaaddddbedacbeecaaaabedcacabdadcdeacaccacbcabcadcedbeaebbbaecaebeeaddaecdceecbcdbbabdddcdccdedbcadabbbacacabbabaaeebddaaebcbdaeaeadacaedaaaaedeeedcbdaaeeaadaaecddedacbebddabbeddbddcdaebccdcebbaceeecabaadcbccbaddbdacbaddceecdbcecaabdededaaebcdaeccaaebeabaeddabecceaecaeeabdbdbddaaeeebaedecbadaeeaddbcedadcaeacabbdebacaabaeddeedbaaededaadecccdceccababbeeceededbcbdbdaadcdaabdcbeaaeaedcebcbaccabbdeceecdeacccabcaddbeaceadeaecacaeaddbdbdeeeedacdcecbacdceeadababdcadbdaddcbccbaeabebeddbebaccbaaacbaaaebebdcccdbacbbddedacbdbddbbbaaecbaedaebbbdabedbccadebedcbeaedcbaabddcebdccaeaceebddcadcabddadebbaccabeeeaccdaacdeacdabccadecbbcecbbabeabddccbedebaceedbceddcaedabcdeedcdbbbeebaadbcdcedcacabedddbcacabeadbbbbcaeeacecadabbdcbdacdbccbbedecadaebebeaecedabdcbbaaadbdabbdabacbeecabbcadeaecbedaccccdbbcbaeeacbcccddadcdeaaacdbdccbbeedbddedaaddecaeedbcdccdecbaadddbeddbcddcecccbeaecdbbcbcbecdebbedbccbbcaadddbcaabdcdbbeededcaddbbecbeceaccdacccabbeaebbbdeaabbcbecdaccdacaebcedcedeadbdababadaebacacdaebcaaebcedecdeabcedeacedabdcbaeedeeceaaaddecbeecbbeeadaebdacbbbbacccedabdaebcdaaecbeaaebddbdddabccaeebbcdcacbacacadbcebdabcdccdcbebeeedcbdeddeeeeaacebdacadecbbbadbbcbbcbabcacccdadeccbdcbbebbdeabeedeeccacaabcebcbbadecdaaddeadedebbacbcaebebbcaadddbbeecaaaecbdccbcacaadedeeddacedebbebdeecbedaddccdbdcaecaccabeaaacedccaddacedcebdceeebbebcaacaecbeadedeebbadbdcaceaaeabbbcbdcbebbeeeedcacecaeeadcbbeeeadddddbcbdededcddedcaebbcdaecbbdceedacdaeedbeeaaacdbcddceaebeecbceadbecaaccbacbcdbacacdecadddadebdbbdbeeeaacebddaddcdeaebbcabaadcbeadaabcecadadbdcbdededcdeacdbacbebebcbbdbdebababbecebbbcbdebeacedbccbaaabeceeeacacbbdcbbbccdeeaecbaeaaebeccecccaadaaeddeaceeedeeececbeaadccedcdaeeeaedaebeddcdacdacbbccdecbdaaebacdacbebaedaeecbbdbeedcccadbabacdeebdeacdbaaedcebbeeaebcedbecccddcdcdeebbbeceacbdcaacbadaccbedbcbcdebacadcbcbbbcbcebdcddbcbaeaabcdcbdceceedecdcceeeabebaabcdbaedeedabcdbaabceaedecbeebdcbaaddaccbddcbdcebacaecbabdabcceeaecedbeaaadaaebcabdaededdadcdaabacbdceddcebdeceeeeedeeedecbeaceaeceddbbbedebdebddcbdcdeaceacedacdbaebedcbcaebadbcdcadabaeebbbccababcaaedabacecbedadaaddbcabdcccacabcabbdebbdbccbbaeeeaeedccdddbacbeaddbeddceecbabccbabeeeaacbcdcaeccecacbdeddeceabbeeeebdcabcbcbcbcbcdbbcecdbabbceddccebbaacadbcbcaedbeececadcdbabbdbddddebdeeeaddaddedabcebdabbcdadbdeaecdebcaaccddaccadabdeddcbaedacdcecebbcccaedababacbabdbeaceeceedeeaceebddcddddcbceedaceaaaecdbcadbdbcecbcdcaaeeeeaadeecbbdbcacdcdeceebcbdcebbdebaeabdddeaebaaaddbeddabaddaedcacceeceebedcebcaedaeacedacdeadaaacedaeabacceeccabbbdcbecacebaeedccacbbdcaeaeacdbebcacaaccbeebcbdcceccadabacdcddcbcdbacebcaedaebcbdeeceddccadacdeadeaabeeaddbdcdbdeddeaeddbcadbcabceccbccddbcabccebcebdebbbaecdbabaabedeaeacdbbbedacddedeebacbacacdbebebeaeedbccabdceccdbbaecadedcabacbdadbeceadeabdcdbbbeeddcaeadddbdceacddabcdeebedaaabbbcaeaaedbeebaaeccdbeaadeaddddeeeeceacbdcceededeacdabbabcbbbbcdccddedaaebcabaababddcdeecbeaceadceabcaceabbeaacaccecbddbedeecdbabdcedbbabaddbcadbdaeeeedabadddeedabdebcedddcecacccdebdadedbbdaccbcbdacaabeccaeebccdbebebeaadacbdbcacebeebddadebbacbaeddeeaecaedcbddbceadedbbbdaebbacbaeedeecacaabebdbbacbbddcbdeeccacdebdeeccdbcdaabcacdcdacaacdaccbecaebaecbabcbceecdbdeaeebcadbaeedbaeecbacceaacbbbecbeecedaabcdeaeabaaebcaedbbbcaabddddeccdedbedaaaceeacacaaadacadcbaeccecbaddababccbbcdedcabcacedacebaceeacaadaaeebceabaebebeabdeabcbbadacdbeccbabddbbadbbbbaabeeddbcbcbebeeedecaeccbbddbeccbbabcdbadbecdeeeaaabdbcbcaeabadaeeccdbeeddccccbeedebcdcccacacebbbebabeeecdcdbadedeacacaadeadacdeceecabedaaaaaaddcbdeaeadaaebdebdacaeaeeddabdabeaadbbbadbcbcabedbacebabdcbcecbebaeddcccaacbeabeabaedbbbddabccecbbebacebaccbebcaeedbbaaebabebdedacdbabbbeeebacbbcbaddadacbecbcdebcccaaeacbdedcceaedeeeaccbeaeebdbcbbebdeebdcdceacebcdbacaadaabecabeeeaaacedadbbdcaeeceadebddebdeadeaedcadbeaeaeeddeedeeacebbdeccdcbdaedececdaaecacccaaccaddddcdeadddeabdecadbabbedceaccaeacdccbdbaabbdbcadceabbdebdadaebbaabedaddecabbdcaacdcacbbdbddcecadbedeaededaddadbbbeadacbbcbeeeebaacdeabddadbbdaabbadeabcbcaaaceeddcaddcacbaabcbcdcaceadaacedacdbbcabedcbacedeedbdddbeeabceebcacbacaddadacacebbaeccaeebcabcdbdaedcabbedacaeddbbacebecbeedeaaedecbcbbcecdeeacadadeacbadbdddbccdabeaeaaeeaadadbdeebbcdebcddaaccaeddbacccaacabbdabcdabeebdabdebbdbcbbcbeddcccdaeccebeeaadddbcbbabeeeadebddccaebdabbdcddcbdadcdbeecaaebbecbdbbedcedacdceabbbbdbbeadaaddbdcadaabacdeeecccebdbaababbacdcdadaedcdacdbcbbebbacabbbbdacbeecceaabdcbaacdebdbdededbddcabadbbaceadaeecbdddadcebedbeabeeaacebccbeaabcacdecceeabaeceecbdbdcbdbbadeeccedaedbaeddadcadccebaaadadddacdadaaedbcbcceccacaaaedcaeecdececdddaedabdbebcdedceadbacbaeededeccdeecbaececcddeaddbebdbeebbdcdaabbebecbacdbeccdcebcbcdaaeacaedecbcdcdcdaceedcdbdeaeeeaaabbdcbceacaebedeaadadaeacedcbddadddaeaccaaddaeccabaabeaddbdcbacbddceeaecbbbaedbcacaeebccebdcaebdcbcdeeedbeacdddbecabcdcbbaadabbdecedbaccdbabdccacaeabecbcbaccaecebadcdccccbbedacadecaaeaeacbdddaadcaeabcaaadadaebadbeecdbdebcdbccccaaadccaeedecadbceccecceaaadbeadddccbaccebcedeaededcdcdaabdeedbabcdecabaebadeddacaddccbadccdbabbdaaaddcabdeaeddbedadaaaecebadaaeaabbcebacceebababbbadcaabcddaadcdccdbaccbdbbcbcdddccedcadcdabcbbcebbacaceedecaccaeaebabcdbdbeccbbbbcaedeeebcadebeedccddedccdaadaacedcbbaddbddbacbdacdbbccdedbddaddbacadcceeadcbdbaceebbadbbdbcbadebcebedacacbccedbcabbccadabacbbcaecabdedcaadedaaecaacbcecdbddddabbaceceadeaebaaeecdbbdbaedbacebabaaadbcbdcaadbebacdaacbeacdceebaaccdbbdbeacacbccaaacedbcbcabbdeceaedacbceacccedbabcedebabbecbebbcabeebcecebbdbbeeeabcbdeadcccabcdbcbbaebddbbeacbbcbcbbaebedeeecddaeddcbebeababbcabacbbacbbdeaebbdacaeeeadcaeaebdbccbabdecccbeeabdcddddabcdbdcddaeaabeebaeaedadccebddcaedabadddeccddbbabccadceddadbaeaecbadcebbdbecebeabadceeddbbaeecbddcebcbbbebbabaadacbaaecebabbabeacacadaebcbedacedbddcdbdebebacbdebacabaedcddeebbcbaadabeeaacbededdbdcbeadaedeabeabaceeddcdaadecbadecabeaadedbcbbbadadddabbebdacaaccaedcdbcbecdbdecacbbedceababcbedcbedbeccabddbcbbedebbaeedbecadbbaacbeedabcdaeabbaaaebaadcecbacbcceaedeccabbdbbcdceabeaebdcaaeaae";
        String i4 = "aaaa";
        System.out.println(run.longestDupSubstring(i4));
    }
    private static void permutationSequence(){
        PermutationSequence s = new PermutationSequence();
//        System.out.println(s.getPermutation(4,9));
//        System.out.println(s.getPermutation(3,3));
//        System.out.println(s.getPermutation(1,1));
//        System.out.println(s.getPermutation(2,2));
        System.out.println(s.getPermutation(5,37));
//        System.out.println(PermutationSequence.factorial(4));
//        System.out.println(PermutationSequence.factorialWithLoop(4));
    }
    private static void validNumber(){
        ValidNumber s = new ValidNumber();
        String in ="-.1e-1";
        System.out.println(s.isNumber(in));
    }
    private static void dungeonGame(){
        DungeonGame s = new DungeonGame();
        int[][] in = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(s.calculateMinimumHP(in));
    }
    private static void findCriticalandPseudoCriticalEdgesinMinimumSpanningTree(){
        FindCriticalandPseudoCriticalEdgesinMinimumSpanningTree s = new FindCriticalandPseudoCriticalEdgesinMinimumSpanningTree();
        
    }
    
    // Function to insert nodes in level order 
    public static TreeNode insertLevelOrder(int[] arr, TreeNode root,int i){
        // Base case for recursion 
        if (i < arr.length) { 
            TreeNode temp = new TreeNode(arr[i]); 
            root = temp; 
  
            // insert left child 
            root.left = insertLevelOrder(arr, root.left, 
                                             2 * i + 1); 
  
            // insert right child 
            root.right = insertLevelOrder(arr, root.right, 
                                               2 * i + 2); 
        } 
        return root; 
    }
    // Function to print tree nodes in InOrder fashion 
    public static void inOrderPrinter(TreeNode root){
        if (root != null) { 
            inOrderPrinter(root.left); 
            System.out.print(root.val + " "); 
            inOrderPrinter(root.right); 
        } 
    } 
    private static void countCompleteTreeNodes(){
        CountCompleteTreeNodes s = new CountCompleteTreeNodes();
        TreeNode t = new TreeNode();
        int[] a = {1,2,3,4,5,6};
        t = insertLevelOrder(a,t,0);
        inOrderPrinter(t);
        s.solution2(t);
    }
    private static void uniqueBinarySearchTrees(){
        UniqueBinarySearchTrees s =new UniqueBinarySearchTrees();
        System.out.println(s.numTrees(3));
//        System.out.println(s.sol2(2));
    }
    private static void jsonExample(){
        String personJSONData =
                "  {" +
                        "   \"name\": \"Jack\", " +
                        "   \"age\" : 13, " +
                        "   \"isMarried\" : false, " +
                        "   \"address\": { " +
                        "     \"street\": \"#1234, Main Street\", " +
                        "     \"zipCode\": \"123456\" " +
                        "   }, " +
                        "   \"phoneNumbers\": [\"011-111-1111\", \"11-111-1111\"] " +
                        " }";

        JsonReader reader = Json.createReader(new StringReader(personJSONData));

        JsonObject personObject = reader.readObject();

        reader.close();

        System.out.println("Name   : " + personObject.getString("name"));
        System.out.println("Age    : " + personObject.getInt("age"));
        System.out.println("Married: " + personObject.getBoolean("isMarried"));

        JsonObject addressObject = personObject.getJsonObject("address");
        System.out.println("Address: ");
        System.out.println(addressObject.getString("street"));
        System.out.println(addressObject.getString("zipCode"));

        System.out.println("Phone  : ");
        JsonArray phoneNumbersArray = personObject.getJsonArray("phoneNumbers");
        for (JsonValue jsonValue : phoneNumbersArray) {
            System.out.println(jsonValue.toString());
        }
    }
    private static JsonObject jsonFromFile(String url){
        JsonObject o;
        try {
            FileReader f = new FileReader(url);
            return Json.createReader(f).readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static void fileExample(){
        File f= new File(".");
        System.out.println(f.getAbsolutePath());
    }
    private static Object jsonToArray(JsonArray jo,int mode){
        //modes: 1. 1D array 2. 2D array
        switch(mode){
            case 1:
                int[] a = new int[jo.size()];
                for(int i=0;i<a.length;i++){
                    a[i] = jo.getInt(i);
                }
                return a;
            case 2:
                int[][] b = new int[jo.size()][];
                for(int i=0;i<b.length;i++){
                    b[i]  = new int[jo.getJsonArray(i).size()];
                    for(int j=0;j<b[i].length;j++){
                        b[i][j] = jo.getJsonArray(i).getInt(j);
                    }
                }
                return b;
        }

        return null;
    }
    private static void maxPointsonaLine(){
//        jsonExample();
//        fileExample();
//        StringReader r = new StringReader("{\"a\":[[1,1],[2,2],[3,3]]}");
//        JsonReader p = Json.createReader(r);
//        JsonObject o = p.readObject();
//        JsonArray a = o.getJsonArray("a");
//        for(JsonValue v: a) System.out.println(v);
        JsonObject o2 = jsonFromFile("src/main/java/resrc/in1.json");
        JsonArray a2= o2.getJsonArray("a");
        for(JsonValue v: a2) System.out.println(v);
        int[][] a = (int[][])jsonToArray(a2,2);
        MaxPointsonaLine s = new MaxPointsonaLine();
//        System.out.println(s.maxPoints(a));
//        System.out.println(s.sol2(a));
//        System.out.println(s.sol3(a));
        System.out.println(s.sol4(a));
    }
    private static void wordLadderII(){
        WordLadderII s = new WordLadderII();
        String a ="lit";
        String b ="bit";
        System.out.println(s.is1CharDiff(a,b));

    }
}

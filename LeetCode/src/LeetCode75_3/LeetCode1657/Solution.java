package LeetCode75_3.LeetCode1657;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String word1 ="byiwbiibwhyyyibybmbyjiembbbybiyhjbfdmuiiyebbqhbijibbifybbybwmbbyddyyibdiupybbmiymfimvijwypiufywybhbhbjyyyymyyyifwbwuyiybbbbjyjwmduvibfzbmbfyfjpyywiiyuyjbbyhwywbwibbyybiybbwjbfjebymiffyifyijbfiyibibyfbymfkwfbjjhiqiipjmyembwbjijuiuydimwjyeidubdwmdjdijjidyidwbbuwfybmybwyhyfyydbbujzjjuwybibdhiuyfbyjhdbuybybbuyfdlubiimjibijywyiyypbiybbpwywbmvuwuiyiwfbiwdbjiiibiwdiiibiimyfwwbybmjwbfyibixdmuybbdbfyewbyifuubmybbyibibyjwbbibbbwufdbbydifybmbyibidiuybbiuiidjmyuddzvyybyuibjhbbysefjbjmiidbfidybfbyyiybdbubiyhbfdbbbbibwwbmdiwydjbeymmqbihubpjyiuuhibidjidjyhbuhdiybjbidbjdbmddiubiiufymjbuuiwbbubyeeijefuwbyejiybybypyyhbdpbfwhjjbdwbiyiwybbfbiwymwdbbbbiiibbwmdydiuwddhbywbehbyfbizybmyhyiedyibbbmuyjimbyivfejqywdjbybubibyjdmdwbdbmmbjubuiubbbwhbbyhbymhihmdbhubjybdyuibbifbbbhbibybfbjyyjbffiybuemiiwhdbyjebbjyihiwbbyuifiydiybbibubfbifybbyhiiuhbbbbzidbwubwbhbiyybbbyhybyiihijhubfybyzdijbmfuoijiybyyyiubwbbyyyyjjujiyjbjedjdjwwbbyiduyfybyyudbydwiijbbjwybjmiyyyjbubwbcbjyybbmdmwbbjibbwwymbdbmiybiibbhmybybeibifyjybybejdibbbfmbybwyqjdwyibybwmdjbbjhfiyfuubbbfpwybyhjbbyybequyuywyyybjbyyiybwhhbiyiwbfyuyiwyfbjyhibyiiybiwbbjejibdyibbyyudyewypwyyyedfbpbbwyuyjmueyibijyjmyfujydiiyiwibiwuwimbwdyzeyfbfbzwydbbyiwudwjwbybbbjyybyjbbyfyybbiubbmbbibdimyiyybjffybmebbbfbjbuimyjfdbyjiwyyidybijiimwijyyibijdyjbbmeyubmdiwubiwwjfbwybbwihiiwbfuipmbiyebbwhyjfifbuwvdyybdyymfyifjiewmyiydbudbbubbyyiyimbjmwbjhiwfybyhwbibhwfwijmjbmbbebbyibbjbijdhffbdadwddifwbhjdybibwuymyyjbybdywbuebwwiyeymwymyuybyjbwyhimiyimwbzijwwdbhbyffjuybwhfbiibfiwhubyijbhwyuybbemfhfdbtymiyybjjbbyfmhyiymjiibbbdywfjwbbjbyiijubywdffjwmhdwijybwbmidyuyuyibbibibbhuiuibbzbyiwyeijdiebbdbwfbjiyibyifiiyeybbfdbibzbzbbyyfbbjyqmibbmbbiifdbwbbyjibmbyydibdhbbbyyibibyybdmymubjbybwfbuiyburybwbibhbhdjuiiiyufewjbiyjyyybiubizbyhbhyyiyibibbbhyjfijbyjmyybiiiyjbybjbjdduiwywdbumymibyybbbjwuifbbiwddbdddbjbjbdeijjqijiyjydjbiybybyibwhwyefbbyfbdybbdbbyhbywyymdbiybiihiywyjfbwwbdfhqhyuuhiwybbbibmybuyiyweyiiybbibwbhwfybyywjmybmjyieuufnjenbyzuyfimeyiydibmidmybiyfuiuwybbijbjibfyubbefdjziyejibbibhibyyjjwfyjemyhbhwyyiydiyybydmwmbzyfqwbjibjimfyhiuufbyhbmiyfyyyifebfbbbhbifbyidbdbbbwyybebiuubymiyyiiybfyijdiibbpymdmmibyfwufyyjbbumyduyyfyjiiyydbbyyyyfyyiwubbybiidewewiwbbjbbyiibffbubmwdybmwijyigbybymidwfyydyyjifjuybjybibnifjbyibyweyibbmjirbybuvwwuhimywujiymyebjbbhdumeyuiyy";
        String word2 ="dikaziirmizqhrdkzikkiazirzviiiiaraikviiairimrdzihiziiizszizzizkiaimhaazdavmaaajlimrikzvhiiiikiizziikrijaiaimzaakizzmrakiziairzaraazraikraaidmihzjizsarzaizismirzsvaazkzsiiziivaaiikivsiiizmzaizrizzzzizikzmkiivijmiiiirvjiziisadrzizjssdiiijzrakqizizkvsazzzkaddmkivairuazsrqjrazzaijkrmzmdsivzddjziimikimmzsazhazjakzvzvzkriirzijmvavaiijurzafziavkrizizjkijzamadzivazzjaakjvavukkiiksizrvgvivivazkmaiijaivrdaskdmsriaizardaikasairakzvmkdsahdiziiiviiihzaavkzvazrizmsarzmikmjkaizifrrkkzmazdsmivvivaiviiizsacaamkzrsdzzaikmizmrzvzjjakazkzzzmzrzijazizimkrikzkiizzzhiizadirdiazdasviarzkirvsaizrisdazszhzziazizrdaziraasdiariaiizkmshumzzadrjaiiiizzsdjaziajziiszdzzsrrsrzzdsiqaihiridizdmadzekmrkismrbrziikrmmizizhrvmjvjzziahikiaajazsdaaikazzdrvjishakmdzajaajhjjivzzrzjaiikirimzijhjzizzzdzziiizazaazahrrzdaszvaavajzkradhhamviijzmkzjizahvksakrszzhisdiikrrzkkimarzizizhorzisrrizruaaijizaizhjizzraissiziarjirjamajadaiiiviaizizmvaazhzraimimvvaiazzkibzasikajkavaavmizzizzadiijajkiiiakikiksmdjzdzzmziikajjzzkzzziazjiairdaiiivisiazzzhdamhmzshrdiziziaazvzsaikrkizhaizrmzarzrzaadviavivdjiiavmziaazkkirddvihkiaiqziiiaijrzkazvazamzizizzsmikiiikddirjjizmrzzmvmzzijmkiivjiimriaidsazaidriakjajziikazaskahzazihrdiiiflzzddkidkzuzijmhzzidihzizidmiqaairmjdadrramaiiijrmaiaiiarjiiiidzmsazmahmjazijihkaiarkazirzazaiakjdvrivhrzazamaaiivzliiqijizzzjzaimzmmhiajimzkikjzikmakviizmijihzdiizizizzrivadaviaiiiiidvziaizzrisrfkirvizjzaidzjjrapkakzrzvvmaimzdidadrjumzaazjuhhziizkddzzrkiiimajmrsazazizdakmiasvkzmazrflkzzaiizhivdzdmvdairzimrrvrzisklzvrkjrkjdzdhzaziiidmiznixjaksiizviiiazzaizkzvizzkhdisvizjasziarzjlikizaidiramzjiamvdaraadrimiaikzaddzzdvaiirdariizriaaizziaizirmizdzizizzzivkakvikiizhiszvkdikiizimkmaiiiirmiiaaywszaiiziiviuzimiaajzzzmakvazvrmsaizaskramsrirzizirrimksvrsjzakavviziirjdfzvidaarmiizriikriarizzrajdzkzdziaiiviaidrsziakikkmiairaaziiiijjiaaiqazihiizziziidzqiiikzkamimiazvzadadzhdzzakvazzzrrkiimsazriiiijariiivzhdzhkarrsimaarzaizijlzdzazvkzazizmmkzqrzmaziziadvziidziiziizvzirizivijaiiaadszduivvkajrazdlimzjisijiqjiaisiabzmzitziraakvakkidmmqikvaiikjjikikjizzaaazizaijsqzvimjzvurmmkzriisdaivkzfmvdzzkazzdkjzkjiviirzrvmajziijmzizmuahikiijrivmaraivdadmirzravazaiimmiiqadzsvrirkzdjavksdlaiivirzlazaiadrjmiirvizizkzzkszizikaghvzmiiqzdmiqhvazmzhikairazkkiivmkjzraiiijaiukrzivjzazidkriziszizkzvarzmmaaiivhmuzmikzadz";
        System.out.println(closeStrings(word1, word2));
    }
    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        if (word1.equals(word2))return true;
        //abbzzca
        //a2b2z2c1
        //babzzcz
        //a1b2z3c1
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        List<Integer>list1 =new ArrayList<>();
        List<Integer>list2 =new ArrayList<>();
        for (int i = 0; i < word1.length(); i++) {
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < word2.length(); i++) {
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0) + 1);
        }
        for (Character character : map1.keySet()) {
            if(!map2.containsKey(character)){
                return false;
            }
        }
        for (Character character : map2.keySet()) {
            if(!map1.containsKey(character)){
                return false;
            }
        }

        for (Integer value : map1.values()) {
            list1.add(value);
        }
        for (Integer value : map2.values()) {
            list2.add(value);
        }
        Collections.sort(list1);
        Collections.sort(list2);
        for (int i = 0; i < list1.size(); i++) {
            //集合 用equals
            if(!(list1.get(i).equals(list2.get(i)))){
                return false;
            }
        }
        return true;
    }

}

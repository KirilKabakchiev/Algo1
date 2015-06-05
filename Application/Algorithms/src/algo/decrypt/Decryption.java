package algo.decrypt;

import java.util.HashMap;
import java.util.Map;

public class Decryption {
    
    private static final String ENCRYPTED1= "vrItommseIal vihack~416~Ilocveakgrithms he";
    private static final String ENCRYPTED2= "rc hscesi tcrest~410~thisaecr .rcese";
    private static final String ENCRYPTED3= "fl k.ccfsIolskv.~312~ .Ifrckslovelvo";
    private static final String ENCRYPTED4= "o?uin uw?stutnfwat?~413~orwa? thfuisnnrsiu";

    public static void main(String[] args) {
        System.out.println(constructOriginalMessage(ENCRYPTED1));
        System.out.println(constructOriginalMessage(ENCRYPTED2));
        System.out.println(constructOriginalMessage(ENCRYPTED3));
        System.out.println(constructOriginalMessage(ENCRYPTED4));
    }


    public static String constructOriginalMessage(String encoded) {
        
        int lengthEncoded = encoded.length() / 2;
        encoded = encoded.substring(lengthEncoded) + encoded.substring(0, lengthEncoded);
        
        int alphabetMarker = encoded.indexOf('~');
        int lengthAlphabet = Integer.parseInt(encoded.substring(0, alphabetMarker));
        String alphabet = encoded.substring(alphabetMarker + 1, alphabetMarker + 1 + lengthAlphabet);
        
        int keyMarker = encoded.indexOf('~', encoded.indexOf('~') + 1);
        int lengthKey = Integer.parseInt(encoded.substring(keyMarker + 1));
        String key = encoded.substring(keyMarker - lengthKey, keyMarker);
        
        String encryptedMessage = encoded.substring(alphabetMarker + 1 + lengthAlphabet, keyMarker - lengthKey);
        
       
        StringBuilder decryptedMessage = new StringBuilder();
        Map<Character, Integer> map = indexedAlphabet(alphabet);
        int walkOnEncoded = 0, walkOnKey = 0;
        while(walkOnEncoded < encryptedMessage.length()){
            if(walkOnKey == lengthKey){
                walkOnKey = 0;
            }
            
        int ind = (map.get(encryptedMessage.charAt(walkOnEncoded)) - map.get(key.charAt(walkOnKey)))%lengthAlphabet;      
        if(ind < 0){
            ind+=lengthAlphabet;
        }
        char currentOriginalChar = 
               alphabet.charAt(ind); 
         decryptedMessage.append(currentOriginalChar);
         walkOnEncoded++; walkOnKey++;
         
        }
        
       
        return decryptedMessage.toString();
    }
    
    private static Map<Character, Integer> indexedAlphabet(String alphabet){
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < alphabet.length(); i++) {
            map.put(alphabet.charAt(i), i);
        }
        return map;
    }
}

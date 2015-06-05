package algo.palindromes;

public class Palindromes {

    public boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < (n / 2) + 1; ++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public void printPalindromicRotations(String s) throws IllegalArgumentException {

        int n = s.length();
        boolean flag = false;
        

        if (n < 1 || n > 1000) {
            throw new IllegalArgumentException("Input string length must be between 1 and 1000");
        }
        
        if(isPalindrome(s)){
            System.out.println(s);
            flag = true;
        }

        for (int i = 0; i < n - 1; i++) {
            StringBuilder sb = new StringBuilder();
            String str1 = s.substring(i + 1, n);
            String str2 = s.substring(0, i + 1);
           // System.out.println(str1 + str2);

            if (isPalindrome(sb.append(str1).append(str2).toString())) {          
                System.out.println(sb.toString());
                if(flag == false){
                    flag = true;
                }
            }
        }
        
        if(flag == false){
            System.out.println("NONE");
        }
    }

    public static void main(String[] args) {
        // hellohello
        // elloh
        // llohe
        // lohel
        // ohell

       // System.out.println(new Palindromes().isPalindrome("wakaakaw"));
        new Palindromes().printPalindromicRotations("shakira");
    }
}

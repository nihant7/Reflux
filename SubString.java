public class SubString {

    public static void main(String[] args) {
        String str = "abbab";
        int start = 0;
        String s = "";
        for (start = 0; start < str.length(); start++) {
            for (int i = start; i < str.length(); i++) {
                s = str.substring(start, i + 1);
                    if(isPalindrome(s)) {
                        System.out.println("Found : " + s);
                    }
            }

        }
    }

    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= s.length() - 1 && j >= 0) {
            if (s.charAt(i) != s.charAt(j)) { //abcab
                return false;
            }
            else {
                i++;
                j--;
            }
        }
        return true;
    }


}

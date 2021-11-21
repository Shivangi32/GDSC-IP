class Solution {
    public List<String> letterCombinations(String digits) {
        
        res=new ArrayList<>();
        if(digits.length()==0)
            return res;
      
        printKPC(digits , "");
        return res;
    }
    static List<String>res;
    static String []codes = {
        ".",
        ".;",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"};
    public static void printKPC(String str, String asf) {
        if(str.length() == 0){
            res.add(asf);
            return;
        }
        
        int index = str.charAt(0) - '0';
        String code = codes[index];
        
        String fS = str.substring(1);
        for(int i=0;i<code.length();i++){
            char cod = code.charAt(i);
            printKPC(fS, asf+cod);
        }
        
    }
}
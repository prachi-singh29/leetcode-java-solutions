class Solution {
    public int countVowelSubstrings(String word) {
        int count=0;
        for(int i =0;i<word.length();i++){
            boolean[] seen=new boolean[5];
            int unique=0;
            for(int j=i;j<word.length();j++){
                char c=word.charAt(j);
                if(!isVowel(c)){
                    break;
                }
                int index=getIndex(c);
                if(!seen[index]){
                    seen[index]=true;
                    unique++;
                }
                if(unique==5){
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
    private int getIndex(char c){
        if(c=='a') return 0;
        if(c=='e') return 1;
        if(c=='i') return 2;
        if(c=='o') return 3;
        return 4;
    }
}
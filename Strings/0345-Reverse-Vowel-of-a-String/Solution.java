class Solution {
    public String reverseVowels(String s) {
        int n=s.length();
        char[] arr=s.toCharArray();
        int start=0;
        int end=n-1;
        while(start<end){
            while(start<end && !isVowel(arr[start])){
                start++;
            }
            while(start<end && !isVowel(arr[end])){
                end--;
            }
            char temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        return new String(arr);
    }
    public boolean isVowel(char ch){
        ch=Character.toLowerCase(ch);
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U';
    }
}
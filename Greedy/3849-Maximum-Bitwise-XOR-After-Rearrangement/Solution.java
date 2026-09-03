class Solution {
    public String maximumXor(String s, String t) {
        int ones=0;
        int zeroes=0;
        for(char c:t.toCharArray()){
            if(c=='1'){
                ones++;
            }else{
                zeroes++;
            }
        }
        StringBuilder result=new StringBuilder();
        for(char c:s.toCharArray()){
            if(c=='0'){
                if(ones>0){
                    result.append('1');
                    ones--;
                }else{
                    result.append('0');
                    zeroes--;
                }
            }else{
                if(zeroes>0){
                    result.append('1');
                    zeroes--;
                }else{
                    result.append('0');
                    ones--;
                }
            }
        }
        return result.toString();
    }
}
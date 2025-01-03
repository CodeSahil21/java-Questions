package Topics.Strings.Medium;
//https://leetcode.com/problems/string-to-integer-atoi/description/
public class Quest4 {
    public int myAtoi(String str) {
        int result = 0;
        int i = 0;
        int sign = 1;
        if (str.isEmpty()) {
            return 0;
        }
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if(i < str.length() && str.charAt(i) == '-'){
            sign = -1;
            i++;
        }else if(i < str.length() && str.charAt(i) == '+'){
            i++;
        }
        while(i < str.length()){
            int currentChar = str.charAt(i);
            if(currentChar < '0' || currentChar > '9'){
                break;
            }
            // Check for overflow and underflow before updating the result
            if (result > (Integer.MAX_VALUE - (currentChar - '0')) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result*10+ (currentChar-'0');
            i++;
        }
        return result*sign;
    }
}


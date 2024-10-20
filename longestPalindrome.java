import java.util.*;
public class Main 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string: ");
        String s = sc.next();
        System.out.println("Longest palindromic subsequence: " + longestPalindrome(s));
    }
    
    // LongestPalindrome checking method
    public static String longestPalindrome(String s) 
    {
        List<String> list = new ArrayList<>();
        String result = "";
        int maxLen = 0;

        for(int i = 0; i < s.length(); i++)
        {
            for(int j = i;j < s.length(); j++)
                list.add(substring(i, j, s));
        }
        
        for(String str : list)
        {
            if(palindrome(str))
            {
                if(str.length() > maxLen)
                {
                    maxLen = str.length();
                    result = str;
                }
            }
        }
        
        return result;
           
    }
    
    // Substring generation function
    public static String substring(int startPos, int stopPos, String s)
    {
        String ans = "";
        for(int i = startPos; i <= stopPos; i++)
        ans = ans + s.charAt(i);

        return ans;
    }
    
    // Check palindrome method
    public static boolean palindrome(String s)
    {
        int leftPtr = 0;
        int rightPtr = s.length() - 1;

        while (leftPtr < rightPtr) 
        {
            if (s.charAt(leftPtr) != s.charAt(rightPtr)) {
                return false;
            }
            leftPtr++;
            rightPtr--;
        }

        return true;
    }


}
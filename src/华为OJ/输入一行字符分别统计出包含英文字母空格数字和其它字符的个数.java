package 华为OJ;
import java.util.*;  
import java.util.regex.*;  
  
public class 输入一行字符分别统计出包含英文字母空格数字和其它字符的个数{  
    public static void main(String[] args){  
        输入一行字符分别统计出包含英文字母空格数字和其它字符的个数 m=new 输入一行字符分别统计出包含英文字母空格数字和其它字符的个数();  
        Scanner s=new Scanner(System.in);  
        String test=s.nextLine();  
        System.out.println(m.getEnglishCharCount(test));  
        System.out.println(m.getBlankCharCount(test));  
        System.out.println(m.getNumberCharCount(test));  
        System.out.println(m.getOtherCharCount(test));  
    }  
    public static int getEnglishCharCount(String str)  
    {   Pattern pattern=Pattern.compile("[A-Za-z]");  
        Matcher m=pattern.matcher(str);  
        int count=0;  
        while(m.find()){  
            count++;  
        }  
        return count;  
    }  
      
    public static int getBlankCharCount(String str)  
    {   Pattern pattern=Pattern.compile(" ");  
        Matcher m=pattern.matcher(str);  
        int count=0;  
        while(m.find()){  
            count++;  
        }  
        return count;  
    }  
      
    public static int getNumberCharCount(String str)  
    {   Pattern pattern=Pattern.compile("\\d");  
        Matcher m=pattern.matcher(str);  
        int count=0;  
        while(m.find()){  
            count++;  
        }  
        return count;  
    }  
      
    public static int getOtherCharCount(String str)  
    {  
        return str.length()-getEnglishCharCount(str)-getBlankCharCount(str)-getNumberCharCount(str);  
    }  
}  
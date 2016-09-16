package algorithm;
/**
 * 赛程规划
 * @author lou
 */
import java.util.LinkedList;

public class 赛程安排{  
    private int num; // 队伍数  
  
    public static void main(String[] args){
    	new 赛程安排(3).print();
    }
    private LinkedList<Integer> list = new LinkedList<Integer>();  
  
    public 赛程安排(int n)  
    {  
        this.num = n;  
        init();  
    }  
  
    private void init()  
    {  
        if (num % 2 == 0)  //偶数个队伍  
        {  
            for (int i = 0; i < num; i++)  
            {  
                list.add(i + 1);  
            }  
        }  
        else  //奇数个队伍  
        {  
            for (int i = 0; i < num; i++)  
            {  
                list.add(i + 1);  
            }  
            list.add(0);  
        }  
  
    }  
  
    public void print()  
    {  
        for (int i = 0; i < list.size() - 1; i++)  
        {  
            System.out.println("\n第" + (i + 1) + "天");  
            for (int j = 0; j < list.size() / 2; j++)  
            {  
            	if(list.get(j)==0||list.get(list.size() - 1 - j)==0){
            		if(list.get(j)==0){
            			System.out.println(list.get(list.size()-j-1) + "(轮空)");
            		}else{
            			System.out.println(list.get(j) + "(轮空)");
            		}
            	}else{
            		System.out.println(list.get(j) + "(主)--"  
                            + list.get(list.size() - 1 - j)+"(客)");
            	}
                  
            }  
            int temp = list.pollLast();  //移动  
            list.add(1, temp);  
  
        }  
        
        
    }
    }  

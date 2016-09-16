package algorithm;
/**
 * package algorithm;
 * 对于又要排序又会重复的集合进行排序 比如对成绩排序 但是可能不同人有相同的成绩
 */
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.Iterator;
public class Map放入Collection进行排序{

	public static void main(String[] args) {
		//输入 3 0 fang 90 yang 50 ning 70
    	Scanner scan=new Scanner(System.in);
       	final int n=scan.nextInt();
        final int type=scan.nextInt();
        HashMap<String, Integer> map=new HashMap<String, Integer>();
        TreeSet<Map.Entry<String,Integer>> set=new TreeSet<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String,Integer>>(){
        	@Override
            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2){
            		if(o1.getValue()>o2.getValue()){
                    	return (type==0)?-1:1;
                    }else if(o1.getValue()<o2.getValue()){
                    	return (type==0)?1:-1;
                    }else{
                   		return 0;
                    }
            }
        });
        for(int i=0;i<=n-1;i++){
        	map.put(scan.next(),scan.nextInt());
        	
        }
        set.addAll(map.entrySet());
        
        Iterator<Map.Entry<String,Integer>> iterator=set.iterator();
        while(iterator.hasNext()){
        	Map.Entry<String,Integer> entry=iterator.next();
            	System.out.print(entry.getKey()+" "+entry.getValue());
            if(iterator.hasNext()){
            	System.out.println();
            }
        }
	}
    
}

package algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

public class 对Map值中某字段进行排序{
	public static void main(String[] args) {
		HashMap<String, LinkedList<String>> map=new HashMap<String, LinkedList<String>>();
		map.put("Lou",new LinkedList<String>(Arrays.asList("91","92")));
		map.put("Liu",new LinkedList<String>(Arrays.asList("80","95")));
		map.put("Li",new LinkedList<String>(Arrays.asList("92","89")));
		map.put("Ke",new LinkedList<String>(Arrays.asList("91","95")));
		System.out.println(map);
		
		TreeSet<Map.Entry<String, LinkedList<String>>> one=new TreeSet<Map.Entry<String, LinkedList<String>>>(new Comparator<Map.Entry<String, LinkedList<String>>>() {

			@Override
			public int compare(Entry<String, LinkedList<String>> o1,
					Entry<String, LinkedList<String>> o2) {
				if(Integer.valueOf(o1.getValue().get(0))<Integer.valueOf(o2.getValue().get(0))){
					return -1;
				}else if(Integer.valueOf(o1.getValue().get(0))>Integer.valueOf(o2.getValue().get(0))){
					return 1;
				}else{
					return 0;
				}
			}
		});
		one.addAll(map.entrySet());
		
		
		TreeSet<Map.Entry<String, LinkedList<String>>> two=new TreeSet<Map.Entry<String, LinkedList<String>>>(new Comparator<Map.Entry<String, LinkedList<String>>>() {

			@Override
			public int compare(Entry<String, LinkedList<String>> o1,
					Entry<String, LinkedList<String>> o2) {
				if(Integer.valueOf(o1.getValue().get(1))<Integer.valueOf(o2.getValue().get(1))){
					return -1;
				}else if(Integer.valueOf(o1.getValue().get(1))>Integer.valueOf(o2.getValue().get(1))){
					return 1;
				}else{
					return 0;
				}
			}
		});
		two.addAll(map.entrySet());
		System.out.println(one);
		System.out.println(two);
	
	}
	
}

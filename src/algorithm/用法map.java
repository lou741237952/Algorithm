package algorithm;

import java.net.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class 用法map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new 用法map();
	}
	public 用法map(){
		 Map<String,String> map=new HashMap<String,String>();
		map.put("louyang", "175");
		map.put("liuguiling","160");
		
		System.out.println("hashcode():"+map.get("louyang").hashCode());
		System.out.println("hashcode():"+map.get("liuguiling").hashCode());
		
		System.out.println("keySet()遍历Key:");
		Iterator<String> it1=map.keySet().iterator();
		while(it1.hasNext()){
			String key=it1.next();
			System.out.println(key);
		}
		
		System.out.println("\n\nvalues()遍历Value:");
		Iterator<String> it2=map.values().iterator();
		for(String str:map.values()){
			System.out.print(str+" ");
		}
		
		System.out.println("\n\nentrySet()遍历Key-Value:");
		Iterator<Map.Entry<String, String>> it3=map.entrySet().iterator();
		for(Map.Entry<String, String> entry:map.entrySet()){
			System.out.println("Key: "+entry.getKey()+" Value:"+entry.getValue());
		}
		
	}
		
}

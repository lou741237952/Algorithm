package algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class 重写hashCode和equals {
	private String name;
	
	public static void main(String[] args) {
		重写hashCode和equals MyMaptest1=new 重写hashCode和equals("louyang");
		重写hashCode和equals MyMaptest2=new 重写hashCode和equals("liuguiling");
		重写hashCode和equals MyMaptest3=new 重写hashCode和equals("unknow");
		people p1=new people(1);
		people p2=new people(2);
		people p3=new people(2);
		people p4=p3;
		
		Map<people,重写hashCode和equals > map=new HashMap<people,重写hashCode和equals>();
		map.put(p1, MyMaptest1);	//可以放入map
		map.put(p2, MyMaptest2); //可以加入map
		map.put(p3, MyMaptest2);	//不是同一个实例对象  如果不重写hashcode和equals 会成为一个新的key
		map.put(p4, MyMaptest3);	//与p3是同一个实例对象，不重写hashcode和equals也不能加入  默认的hashcode和equals都可以式他们相等
		
		for(Map.Entry<people, 重写hashCode和equals> entry:map.entrySet()){
			people key=entry.getKey();
			重写hashCode和equals value=entry.getValue();
			System.out.println("Key: "+key.toString()+" Value: "+value.toString());
		}
		
	}
	public 重写hashCode和equals(String name){
		this.name=name;
	}
	public String toString(){
		return this.name;
	}
	
}

class people{
	private int id;
	people(int i){
		this.id=i;
	}
	public String toString(){
		return String.valueOf(this.id);
	}
	
	public int hashCode(){
		return 1;
	}
	
	public boolean equals(Object o){
		if(this==o){return true;}
		if(o instanceof people){
			if(id==((people)o).id){
				return true;
			}
		}
		return false;
	}
//	public boolean equals(Object o){
//		return true;				//hashCode相等的时候看equals  如果equals相等不能加入 如果不相等加入到linkedlist
//	}
}


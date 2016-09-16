package algorithm;
import java.util.*;

public class 比较器排序 {

	public static void main(String[] args) {
		Set<item> set=new TreeSet<item>();
		set.add(new item("楼洋",25));
		set.add(new item("刘贵玲",24));
		set.add(new item("何赛灵",50));
		set.add(new item("何赛灵",100));
		set.add(new item("竺可桢",100));
		set.add(new item("耶稣",100));
		set.add(new item("释迦摩尼",100));
		set.add(new item("释迦摩尼",100));	//加入不进去
		Iterator<item> iterator=set.iterator();
		while(iterator.hasNext()){
			item p=iterator.next();
			System.out.println("Name:"+p.getName()+"Age:"+p.getAge()+" Hashcode:"+p.hashCode());
		}
		
	}
	
}
class item implements Comparable<Object> {			
	private String name;
	private int age;
	item(String name,int age){
		setName(name);
		setAge(age);
	}
	 void setName(String name){
		this.name=name;
	}
	 void setAge(int age){
		this.age=age;
	}
	 String getName(){
		return this.name;
	}
	 int getAge(){
		return this.age;
	}
	 
	 @Override
		public int compareTo(Object o) {
			item p=(item)o;
			if(age<p.getAge()){
				return -1;
			}
			if(age>p.getAge()){
				return 1;
			}
			if(age==p.getAge()){
				int num=p.getName().length();
				if(name.length()<num){return -1;}
				if(name.length()>num){return 1;}
				if(p.getName().equals(this.name)){return 0;}
			}
			
				return 1;
			
			
		}
	 public int hashCode(){		//规定equals相等时候要求hashcode也相等
		 return name.hashCode()+age;
	 }
	 
	 public boolean equals(Object o){		//根据规定，comparable相等的时候应该保证equals也相等，才能拥有正确的自然排序
		 item p=(item)o;
		 if(p.getName().equals(this.name)&&p.getAge()==this.age){return true;}
		 return false;
	 }
		 
	 
}


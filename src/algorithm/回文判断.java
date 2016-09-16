package algorithm;

public class 回文判断 {

	public static void main(String[] args) {
		new 回文判断("上,海,自,来,水,来,自,海,上");

	}
	public 回文判断(String str){
		String strarr[]=str.split(",");
		for(String s:strarr){
			System.out.print(s+" ");
		}
		
		for(int i=0;i<=strarr.length-1;i++){
			if(i>=(strarr.length-1)/2){
				System.out.println("\n是回文！");
				break;
			}
			if(!strarr[i].equals(strarr[strarr.length-1-i])){
				System.out.println("\n不是回文！");
				break;
			}
			
		}
	}
}

package algorithm;

public class 恒生比赛题 {
	int x,y,z;
	public static void main(String[] args) {
		恒生比赛题 tes=new 恒生比赛题();
		System.out.println(tes.x+" "+tes.y+" "+tes.z+" ");
	}
	
	public  恒生比赛题(){
		int i,m,n;
		for (i=1;i<=3;i++){			//b
			
			for(m=1;m<=3;m++){		//a
				if(m==1) continue;
				for(n=1;n<=3;n++){	//c
					if(n==1||n==3) continue;
					this.x=i;
					this.y=m;
					this.z=n;
				}
			}
			if(x==y||x==z||y==z){
				continue;
			}else{
				break;
			}
		}
	}
}
	


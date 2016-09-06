
public class Person implements Comparable{
    public static final int M=10000;
    public static final int MAX=10000;
	private double money; 
	
    public Person(double money) {
		this.money=money;
	}
	
	public int compareTo(Object arg0) {
		Person person=(Person)arg0;
		if(money==person.money) return 0;
		if(money<person.money) return -1;
		return 1;
	}
	public static int ranInt(int min,int max) {
		return (int)(min+Math.random()*(max-min+1));
	}
	
	public static double ranDouble(int min,int max){
		return min+Math.random()*(max-min+1);
	}
	
	public static boolean check(Comparable[] a){
		for (int i = 1; i < a.length; i++) {
			if(a[i-1].compareTo(a[i])>0)
			        return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		Person[] pa=new Person[M];
		for(int i=0;i<M;++i){
			pa[i]=new Person(ranDouble(0, MAX));
		}
	
		//for(int i=0;i<M;++i){
		//	System.out.print(pa[i].money+" ");
		//}
		
		long before=System.currentTimeMillis();
		//Sort.insertion(pa);
		//Sort.guiBing(pa);
		//Sort.quick(pa,0);
		
		Sort.quickThree(pa);
		long after=System.currentTimeMillis();
		System.out.println(after-before);
		//for(int i=0;i<M;++i){
		//	System.out.print(pa[i].money+" ");
		//}
		System.out.print(check(pa));
	}
}

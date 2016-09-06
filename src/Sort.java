
public class Sort {

	/**
	 * @param args
	 */
	private static Comparable[] aux;  //归并排序辅助数组

	
	private static void exch(Comparable[] a,int i,int j) {
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	

	

	
	//插入排序
	private static void insertion(Comparable[] a,int low,int high) {
		for(int i=low+1;i<high;++i){
			for(int j=i-1;j>=0;--j){
				int cmp=a[j].compareTo(a[j+1]);
				if(cmp>0){
				  exch(a, j, j+1);
				}
				else break;
			}
		}
	}
	public static void insertion(Comparable[] a){
		insertion(a, 0, a.length);
	}

	
	//归并排序的合并
	private static void guiBing_Merge(Comparable[] a,int low,int mid,
			int high) {  //mid参数指向右边一个有序数组的第一个元素
		                 //high参数为最后一个元素下标加一
		//复制到aux中
		for(int i=low;i<high;++i){
		   aux[i-low]=a[i];
		}
		int k=low,           //k为复制回原数组的指向原数组
			i=0,             //i为aux中左边有序数组的指针
			j=mid-low,       //j为aux中右边有序数组指针
			auxMid=mid-low,  //auxMid为aux中点
			auxHigh=high-low;//为aux最后一个加一
		//开始排序
		while (true) {
			if(i>=auxMid){     //如果i已到底，则把右边剩余的复制过去，退出循环
				for(;j<auxHigh;++j,++k){
					a[k]=aux[j];
				}
				break;
			}
			else if(j>=auxHigh){ //如果j已到底，则把左边剩余的复制过去，退出循环
				for(;i<auxMid;++i,++k){
					a[k]=aux[i];
				}
				break;
			}
			else if(aux[i].compareTo(aux[j])>=0){  //如果aux[j]较小
				a[k]=aux[j];                         //则把aux[j]复制过去
				++k;
				++j;
			}
			else {               //如果aux[i]较小则复制过去
				a[k]=aux[i];
				++k;
				++i;
			}
		}
	}
	
	//归并排序递归
	private static void guiBing(Comparable[] a,int low,int high) {//high参数为最后一个元素下标加一
		if(high-low==1) return;    //只剩下一个元素
		else{
			int mid=(low+high)/2;
			guiBing(a, low, mid);
			guiBing(a, mid, high);
			guiBing_Merge(a, low, mid, high);
		}
		
	}
	//归并排序
	public static void guiBing(Comparable[] a) {
		aux=new Comparable[a.length];
		guiBing(a, 0, a.length);
	}
	
	//快速排序递归
	private static void quick(Comparable[] a,int low,int high) {
		if(high-low==1||high-low==0)  return;
		else{
		
			
			int i=low+1,     //i为从左
				j=high-1;	//j为从右
			while(true){
				while(a[i].compareTo(a[low])<=0){
					if(i==high-1)  break;  //如果i到了最后，跳出循环
					else ++i;
				}
				while(a[j].compareTo(a[low])>=0){
					if(j==low)   break;   //如果j到了最前，跳出循环
					else --j;
				}
				if(i>=j)  break;
				else{
					exch(a,i,j);
				}
			}
			exch(a,j,low);
			
			quick(a, low, j);
			quick(a, j+1, high);
		}
	}
	
	public static void quick(Comparable[] a){
		
		quick(a, 0, a.length);
	}
	

	
	//三分快速排序递归
	private static void quickThree(Comparable[] a,int low,int high) {
		if(high-low==1||high-low==0) return;
		else{
			int i=low,      //指向相等的最左一个
				j=low+1,    //指向相等最右的右边一个待比较
				k=high-1;   //指向后面待比较的
			Comparable c=a[low];
			while(j<=k){
				if(a[j].compareTo(c)==0)  ++j;  
				else if(a[j].compareTo(c)<0){  //a[j]小则移到左边
					exch(a,i,j);
					++i;  ++j;
				}
				else{
					exch(a,j,k);   //a[j]大则移到右边
					--k;
				}
			}
			quickThree(a, low, i);
			quickThree(a, j, high);
		}
	}
	
	public static void quickThree(Comparable[] a) {
		quickThree(a, 0, a.length);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

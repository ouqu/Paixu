
public class Sort {

	/**
	 * @param args
	 */
	private static Comparable[] aux;  //�鲢����������

	
	private static void exch(Comparable[] a,int i,int j) {
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	

	

	
	//��������
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

	
	//�鲢����ĺϲ�
	private static void guiBing_Merge(Comparable[] a,int low,int mid,
			int high) {  //mid����ָ���ұ�һ����������ĵ�һ��Ԫ��
		                 //high����Ϊ���һ��Ԫ���±��һ
		//���Ƶ�aux��
		for(int i=low;i<high;++i){
		   aux[i-low]=a[i];
		}
		int k=low,           //kΪ���ƻ�ԭ�����ָ��ԭ����
			i=0,             //iΪaux��������������ָ��
			j=mid-low,       //jΪaux���ұ���������ָ��
			auxMid=mid-low,  //auxMidΪaux�е�
			auxHigh=high-low;//Ϊaux���һ����һ
		//��ʼ����
		while (true) {
			if(i>=auxMid){     //���i�ѵ��ף�����ұ�ʣ��ĸ��ƹ�ȥ���˳�ѭ��
				for(;j<auxHigh;++j,++k){
					a[k]=aux[j];
				}
				break;
			}
			else if(j>=auxHigh){ //���j�ѵ��ף�������ʣ��ĸ��ƹ�ȥ���˳�ѭ��
				for(;i<auxMid;++i,++k){
					a[k]=aux[i];
				}
				break;
			}
			else if(aux[i].compareTo(aux[j])>=0){  //���aux[j]��С
				a[k]=aux[j];                         //���aux[j]���ƹ�ȥ
				++k;
				++j;
			}
			else {               //���aux[i]��С���ƹ�ȥ
				a[k]=aux[i];
				++k;
				++i;
			}
		}
	}
	
	//�鲢����ݹ�
	private static void guiBing(Comparable[] a,int low,int high) {//high����Ϊ���һ��Ԫ���±��һ
		if(high-low==1) return;    //ֻʣ��һ��Ԫ��
		else{
			int mid=(low+high)/2;
			guiBing(a, low, mid);
			guiBing(a, mid, high);
			guiBing_Merge(a, low, mid, high);
		}
		
	}
	//�鲢����
	public static void guiBing(Comparable[] a) {
		aux=new Comparable[a.length];
		guiBing(a, 0, a.length);
	}
	
	//��������ݹ�
	private static void quick(Comparable[] a,int low,int high) {
		if(high-low==1||high-low==0)  return;
		else{
		
			
			int i=low+1,     //iΪ����
				j=high-1;	//jΪ����
			while(true){
				while(a[i].compareTo(a[low])<=0){
					if(i==high-1)  break;  //���i�����������ѭ��
					else ++i;
				}
				while(a[j].compareTo(a[low])>=0){
					if(j==low)   break;   //���j������ǰ������ѭ��
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
	

	
	//���ֿ�������ݹ�
	private static void quickThree(Comparable[] a,int low,int high) {
		if(high-low==1||high-low==0) return;
		else{
			int i=low,      //ָ����ȵ�����һ��
				j=low+1,    //ָ��������ҵ��ұ�һ�����Ƚ�
				k=high-1;   //ָ�������Ƚϵ�
			Comparable c=a[low];
			while(j<=k){
				if(a[j].compareTo(c)==0)  ++j;  
				else if(a[j].compareTo(c)<0){  //a[j]С���Ƶ����
					exch(a,i,j);
					++i;  ++j;
				}
				else{
					exch(a,j,k);   //a[j]�����Ƶ��ұ�
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


public class StringSort {

	/**
	 * @param args
	 */
	
	private static String[] aux;
	private static int r=256;
	
	public static void fixedLengthSort(String[] a){
		int w=a[0].length();
		String[] temp=new String[a.length];
		int[] count=new int[r+1];
		for(int d=w-1;d>=0;--d){     //对同一位置字符排序
			for(int i=0;i<a.length;++i){
				++count[a[i].charAt(d)+1];   //统计字符出现次数
			}
			for(int i=1;i<r+1;++i){
				count[i]=count[i-1]+count[i];  //转换索引
			}
			for(int i=0;i<a.length;++i){
				int k=a[i].charAt(d);
				temp[count[k]]=a[i];
				++count[k];
			}
			for(int i=0;i<a.length;++i){
				a[i]=temp[i];    //回写
			}
		}
	}
	
	public static void highSort(String[] a){
		aux=new String[a.length];
		highSort(a, 0, a.length, 0);
	}
	
	private static void highSort(String[] a,int low,int high,int d) {
		if(high-low==1) return;
		int[] count=new int[r+2];
		for(int i=low;i<high;++i){
			++count[charIndex(a[i], d)+2];
		}
		for(int i=1;i<r+2;++i){
			count[i]=count[i-1]+count[i];
		}
		for(int i=low;i<high;++i){
			int k=charIndex(a[i], d)+1;
			aux[count[k]]=a[i];
			++count[k];
		}
		for(int i=low;i<high;++i){
			a[i]=aux[i-low];
		}
		for(int i=0;i<r;++i){
			highSort(a, low+count[i], low+count[i+1], d+1);
		}
	}
	
	private static int charIndex(String s,int d){
		if(d>=s.length()) return -1;
		return s.charAt(d);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

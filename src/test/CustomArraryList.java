package test;

public class CustomArraryList {
	
	Object a[] ;
	int size;
	int i=0;
	
	public CustomArraryList(int size) {
		// TODO Auto-generated constructor stub
		this.a = new Object[size];
		this.size = size;
		
	}
	
	void add(Object o){
		
		if(i<size){
			a[i] = o;
			i++;
		} else {
			Object temp[] = new Object[size];
			temp = a;
			a = new Object[size*2];
			a = temp;//a size 10
			a[i] = o;
			i++;
		}
		
	}
	
	public static void main(String[] args) {
		CustomArraryList csl = new CustomArraryList(1);
		csl.add(new Integer(1));
		csl.add(new Integer(2));
	}
}

package inner.classes;

public class OuterClass {
	
	public static class InnerStaticClass {
		static int count = 0;
		void printMsg() {
			System.out.println("StaticInnerClass message, count: "+count);
		}
		
		static void pringStaticMsg() {
			System.out.println("StaticInnerClass static method message, count: "+count);
		}
	}
	
	public class InnerClass {
		
		void printMsg(){
			System.out.println("InnerClass message");
		}
		
		//Compiler error
		/*static void printStaticMsg() {
			System.out.println("InnerClass static method message");
		}*/
	}
	
	public static void main(String[] args) {
		OtherClass otherClass = new OtherClass();
		otherClass.innerClass.printMsg();
		otherClass.staticClass.printMsg();
		otherClass.staticClass.pringStaticMsg();
		OuterClass.InnerStaticClass.pringStaticMsg();
		System.out.println(otherClass.otherClassCount);
	}

}

class OtherClass {
	
	OuterClass.InnerStaticClass staticClass = new OuterClass.InnerStaticClass();
	//private OuterClass.InnerClass innerClass = new OuterClass.InnerClass(); //Compiler error
	OuterClass.InnerClass innerClass = new OuterClass().new InnerClass();
	int otherClassCount = OuterClass.InnerStaticClass.count;
	
}

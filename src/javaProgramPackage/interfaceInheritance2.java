package javaProgramPackage;

//Creating interface that has 4 methods  
interface interfac {
	void a();// bydefault, public and abstract

	void b();

	void c();

	void d();
}

//Creating abstract class that provides the implementation of one method of A interface  
abstract class B1 implements interfac {
	public void c() {
		System.out.println("I am C");
	}
}

//Creating subclass of abstract class, now we need to provide the implementation of rest of the methods  
class M1 extends B1 {
	public void a() {
		System.out.println("I am a");
	}

	public void b() {
		System.out.println("I am b");
	}

	public void d() {
		System.out.println("I am d");
	}
}

//Creating a test class that calls the methods of A interface  
class interfaceInheritance2{
	public static void main(String args[]) {
		interfac a = new M1();
		a.a();
		a.b();
		a.c();
		a.d();
	}
}
package JavaConcepts.Polymorphism;

public class MethodOverriding {
	public static void main(String[] args) {
		MethodOverridingTesterBase motb = new MethodOverridingTesterChild();
		A a = motb.add();
		System.out.println(a.id);
		motb.displayBase();
		System.out.println("----");
		B b = (B) motb.add();
		System.out.println(b.id);
		System.out.println(b.name);
		MethodOverridingTesterChild motc = (MethodOverridingTesterChild) motb;
		motc.displayBase();
		motc.displayChild();
		
		//Method hiding
		MethodOverridingTesterBase motb1 = new MethodOverridingTesterChild();;
		motb1.staicDisplay();	//calls staicDisplay in base class as per reference variable created.
	}
}

class MethodOverridingTesterBase {
	public A add() {
		System.out.println("Base add() called..");
		A a = new A();
		a.id = 101;
		return a;
	}
	
	public void displayBase() {
		System.out.println("displayBase called..");
	}
	
	public static void staicDisplay() {
		System.out.println("staicDisplayBase called..");
	}
}

class MethodOverridingTesterChild extends MethodOverridingTesterBase {
	
	@Override
	public B add() {		//covariant return type is allowed in overriden method.
		System.out.println("Child add() called..");
		B b = new B();
		b.id = 102;
		b.name = "Binay";
		return b;
	}
	
	public void displayChild() {
		System.out.println("displayChild called..");
	}
	
	public static void staicDisplay() {		//this method will remain hidden.
		System.out.println("staicDisplayChild called..");
	}
}

class A {
	int id;
}

class B extends A {
	String name;
}
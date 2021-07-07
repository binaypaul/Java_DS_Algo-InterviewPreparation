package Exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ThrowsExceptionAndOverriding {
	public static void main(String[] args) throws IOException {
		Parent p = new Child();
		p.displayForCheckedException();
		p.displayForUncheckedException();
	}
}

class Parent{
	public void displayForCheckedException() throws FileNotFoundException {	//Throwing FileNotFoundException which is child class IOException.
		for (int i=0;i<5;i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Parent: displayForCheckedException: i: " + i);
		}
	}
	
	public void displayForUncheckedException() throws NullPointerException { //Throwing NullPointerException which is child class RuntimeException.
		for (int i=0;i<5;i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Parent: displayForUncheckedException: i: " + i);
		}
	}
}

class Child extends Parent {
//	@Override
//	public void displayForCheckedException() throws IOException {	//Not allowed. Child class overridden method can't throw parent class checked exception.
//		for (int i=0;i<5;i++) {
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println("Parent: displayForCheckedException: i: " + i);
//		}
//	}
	
	@Override
	public void displayForUncheckedException() throws RuntimeException {//allowed. Child class overridden method can throw parent class unchecked exception.
		for (int i=0;i<5;i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Child: displayForUncheckedException: i: " + i);
		}
	}
}
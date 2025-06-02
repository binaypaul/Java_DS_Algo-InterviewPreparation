package JavaConcepts.Exception;

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
	//CheckedException:
	//Throwing FileNotFoundException which is child class IOException.
	public void displayForCheckedException() throws FileNotFoundException {
		for (int i=0;i<5;i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Parent: displayForCheckedException: i: " + i);
		}
	}

	//UncheckedException:
	//Throwing NullPointerException which is child class RuntimeException.
	public void displayForUncheckedException() throws NullPointerException {
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
//	//CheckedException:
//	//Not allowed. Child class overridden method can't throw parent class's checked exception class's Parent class.
//	//IOException is the parent of FileNotFoundException.
//	@Override
//	public void displayForCheckedException() throws IOException {
//		for (int i=0;i<5;i++) {
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println("Parent: displayForCheckedException: i: " + i);
//		}
//	}

	//UncheckedException:
	//allowed. Child class overridden method can throw parent class unchecked exception.
	//RuntimeException is the parent of NullPointerException.
	@Override
	public void displayForUncheckedException() throws RuntimeException {
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
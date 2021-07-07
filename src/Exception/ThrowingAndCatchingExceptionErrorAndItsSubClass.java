package Exception;

import java.io.IOException;

public class ThrowingAndCatchingExceptionErrorAndItsSubClass {

	public static void main(String[] args) {
		Tester t = new Tester();
		try {
			t.tester();
		} 
//		catch (MyCheckedExcepton e) {
//			System.out.println("Caught exception in Main -> MyCheckedExcepton");
//		} 
		catch (IOException e) {
			System.out.println("Caught exception in Main -> IOException");
		}
	}
	
	public void throwingException() throws Error, MyCheckedExcepton{
		try {
			throw new MyCheckedExcepton("-message-");
			//throw new IOException();
			//throw new ArrayIndexOutOfBoundsException(); //can throw checked exception.
			//throw new MyRunntimeExcepton("-message-");	//can throw child class checked exception.
			//throw new NullPointerException();	//can throw unchecked exception.
			//throw new Exception();
			//throw new Error();
			//throw new MyError("-message-"); //can throw child class.
			//throw new Throwable();	//can throw a throwable
		}
//		catch(MyCheckedExcepton e) {//child class MyCheckedExcepton can't handle exception of parent class IOException
//			System.out.println("Caught exception in MyCheckedExcepton");
//		}
//		catch (IOException e) {
//			System.out.println("Caught exception in IOException");
//		}
		catch(MyRunntimeExcepton e) {//child class MyRunntimeExcepton can't handle exception of parent class ArrayIndexOutOfBoundsException
			System.out.println("Caught exception in MyRunntimeExcepton");
		}
		catch (ArrayIndexOutOfBoundsException e) {//can handle exception of child class MyRunntimeExcepton, similarly how Exception class can handle all type of exception
			System.out.println("Caught exception in ArrayIndexOutOfBoundsException");
		}
		catch(RuntimeException e) {
			System.out.println("Caught exception in RuntimeException");
		}
//		catch (Exception e) {	//can catch all exceptions but can't catch Error or its subclass.
//			System.out.println("Caught exception in Exception");
//		}
		catch(MyError e) { //can catch error
			System.out.println("Caught error in MyError");
		} 
		catch(Error e) {
			System.out.println("Caught error in Error");
		} 
//		catch (Throwable t) {
//			System.out.println("Caught throwable in Throwable");
//		}
	}
}

class MyCheckedExcepton extends IOException {
	private static final long serialVersionUID = 1L;
	public MyCheckedExcepton(String str) {
		super(str);
	}
}
class MyRunntimeExcepton extends ArrayIndexOutOfBoundsException {
	private static final long serialVersionUID = 1L;
	public MyRunntimeExcepton(String str) {
		super(str);
	}
}
class MyError extends NoClassDefFoundError {
	private static final long serialVersionUID = 1L;
	public MyError(String str) {
		super(str);
	}
}

class Tester {
	public void tester() throws MyCheckedExcepton{
		ThrowingAndCatchingExceptionErrorAndItsSubClass e = new ThrowingAndCatchingExceptionErrorAndItsSubClass();
		e.throwingException();
	}
}
package JavaConcepts.Polymorphism.Overloading.Tricky;

/*
^! Forbidden: Automatic Type Promotion then Boxing.
! You cannot pass an int to a method expecting a Long object.
! The compiler will not do Automatic Type Promotion of int to long and then Box it into Long.

^* Allowed: Boxing then Widening Reference Conversion.
* You can pass an int to a method expecting an Number (it Boxes to Integer, then Widening Reference Conversion to Number/Object).
 */
public class c_AB_BW {
    //! int to Integer to Long is not allowed.
    // Comment the below method "String show (Number bow)" to see.
    String show (Long bow) {
        return "Long bow";
    }

    //? int to Integer to Number is allowed.
    String show (Number bow) {
        return "Number bow";
    }

    public static void main(String[] args) {
        c_AB_BW wpal = new c_AB_BW();
        System.out.println(wpal.show(1)); // always calls Number param show method
    }
}

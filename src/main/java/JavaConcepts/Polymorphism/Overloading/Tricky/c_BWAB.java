package JavaConcepts.Polymorphism.Overloading.Tricky;

/*
^* Allowed: Boxing then Widening Reference Conversion.
* You can pass an int to a method expecting an Object (it Boxes to Integer, then Widening Reference Conversion to Number/Object).

^! Forbidden: Automatic Type Promotion then Boxing.
! You cannot pass an int to a method expecting a Long object. The compiler will not do Automatic Type Promotion of int to long and then Box it into Long.
 */
public class c_BWAB {
    //? int to Integer to Number is allowed.
    String show (Number bow) {
        return "Number bow";
    }

    //! int to Integer to Long is not allowed.
    String show (Long bow) {
        return "Long bow";
    }

    public static void main(String[] args) {
        c_BWAB wpal = new c_BWAB();
        System.out.println(wpal.show(1)); // always calls Number param show method
    }
}

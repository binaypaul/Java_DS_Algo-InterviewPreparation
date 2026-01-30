package JavaConcepts.Polymorphism.Overloading.Tricky;

//^ Automatic Type Promotion -> (byte → short → int → long → float → double).
//^                                      char ---^
//^ Widening Reference Conversion -> Sub-Class to Parent class.

//^ Autoboxing means conversion to Wrapper.

/*
When multiple types of conversions are possible, Java follows a strict "order of preference":

1.E - Exact Match
2.A - Automatic Type Promotion (e.g., int to long)
3.B - Boxing/Autoboxing(e.g., int to Integer)
4.W - Widening Reference Conversion (e.g. int to Number/Object)
5.V - Varargs (e.g., int...)
 */

public class b_EAWBV {
    //Comment methods one by one to see the overloading preference behaviour works.
    //? Exact Match
    public String show(int i) {
        return "show: Exact Match";
    }
    //? Automatic Type Promotion
    public String show(long i) {
        return "show: Automatic Type Promotion";
    }
    //? Boxing
    public String show(Integer i) {
        return "show: Boxing";
    }
    //? Widening Reference Conversion
    public String show(Number i) {
        return "show: Widening Reference Conversion";
    }
    //? Varargs
    public String show(int... i) {
        return "show: Varargs";
    }

    public static void main(String[] args) {
        b_EAWBV ewav = new b_EAWBV();
        System.out.println(ewav.show(1));
    }
}

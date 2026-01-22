package JavaConcepts.Polymorphism.Overloading.Tricky;

public class d_AmbiguityWithVarargs {
    String show(int a, int... b) {
        return "param with varArgs";
    }
    String show(int... a) {
        return "only varArgs";
    }

    public static void main(String[] args) {
        d_AmbiguityWithVarargs awv = new d_AmbiguityWithVarargs();
        //! Compile time error: Ambiguous method call.
//        awv.show(1,2,3,4,5);
    }

}

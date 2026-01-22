package JavaConcepts.Polymorphism.Overloading.Tricky;

public class a_ParentAndSiblingParameterTypes {
    //? Parent - Child parameter type.
    public String name(String str) { //String is child of Object
        return "str name" + str;
    }
    public String name(Object obj) { //Object is parent of String
        return "object name" + obj;
    }
    //?

    //? Sibling parameter type.
    public String get(String str) { //String is child of Object
        return "str name" + str;
    }
    public String get(Integer obj) { //Integer is child of Object
        return "object name" + obj;
    }
    //?



    public static void main(String[] args) {
        //? Though null can be sent to both Object and String type, but String type will be called because since String is subclass of object, it is considered "more specific" by the JVM.
        System.out.println(new a_ParentAndSiblingParameterTypes().name(null));

        //? Though null can be sent to both String and Integer type and both of these are siblings (subclass of Object), JVM can't choose one between these two and considers this ambiguous.
//        System.out.println(new OverloadingParentAndSiblingParameterTypes().get(null));
    }
}

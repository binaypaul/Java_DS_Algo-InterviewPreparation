package JavaConcepts;

import java.lang.ref.*;

public class StrongRefWeakRef {
    public static void main(String[] args) {
        String strongRef = new String("abc");
        WeakReference<String> weakRef = new WeakReference<>(strongRef);
        System.out.println(strongRef);
        System.out.println(weakRef.get());
        strongRef=null;
        System.out.println(strongRef);
        System.out.println(weakRef.get());
        System.gc(); //triggers GC but not always guaranteed.
        System.out.println(strongRef);
        System.out.println(weakRef.get());
    }
}

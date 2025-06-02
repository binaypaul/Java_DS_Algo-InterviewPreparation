package SystemDesign.LLD.DesignPattern.f_SingletonPattern;

class SynchronisedSingleton {
    private SynchronisedSingleton synchronisedSingleton;

    //* "i" is stored in main memory.
    //* Volatile ensures that any changes made to that variable by one thread are immediately
    //* written to main memory and are visible to all other threads.
    //* This prevents threads from working with stale, cached copies of the variable.
    private volatile int i;

    private SynchronisedSingleton() {
    }

    public synchronized SynchronisedSingleton getInstance() {
        if (synchronisedSingleton == null) {
            synchronisedSingleton = new SynchronisedSingleton();
        }
        return synchronisedSingleton;
    }


    public int getI() {
        return i;
    }

    public synchronized void setI(int i) {
        this.i = i;
    }
}

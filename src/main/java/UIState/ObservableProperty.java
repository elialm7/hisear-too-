package UIState;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ObservableProperty<T> {
    private T value;
    private List<Consumer<T>> observers = new ArrayList<>();

    public ObservableProperty(T value){
        this.value = value;
    }
    public ObservableProperty(){

    }
    public void set(T value){
        synchronized (this) {
            this.value = value;
            notifyObservers();
        }
    }
    public T get(){
        synchronized (this){
            return value;
        }

    }
    private void notifyObservers(){
        for(Consumer<T> obs : observers){
            obs.accept(value);
        }
    }
    public void addObserver(Consumer<T> obs){
        synchronized (this){
            if(observers.contains(obs)){
                return;
            }
            observers.add(obs);
        }
    }
}

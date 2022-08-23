import java.util.Arrays;

public class MyList<T> {
    private int capacity = 10;
    private T[] arry;
    private T[] tempArry;

    public MyList(){
        this.arry = (T[]) new Object[capacity];
    }

    public MyList(int capacity){
        this.capacity = capacity;
        this.arry = (T[]) new Object[capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public T[] getArry() {
        return arry;
    }

    public void setArry(T[] arry) {
        this.arry = arry;
    }

    public T[] getTempArry() {
        return tempArry;
    }

    public void setTempArry(T[] tempArry) {
        this.tempArry = tempArry;
    }

    public int size(){
        int number = 0;
        for(int i = 0; i < getCapacity(); i++){
            if(arry[i] != null){
                number++;
            }
        }
        return number;
    }

    public void add(T data){
        if(size() > getCapacity()){
            this.tempArry = this.arry;
            setCapacity(getCapacity() * 2);
            this.arry = (T[]) new Object[getCapacity()];
            this.arry = Arrays.copyOf(tempArry, getCapacity());
        }
        this.arry[size()] = data;
    }

    public T get(int index){
        if(index > size() || index < 0){
            return null;
        }
        return this.arry[index];
    }

    public  T remove(int index){
        if(size() < index || index < 0){
            return null;
        }
        T[] temp = this.arry;
        this.arry[index] = null;
        for(int i = index; i < size(); i++){
            if(size() - i == 1){
                this.arry[i] = null;
            }else{
                this.arry[i] = temp[i + 1];
            }
        }
        return  this.arry[index];
    }

    public T set(int index, T data){
        if(size() < index || index < 0){
            return null;
        }
        this.arry[index] = data;
        return this.arry[index];
    }

    @Override
    public String toString(){
        return "My list : " + Arrays.toString(arry);
    }

    public int indexOf(T data){
        for(int i = 0; i < size(); i++){
            if(this.arry[i] == data){
                return i;
            }
        }
        return -12;
    }

    public int lastIndexOf(T data){
        for(int i = size(); i >= 0; i--){
            if(this.arry[i] == data){
                return i;
            }
        }
        return -2;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public T[] toArray(){
        return this.arry;
    }

    public void clear(){
        for(int i = 0; i < this.size(); i++){
            this.arry[i] = null;
        }
    }

    public MyList<T> sybList(int start, int finish){
        MyList<T> list = new MyList<>(finish - start + 1);
        for(int i = start; i <= finish; i++){
            list.add(this.arry[i]);
        }
        return list;
    }

    public boolean contains(T data){
        for(int i = 0; i < size(); i++){
            if(this.arry[i] == data){
                return true;
            }
        }
        return false;
    }
}

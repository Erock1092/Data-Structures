public interface List<E>{

    public int size();
    public boolean add(E e);
    public void add(int index, Object o);
    public void clear();
    public boolean contains(Object o);
    public boolean equals(Object o);
    public E get(int index);
    public int hashCode();
    public int indexOf(Object o);
    public boolean isEmpty();
    public E remove(int index);
    public E remove(Object o);
    
}

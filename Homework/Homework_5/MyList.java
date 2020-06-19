package Homework_5;

public class MyList<E> implements List<E> {
    E[] elements;
    int size;
    public MyList()
    {
        size = INITIAL_CAPACITY;
        elements  = (E[]) new Object[size];
    }
    public MyList(int capacity)
    {
        size = capacity;
        elements  = (E[]) new Object[size];
    }

    @Override
    public void add(E e) {
        if (elements[this.size - 1] == null)
        {
            for(int i = 0; i < this.size; i++)
            {
                if(elements[i] == null)
                {
                    elements[i] = e;
                    break;
                }
            }
        }
        else {
            E[] elements1 = (E[]) new Object[2 * size];
            for (int i = 0; i < this.size; i++)
            {
                elements1[i] = elements[i];
            }
            elements1[size] = e;
            this.elements = elements1;
            size = 2 * size;
        }
    }

    @Override
    public E get(int index) {
        return elements[index];
    }

    @Override
    public void replace(E o, E replaceWith) {
        if(o == null || replaceWith == null)
        {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < size; i++)
        {
            if(elements[i].equals(o))
            {
                elements[i] = replaceWith;
            }
        }
    }

    @Override
    public int remove(E o) {
        int count = 0;
        for(int i = 0; i < size; i++)
        {
            if(elements[i] == o)
            {
                count++;
                int index = i;
                while(index < size-1)
                {
                    elements[index] = elements[index+1];
                    index++;
                }

            }
        }
        return count;
    }

    @Override
    public int contains(E o) {
        int count = 0;
        if(o == null)
        {
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < size; i++)
        {
            if(elements[i] == o)
            {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        if(elements[0] == null)
        {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        E[] elements1  = (E[]) new Object[size];
        elements = elements1;
    }

    @Override
    public int size() {
        int count = 0;
        for(int i = 0; i < this.size; i++)
        {
            if(elements[i] != null)
            {
                count++;
            }
            else
            {
                return count;
            }
        }
        return count;
    }

    @Override
    public E[] toArray(E[] e) {
        int len = e.length;
        E[] elements1 = (E[]) new Object[size];
        for(int i = 0; i < len; i++)
        {
            elements1[i] = this.elements[i];
        }
        return elements1;
    }
}

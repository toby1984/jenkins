package hudson.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A collection of (string) {@link Tag}s.
 *
 * Tags cannot be blank or NULL. Duplicate tags will be silently ignored/dropped.
 *
 * @author tobias.gierke@code-sourcery.de
 */
public class Tags implements Set<Tag>
{
    private final List<Tag> tags = new ArrayList<>();

    @Override
    public int size()
    {
        synchronized(tags)
        {
            return tags.size();
        }
    }

    /**
     * Returns the tag at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         ({@code index < 0 || index >= size()})
     */
    public Tag get(int index) {
        synchronized(tags)
        {
            return tags.get(index);
        }
    }

    @Override
    public boolean isEmpty()
    {
        synchronized(tags)
        {
            return tags.isEmpty();
        }
    }

    @Override
    public boolean contains(Object o)
    {
        synchronized(tags)
        {
            return tags.contains(o);
        }
    }

    @Override
    public Iterator<Tag> iterator()
    {
        synchronized(tags)
        {
            return tags.iterator();
        }
    }

    @Override
    public Object[] toArray()
    {
        synchronized(tags)
        {
            return tags.toArray();
        }
    }

    @Override
    public <T> T[] toArray(T[] a)
    {
        synchronized(tags)
        {
            return tags.toArray(a);
        }
    }

    @Override
    public boolean add(Tag tag)
    {
        if ( tag == null ) {
            throw new IllegalArgumentException( "NULL tags are not allowed" );
        }
        synchronized(tags)
        {
            if (!tags.contains(tag))
            {
                tags.add(tag);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o)
    {
        synchronized(tags)
        {
            return tags.remove(o);
        }
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        synchronized(tags)
        {
            return tags.containsAll(c);
        }
    }

    @Override
    public boolean addAll(Collection<? extends Tag> c)
    {
        boolean result = false;
        for ( Tag t : c ) {
            result |= add(t);
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        synchronized(tags)
        {
            return tags.retainAll(c);
        }
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        synchronized(tags)
        {
            return tags.removeAll(c);
        }
    }

    @Override
    public void clear()
    {
        synchronized(tags)
        {
            tags.clear();
        }
    }

    @Override
    public String toString()
    {
        synchronized(tags)
        {
            return tags.stream().map(x -> "'" + x.getName() + "'").collect(Collectors.joining(","));
        }
    }
}
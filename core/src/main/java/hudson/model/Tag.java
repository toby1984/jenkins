package hudson.model;

/**
 * An arbitrary (string) tag.
 *
 * Blank or NULL values are not allowed.
 * @author tobias.gierke@code-sourcery.de
 */
public class Tag
{
    private String name;

    /**
     * Create a new tag.
     *
     * @param name tag name, never <code>null</code> or blank
     * @throws IllegalArgumentException if <code>name</code> was <code>null</code> or blank
     */
    public Tag(String name) throws IllegalArgumentException
    {
        setName(name);
    }

    /**
     * Get tag name.
     *
     * @return tag name, never <code>null</code> or blank
     * @see #setName(String)
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set tag name.
     *
     * @param name tag name, never <code>null</code> or blank
     * @throws IllegalArgumentException if <code>name</code> was <code>null</code> or blank
     * @see #getName()
     */
    public void setName(String name) throws IllegalArgumentException
    {
        if ( name == null || name.trim().length() == 0 ) {
            throw new IllegalArgumentException( "Tag name cannot be NULL or blank" );
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o)
    {
        if ( o == null || o.getClass() != Tag.class )
        {
            return false;
        }
        return ((Tag) o).name.equals(this.name);
    }

    @Override
    public int hashCode()
    {
        return name.hashCode();
    }

    @Override
    public String toString()
    {
        return name;
    }
}
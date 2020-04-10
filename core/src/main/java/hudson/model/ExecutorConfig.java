package hudson.model;

/**
 * Configuration of an {@link Executor}.
 *
 * @author tobias.gierke@code-sourcery.de
 */
public class ExecutorConfig
{
    private String tagExpression;

    /**
     * Returns an expression to be matched against
     * the tags configured on a project
     * to decide whether it's eligible to be build
     * be this executor.
     *
     * Note that the project's {@link AbstractProject#getAssignedLabel()}}
     * still overrides this expression.
     *
     * @return
     * @see AbstractProject#getTags()
     */
    public String getTagExpression()
    {
        return tagExpression;
    }

    /**
     * Sets the expression to be matched against
     * the tags configured on a project
     * to decide whether it's eligible to be build
     * be this executor.
     *
     * Note that the project's {@link AbstractProject#getAssignedLabel()}}
     * still overrides this expression.
     *
     * @param tagExpression expression to use
     * @see AbstractProject#getTags()
     */
    public void setTagExpression(String tagExpression)
    {
        this.tagExpression = tagExpression;
    }
}
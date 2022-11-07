package Movie;

/** Interface that specifies method for builders
 * 
 */
public interface InterfaceBuilder<SepcifyObject> {

    /** Method to return built object from builders
     * 
     * @return <SpecifyObject>
     */
    public SepcifyObject build();
}

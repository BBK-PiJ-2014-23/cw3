/**
 * A sampleable list can be sampled. 
 * 
 * @author Stefan E. Mayer
 */
public class SampleableListImpl extends ArrayList implements SampleableList {
    /**
     * {@inheritDoc}
     */
    @Override
    public SampleableList sample () {
        SampleableList sample = new SampleableListImpl();
        // Only adding every other element so incrementing i by 2.
        for (int i = 0; i < size(); i = i + 2) {
            sample.add(array[i]);
        }
        return sample;
    }
}

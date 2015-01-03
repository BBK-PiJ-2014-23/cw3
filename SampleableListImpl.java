/**
 * A sampleable list can be sampled. 
 * 
 * @author Stefan E. Mayer
 */
public class SampleableListImpl extends ArrayList implements SampleableList {
    /**
     * Returns a list containing the first, third, fifth...
     * items of this list, or an empty list if the list is empty. 
     * 
     * @return a list containing the first, third, fifth... items of this list
     */
    @Override
    public SampleableList sample (){
        SampleableList sample = new SampleableListImpl();
        // Only adding uneving elements so incrementing i by 2.
        for (int i = 0; i < size(); i = i + 2) {
            sample.add(array[i]);
        }
        return sample;
    }
}

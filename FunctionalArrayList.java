/**
 * A functional list is a list with a few additional methods that are
 * common in functional languages (such as Lisp, Clojure, or Haskell)
 * to work with lists in a recursive way. 
 *
 * Not all operations on a recursive list will always be
 * successful. For example, a programmer may try to extract the head
 * from an empty list. Since we hace not covered exceptions yet, we
 * need another mechanism to report errors. In order to do that,
 * methods of this list will return a {@see ReturnObject} that will
 * contain either an object or an error value of the right kind (as
 * defined in {@see ErrorMessage}).
 * 
 * @author Stefan E. Mayer
 */
public class FunctionalArrayList extends ArrayList implements FunctionalList {
    /**
     * {@inheritDoc}
     */
    @Override
    public ReturnObject head() {
        // Error handling included in method get().
        ReturnObject head = get(0);
        return head;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FunctionalList rest() {
        FunctionalList rest = new FunctionalArrayList();
        // Not including the head so starting i at 1.
        for (int i = 1; i < size(); i++) {
            rest.add(array[i]);
        }
        return rest;
    }
}
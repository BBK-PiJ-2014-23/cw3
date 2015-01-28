/**
 * A wrapper containing either an object (the result of an operation
 * on a data structure) or an error value.
 *
 * @author Stefan E. Mayer
 */
public class ReturnObjectImpl implements ReturnObject {
    private Object returnObject;
    private ErrorMessage errorMessage;

    /**
     * Constructor for successful operation on a data structure.
     * @param object the result of a successful operation.
     */
    public ReturnObjectImpl(Object object) {
        returnObject = object;
        errorMessage = ErrorMessage.NO_ERROR;
    }

    /**
     * Constructor for unsuccesful operation on a data structure.
     * @param errorMessage the error value of an unsuccessful operation.
     */
    public ReturnObjectImpl(ErrorMessage errorMessage) {
        returnObject = null;
        this.errorMessage = errorMessage;
    }

    /**
     * Returns whether there has been an error
     * @return whether there has been an error
     */
    @Override
    public boolean hasError() {
        if (errorMessage.equals(ErrorMessage.NO_ERROR)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Returns the error message. 
     * 
     * This method must return NO_ERROR if and only if
     * {@hasError} returns false.
     * 
     * @return the error message
     */
    @Override
    public ErrorMessage getError() {
        return errorMessage;
    }

    /**
     * Returns the object wrapped in this ReturnObject, i.e. the
     * result of the operation if it was successful, or null if
     * there has been error.
     * 
     * Note that the output of this method must be null if {@see
     * hasError} returns true, but the opposite is not true: if
     * {@see hasError} returns false, this method may or may not
     * return null.
     * 
     * @return the return value from the method or null if there has been an
     *         error
     */
    @Override
    public Object getReturnValue() {
        return returnObject;
    }
}

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
     * {@inheritDoc}
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
     * {@inheritDoc}
     */
    @Override
    public ErrorMessage getError() {
        return errorMessage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getReturnValue() {
        return returnObject;
    }
}

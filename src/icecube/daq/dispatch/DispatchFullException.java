/*
 * class: DispatchFullException
 *
 * Version $Id: DispatchFullException.java,v 1.5 2005/06/20 16:25:13 patton Exp $
 *
 * Date: March 31 2004
 *
 * (c) 2004 IceCube Collaboration
 */

package icecube.daq.dispatch;

/**
 * This class is thrown when there is an attempt to put data into a Dispatcher
 * but there is no room.
 *
 * @author patton
 * @version $Id: DispatchFullException.java,v 1.5 2005/06/20 16:25:13 patton Exp $
 */
public class DispatchFullException
        extends DispatchException
{
    // constructors

    /**
     * Create an instance of this class.
     *
     * @param message a desciption of the exception.
     */
    public DispatchFullException(String message)
    {
        super(message);
    }

    /**
     * Create an instance of this class.
     *
     * @param cause the exception that caused this execption to be generated.
     */
    public DispatchFullException(Throwable cause)
    {
        super(cause);
    }

    /**
     * Create an instance of this class.
     *
     * @param message a desciption of the exception.
     * @param cause the reason this object was thrown.
     */
    public DispatchFullException(String message,
                             Throwable cause)
    {
        super(message,
              cause);
    }
}
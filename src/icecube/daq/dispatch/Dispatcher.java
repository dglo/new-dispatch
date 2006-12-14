/*
 * interface: Dispatcher
 *
 * Version $Id: Dispatcher.java,v 1.7 2005/11/07 00:19:13 patton Exp $
 *
 * Date: April 1 2004
 *
 * (c) 2004 IceCube Collaboration
 */

package icecube.daq.dispatch;

import java.nio.ByteBuffer;

/**
 * This interface specifies how events are dispatched from the DAQ system.
 *
 * @author patton
 * @version $Id: Dispatcher.java,v 1.7 2005/11/07 00:19:13 patton Exp $
 */
public interface Dispatcher
{

    // public static final member data

    // instance member method (alphabetic)

    /**
     * Signals to the dispatch system that the set of events that preced this
     * call are separated, by some criteria, for those that succeed it.
     *
     * @throws DispatchException is there is a problem in the Dispatch system.
     */
    void dataBoundary()
            throws DispatchException;

    /**
     * Signals to the dispatch system that the set of events that preced this
     * call are separated, by some criteria, for those that succeed it.
     * <p/>
     * The message supplied with this method is opaque to the system, i.e. it
     * is not used by the system, and it simple passed on through the any
     * delivery client.
     *
     * @param message a String explaining the reason for the boundary.
     * @throws DispatchException is there is a problem in the Dispatch system.
     */
    void dataBoundary(String message)
            throws DispatchException;

    /**
     * Copies the event in the buffer into this object. The buffer should be
     * prepared for reading so normally a {@link ByteBuffer#flip flip} should
     * be done before this call and a {@link ByteBuffer#compact compact}
     * afterwards.
     *
     * @param buffer the ByteBuffer containg the event.
     * @throws DispatchFullException if the event can not currently be
     * accepted.
     * @throws DispatchException is there is a problem in the Dispatch system.
     */
    void dispatchEvent(ByteBuffer buffer)
            throws DispatchFullException,
                   DispatchException;

    /**
     * Copies the events in the buffer into this object. The buffer should be
     * prepared for reading so normally a {@link ByteBuffer#flip flip} should
     * be done before this call and a {@link ByteBuffer#compact compact}
     * afterwards.
     * <p/>
     * The number of events is taken to be the length of the indices array.
     *
     * @param buffer the ByteBuffer containg the events.
     * @param indices the 'position' of each event inside the buffer.
     * @throws DispatchFullException if the event can not currently be
     * accepted.
     * @throws DispatchException is there is a problem in the Dispatch system.
     */
    void dispatchEvents(ByteBuffer buffer,
                        int[] indices)
            throws DispatchFullException,
                   DispatchException;

    /**
     * Copies the events in the buffer into this object. The buffer should be
     * prepared for reading so normally a {@link ByteBuffer#flip flip} should
     * be done before this call and a {@link ByteBuffer#compact compact}
     * afterwards.
     *
     * @param buffer the ByteBuffer containg the events.
     * @param indices the 'position' of each event inside the buffer.
     * @param count the number of events, this must be less that the length of
     * the indices array.
     * @throws DispatchFullException if the event can not currently be
     * accepted.
     * @throws DispatchException is there is a problem in the Dispatch system.
     */
    void dispatchEvents(ByteBuffer buffer,
                        int[] indices,
                        int count)
            throws DispatchFullException,
                   DispatchException;

    // static member methods (alphabetic)

}

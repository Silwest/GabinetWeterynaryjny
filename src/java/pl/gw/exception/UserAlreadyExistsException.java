/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.exception;

/**
 *
 * @author Silwest
 */
public class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException() {
        super();
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}

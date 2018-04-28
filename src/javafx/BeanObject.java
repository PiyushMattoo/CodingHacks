package javafx;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 *
 * @author mattoop
 */
public class BeanObject {

    private BooleanProperty one;
    private BooleanProperty two;
    private BooleanProperty three;

    public BeanObject(boolean one, boolean two, boolean three) {
        this.one = new SimpleBooleanProperty(one);
        this.two = new SimpleBooleanProperty(two);
        this.three = new SimpleBooleanProperty(three);
    }

    /**
     * @return the one
     */
    public BooleanProperty getOne() {
        return one;
    }

    /**
     * @param one the one to set
     */
    public void setOne(BooleanProperty one) {
        this.one = one;
    }

    /**
     * @return the two
     */
    public BooleanProperty getTwo() {
        return two;
    }

    /**
     * @param two the two to set
     */
    public void setTwo(BooleanProperty two) {
        this.two = two;
    }

    /**
     * @return the three
     */
    public BooleanProperty getThree() {
        return three;
    }

    /**
     * @param three the three to set
     */
    public void setThree(BooleanProperty three) {
        this.three = three;
    }

}

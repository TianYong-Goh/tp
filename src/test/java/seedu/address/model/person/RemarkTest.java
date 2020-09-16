package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RemarkTest {

    @Test
    public void equals() {
        Remark remark = new Remark("Hello");

        // same object -> return ture
        assertTrue(remark.equals(remark));

        //same values -> return true
        Remark remarkCopy = new Remark(remark.value);
        assertTrue(remark.equals(remarkCopy));

        // different typed -> return false
        assertFalse(remark.equals(1));

        //null -> return false
        assertFalse(remark.equals(null));

        //different remark -> return false
        Remark differentRemark = new Remark("Bye");
        assertFalse(remark.equals(differentRemark));
    }
}

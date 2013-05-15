package example;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ArrayListTest {

    @Test
    public void testBasic() {
        ArrayList<String> al = new ArrayList<>();
        al.add("x");
        al.add("y");
        al.add("z");

        assertThat(al.length(), is(3));
        assertThat(al.get(1), is("y"));
        assertThat(al.removeLast(), is("z"));
        assertThat(al.remove("y"), is(true));
        assertThat(al.length(), is(1));
        assertThat(al.remove("a"), is(false));
    }

    @Test
    public void testAdd() {
        ArrayList<String> al = new ArrayList<>("x0");

        for (int i=1;i<38;i++) {
            al.add(("x"+i).intern());
        }

        assertThat(al.length(), is(38));
        assertThat(al.get(0), is("x0"));
        assertThat(al.get(1), is("x1"));
        assertThat(al.get(37), is("x37"));

        assertThat(al.removeLast(), is("x37"));
        assertThat(al.remove("x2"), is(true));
        assertThat(al.remove("x"), is(false));
        assertThat(al.length(), is(36));
    }

}

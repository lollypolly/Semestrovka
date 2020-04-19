package Tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.polly.dictionary.EndlessArray;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class EndlessArrayTest {

    @Test
    void add() {
        EndlessArray end1 = new EndlessArray();
        EndlessArray end2 = new EndlessArray();
        end1.add(3);
        end2.add(3);
        end1.add(1);
        end2.add(1);
        end1.add(9);
        end2.add(9);
        end1.add(8);
        end2.add(8);
        Assert.assertEquals(end1,end2);
    }

    @Test
    void remove() throws IndexOutOfBoundsException{
        EndlessArray end1 = new EndlessArray();
        EndlessArray end2 = new EndlessArray();
        end1.add(3);
        end2.add(3);
        end1.add(1);
        end2.add(1);
        end1.add(9);
        end2.add(9);
        end1.add(8);
        end2.add(8);
        end1.remove(1);
        end2.remove(1);

        Assert.assertEquals(end1,end2);
    }

    @Test
    void get() {
        EndlessArray end1 = new EndlessArray();
        EndlessArray end2 = new EndlessArray();
        end1.add(3);
        end2.add(3);
        end1.add(1);
        end2.add(1);
        end1.add(9);
        end2.add(9);
        end1.add(8);
        end2.add(8);


        Assert.assertEquals(end1.get(1),end2.get(1));

    }

    @Test
    void indexOf() throws IndexOutOfBoundsException{
        EndlessArray end1 = new EndlessArray();
        EndlessArray end2 = new EndlessArray();
        end1.add(3);
        end2.add(3);
        end1.add(1);
        end2.add(1);
        end1.add(9);
        end2.add(9);
        end1.add(8);
        end2.add(8);

        Assert.assertEquals(end1.indexOf(9),end2.indexOf(9));
    }

    @Test
    void lastIndexOf() throws IndexOutOfBoundsException {
        EndlessArray end1 = new EndlessArray();
        EndlessArray end2 = new EndlessArray();
        end1.add(3);
        end2.add(3);
        end1.add(1);
        end2.add(1);
        end1.add(8);
        end2.add(8);
        end1.add(8);
        end2.add(8);


        Assert.assertEquals(end1.lastIndexOf(8),end2.lastIndexOf(8));
    }

    @Test
    void contains() {
        EndlessArray end1 = new EndlessArray();
        EndlessArray end2 = new EndlessArray();
        end1.add(3);
        end2.add(3);
        end1.add(1);
        end2.add(1);
        end1.add(8);
        end2.add(8);
        end1.add(8);
        end2.add(8);


        Assert.assertEquals(end1.contains(8),end2.contains(8));
    }

    @Test
    void getArray() {
        EndlessArray end1 = new EndlessArray();
        EndlessArray end2 = new EndlessArray();
        end1.add(3);
        end2.add(3);
        end1.add(1);
        end2.add(1);
        end1.add(8);
        end2.add(8);
        end1.add(8);
        end2.add(8);
        Object [] test1 = end1.getArray();
        Object [] test2 = end1.getArray();


        Assert.assertArrayEquals(test1,test2);
    }
}

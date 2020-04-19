package Tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.polly.dictionary.Dictionary;

import java.io.IOException;

class DictionaryTest {

    @Test
    void insert() throws IOException {
        String path = "C:\\Users\\Полин о4чка\\Desktop\\dict.txt";
        Dictionary d1 = new Dictionary(path);
        d1.insert("apple", "яблоко");
        Dictionary d2 = new Dictionary(path);
        d2.insert("apple", "яблоко");
        Assert.assertEquals(d1, d2);
    }

    @Test
    void delete() throws IOException {
        String path = "C:\\Users\\Полин о4чка\\Desktop\\dict.txt";
        Dictionary d1 = new Dictionary(path);
        Dictionary d2 = new Dictionary(path);
        d1.delete("apple");
        d2.delete("apple");
        Assert.assertEquals(d1,d2);
    }

    @Test
    void unique() throws IOException {
        String path = "C:\\Users\\Полин о4чка\\Desktop\\dict.txt";
        Dictionary d1 = new Dictionary(path);
        Dictionary d2 = new Dictionary(path);
        Assert.assertEquals(d1.unique(),d2.unique());

    }

    @Test
    void numLen1() throws IOException {
        String path = "C:\\Users\\Полин о4чка\\Desktop\\dict.txt";
        Dictionary d1 = new Dictionary(path);
        Dictionary d2 = new Dictionary(path);
        Assert.assertEquals(d1.numLen1(),d2.numLen1());
    }

    @Test
    void translate() throws IOException {
        String path = "C:\\Users\\Полин о4чка\\Desktop\\dict.txt";
        Dictionary d1 = new Dictionary(path);
        Dictionary d2 = new Dictionary(path);

        String text = "polly apple";
        String test1 = d1.translate(text);
        String test2 = d2.translate(text);
        Assert.assertEquals(test1, test2);
    }
}
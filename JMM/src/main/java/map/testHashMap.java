package map;

import javax.crypto.spec.PSource;
import java.util.HashMap;

public class testHashMap {
    public static void main(String[] args) {

        System.out.println(tableSizeFor(16));
        HashMap map=new HashMap(10);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 111111) ? 1111111 : n + 1;
    }
}

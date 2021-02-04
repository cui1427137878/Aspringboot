package cgb.java.jvm.oom;

import java.util.ArrayList;
import java.util.List;

//  -Xmx20m -Xms5m 
//  调整堆大小 -Xmx1g
public class TestOOM01 {

    public static void main(String[] args) throws Exception {
        long t1 = System.currentTimeMillis();
        try {
            List<byte[]> list = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                //1m
                list.add(new byte[1024 * 1024]);
            }
            long t2 = System.currentTimeMillis();
            System.out.println("运行时间:" + (t2 - t1));
        } finally {

        }
    }
}

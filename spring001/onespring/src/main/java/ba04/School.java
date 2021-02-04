package ba04;

/**
 * Classsname:School
 * Package:com.tedu.cn
 * Description:
 *
 * @Data:2020/10/22 15:39
 * Author:崔建新
 */
public class School {
    private String sname;

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "School{" +
                "sname='" + sname + '\'' +
                '}';
    }
}

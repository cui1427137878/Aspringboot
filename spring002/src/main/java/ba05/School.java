package ba05;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ClassName:School
 * Package:ba03
 * Description:
 *
 * @Data:2020/10/23 19:37
 * Author:崔建新
 */
@Component("school")
public class School {
    @Value("山东大学")
    private String name;

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                '}';
    }
}

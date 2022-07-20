package z;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import z.config.SpringConfig;
import z.pojo.User;

/**
 * @author zhangfx
 * @date 2022/7/19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class MainTest {


  //  ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    @Autowired
    User user;
    @Test
    public void test1() {
        user.t1();
    }

}

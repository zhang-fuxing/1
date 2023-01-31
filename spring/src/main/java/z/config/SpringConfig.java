package z.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zhangfx
 * @date 2022/7/19
 */
@Configurable
@ComponentScan("z")
// 开启切面代理
@EnableAspectJAutoProxy
public class SpringConfig {
}

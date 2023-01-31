package z.intef.impl;

import org.springframework.stereotype.Service;
import z.intef.FlyType;

/**
 * @author zhangfx
 * @date 2023/1/31
 */
@Service
public class FlyTypeImpl implements FlyType {
	@Override
	public void fly() {
		System.out.println("wuwuwu~~~");
	}
}

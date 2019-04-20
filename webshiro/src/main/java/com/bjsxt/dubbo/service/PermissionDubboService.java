package com.bjsxt.dubbo.service;

import java.util.List;

public interface PermissionDubboService {
	List<Long> selPermissionByUid(long uid);
}

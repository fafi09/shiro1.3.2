package com.bjsxt.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjsxt.dubbo.service.MenuDubboService;
import com.bjsxt.manage.pojo.Attributes;
import com.bjsxt.manage.pojo.EasyUITree;
import com.bjsxt.manage.service.MenuService;
import com.bjsxt.pojo.Menu;

@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDubboService menuDubboService;
	@Override
	public List<EasyUITree> selByUidPid(long uid, long pid) {
		List<Menu> list = menuDubboService.selByUidPid(uid, pid);
		List<EasyUITree> listTree = new ArrayList<>();
		for(Menu menu :list){
			EasyUITree tree = new EasyUITree();
			tree.setAttributes(new Attributes(menu.getFilename()));
			BeanUtils.copyProperties(menu, tree);
			listTree.add(tree);
		}
		return listTree;
	}

}

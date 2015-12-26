package boke.service.impl;

import java.util.List;

import boke.dao.service.BtypesManager;
import boke.po.Btypes;
import boke.service.util.ManagerTemplate;

public class BtypesManagerImpl extends ManagerTemplate implements BtypesManager{

	@Override
	public List<Btypes> QueryAll() {
		// TODO Auto-generated method stub
		return this.btypesDao.findAll();
	}

	@Override
	public Btypes getById(Integer tid) {
		// TODO Auto-generated method stub
		return this.btypesDao.get(tid);
	}

	@Override
	public Btypes findtype(String name) {
		// TODO Auto-generated method stub
		return this.getBtypesDao().getByName(name);
	}
	
}

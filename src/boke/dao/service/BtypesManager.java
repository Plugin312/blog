package boke.dao.service;

import java.util.List;

import boke.po.Btypes;

public interface BtypesManager {
	
	public List<Btypes> QueryAll();
	
	public Btypes getById(Integer tid);
	
	public Btypes findtype(String name);
}

package boke.dao;

import java.util.List;

import boke.po.Btypes;

public interface BtypesDao {

	void save(Btypes btypes);

	void update(Btypes btypes);

	void delete(Btypes btypes);

	void delete(Integer tid);
	
	Btypes get(Integer tid);
	
	Btypes getByName(String name);

	List<Btypes> findAll();
}

package fa.training.dao;

import java.util.List;

import fa.training.entities.Item;

public interface ItemDao {
	boolean save(Item item);
	Item getById(int id);
	List<Item> getAll();
	boolean update(Item item);
	boolean delete(Item item);
}

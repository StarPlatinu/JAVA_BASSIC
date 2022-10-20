package fa.training.dao;

import java.sql.SQLException;
import java.util.List;

import fa.training.entities.CusSuper;

public interface CusSuperDao {
	public List<CusSuper>  getCusSuperByCusId(int cid) throws SQLException;
}

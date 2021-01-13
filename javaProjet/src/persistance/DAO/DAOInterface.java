package persistance.DAO;

public interface DAOInterface<Table> {
	
	
	boolean isExist(Table table);
	boolean insert(Table table);
	boolean delete(Table table);
	Object searchById(String id);
	boolean update(Table table1);
	


}

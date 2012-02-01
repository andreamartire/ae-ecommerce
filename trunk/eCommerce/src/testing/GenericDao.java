package testing;

import java.util.List;


public interface GenericDao {
	public void insert(Object entity);

	public void update(Object entity);

	public void delete(Object entity);
	
	public void delete(int id);

	public Object findById(int id);

	public List<Object> findAll(Class<?> entityClass);

	public int count(Class<?> entityClass);
}

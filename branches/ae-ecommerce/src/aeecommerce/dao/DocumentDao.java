package aeecommerce.dao;

import aeecommerce.pojo.Document;

public interface DocumentDao {

	public void update(Document d);

	public Document load();

	public void insert(Document document);
}

package aeecommerce.service;

import aeecommerce.pojo.Document;

public interface DocumentService {

	public void update(Document d);

	public Document load();

	public void save(Document document);
}


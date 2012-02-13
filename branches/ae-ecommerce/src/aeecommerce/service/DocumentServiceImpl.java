package aeecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeecommerce.dao.DocumentDao;
import aeecommerce.pojo.Document;

@Service
public class DocumentServiceImpl implements DocumentService {
	
	@Autowired
	private DocumentDao documentsDao;

	@Override
	public void update(Document d) {
		documentsDao.update(d);
	}

	@Override
	public Document load() {
		return documentsDao.load();
	}

	@Override
	public void save(Document document) {
		documentsDao.insert(document);
	}
}

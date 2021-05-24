package mx.edu.uacm.mor.spring.orm.dao;

import java.util.List;

import mx.edu.uacm.mor.spring.orm.entity.Product;

public interface ProductDAO {
	
	public int create(Product product);
	public void update(Product product);
	public void delete(int id);
	public Product search(int id);
	public List<Product> loadAll();

}

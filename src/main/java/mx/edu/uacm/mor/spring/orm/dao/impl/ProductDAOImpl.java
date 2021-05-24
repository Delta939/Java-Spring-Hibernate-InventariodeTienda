package mx.edu.uacm.mor.spring.orm.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.uacm.mor.spring.orm.dao.ProductDAO;
import mx.edu.uacm.mor.spring.orm.entity.Product;

@Component("productDAO")
public class ProductDAOImpl implements ProductDAO{
	
	List<Product> lista;
	
	
	public List<Product> getLista() {
		return lista;
	}

	public void setLista(List<Product> lista) {
		this.lista = lista;
	}

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Override
	@Transactional(readOnly = false)
	public int create(Product product) {
		Integer result = (Integer) hibernateTemplate.save(product);
		return result;
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Product product) {
		hibernateTemplate.update(product);
		
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(int id) {
		Product product=new Product();
		product.setId(id);
		hibernateTemplate.delete(product);
		
	}

	@Override
	@Transactional(readOnly = false)
	public Product search(int id) {
		
		return hibernateTemplate.get(Product.class, id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Product> loadAll() {
    
      return (List<Product>) this.hibernateTemplate.find("FROM Product");
	    
		
	}


}

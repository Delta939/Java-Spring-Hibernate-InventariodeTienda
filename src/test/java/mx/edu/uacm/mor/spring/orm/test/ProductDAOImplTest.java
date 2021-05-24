package mx.edu.uacm.mor.spring.orm.test;


import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.FlushMode;
import org.hibernate.Session;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import mx.edu.uacm.mor.spring.orm.dao.ProductDAO;
import mx.edu.uacm.mor.spring.orm.dao.impl.ProductDAOImpl;
import mx.edu.uacm.mor.spring.orm.entity.Product;

public class ProductDAOImplTest {
	
	public static void main(String[] args) {
		//leemos e instanciamos objeto
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config_orm.xml");
		
		ProductDAO productDAO = (ProductDAO) ctx.getBean("productDAO");
		 Scanner s=new Scanner(System.in);
		
		
		
		int n=0;
		do {
		
		System.out.println("Inventario de Tienda Deportiva");
		System.out.println("1. Agregar producto");
		System.out.println("2. Editar producto");
		System.out.println("3. Borrar producto");
		System.out.println("4. Buscar producto por id");
		System.out.println("5. Listar todos los productos");
		System.out.println("6. Salir");
		n=s.nextInt();
		
		
		switch(n) {
		case 1: 
			Product p = new Product();
			Scanner scan=new Scanner(System.in);
			int id;
			String nom, des;
			float precio;
			System.out.println("Agregar producto por id ");
			System.out.println("Teclee el Id ");
			id=scan.nextInt();
			scan.nextLine();
			System.out.println("Teclee el nombre del articulo ");
			nom=scan.next();
			scan.nextLine();
			System.out.println("Teclee la descripcion del articulo ");
			des=scan.next();
			scan.nextLine();
			System.out.println("Teclee el precio del articulo ");
			precio=scan.nextFloat();
			scan.nextLine();
			
			int a=0;
			System.out.println("Teclee 1 para agregar el producto");
			a=scan.nextInt();
			scan.nextLine();
			if(a==1) {
			p.setId(id);
			p.setName(nom);
			p.setDescription(des);
			p.setPrice(precio);
			productDAO.create(p);
			System.out.println("Done...");
			}
			break;
		case 2:
			Scanner sca=new Scanner(System.in);
			int id4;
			String nomb, desc;
			float precioo;
			System.out.println("Editar por id ");
			System.out.println("Teclee el Id ");
			id4=sca.nextInt();
			sca.nextLine();
			System.out.println("Teclee el nombre del articulo ");
			nomb=sca.next();
			sca.nextLine();
			System.out.println("Teclee la descripcion del articulo ");
			desc=sca.next();
			sca.nextLine();
			System.out.println("Teclee el precio del articulo ");
			precioo=sca.nextFloat();
			sca.nextLine();
			
			int z=0;
			System.out.println("Teclee 1 para Editar el producto");
			z=sca.nextInt();
			sca.nextLine();
			
			if(z==1) {
			Product p2 = new Product();
			p2.setId(id4);
			p2.setName(nomb);
			p2.setDescription(desc);
			p2.setPrice(precioo);
			productDAO.update(p2);
			System.out.println("Done...");
			}
			break;
		case 3:
			Scanner sc=new Scanner(System.in);
			int id2;
			System.out.println("Borrar producto por id");
			System.out.println("Teclee el Id: ");
			id2=sc.nextInt();
			sc.nextLine();
						
			int aaa=0;
			System.out.println("Teclee 1 para borrar el producto");
			aaa=sc.nextInt();
			sc.nextLine();
			if(aaa==1) {
			productDAO.delete(id2);
			System.out.println("Done...");
			}
			break;
		case 4:
			Scanner scann=new Scanner(System.in);
			int id3;
			System.out.println("Busqueda por id");
			System.out.println("Teclee el Id: ");
			id3=scann.nextInt();
			scann.nextLine();
						
			int aa=0;
			System.out.println("Teclee 1 para buscar el producto");
			aa=scann.nextInt();
			scann.nextLine();
			Product pr=new Product();
			if(aa==1) {
			pr=productDAO.search(id3);
			System.out.println("Id: "+pr.getId()+" Nombre: "+pr.getName()+" Desc: "+pr.getDescription()+" Precio: "+pr.getPrice());
			}
			break;
		case 5:
			
			List l= productDAO.loadAll();
			Iterator iter = l.iterator();
			  System.out.println("Listar todos los productos");
			while (iter.hasNext()) {
			  System.out.println(iter.next());
			}
						
			
			break;
		case 6:
			 
			break;
		
		}
		
		
		
		}while(n!=6);
		
		
	}

}

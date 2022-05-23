package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entity.User;
import Untils.JPAUtils;

public class AbstractDAO<T> {
	public static final EntityManager entityManager=JPAUtils.getEntityManager();
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		
		super.finalize();
	}
	public T findbyID(Class<T> clazz,String id) {
		return entityManager.find(clazz, id);
	}
	public T findbyID(Class<T> clazz,Integer id) {
		return entityManager.find(clazz, id);
	}
	
	public List<T> findAll(Class<T> clazz,boolean existIsActive){
		String entityName=clazz.getSimpleName();
		StringBuilder sql =new  StringBuilder();
		sql.append("SELECT o FROM ").append(entityName).append(" o");
		if(existIsActive == true ) {
			sql.append(" WHERE Active = 1");
		}
		TypedQuery<T> query =entityManager.createQuery(sql.toString(), clazz);
		return query.getResultList();
	}
	public List<T> findAll(Class<T> clazz){
		String entityName=clazz.getSimpleName();
		StringBuilder sql =new  StringBuilder();
		sql.append("SELECT o FROM ").append(entityName).append(" o");
		TypedQuery<T> query =entityManager.createQuery(sql.toString(), clazz);
		return query.getResultList();
	}
	
	public List<T> findAll(Class<T> clazz,boolean existIsActive,int pageNumber, int pageSize){
		String entityName=clazz.getSimpleName();
		StringBuilder sql =new  StringBuilder();
		sql.append("SELECT o FROM ").append(entityName).append(" o");
		if(existIsActive == true ) {
			sql.append(" WHERE Active = 1");
		}
		TypedQuery<T> query =entityManager.createQuery(sql.toString(), clazz);
		query.setFirstResult((pageNumber-1) *pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
		/*
		 * 5 phần tử
		 * muốn 1 trang 2 phân tử
		 * tống số trang 3
		 * trang 1 :2pt
		 * trang2:2pt
		 * trang 3: 1pt
		 * muôn lấy các phan tu ở trang số 2 >>> pageNumber=2,pasize =2(bắt đầu lấy từ phần tử thứ 2)
		 */
	}
	
	//select o from user o where o.id = ?0 and o.password =?1;
	public T findOne(Class<T> clazz,String sql,Object ... params) {
		TypedQuery<T> query=entityManager.createQuery(sql,clazz);
		for(int i =0;i<params.length;i++) {
			query.setParameter(i, params[i]);
		}
		List<T> result =query.getResultList();
		if(result.isEmpty()) {
			return null;
		}
		return result.get(0);		
	}
	
	public List<T> findMany(Class<T> clazz,String sql,Object ... params) {
		TypedQuery<T> query=entityManager.createQuery(sql,clazz);
		for(int i =0;i<params.length;i++) {
			query.setParameter(i, params[i]);
		}
		return query.getResultList();		
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> findManyBYNativeQuery(Class<T> clazz,String sql,Object ... params) {
		Query query=entityManager.createQuery(sql,clazz);
		for(int i =0;i<params.length;i++) {
			query.setParameter(i, params[i]);
		}
		return query.getResultList();		
	}
	
	public T create(T entity){
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			System.out.println("Thêm thành công");
			return entity;
		} catch (Exception e) {
			// TODO: handle exception
			entityManager.getTransaction().rollback();
			System.out.println("Ko thêm được "+entity.getClass().getSimpleName()+"to DB");
			throw new RuntimeException(e);
		}	
	}
	
	public T update(T entity){
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
			System.out.println("Cập nhật thành công");
			return entity;
		} catch (Exception e) {
			// TODO: handle exception
			entityManager.getTransaction().rollback();
			System.out.println("Ko update được "+entity.getClass().getSimpleName()+"to DB");
			throw new RuntimeException(e);
		}	
	}
	
	public T delete(T entity){
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			System.out.println("Xoá thành công");
			return entity;
		} catch (Exception e) {
			// TODO: handle exception
			entityManager.getTransaction().rollback();
			System.out.println("Ko xoá được "+entity.getClass().getSimpleName()+"to DB");
			throw new RuntimeException(e);
		}	
	}

}


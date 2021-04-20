package br.com.task.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.task.repository.BaseRepository;

public class DAO<T extends BaseRepository> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static EntityManager em = ConectionFactory.getManager();
	
	public T buscarPorId(Class<T> class1, Long id) {
		return em.find(class1, id);
	}
	
	public void salvar(T t) {
		try {
			em.getTransaction().begin();
			if(t.getId()== null) {
				//talvez resolver 
				em.persist(t);
			}else {
				em.merge(t);
			}
			
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
		}
	}
	
	public void remover(Class<T> class1, Long id) {
		T t = buscarPorId(class1, id);
		try {
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
		}
	}
	@SuppressWarnings("unchecked")
	public List<T> buscarTodos(String jpql){
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}
	
	
	
	
	
}

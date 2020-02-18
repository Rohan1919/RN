package com.lti.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Album;
import com.lti.entity.Customer;
import com.lti.entity.Song;

public class AlbumSongDao extends GenericDao {
	
	public List<Album> fetchAlbumsReleasedIn(int year){
			EntityManagerFactory emf=
					Persistence.createEntityManagerFactory("hibernate-demo");
			EntityManager em=emf.createEntityManager();
			try{String ql="select a from Album a where extract(year from a.releaseDate)";
			//String ql="select c from Customer c where c.email like '%@gmail.com'";
			Query q=em.createQuery(ql);
			q.setParameter("year",year);
			
			List<Album> list=q.getResultList();
			return list;
			}
			finally{
				em.close();
				emf.close();
			}
		
	}
	public List<Song> fetchSongsSungBy(String artist){
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("hibernate-demo");
		EntityManager em=emf.createEntityManager();
		try{String ql="select s from Song s where s.artist =:artist";
		//String ql="select c from Customer c where c.email like '%@gmail.com'";
		Query q=em.createQuery(ql);
		q.setParameter("artist",artist);
	
		List<Song> list=q.getResultList();
		return list;
		}
		finally{em.close();
		emf.close();
		}
	
}
	public List<Album> fetchAlbumsOf(String artist){
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("hibernate-demo");
		EntityManager em=emf.createEntityManager();
		try {
		
			
			String ql="select a from Album a join a.song s where s.artist =:artist";
			//String ql="select c from Customer c where c.email like '%@gmail.com'";
			Query q=em.createQuery(ql);
			q.setParameter("artist",artist);
			List<Album> list=q.getResultList();
			return list;
			
		}
		finally {
			em.close();
			emf.close();
	
		}
		
		

}
	public List<Song> fetchSongsOfType(String genre){
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("hibernate-demo");
		EntityManager em=emf.createEntityManager();
		try{String ql="select s from Song s.id a where a.genre=:genre";
		//String ql="select c from Customer c where c.email like '%@gmail.com'";
		Query q=em.createQuery(ql);
		q.setParameter("genre",genre);
	
		List<Song> list=q.getResultList();
		return list;

		}
		finally{
			em.close();
			emf.close();
		}
}
	
}

package com.lti.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lti.dao.AlbumSongDao;
import com.lti.dao.GenericDao;
import com.lti.entity.Album;
import com.lti.entity.Song;

public class AlbumSongAlbum {
	
	@Test
	public void addAlbum() {
		GenericDao dao=new GenericDao();
		Album al=new Album();
		al.setName("opukh");
		al.setReleaseDate(LocalDate.of(2020,05,02));
		al.setGenre("kliujdfhj");
		dao.upsert(al);
		
	}
	@Test
	public void addSongToAnAlbum() {
		GenericDao dao=new GenericDao();
		Album al=dao.fetchByPK(Album.class, 82);
		Song sg=new Song();
		List<Song> song=new ArrayList<Song>();
		sg.setArtist("salman");
		sg.setDuration(10.00);
		sg.setTitle("hello");
		sg.setId(82);
		sg.setAlbum(al);
		dao.upsert(sg);
		song.add(sg);
//		Song sg1=new Song();
//		sg1.setArtist("abc");
//		sg1.setDuration(6.00);
//		sg1.setTitle("pqr");
//		sg1.setAlbum(al);
//		dao.upsert(sg1);
//		song.add(sg1);
		
		
		al.setSong(song);
		
	}
	@Test
	public void addAlbumAlongWithSongs() {
		GenericDao dao=new GenericDao();
		Album al=new Album();
		al.setName("rohan");
		al.setReleaseDate(LocalDate.of(2010,05,02));
		al.setGenre("fadfjdfhj");
		
		Song sg=new Song();
		List<Song> song=new ArrayList<Song>();
		sg.setArtist("shubham");
		sg.setDuration(5.00);
		sg.setTitle("hhlo");
		sg.setAlbum(al);
		//dao.upsert(sg);
		song.add(sg);
		//dao.upsert(song);
//		Song sg1=new Song();
//		sg1.setArtist("abc");
//		sg1.setDuration(6.00);
//		sg1.setTitle("pqr");
//		sg1.setAlbum(al);
//		dao.upsert(sg1);
//		song.add(sg1);
//		
		
		al.setSong(song);
		dao.upsert(al);
		
		
	}
	@Test
	public void fetchByReleaseDate() {
		AlbumSongDao dao=new AlbumSongDao();
	
		Song sg=new Song();
		List<Album> album=new ArrayList<Album>();
		album=dao.fetchAlbumsReleasedIn(2010);
		for(Album al:album) {
		System.out.println(al.toString());
	      }
	}
	@Test
	public void fetchBySungBy() {
		AlbumSongDao dao=new AlbumSongDao();
	
		
		List<Song> song=new ArrayList<Song>();
		song=dao.fetchSongsSungBy("shubham");
		for(Song sg:song) {
		System.out.println(sg.getTitle());
	      }
	}
	@Test
	public void fetchAlbumsOfs() {
		AlbumSongDao dao=new AlbumSongDao();
	
		
		List<Album> all=dao.fetchAlbumsOf("shubham");
		for(Album al:all) {
		System.out.println(al.getName());
	      }
	}


}

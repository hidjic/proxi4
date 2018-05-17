package fr.gtm.pbsi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.test2.dao.ArtistDao;
import fr.test2.dao.DaoCountry;
import fr.test2.domain.Album;
import fr.test2.domain.Artist;
import fr.test2.domain.Country;

@Controller
public class IndexController {
	
//	@Autowired(required = true)
//	private Artist artist;
//	
//	@Autowired(required = true)
//	private ArtistDao artistDao;
//	
//	@Autowired(required = true)
//	private DaoCountry daoCountry;
//	
//	public Artist getArtist() {
//		return artist;
//	}
//	public void setArtist(Artist artist) {
//		this.artist = artist;
//	}
	
	@RequestMapping(path = "/testWelcome", method = RequestMethod.GET)
	public ModelAndView displayIndex() {
		ModelAndView mav = new ModelAndView("testWelcome");
		
//		Country newCountry = new Country("France");
//		this.daoCountry.save(newCountry);
//		
//		Optional<Country> test = this.daoCountry.findById(1);
//		
//		if(test.isPresent()) {
//			
//			List<Album> listAlbumLofofora = new ArrayList<Album>();
//			Album a1 = new Album("Lofofora");
//			Album a2 = new Album("Peuh !");
//			Album a3 = new Album("Dur comme fer");
//			Album a4 = new Album("Le fond et la forme");
//			listAlbumLofofora.add(a1);
//			listAlbumLofofora.add(a2);
//			listAlbumLofofora.add(a3);
//			listAlbumLofofora.add(a4);
//			
//			List<Album> listAlbumbba = new ArrayList<Album>();
//			Album aa1 = new Album("Human Bomb");
//			Album aa2 = new Album("Speech of Freedom");
//			Album aa3 = new Album("One Sound Bite to React");
//			Album aa4 = new Album("From Chaos");
//			listAlbumbba.add(aa1);
//			listAlbumbba.add(aa2);
//			listAlbumbba.add(aa3);
//			listAlbumbba.add(aa4);
//			
//			Artist newArtist1 = new Artist("Lofofora",test.get(),listAlbumLofofora);
//			Artist newArtist2 = new Artist("Black bomb A", test.get(),listAlbumbba);
//			this.artistDao.save(newArtist1);
//			this.artistDao.save(newArtist2);
//		}
		
		List<Artist> listArtist = new ArrayList<Artist>();
		listArtist.addAll(this.artistDao.findAll());
		for(Artist a:listArtist) {
			System.out.println(a);
		}

		ObjectMapper mapper = new ObjectMapper();
		String s = "";
		try {
			s = mapper.writeValueAsString(listArtist);
			System.out.println(s);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		mav.getModel().put("listArtist", s);
		
		return mav;
	}


	
}

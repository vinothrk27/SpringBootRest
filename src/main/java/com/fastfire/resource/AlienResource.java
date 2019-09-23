package com.fastfire.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fastfire.bean.Alien;
import com.fastfire.repository.AlienRepository;

@RestController
public class AlienResource {
	
	@Autowired
	AlienRepository repo;
	
	@GetMapping("/aliens")
	public List<Alien> getAliens()
	{
		List<Alien> aliens = (List<Alien>) repo.findAll();
		
		return aliens;
	}
	
	@GetMapping("/getAlien")
	public Alien getAlien(@RequestParam int id) 
	{
		System.out.println(id);
		return repo.findById(id).get();
	}
	
	@PostMapping("/createAlien")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Alien> createAliens(@RequestBody Alien a)
	{
		repo.save(a);
		return (List<Alien>) repo.findAll();
	}
	
	@PutMapping("/updateAlien")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Alien> updateAlien(@RequestBody Alien a)
	{
		repo.save(a);
		return (List<Alien>) repo.findAll();
	}
	
	@DeleteMapping("/deleteAlien")
	public List<Alien> deleteAlien(@RequestBody Alien a)
	{
		repo.delete(a);
		return (List<Alien>) repo.findAll();
	}
}

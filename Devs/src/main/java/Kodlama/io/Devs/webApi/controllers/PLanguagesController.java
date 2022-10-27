package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.PLanguageService;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/languages")
public class PLanguagesController {
	private PLanguageService pLanguageService;

	@Autowired
	public PLanguagesController(PLanguageService pLanguageService) {
		super();
		this.pLanguageService = pLanguageService;
	}
	
	@PostMapping("/add")
	public void add(@RequestBody ProgrammingLanguage programmingLanguage) {
		pLanguageService.add(programmingLanguage);
	}
	
	@PostMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		pLanguageService.delete(id);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody ProgrammingLanguage programmingLanguage) {
		pLanguageService.update(programmingLanguage);
	}
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll(){
		return pLanguageService.getAll();
	}
	
	@GetMapping("/get/{id}")
	public ProgrammingLanguage getById(@PathVariable("id") int id) {
		return pLanguageService.getById(id);
	}
}

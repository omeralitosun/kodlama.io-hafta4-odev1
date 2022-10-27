package Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.PLanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.PLanguageRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class PLanguageManager implements PLanguageService{
	
	private PLanguageRepository pLanguageRepository;
	
	@Autowired
	public PLanguageManager(PLanguageRepository pLanguageRepository) {
		super();
		this.pLanguageRepository = pLanguageRepository;
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		try {
			if(programmingLanguage.getName()!=null && programmingLanguage.getName().trim()!="") {
				for(ProgrammingLanguage _programmingLanguage: pLanguageRepository.getAll()) {
					
					if(programmingLanguage.getId()==_programmingLanguage.getId()) {
						throw new Exception(programmingLanguage.getId()+" id'ye Sahip Data Var");
					}
					else if(programmingLanguage.getName().trim().equals(_programmingLanguage.getName().trim())) {
						throw new Exception(programmingLanguage.getName()+" Zaten Mevcut. Başka isim ile tekrar deneyiniz.");
					}
				}
				pLanguageRepository.add(programmingLanguage);
			}else {
				throw new Exception("Name alanı boş olamaz");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void delete(int id) {
		pLanguageRepository.delete(id);		
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		try {
			if(programmingLanguage.getName()!=null) {
				for(ProgrammingLanguage _programmingLanguage: pLanguageRepository.getAll()) {
					if(programmingLanguage.getName().trim().equals(_programmingLanguage.getName().trim())) {
						throw new Exception(programmingLanguage.getName()+" Zaten Mevcut. Başka isim ile tekrar deneyiniz.");
					}
				}
				pLanguageRepository.update(programmingLanguage);
			}else {
				throw new Exception("Name alanı boş olamaz");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		// TODO Auto-generated method stub
		return pLanguageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		// TODO Auto-generated method stub
		return pLanguageRepository.getById(id);
	}

}

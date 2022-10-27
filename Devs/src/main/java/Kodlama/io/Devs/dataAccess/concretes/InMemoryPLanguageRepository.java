package Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.dataAccess.abstracts.PLanguageRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
@Repository
public class InMemoryPLanguageRepository implements PLanguageRepository{
	
	private List<ProgrammingLanguage> programmingLanguages;
	
	@Autowired
	public InMemoryPLanguageRepository() {
		super();
		this.programmingLanguages = new ArrayList<ProgrammingLanguage>();
		programmingLanguages.add(new ProgrammingLanguage(0, "Java"));
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {	
		
		try {
			if(!programmingLanguages.add(programmingLanguage)) {
				throw new Exception(programmingLanguage.getId()+" "+programmingLanguage.getName()+" Eklenemedi.!!!!");
			}
			System.out.println(programmingLanguage.getName()+" Eklendi");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void delete(int id) {
		
		try {			
			for(ProgrammingLanguage _programmingLanguage: programmingLanguages) {
				
				if(_programmingLanguage.getId()==id) {
					programmingLanguages.remove(programmingLanguages.indexOf(_programmingLanguage));
					System.out.println(_programmingLanguage.getId()+": "+_programmingLanguage.getName()+" silindi.");
					break;
				}else if(programmingLanguages.size()-1==programmingLanguages.indexOf(_programmingLanguage)) {
					throw new Exception("id ="+id+" Bulunamadı. Silme İşlemi Başarısız.");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		try {
			for(ProgrammingLanguage _programmingLanguage: programmingLanguages) {
				
				if(_programmingLanguage.getId()==programmingLanguage.getId()) {
					programmingLanguages.set(programmingLanguages.indexOf(_programmingLanguage),programmingLanguage);
					System.out.println("Güncellendi "+_programmingLanguage.getId()+": "+_programmingLanguage.getName()+" >> "+programmingLanguage.getName());
					break;
				}else if(programmingLanguages.size()-1==programmingLanguages.indexOf(_programmingLanguage)) {
					throw new Exception("id ="+programmingLanguage.getId()+" Bulunamadı. Güncelleme İşlemi Başarısız.");
				}
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return this.programmingLanguages;
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		try {
			for(ProgrammingLanguage _programmingLanguage: programmingLanguages) {
				if(_programmingLanguage.getId()==id) {
					return _programmingLanguage;
				}
			}
			throw new Exception(id+" Bulunamadı.");			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}

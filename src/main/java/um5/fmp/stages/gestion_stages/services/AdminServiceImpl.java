package um5.fmp.stages.gestion_stages.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import um5.fmp.stages.gestion_stages.models.Admin;
import um5.fmp.stages.gestion_stages.models.Annonce;
import um5.fmp.stages.gestion_stages.models.Document;
import um5.fmp.stages.gestion_stages.models.EmplacementStage;
import um5.fmp.stages.gestion_stages.models.Encadrant;
import um5.fmp.stages.gestion_stages.models.Etudiant;
import um5.fmp.stages.gestion_stages.models.Niveau;
import um5.fmp.stages.gestion_stages.models.Stage;
import um5.fmp.stages.gestion_stages.repository.AdminRepository;
import um5.fmp.stages.gestion_stages.repository.AffectationRepository;
import um5.fmp.stages.gestion_stages.repository.AnnonceRepository;
import um5.fmp.stages.gestion_stages.repository.DocumentRepository;
import um5.fmp.stages.gestion_stages.repository.EmplacementStageRepository;
import um5.fmp.stages.gestion_stages.repository.EncadrantRepository;
import um5.fmp.stages.gestion_stages.repository.EtudiantRepository;
import um5.fmp.stages.gestion_stages.repository.NiveauRepository;
import um5.fmp.stages.gestion_stages.repository.StageRepository;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminRepository adminRepo;
	@Autowired
	AffectationRepository affectationRepo;
	@Autowired
	AnnonceRepository annonceRepo;
	@Autowired
	DocumentRepository documentRepo;
	@Autowired
	EmplacementStageRepository emplacementStageRepo;
	@Autowired
	EncadrantRepository encadrantRepo;
	@Autowired
	EtudiantRepository etudiantRepo;
	@Autowired
	NiveauRepository niveauRepo;
	@Autowired
	StageRepository stageRepo;

	@Override
	public List<Etudiant> listEtudiant(int  page) {
		Pageable p = PageRequest.of(page,10);
		return etudiantRepo.findAll(p).toList();
	}

	@Override
	public List<Encadrant> listEncadrant(int page) {
		Pageable p = PageRequest.of(page,10);
		return encadrantRepo.findAll(p).toList();
	}

	@Override
	public List<Admin> listAdmin(int page) {
		Pageable p = PageRequest.of(page,10);
		return adminRepo.findAll(p).toList();
	}

	@Override
	public List<Stage> listStage(int page) {
		Pageable p = PageRequest.of(page,10);
		return stageRepo.findAll(p).toList();
	}

	@Override
	public List<Annonce> listAnnonce(int page) {
		Pageable p = PageRequest.of(page,10);
		return annonceRepo.findAll(p).toList();
	}

	@Override
	public List<Document> listDocuments(int page) {
		Pageable p = PageRequest.of(page,10);
		return documentRepo.findAll(p).toList();
	}

	@Override
	public List<EmplacementStage> listEmplacement(int page) {
		Pageable p = PageRequest.of(page,10);
		return emplacementStageRepo.findAll(p).toList();
	}

	@Override
	public List<Niveau> listNiveau(int page) {
		Pageable p = PageRequest.of(page,10);
		return niveauRepo.findAll(p).toList();
	}

	@Override
	public Etudiant getEtudiant(long id) {
		Optional<Etudiant> etudiant = etudiantRepo.findById(id);
        return etudiant.isPresent() ? etudiant.get() : null;
	}

	@Override
	public Encadrant getEncadrant(long id) {
		Optional<Encadrant> encadrant = encadrantRepo.findById(id);
        return encadrant.isPresent() ? encadrant.get() : null;
	}

	@Override
	public Admin getAdministrateur(long id) {
		Optional<Admin> admin = adminRepo.findById(id);
        return admin.isPresent() ? admin.get() : null;
	}

	@Override
	public Stage getStage(long id) {
		Optional<Stage> stage = stageRepo.findById(id);
        return stage.isPresent() ? stage.get() : null;
	}

	@Override
	public Annonce getAnnonce(long id) {
		Optional<Annonce> annonce = annonceRepo.findById(id);
        return annonce.isPresent() ? annonce.get() : null;
	}

	@Override
	public Document getDocument(long id) {
		Optional<Document> document = documentRepo.findById(id);
        return document.isPresent() ? document.get() : null;
	}

	@Override
	public EmplacementStage getEmplacement(long id) {
		Optional<EmplacementStage> emplacement = emplacementStageRepo.findById(id);
        return emplacement.isPresent() ? emplacement.get() : null;
	}

	@Override
	public Niveau getNiveau(long id) {
		Optional<Niveau> niveau = niveauRepo.findById(id);
        return niveau.isPresent() ? niveau.get() : null;
	}

	@Override
	public Boolean ajouterEtudiant(Etudiant e) {
		try {
            etudiantRepo.save(e);
            return true;

        } catch (Exception ex) {
            // TODO: handle exception
            System.out.println("Unable to save entity etudiant");
            System.out.println(ex.getMessage());
            return false;
        }
	}

	@Override
	public Boolean ajouterEncadrant(Encadrant e) {
		try {
            encadrantRepo.save(e);
            return true;

        } catch (Exception ex) {
            // TODO: handle exception
            System.out.println("Unable to save entity encadrant");
            System.out.println(ex.getMessage());
            return false;
        }
	}

	@Override
	public Boolean ajouterAdmin(Admin a) {
		try {
            adminRepo.save(a);
            return true;

        } catch (Exception ex) {
            // TODO: handle exception
            System.out.println("Unable to save entity admin");
            System.out.println(ex.getMessage());
            return false;
        }
	}

	@Override
	public Boolean ajouterStage(Stage s) {
		try {
            stageRepo.save(s);
            return true;

        } catch (Exception ex) {
            // TODO: handle exception
            System.out.println("Unable to save entity stage");
            System.out.println(ex.getMessage());
            return false;
        }
	}

	@Override
	public Boolean ajouterAnnonce(Annonce a) {
		try {
            annonceRepo.save(a);
            return true;

        } catch (Exception ex) {
            // TODO: handle exception
            System.out.println("Unable to save entity annonce");
            System.out.println(ex.getMessage());
            return false;
        }
	}

	
    @Override
	public Boolean ajouterEmplacement(EmplacementStage e) {
		try {
            emplacementStageRepo.save(e);
            return true;

        } catch (Exception ex) {
            // TODO: handle exception
            System.out.println("Unable to save entity emplacement");
            System.out.println(ex.getMessage());
            return false;
        }
	}
  
    public Boolean ajouterNiveau(Niveau s) {
  		try {
              niveauRepo.save(s);
              return true;

          } catch (Exception ex) {
              // TODO: handle exception
              System.out.println("Unable to save entity niveau");
              System.out.println(ex.getMessage());
              return false;
          }
  	}
	
	

	@Override
	public Boolean modifierEtudiant(Etudiant e) {
		Etudiant existantEtudiant  = etudiantRepo.findById(e.getId()).get();
		existantEtudiant.setEmail(e.getEmail());
		existantEtudiant.setNom(e.getNom());
		existantEtudiant.setPrenom(e.getPrenom());
		existantEtudiant.setUsername(e.getUsername());
		existantEtudiant.setPassword(e.getPassword());
		try {
			etudiantRepo.save(existantEtudiant);
			return true;
		}catch (Exception ex) {
            // TODO: Switch to slf4j for logging
            System.out.println("Unable to modify etudiant");
            return false;
        }
	}

	@Override
	public Boolean modifierEncadrant(Encadrant e) {
		Encadrant existantEncadrant  = encadrantRepo.findById(e.getId()).get();
		existantEncadrant.setEmail(e.getEmail());
		existantEncadrant.setNom(e.getNom());
		existantEncadrant.setPrenom(e.getPrenom());
		existantEncadrant.setUsername(e.getUsername());
		existantEncadrant.setPassword(e.getPassword());
		
		try {
			encadrantRepo.save(existantEncadrant);
			return true;
		}catch (Exception ex) {
            // TODO: Switch to slf4j for logging
            System.out.println("Unable to modify encadrant");
            return false;
        }
	}

	@Override
	public Boolean modifierAdmin(Admin a) {
		Admin existantAdmin  = adminRepo.findById(a.getId()).get();
		existantAdmin.setEmail(a.getEmail());
		existantAdmin.setNom(a.getNom());
		existantAdmin.setPrenom(a.getPrenom());
		existantAdmin.setUsername(a.getUsername());
		existantAdmin.setPassword(a.getPassword());
		try {
			adminRepo.save(existantAdmin);
			return true;
		}catch (Exception ex) {
            // TODO: Switch to slf4j for logging
            System.out.println("Unable to modify admin");
            return false;
        }
	}

	@Override
	public Boolean modifierStage(Stage s) {
		Stage existantStage  = stageRepo.findById(s.getId()).get();
		existantStage.setDuree(s.getDuree());
		existantStage.setNom(s.getNom());
		existantStage.setSujet(s.getSujet());
		try {
			stageRepo.save(existantStage);
			return true;
		}catch (Exception ex) {
            // TODO: Switch to slf4j for logging
            System.out.println("Unable to modify stage");
            return false;
        }
	}

	@Override
	public Boolean modifierAnnonce(Annonce a) {
		Annonce existantAnnonce  = annonceRepo.findById(a.getId()).get();
		existantAnnonce.setAuteur(a.getAuteur());
		existantAnnonce.setDescription(a.getDescription());
		existantAnnonce.setTitre(a.getTitre());
		try {
			annonceRepo.save(existantAnnonce);
			return true;
		}catch (Exception ex) {
            // TODO: Switch to slf4j for logging
            System.out.println("Unable to modify annonce");
            return false;
        }
	}

	
	

	@Override
	public Boolean modifierEmplacement(EmplacementStage e) {
		EmplacementStage existantEmplacement  = emplacementStageRepo.findById(e.getId()).get();
		existantEmplacement.setAdresse(e.getAdresse());
		existantEmplacement.setNom(e.getNom());
		existantEmplacement.setVille(e.getVille());
		try {
			emplacementStageRepo.save(existantEmplacement);
			return true;
		}catch (Exception ex) {
            // TODO: Switch to slf4j for logging
            System.out.println("Unable to modify emplacement");
            return false;
        }
	}

	@Override
	public Boolean deleteEtudiant(long id) {
		try {
			
            etudiantRepo.delete(etudiantRepo.findById(id).get());
            return true;

        } catch (Exception ex) {
            // TODO: handle exception
            System.out.println("Unable to delete entity etudiant");
            System.out.println(ex.getMessage());
            return false;
        }
	}

	@Override
	public Boolean deleteEncadrant(long id) {
try {
			
            encadrantRepo.delete(encadrantRepo.findById(id).get());
            return true;

        } catch (Exception ex) {
            // TODO: handle exception
            System.out.println("Unable to delete entity encadrant");
            System.out.println(ex.getMessage());
            return false;
        }
	}

	@Override
	public Boolean deleteAdministrateur(long id) {
try {
			
            adminRepo.delete(adminRepo.findById(id).get());
            return true;

        } catch (Exception ex) {
            // TODO: handle exception
            System.out.println("Unable to delete entity admin");
            System.out.println(ex.getMessage());
            return false;
        }
	}

	@Override
	public Boolean deleteStage(long id) {
try {
			
            stageRepo.delete(stageRepo.findById(id).get());
            return true;

        } catch (Exception ex) {
            // TODO: handle exception
            System.out.println("Unable to delete entity satage");
            System.out.println(ex.getMessage());
            return false;
        }
	}

	@Override
	public Boolean deleteAnnonce(long id) {
try {
			
            annonceRepo.delete(annonceRepo.findById(id).get());
            return true;

        } catch (Exception ex) {
            // TODO: handle exception
            System.out.println("Unable to delete entity annonce");
            System.out.println(ex.getMessage());
            return false;
        }
	}

	@Override
	public Boolean deleteEmplacement(long id) {
try {
			
            emplacementStageRepo.delete(emplacementStageRepo.findById(id).get());
            return true;

        } catch (Exception ex) {
            // TODO: handle exception
            System.out.println("Unable to delete entity emplacement");
            System.out.println(ex.getMessage());
            return false;
        }
	}

	@Override
	public Boolean assignLevelToStudent(long idStudent, long idLevel) {
		try {
		Etudiant e = etudiantRepo.findById(idStudent).get();
		Niveau n = niveauRepo.findById(idLevel).get();
		e.setNiveau(n);
		etudiantRepo.save(e);
		return true;
		 } catch (Exception ex) {
	            // TODO: handle exception
	            System.out.println("Unable to find the student or the level");
	            System.out.println(ex.getMessage());
	            return false;
	        }
		
		
		
		
		
	}

	@Override
	public Boolean assignLevelToTeacher(long idTeacher, long idLevel) {
		try {
			Encadrant e = encadrantRepo.findById(idTeacher).get();
			Niveau n = niveauRepo.findById(idLevel).get();
			e.setNiveau(n);
			encadrantRepo.save(e);
			return true;
			 } catch (Exception ex) {
		            // TODO: handle exception
		            System.out.println("Unable to find the teacher or the level");
		            System.out.println(ex.getMessage());
		            return false;
		        }
	}

	@Override
	public Boolean assignLevelToStage(long idStage, long idLevel) {
		try {
			Stage e = stageRepo.findById(idStage).get();
			Niveau n = niveauRepo.findById(idLevel).get();
			n.getStages().add(e);
			niveauRepo.save(n);
			return true;
			 } catch (Exception ex) {
		            // TODO: handle exception
		            System.out.println("Unable to find the student or the level");
		            System.out.println(ex.getMessage());
		            return false;
		        }
	}

	@Override
	public Boolean removeLevelStudent(long idStudent) {
		try {
			Etudiant e = etudiantRepo.findById(idStudent).get();
			e.setNiveau(null);
			return true;
			 } catch (Exception ex) {
		            // TODO: handle exception
		            System.out.println("Unable to find the student ");
		            System.out.println(ex.getMessage());
		            return false;
		        }
	}

	@Override
	public Boolean removeLevelTeacher(long idTeacher) {
		try {
			Encadrant e = encadrantRepo.findById(idTeacher).get();
			
			e.setNiveau(null);
			return true;
			 } catch (Exception ex) {
		            // TODO: handle exception
		            System.out.println("Unable to find the teacher");
		            System.out.println(ex.getMessage());
		            return false;
		        }
	}

	@Override
	public Boolean removeLevelStage(long idStage, long idNiveau) {
		try {
			Niveau e = niveauRepo.findById(idNiveau).get();
			for(int i=0;i<e.getStages().size();i++) {
				if(idStage==e.getStages().get(i).getId())
                   e.getStages().remove(i);
				   return true;
			}
			return false;
			
			
			 } catch (Exception ex) {
		            // TODO: handle exception
		            System.out.println("Unable to find the level or stage");
		            System.out.println(ex.getMessage());
		            return false;
		        }
	}

	

	

	

	

}

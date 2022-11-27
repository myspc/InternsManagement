package um5.fmp.stages.gestion_stages.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import um5.fmp.stages.gestion_stages.models.Annonce;
import um5.fmp.stages.gestion_stages.services.AdminService;

@RestController
@RequestMapping("/home")
public class HomeController {
	@Autowired
	AdminService adminService;
	@GetMapping("/annonces/{page}")
	public Page<Annonce> listAnnonce(@PathVariable int page) {
		return adminService.listAnnonce(page);
	}

}

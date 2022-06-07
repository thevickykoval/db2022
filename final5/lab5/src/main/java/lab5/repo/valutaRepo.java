package lab5.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import lab5.valuta.Valuta;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface valutaRepo extends JpaRepository<Valuta, Integer>{

}

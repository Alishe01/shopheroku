package kz.kaznitu.lessons.repas;

import org.springframework.data.repository.CrudRepository;
import kz.kaznitu.lessons.mod.Club;

import java.util.List;

public interface ClubRepas extends CrudRepository<Club, Integer> {
    List<Club> findByLabel(String Label);
}

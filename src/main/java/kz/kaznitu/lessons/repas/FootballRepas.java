package kz.kaznitu.lessons.repas;

import kz.kaznitu.lessons.mod.Football;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FootballRepas extends CrudRepository< Football, Integer> {
    Optional<Football> findById(Long id);
}

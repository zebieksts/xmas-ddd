package lt.zebieksts.xmas.evaluation.infra;

import lt.zebieksts.xmas.evaluation.model.letter.Letter;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LetterRepository {
  UUID save(Letter letter);
}

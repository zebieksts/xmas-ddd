package lt.zebieksts.xmas.evaluation.infra;

import lt.zebieksts.xmas.evaluation.model.Evaluation;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepository {
  void save(Evaluation evaluation);
}

package lt.zebieksts.xmas.evaluation.repositories;

import lt.zebieksts.xmas.common.model.ApprovalStatus;
import lt.zebieksts.xmas.evaluation.model.letter.Letter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface LetterRepository {
  @Transactional
  Letter save(Letter letter);

  @Transactional
  void setApprovalStatus(UUID id, ApprovalStatus status);
}

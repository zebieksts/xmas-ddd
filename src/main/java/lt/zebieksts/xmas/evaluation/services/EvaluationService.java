package lt.zebieksts.xmas.evaluation.services;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lt.zebieksts.xmas.common.events.RequestApproved;
import lt.zebieksts.xmas.common.events.RequestRejected;
import lt.zebieksts.xmas.common.model.ApprovalStatus;
import lt.zebieksts.xmas.common.model.DomainEventPublisher;
import lt.zebieksts.xmas.evaluation.repositories.ChildRepository;
import lt.zebieksts.xmas.evaluation.repositories.LetterRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EvaluationService {

  private DomainEventPublisher eventPublisher;
  private ChildRepository childRepository;
  private LetterRepository letterRepository;

  public void evaluate(UUID childId, UUID letterId) {
    if (childRepository.isGood(childId)) {
      approve(letterId);
    } else {
      reject(letterId);
    }
  }

  private void approve(UUID letterId) {
    letterRepository.setApprovalStatus(letterId, ApprovalStatus.APPROVED);
    eventPublisher.publish(new RequestApproved(letterId));
  }

  private void reject(UUID letterId) {
    letterRepository.setApprovalStatus(letterId, ApprovalStatus.REJECTED);
    eventPublisher.publish(new RequestRejected(letterId));
  }
}

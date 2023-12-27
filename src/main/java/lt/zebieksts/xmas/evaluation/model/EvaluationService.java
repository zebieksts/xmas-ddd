package lt.zebieksts.xmas.evaluation.model;

import lombok.AllArgsConstructor;
import lt.zebieksts.xmas.common.model.ApprovalStatus;
import lt.zebieksts.xmas.common.model.DomainEventPublisher;
import lt.zebieksts.xmas.evaluation.infra.ChildRepository;
import lt.zebieksts.xmas.evaluation.infra.EvaluationRepository;
import lt.zebieksts.xmas.evaluation.infra.LetterRepository;
import lt.zebieksts.xmas.evaluation.model.child.Child;
import lt.zebieksts.xmas.evaluation.model.child.ChildAddress;
import lt.zebieksts.xmas.evaluation.model.child.ChildName;
import lt.zebieksts.xmas.evaluation.model.letter.Letter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@AllArgsConstructor
public class EvaluationService {

  private EvaluationRepository evaluationRepository;
  private LetterRepository letterRepository;
  private ChildRepository childInfoRepository;
  private final DomainEventPublisher eventPublisher;

  @Transactional
  public void evaluate(ChildName name, ChildAddress address, String request) {
    childInfoRepository.find(name, address)
        .ifPresentOrElse(child -> evaluateRequest(child, request), this::notFound);
  }

  private void evaluateRequest(Child child, String request) {
    var letter = new Letter(UUID.randomUUID(), child.id(), request);
    letterRepository.save(letter);
    if (child.behavior().good()) {
      approve(letter);
    } else {
      reject(letter);
    }
  }

  private void approve(Letter letter) {
    evaluationRepository.save(new Evaluation(UUID.randomUUID(), letter.id(), ApprovalStatus.APPROVED));
    eventPublisher.publish(new RequestApproved(letter.id()));
  }

  private void reject(Letter letter) {
    evaluationRepository.save(new Evaluation(UUID.randomUUID(), letter.id(), ApprovalStatus.REJECTED));
    eventPublisher.publish(new RequestRejected(letter.id()));
  }

  private void notFound() {
  }
}

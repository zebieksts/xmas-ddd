package lt.zebieksts.xmas.evaluation;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.UUID;
import lt.zebieksts.xmas.common.events.RequestApproved;
import lt.zebieksts.xmas.common.events.RequestRejected;
import lt.zebieksts.xmas.common.model.ApprovalStatus;
import lt.zebieksts.xmas.common.model.DomainEventPublisher;
import lt.zebieksts.xmas.evaluation.repositories.ChildRepository;
import lt.zebieksts.xmas.evaluation.repositories.LetterRepository;
import lt.zebieksts.xmas.evaluation.services.EvaluationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("Evaluation examples")
@ExtendWith(MockitoExtension.class)
public class EvaluationServiceTest {

  @Mock
  private ChildRepository childRepository;
  @Mock
  private LetterRepository letterRepository;
  @Mock
  private DomainEventPublisher eventPublisher;
  @InjectMocks
  private EvaluationService evaluationService;

  @Test
  void givenChildIsGood_whenEvaluate_thenRequestApproved() {
    UUID letterId = UUID.randomUUID();
    UUID childId = UUID.randomUUID();

    when(childRepository.isGood(childId)).thenReturn(true);
    evaluationService.evaluate(childId, letterId);

    verify(letterRepository).setApprovalStatus(letterId, ApprovalStatus.APPROVED);
    verify(eventPublisher).publish(any(RequestApproved.class));
  }

  @Test
  void givenChildIsNaughty_whenEvaluate_thenRequestRejected() {
    UUID letterId = UUID.randomUUID();
    UUID childId = UUID.randomUUID();

    when(childRepository.isGood(childId)).thenReturn(false);
    evaluationService.evaluate(childId, letterId);

    verify(letterRepository).setApprovalStatus(letterId, ApprovalStatus.REJECTED);
    verify(eventPublisher).publish(any(RequestRejected.class));
  }

}

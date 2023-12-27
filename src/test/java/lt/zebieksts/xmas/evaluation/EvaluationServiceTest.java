package lt.zebieksts.xmas.evaluation;

import lt.zebieksts.xmas.common.model.DomainEventPublisher;
import lt.zebieksts.xmas.evaluation.infra.ChildRepository;
import lt.zebieksts.xmas.evaluation.infra.EvaluationRepository;
import lt.zebieksts.xmas.evaluation.infra.LetterRepository;
import lt.zebieksts.xmas.evaluation.model.EvaluationService;
import lt.zebieksts.xmas.evaluation.model.RequestApproved;
import lt.zebieksts.xmas.evaluation.model.RequestRejected;
import lt.zebieksts.xmas.evaluation.model.child.Behavior;
import lt.zebieksts.xmas.evaluation.model.child.Child;
import lt.zebieksts.xmas.evaluation.model.child.ChildAddress;
import lt.zebieksts.xmas.evaluation.model.child.ChildName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Evaluation examples")
@ExtendWith(MockitoExtension.class)
public class EvaluationServiceTest {

  @Mock
  private ChildRepository childRepository;
  @Mock
  private EvaluationRepository evaluationRepository;
  @Mock
  private LetterRepository letterRepository;
  @Mock
  private DomainEventPublisher eventPublisher;
  @InjectMocks
  private EvaluationService evaluationService;

  @Test
  void givenLetterReceived_whenChildBehaviorGood_thenGiftApproved() {
    ChildName name = new ChildName();
    ChildAddress address = new ChildAddress();
    String request = "I would really like Santa to bring me a sausage";
    var child = Optional.of(new Child(UUID.randomUUID(), address, new Behavior(true)));
    when(childRepository.find(name, address)).thenReturn(child);

    evaluationService.evaluate(name, address, request);

    verify(eventPublisher).publish(any(RequestApproved.class));
  }

  @Test
  void givenLetterReceived_whenChildBehaviorNaughty_thenGiftApproved() {
    ChildName name = new ChildName();
    ChildAddress address = new ChildAddress();
    String request = "You better bring my pony this year or there will be consequences";
    var child = Optional.of(new Child(UUID.randomUUID(), address, new Behavior(false)));
    when(childRepository.find(name, address)).thenReturn(child);

    evaluationService.evaluate(name, address, request);

    verify(eventPublisher).publish(any(RequestRejected.class));
  }

}

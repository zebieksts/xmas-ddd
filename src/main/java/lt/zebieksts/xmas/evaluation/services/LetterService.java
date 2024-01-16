package lt.zebieksts.xmas.evaluation.services;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lt.zebieksts.xmas.common.model.Address;
import lt.zebieksts.xmas.common.model.DomainEventPublisher;
import lt.zebieksts.xmas.common.model.Name;
import lt.zebieksts.xmas.evaluation.repositories.ChildRepository;
import lt.zebieksts.xmas.evaluation.repositories.LetterRepository;
import lt.zebieksts.xmas.evaluation.model.ChildNotFoundException;
import lt.zebieksts.xmas.evaluation.model.events.EvaluationRequested;
import lt.zebieksts.xmas.evaluation.model.child.Child;
import lt.zebieksts.xmas.evaluation.model.letter.Letter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LetterService {

  private LetterRepository letterRepository;
  private ChildRepository childInfoRepository;
  private DomainEventPublisher eventPublisher;

  public void storeLetter(Name name, Address address, String request) {
    Child child = childInfoRepository.find(name, address)
        .orElseThrow(() -> new ChildNotFoundException());
    Letter letter = letterRepository.save(new Letter(UUID.randomUUID(), child.id(), request));
    eventPublisher.publish(new EvaluationRequested(letter.id(), child.id()));
  }

}

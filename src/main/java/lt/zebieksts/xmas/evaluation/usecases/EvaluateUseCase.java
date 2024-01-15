package lt.zebieksts.xmas.evaluation.usecases;

import lombok.AllArgsConstructor;
import lt.zebieksts.xmas.evaluation.model.events.EvaluationRequested;
import lt.zebieksts.xmas.evaluation.services.EvaluationService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EvaluateUseCase {

  private EvaluationService evaluationService;

  @EventListener
  public void handleEvaluationRequested(EvaluationRequested evaluationRequested) {
    evaluationService.evaluate(evaluationRequested.childId(), evaluationRequested.letterId());
  }

}

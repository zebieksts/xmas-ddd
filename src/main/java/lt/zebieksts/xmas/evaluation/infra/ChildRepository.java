package lt.zebieksts.xmas.evaluation.infra;

import lt.zebieksts.xmas.common.model.Address;
import lt.zebieksts.xmas.common.model.Name;
import lt.zebieksts.xmas.evaluation.model.child.Child;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChildRepository {
  Optional<Child> find(Name name, Address address);
}

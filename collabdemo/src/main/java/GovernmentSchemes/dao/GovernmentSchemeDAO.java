package GovernmentSchemes.dao;

import GovernmentSchemes.model.GovernmentScheme;
import java.util.List;

public interface GovernmentSchemeDAO {
    void save(GovernmentScheme scheme);
    List<GovernmentScheme> getAll();
    GovernmentScheme getById(int id);
    void update(GovernmentScheme scheme);
    void delete(int id);
}

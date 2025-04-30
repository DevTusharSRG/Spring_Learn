package com.GovernmentSchemes.GovernmentSchemes.dao;

import java.util.List;
import com.GovernmentSchemes.GovernmentSchemes.model.GovernmentSchemeApplication;

public interface GovernmentSchemeApplicationDAO {
    void save(GovernmentSchemeApplication app);
    List<GovernmentSchemeApplication> getAll();
    GovernmentSchemeApplication getById(int id);
    void update(GovernmentSchemeApplication app);
    void delete(int id);
}

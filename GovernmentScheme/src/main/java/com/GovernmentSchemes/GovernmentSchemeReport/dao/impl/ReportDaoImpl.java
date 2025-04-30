//package dao;
//
//import dto.FarmerSchemeInfoDto;
//import java.sql.Array;
//import java.sql.SQLException;
//import java.util.Arrays;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.NativeQuery;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Repository
//public class ReportDao {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//
//@Transactional
//public List<FarmerSchemeInfoDto> getFarmersWithMultipleSchemes() {
//	String sql = "SELECT users.user_id AS farmerId, users.name AS farmerName, " +
//	        "COUNT(s.scheme_id) AS totalSchemes, STRING_AGG(g.title, ',') AS schemeNames " +
//	        "FROM users users " +
//	        "JOIN government_scheme_application s ON users.user_id = s.farmer_id " +
//	        "JOIN government_schemes g ON s.scheme_id = g.scheme_id " +
//	        "GROUP BY users.user_id, users.name";
//
//
//    NativeQuery<Object[]> query = sessionFactory.getCurrentSession().createNativeQuery(sql);
//    List<Object[]> rows = query.getResultList();
//
//    return rows.stream().map(row -> {
//        FarmerSchemeInfoDto dto = new FarmerSchemeInfoDto();
//        dto.setFarmerId((Integer) row[0]);
//        dto.setFarmerName((String) row[1]);
//        dto.setTotalSchemes(((Number) row[2]).longValue());
//
//        // Split the comma-separated string into list
//        String schemeNamesStr = (String) row[3];
//        dto.setSchemeNames(List.of(schemeNamesStr.split(",")));
//	
//        return dto;
//    }).toList();
//
//}
//}


package com.GovernmentSchemes.GovernmentSchemeReport.dao.impl;

import com.GovernmentSchemes.GovernmentSchemeReport.dao.ReportDao;
import com.GovernmentSchemes.GovernmentSchemeReport.dto.FarmerSchemeInfoDto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ReportDaoImpl implements ReportDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<FarmerSchemeInfoDto> getFarmersWithMultipleSchemes() {

        // Get distinct farmer IDs who applied for schemes
    	String hql = "SELECT s.farmer.id FROM GovernmentSchemeReport s GROUP BY s.farmer.id";
        List<Integer> farmerIds = sessionFactory.getCurrentSession()
                .createQuery(hql, Integer.class)
                .getResultList();

        return farmerIds.stream().map(farmerId -> {
            // Get farmer name
            String nameHql = "SELECT u.name FROM ReportUser  u WHERE u.id = :farmerId";
            String farmerName = sessionFactory.getCurrentSession()
                    .createQuery(nameHql, String.class)
                    .setParameter("farmerId", farmerId)
                    .uniqueResult();

            // Get scheme titles applied by farmer
            String schemeHql = "SELECT s.scheme.title FROM GovernmentSchemeReport s WHERE s.farmer.id = :farmerId";
            List<String> schemeTitles = sessionFactory.getCurrentSession()
                    .createQuery(schemeHql, String.class)
                    .setParameter("farmerId", farmerId)
                    .getResultList();

            FarmerSchemeInfoDto dto = new FarmerSchemeInfoDto();
            dto.setFarmerId(farmerId);
            dto.setFarmerName(farmerName);
            dto.setSchemeNames(schemeTitles);
            dto.setTotalSchemes(schemeTitles.size());

            return dto;
        }).collect(Collectors.toList());
    }
}



//
//package dao;
//
//import dto.FarmerSchemeInfoDto;
//import model.GovernmentSchemeApplication;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import javax.transaction.Transactional;
//import java.util.*;
//
//@Repository
//public class ReportDao {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @Transactional
//    public List<FarmerSchemeInfoDto> getFarmersWithMultipleSchemes() {
//        // HQL query that joins mapped entities
//    	String hql = "select s.farmer.id, s.farmer.name, s.scheme.title " +
//                "from GovernmentSchemeApplication s";
//
//
//        Query<Object[]> query = sessionFactory.getCurrentSession().createQuery(hql, Object[].class);
//        List<Object[]> results = query.getResultList();
//
//        // Grouping results by farmer ID and aggregating scheme titles
//        Map<Integer, FarmerSchemeInfoDto> dtoMap = new LinkedHashMap<>();
//
//        for (Object[] row : results) {
//            Integer farmerId = (Integer) row[0];
//            String farmerName = (String) row[1];
//            String schemeTitle = (String) row[2];
//
//            FarmerSchemeInfoDto dto = dtoMap.getOrDefault(farmerId, new FarmerSchemeInfoDto());
//            dto.setFarmerId(farmerId);
//            dto.setFarmerName(farmerName);
//
//            List<String> schemeNames = dto.getSchemeNames();
//            if (schemeNames == null) {
//                schemeNames = new ArrayList<>();
//                dto.setSchemeNames(schemeNames);
//            }
//
//            schemeNames.add(schemeTitle);
//            dtoMap.put(farmerId, dto);
//        }
//
//        // Set total schemes count for each DTO
//        dtoMap.values().forEach(dto -> dto.setTotalSchemes((long) dto.getSchemeNames().size()));
//
//        return new ArrayList<>(dtoMap.values());
//    }
//}

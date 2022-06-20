package com.example.demo.service.impl;

import com.example.demo.enums.ApplicationStatus;
import com.example.demo.service.UtilsService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UtilsServiceImpl implements UtilsService {

    @Override
    public ApplicationStatus applicationStatus() {
        try {
            if(isDatabaseOperational()){
                return ApplicationStatus.UP;
            }
        } catch (SQLException e) {
            return ApplicationStatus.DOWN;
        }
        return ApplicationStatus.DOWN;
    }
    private boolean isDatabaseOperational() throws SQLException {
        //simulate
        //throw new SQLException("Database not connected");
        return true;
    }

}

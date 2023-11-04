package com.yh.service.impl;

import com.yh.mapper.TravellerMapper;
import com.yh.pojo.Traveller;
import com.yh.service.TravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Yanjw
 * @Date: 2023/11/4 - 11 - 04 - 10:04
 * @Description: com.yh.service.impl
 * @version: 1.0
 */
@Service
public class TravellerServiceImpl implements TravellerService {
    @Autowired
    TravellerMapper travellerMapper;
    @Override
    public List<Traveller> findAll() {
        return travellerMapper.findAll();
    }
}

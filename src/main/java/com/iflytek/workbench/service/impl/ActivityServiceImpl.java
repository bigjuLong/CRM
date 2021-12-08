package com.iflytek.workbench.service.impl;

import com.iflytek.workbench.dao.ActivityDao;
import com.iflytek.workbench.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author congchen6
 * @date 2021-12-08 17:18
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    ActivityDao activityDao;
}

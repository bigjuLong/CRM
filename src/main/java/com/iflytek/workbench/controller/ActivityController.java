package com.iflytek.workbench.controller;

import com.iflytek.workbench.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author congchen6
 * @date 2021-12-08 17:22
 */
@Controller
public class ActivityController {
    @Autowired
    ActivityService activityService;
}

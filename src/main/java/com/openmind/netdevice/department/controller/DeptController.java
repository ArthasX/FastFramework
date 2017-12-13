package com.openmind.netdevice.department.controller;

import com.openmind.netdevice.department.model.Department;
import com.openmind.netdevice.department.service.IDeptService;
import com.openmind.netdevice.framework.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiuBin
 * @version Created on 2017/9/5
 */

@RequestMapping(value = "/depts")
@RestController
public class DeptController extends BaseController<IDeptService,Department> {
}

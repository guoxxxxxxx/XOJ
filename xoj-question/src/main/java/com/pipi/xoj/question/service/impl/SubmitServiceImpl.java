package com.pipi.xoj.question.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pipi.xoj.question.dao.SubmitDao;
import com.pipi.xoj.question.entity.Submit;
import com.pipi.xoj.question.service.SubmitService;
import org.springframework.stereotype.Service;

/**
 * (Submit)表服务实现类
 *
 * @author guox
 * @since 2024-04-11 22:12:53
 */
@Service("submitService")
public class SubmitServiceImpl extends ServiceImpl<SubmitDao, Submit> implements SubmitService {

}


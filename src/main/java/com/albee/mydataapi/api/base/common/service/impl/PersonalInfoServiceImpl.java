package com.albee.mydataapi.api.base.common.service.impl;

import com.albee.mydataapi.api.base.common.service.PersonalInfoService;
import com.albee.mydataapi.api.common.trans.models.entity.TransReqEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class PersonalInfoServiceImpl implements PersonalInfoService {

    @Override
    public void deleteTable(TransReqEntity dom) {

    }
}

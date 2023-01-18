package com.kpcnc.mydataapi.api.collect.pull.service;


import com.kpcnc.mydataapi.api.collect.pull.models.form.PullForm;

import java.util.List;

public interface PullService {
    public List<String> execPullPersonalInfoRun(PullForm form);

}

package com.albee.mydataapi.api.collect.pull.service;


import com.albee.mydataapi.api.collect.pull.models.form.PullForm;

import java.util.List;

public interface PullService {
    public List<String> execPullPersonalInfoRun(PullForm form);

}

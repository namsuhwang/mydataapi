package com.albee.mydataapi.api.base.common.repository;

import com.albee.mydataapi.api.base.common.models.dto.DeleteKeyDto;
import org.springframework.stereotype.Component;

@Component
public interface DeleteGurtMapper {

    int deleteGurtBase(DeleteKeyDto dom);

    int deleteGurtHist(DeleteKeyDto dom);

    int deleteGurtInsd(DeleteKeyDto dom);

    int deleteGurt(DeleteKeyDto dom);

}

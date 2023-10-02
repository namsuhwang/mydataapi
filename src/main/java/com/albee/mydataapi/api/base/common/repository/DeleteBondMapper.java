package com.albee.mydataapi.api.base.common.repository;

import com.albee.mydataapi.api.base.common.models.dto.DeleteKeyDto;
import org.springframework.stereotype.Component;

@Component
public interface DeleteBondMapper {

    int deleteBondBal(DeleteKeyDto dom);

    int deleteBondHist(DeleteKeyDto dom);

    int deleteBond(DeleteKeyDto dom);

}

package com.albee.mydataapi.api.base.common.repository;

import com.albee.mydataapi.api.base.common.models.dto.DeleteKeyDto;
import org.springframework.stereotype.Component;

@Component
public interface DeleteInvtMapper {

    int deleteInvtAccProdBaseDate(DeleteKeyDto dom);

    int deleteInvtAccProd(DeleteKeyDto dom);

    int deleteInvtAccHist(DeleteKeyDto dom);

    int deleteInvtAcc(DeleteKeyDto dom);

    int deleteInvtAccBase(DeleteKeyDto dom);

    int deleteInvtAutoTrans(DeleteKeyDto dom);

    int deleteInvtPensionAccAdd(DeleteKeyDto dom);

}

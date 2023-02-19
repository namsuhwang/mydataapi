package com.albee.mydataapi.api.base.common.service.impl;

import com.albee.mydataapi.api.base.common.models.dto.DeleteKeyDto;
import com.albee.mydataapi.api.base.common.repository.*;
import com.albee.mydataapi.api.base.common.service.PersonalInfoService;
import com.albee.mydataapi.api.common.trans.models.dto.TransAsset;
import com.albee.mydataapi.api.common.trans.models.dto.TransRequestConsent;
import com.albee.mydataapi.api.common.trans.models.dto.TransTargetInfo;
import com.albee.mydataapi.api.common.trans.models.entity.TransReqEntity;
import com.albee.mydataapi.common.CommUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class PersonalInfoServiceImpl implements PersonalInfoService {

    @Autowired
    DeleteBankMapper deleteBankMapper;

    @Autowired
    DeleteCardMapper deleteCardMapper;

    @Autowired
    DeleteDbMapper deleteDbMapper;

    @Autowired
    DeleteDcMapper deleteDcMapper;

    @Autowired
    DeleteIrpMapper deleteIrpMapper;

    @Autowired
    DeletePpayMapper deletePpayMapper;

    @Override
    public void deleteTable(TransReqEntity dom) {
        DeleteKeyDto delKey = new DeleteKeyDto(dom.getMemberId(), dom.getOrgCd());

        TransRequestConsent consent = dom.getTransRequestConsent();
        for(TransTargetInfo targetInfo : consent.getTargetInfo()){
            String scope = targetInfo.getScope();
            for(TransAsset transAsset : targetInfo.getAssetList()){
                if(!transAsset.getAsset().toLowerCase().equals("all_asset")){
                    if(!CommUtil.isNullEmpty(transAsset.getAsset())){
                        delKey.setAsset(transAsset.getAsset());
                    }else{
                        delKey.setAsset(null);
                    }

                    if(!CommUtil.isNullEmpty(transAsset.getSeqno())){
                        delKey.setSeqno(transAsset.getSeqno());
                    }else{
                        delKey.setSeqno(null);
                    }
                }else{
                    // all_asset 이면 전제 자산정보(계좌 등) 삭제
                    delKey.setAsset(null);
                    delKey.setSeqno(null);
                }

                switch (CommUtil.getIdstTypeByScope(scope))
                {
                    case "BANK": deleteBank(delKey, scope, transAsset); break;
                    case "CARD": deleteCard(delKey, scope, transAsset); break;
                }
            }
        }
    }

    private void deleteBank(DeleteKeyDto delKey, String scope, TransAsset transAsset){
        switch (scope.toLowerCase())
        {
            case "bank.list":
                deleteBankMapper.deleteBankCust(delKey);
                deleteBankMapper.deleteBankAcc(delKey);
                deleteDcMapper.deleteDc(delKey);
                deleteIrpMapper.deleteIrpAcc(delKey);
                deletePpayMapper.deletePpay(delKey);
                break;
            case "bank.deposit":
                deleteBankMapper.deleteBankAccDepositHist(delKey);
                deleteBankMapper.deleteBankAccDepositAdd(delKey);
                deleteBankMapper.deleteBankAccDeposit(delKey);
                deleteBankMapper.deleteBankAutoTrans(delKey);
                break;
            case "bank.invest":
                deleteBankMapper.deleteBankAccFundAdd(delKey);
                deleteBankMapper.deleteBankAccFundHist(delKey);
                deleteBankMapper.deleteBankAccFund(delKey);
                break;
            case "bank.loan":
                deleteBankMapper.deleteBankAccLoanAdd(delKey);
                deleteBankMapper.deleteBankAccLoanHistInt(delKey);
                deleteBankMapper.deleteBankAccLoanHist(delKey);
                deleteBankMapper.deleteBankAccLoan(delKey);
                break;
            case "bank.isa":
                deleteBankMapper.deleteBankAccProdHist(delKey);
                deleteBankMapper.deleteBankAccEachProd(delKey);
                deleteBankMapper.deleteBankAccProd(delKey);
                break;
            case "bank.irp":
                deleteIrpMapper.deleteIrpAccAdd(delKey);
                deleteIrpMapper.deleteIrpAccHist(delKey);
                deleteIrpMapper.deleteIrpAccBase(delKey);
                break;
            case "bank.prepaid":
                deletePpayMapper.deletePpayAprHist(delKey);
                deletePpayMapper.deletePpayHist(delKey);
                deletePpayMapper.deletePpayBal(delKey);
                break;
            case "bank.db":
                deleteDbMapper.deleteDb(delKey);
                break;
            case "bank.dc":
                deleteDcMapper.deleteDcAdd(delKey);
                deleteDcMapper.deleteDcHist(delKey);
                deleteDcMapper.deleteDcBase(delKey);
                break;
        }
    }


    private void deleteCard(DeleteKeyDto delKey, String scope, TransAsset transAsset){
        switch (scope.toLowerCase())
        {
            case "card.list":
                deleteCardMapper.deleteCard(delKey);
                deletePpayMapper.deletePpay(delKey);
                break;
            case "card.card":
                deleteCardMapper.deleteCardAprDmHist(delKey);
                deleteCardMapper.deleteCardAprOsHist(delKey);
                deleteCardMapper.deleteCardDmPca(delKey);
                deleteCardMapper.deleteCardOsPca(delKey);
                deleteCardMapper.deleteCardBase(delKey);
                break;
            case "card.prepaid":
                deletePpayMapper.deletePpayAprHist(delKey);
                deletePpayMapper.deletePpayHist(delKey);
                deletePpayMapper.deletePpayBal(delKey);
                break;
            case "card.point":
                deleteCardMapper.deleteCardPt(delKey);
                break;
            case "card.bill":
                deleteCardMapper.deleteCardChargeAdd(delKey);
                deleteCardMapper.deleteCardCharge(delKey);
                deleteCardMapper.deleteCardPayDetail(delKey);
                deleteCardMapper.deleteCardPay(delKey);
                break;
            case "card.loan":
                deleteCardMapper.deleteCardLoanLgHist(delKey);
                deleteCardMapper.deleteCardLoanLg(delKey);
                deleteCardMapper.deleteCardLoanSt(delKey);
                deleteCardMapper.deleteCardLoan(delKey);
                break;
        }
    }

    // 금융투자
    private void deleteInvt(DeleteKeyDto delKey, String scope, TransAsset transAsset){
        switch (scope.toLowerCase())
        {
            case "invt.list":
                deleteCardMapper.deleteCard(delKey);
                deletePpayMapper.deletePpay(delKey);
                break;
            case "invt.card":
                deleteCardMapper.deleteCardAprDmHist(delKey);
                deleteCardMapper.deleteCardAprOsHist(delKey);
                deleteCardMapper.deleteCardDmPca(delKey);
                deleteCardMapper.deleteCardOsPca(delKey);
                deleteCardMapper.deleteCardBase(delKey);
                break;
            case "invt.prepaid":
                deletePpayMapper.deletePpayAprHist(delKey);
                deletePpayMapper.deletePpayHist(delKey);
                deletePpayMapper.deletePpayBal(delKey);
                break;
            case "invt.point":
                deleteCardMapper.deleteCardPt(delKey);
                break;
            case "card.bill":
                deleteCardMapper.deleteCardChargeAdd(delKey);
                deleteCardMapper.deleteCardCharge(delKey);
                deleteCardMapper.deleteCardPayDetail(delKey);
                deleteCardMapper.deleteCardPay(delKey);
                break;
            case "card.loan":
                deleteCardMapper.deleteCardLoanLgHist(delKey);
                deleteCardMapper.deleteCardLoanLg(delKey);
                deleteCardMapper.deleteCardLoanSt(delKey);
                deleteCardMapper.deleteCardLoan(delKey);
                break;
        }
    }
}

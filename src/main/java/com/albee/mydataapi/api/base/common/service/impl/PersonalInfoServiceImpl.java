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

    @Autowired
    DeleteInvtMapper deleteInvtMapper;

    @Autowired
    DeleteInsuMapper deleteInsuMapper;

    @Autowired
    DeleteElecMapper deleteElecMapper;

    @Autowired
    DeleteItfnMapper deleteItfnMapper;

    @Autowired
    DeleteGurtMapper deleteGurtMapper;

    @Autowired
    DeleteTeleMapper deleteTeleMapper;

    @Autowired
    DeleteP2pMapper deleteP2pMapper;

    @Autowired
    DeleteBondMapper deleteBondMapper;

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
                    case "INVT": deleteInvt(delKey, scope, transAsset); break;
                    case "INSU": deleteInsu(delKey, scope, transAsset); break;
                    case "ELEC": deleteElec(delKey, scope, transAsset); break;
                    case "ITFN": deleteItfn(delKey, scope, transAsset); break;
                    case "GURT": deleteGurt(delKey, scope, transAsset); break;
                    case "TELE": deleteTele(delKey, scope, transAsset); break;
                    case "BOND": deleteBond(delKey, scope, transAsset); break;
                    case "P2P": deleteTele(delKey, scope, transAsset); break;
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
            case "invest.list":
                deleteCardMapper.deleteCard(delKey);
                deleteIrpMapper.deleteIrpAcc(delKey);
                deleteDbMapper.deleteDb(delKey);
                break;
            case "invest.account":
                deleteInvtMapper.deleteInvtPensionAccAdd(delKey);
                deleteInvtMapper.deleteInvtAutoTrans(delKey);
                deleteInvtMapper.deleteInvtAccProd(delKey);
                deleteInvtMapper.deleteInvtAccProdBaseDate(delKey);
                deleteInvtMapper.deleteInvtAccBase(delKey);
                break;
            case "invest.db":
                deleteDbMapper.deleteDb(delKey);
                break;
            case "invest.dc":
                deleteDcMapper.deleteDcAdd(delKey);
                deleteDcMapper.deleteDcHist(delKey);
                deleteDcMapper.deleteDcBase(delKey);
                break;
        }
    }

    // 보험
    private void deleteInsu(DeleteKeyDto delKey, String scope, TransAsset transAsset){
        switch (scope.toLowerCase())
        {
            case "insu.list":
                deleteInsuMapper.deleteInsu(delKey);
                deleteInsuMapper.deleteInsuLoan(delKey);
                deleteInsuMapper.deleteInsuInsd(delKey);
                deleteIrpMapper.deleteIrpAcc(delKey);
                deleteDbMapper.deleteDb(delKey);
                break;
            case "insu.insurance":
                deleteInsuMapper.deleteInsuBase(delKey);
                deleteInsuMapper.deleteInsuBaseInsd(delKey);
                deleteInsuMapper.deleteInsuSccont(delKey);
                deleteInsuMapper.deleteInsuCar(delKey);
                deleteInsuMapper.deleteInsuPay(delKey);
                deleteInsuMapper.deleteInsuHist(delKey);
                deleteInsuMapper.deleteInsuCarHist(delKey);
                deleteInsuMapper.deleteInsuGurt(delKey);
                deleteInsuMapper.deleteInsuMiBase(delKey);
                deleteInsuMapper.deleteInsuMiBasePp(delKey);
                deleteInsuMapper.deleteInsuMiPay(delKey);
                deleteInsuMapper.deleteInsuMiHist(delKey);
                deleteInsuMapper.deleteInsuMi(delKey);
                break;
            case "insu.insured":
                deleteInsuMapper.deleteInsuInsdSccont(delKey);
                deleteInsuMapper.deleteInsuInsdBase(delKey);
                deleteInsuMapper.deleteInsuInsdCar(delKey);
                deleteInsuMapper.deleteInsuInsdGurt(delKey);
                deleteInsuMapper.deleteInsuInsdMiBasePp(delKey);
                deleteInsuMapper.deleteInsuInsdMiBase(delKey);
                deleteInsuMapper.deleteInsuInsdMiSccont(delKey);
                deleteInsuMapper.deleteInsuInsdMi(delKey);
                break;
            case "insu.loan":
                deleteInsuMapper.deleteInsuLoanAdd(delKey);
                deleteInsuMapper.deleteInsuLoanBase(delKey);
                deleteInsuMapper.deleteInsuLoanHist(delKey);
                break;
            case "insu.irp":
                deleteIrpMapper.deleteIrpAccAdd(delKey);
                deleteIrpMapper.deleteIrpAccHist(delKey);
                deleteIrpMapper.deleteIrpAccBase(delKey);
                break;
            case "insu.db":
                deleteDbMapper.deleteDb(delKey);
                break;
            case "insu.dc":
                deleteDcMapper.deleteDcAdd(delKey);
                deleteDcMapper.deleteDcHist(delKey);
                deleteDcMapper.deleteDcBase(delKey);
                break;
        }
    }



    // 전자금융
    private void deleteElec(DeleteKeyDto delKey, String scope, TransAsset transAsset){
        switch (scope.toLowerCase())
        {
            case "efin.list":
                deleteElecMapper.deleteElecPpayAcc(delKey);
                deleteElecMapper.deleteElecPpay(delKey);
                deleteElecMapper.deleteElecAcc(delKey);
                break;
            case "efin.prepaid":
                deleteElecMapper.deleteElecPpayBal(delKey);
                deleteElecMapper.deleteElecPpayAutoCharge(delKey);
                deleteElecMapper.deleteElecPpayHist(delKey);
                break;
            case "efin.paid":
                deleteElecMapper.deleteElecPayHist(delKey);
                deleteElecMapper.deleteElecPayMethod(delKey);
                break;
        }
    }

    // 할부금융
    private void deleteItfn(DeleteKeyDto delKey, String scope, TransAsset transAsset){
        switch (scope.toLowerCase())
        {
            case "capital.list":
                deleteItfnMapper.deleteItfnCust(delKey);
                deleteItfnMapper.deleteItfnAcc(delKey);
                break;
            case "capital.loan":
                deleteItfnMapper.deleteItfnLoanHistInt(delKey);
                deleteItfnMapper.deleteItfnLoanHist(delKey);
                deleteItfnMapper.deleteItfnLoanAdd(delKey);
                deleteItfnMapper.deleteItfnLeaseHist(delKey);
                deleteItfnMapper.deleteItfnLease(delKey);
                break;
        }
    }


    // 보증보험
    private void deleteGurt(DeleteKeyDto delKey, String scope, TransAsset transAsset){
        switch (scope.toLowerCase())
        {
            case "ginsu.list":
                deleteGurtMapper.deleteGurt(delKey);
                break;
            case "ginsu.insurance":
                deleteGurtMapper.deleteGurtHist(delKey);
                deleteGurtMapper.deleteGurtInsd(delKey);
                deleteGurtMapper.deleteGurtBase(delKey);
                break;
        }
    }

    // 통신
    private void deleteTele(DeleteKeyDto delKey, String scope, TransAsset transAsset){
        switch (scope.toLowerCase())
        {
            case "telecoms.list":
                deleteTeleMapper.deleteTeleCont(delKey);
                break;
            case "telecoms.mgmt":
                deleteTeleMapper.deleteTeleHist(delKey);
                deleteTeleMapper.deleteTeleCharge(delKey);
                deleteTeleMapper.deleteTelePay(delKey);
                break;
        }
    }

    // p2p
    private void deleteP2p(DeleteKeyDto delKey, String scope, TransAsset transAsset){
        switch (scope.toLowerCase())
        {
            case "p2p.list":
                deleteP2pMapper.deleteP2pLoan(delKey);
                break;
            case "p2p.lending":
                deleteP2pMapper.deleteP2pLoanHist(delKey);
                deleteP2pMapper.deleteP2pLoanBase(delKey);
                deleteP2pMapper.deleteP2pLoanAdd(delKey);
                break;
        }
    }

    // 채권
    private void deleteBond(DeleteKeyDto delKey, String scope, TransAsset transAsset){
        switch (scope.toLowerCase())
        {
            case "bond.list":
                deleteBondMapper.deleteBond(delKey);
                break;
            case "bond.bond":
                deleteBondMapper.deleteBondBal(delKey);
                deleteBondMapper.deleteBondHist(delKey);
                break;
        }
    }
}

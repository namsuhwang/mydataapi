package com.kpcnc.mydataapi.common.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class SearchDto {
    private Integer requestPage;  // 1부터 시작

    private Integer requestCnt;

    private String startDt;

    private String endDt;

    private Integer startIndex;

    private Integer endIndex;

    public Integer getRequestPage() {
        return requestPage;
    }

    public void setRequestPage(Integer requestPage) {
        Integer si = null;
        if(requestPage != null && requestPage > 0 && requestCnt != null && requestCnt > 0){
            si = (requestPage - 1) * requestCnt + 1;
        }
        this.startIndex = si;

        Integer ei = null;
        if(requestPage != null && requestPage > 0 && requestCnt != null && requestCnt > 0){
            ei = (requestPage - 1) * requestCnt + requestCnt;
        }
        this.endIndex = ei;
        this.requestPage = requestPage;
    }

    public Integer getRequestCnt() {
        return requestCnt;
    }

    public void setRequestCnt(Integer requestCnt) {
        Integer si = null;
        if(requestPage != null && requestPage > 0 && requestCnt != null && requestCnt > 0){
            si = (requestPage - 1) * requestCnt + 1;
        }
        this.startIndex = si;

        Integer ei = null;
        if(requestPage != null && requestPage > 0 && requestCnt != null && requestCnt > 0){
            ei = (requestPage - 1) * requestCnt + requestCnt;
        }
        this.endIndex = ei;
        this.requestCnt = requestCnt;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public void setEndIndex(Integer endIndex) {
        this.endIndex = endIndex;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public Integer getEndIndex() {
        return endIndex;
    }
//    public Integer getStartIndex(){
//        Integer si = null;
//        if(requestPage != null && requestPage > 0 && requestCnt != null && requestCnt > 0){
//            si = (requestPage - 1) * requestCnt;
//        }
//
//        return si;
//    }
//
//    public Integer getEndIndex(){
//        Integer ei = null;
//        if(requestPage != null && requestPage > 0 && requestCnt != null && requestCnt > 0){
//            ei = (requestPage - 1) * requestCnt + requestCnt - 1;
//        }
//
//        return ei;
//    }

    public String getStartDt() {
        return startDt;
    }

    public void setStartDt(String startDt) {
        this.startDt = startDt;
    }

    public String getEndDt() {
        return endDt;
    }

    public void setEndDt(String endDt) {
        this.endDt = endDt;
    }
}

package com.vaia.crm.controller.vo;

import com.vaia.entity.AllianceMembers;

/**
 * Created by ubuntu on 18-4-17.
 */
public class GetAllianceMembersVO extends BaseVO {

    private Integer memberId;

    private String memberName;

    private String imgUrl;

    private String companyLinks;

    public GetAllianceMembersVO() {
    }

    public GetAllianceMembersVO(Integer memberId, String memberName, String imgUrl, String companyLinks) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.imgUrl = imgUrl;
        this.companyLinks = companyLinks;
    }

    public GetAllianceMembersVO(AllianceMembers allianceMembers) {
        this.memberId = allianceMembers.getMemberId();
        this.memberName = allianceMembers.getMemberName();
        this.imgUrl = allianceMembers.getImgUrl();
        this.companyLinks = allianceMembers.getCompanyLinks();
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCompanyLinks() {
        return companyLinks;
    }

    public void setCompanyLinks(String companyLinks) {
        this.companyLinks = companyLinks;
    }
}

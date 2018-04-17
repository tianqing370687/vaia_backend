package com.vaia.entity;

public class AllianceMembers {
    private Integer memberId;

    private String memberName;

    private String imgUrl;

    private String companyLinks;

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
        this.memberName = memberName == null ? null : memberName.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getCompanyLinks() {
        return companyLinks;
    }

    public void setCompanyLinks(String companyLinks) {
        this.companyLinks = companyLinks == null ? null : companyLinks.trim();
    }
}
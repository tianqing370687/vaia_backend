package com.vaia.crm.controller.form;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ubuntu on 18-4-17.
 */
public class SaveAllianceMembersForm {

    private String memberName;
    private MultipartFile img;
    private String companyLinks;

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }

    public String getCompanyLinks() {
        return companyLinks;
    }

    public void setCompanyLinks(String companyLinks) {
        this.companyLinks = companyLinks;
    }

    @Override
    public String toString() {
        return "SaveAllianceMembersForm{" +
                "memberName='" + memberName + '\'' +
                ", img=" + img +
                ", companyLinks='" + companyLinks + '\'' +
                '}';
    }

    public boolean isEmpty(){
        if(StringUtils.isBlank(this.memberName)){
            return true;
        }
        if(StringUtils.isBlank(this.companyLinks)){
            return true;
        }
        return false;
    }
}

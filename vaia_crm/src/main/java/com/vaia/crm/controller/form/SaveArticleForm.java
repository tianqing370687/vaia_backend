package com.vaia.crm.controller.form;

import org.apache.commons.lang.StringUtils;

/**
 * Created by nicholas.chi on 2018/4/17.
 */
public class SaveArticleForm {
    private int acId;
    private String articleText;

    public int getAcId() {
        return acId;
    }

    public void setAcId(int acId) {
        this.acId = acId;
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    @Override
    public String toString() {
        return "SaveArticleForm{" +
                "acId=" + acId +
                ", articleText='" + articleText + '\'' +
                '}';
    }

    public boolean isEmpty(){
        if(this.acId <= 0){
            return true;
        }
        if(StringUtils.isBlank(this.articleText)){
            return true;
        }
        return false;
    }
}

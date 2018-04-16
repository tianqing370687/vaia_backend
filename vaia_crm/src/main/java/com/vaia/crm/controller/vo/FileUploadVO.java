package com.vaia.crm.controller.vo;

import java.util.Arrays;

/**
 * Created by ubuntu on 18-4-14.
 */
public class FileUploadVO {

    private int errno;
    private String[] data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "FileUploadVO{" +
                "errno='" + errno + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}

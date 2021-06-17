package com.example.demo.exceptions;

import com.example.demo.exceptions.DemoResponseConst.ReturnCode;

public class DemoException extends RuntimeException  {

    public static DemoException createByCode(ReturnCode customCode) {
        return new DemoException(customCode);
    }

	public static DemoException createByCodeAndExtInfo(
            ReturnCode customCode, String extInfo) {
        return new DemoException(customCode, extInfo);
    }

    private String returnCode;

    private String extInfo;

    private DemoException(ReturnCode customCode) {
        super(customCode.toString());
        this.returnCode = customCode.name();
    }

    private DemoException(ReturnCode customCode, String extInfo) {
        super(extInfo);
        this.returnCode = customCode.name();
        this.extInfo = extInfo;
    }

    private DemoException(String returnCode) {
        super(returnCode);
        this.returnCode = returnCode;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }
}

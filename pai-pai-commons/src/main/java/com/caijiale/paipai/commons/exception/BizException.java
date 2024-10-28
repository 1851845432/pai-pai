package com.caijiale.paipai.commons.exception;

import com.caijiale.paipai.base.exception.BaseException;
import com.caijiale.paipai.commons.enums.BizErrorCodeEnum;
import lombok.Getter;

/**
 * 业务异常
 *
 * @author MAKABAKA
 */
@Getter
public class BizException extends BaseException {

    /**
     * 错误码
     */
    protected final BizErrorCodeEnum errorCode;


    /**
     * 无参默认构造UNSPECIFIED
     */
    public BizException() {
        super(BizErrorCodeEnum.UNKNOWN.getMessage());
        this.errorCode = BizErrorCodeEnum.UNKNOWN;
    }

    /**
     * 有参构造
     *
     * @param errorCode 错误码
     */
    public BizException(BizErrorCodeEnum errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    /**
     * 有参构造
     *
     * @param errorCode 错误码
     * @param message   错误信息
     */
    public BizException(BizErrorCodeEnum errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }


}
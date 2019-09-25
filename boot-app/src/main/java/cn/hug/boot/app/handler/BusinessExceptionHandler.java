package cn.hug.boot.app.handler;

import cn.hug.boot.api.enums.ErrCodeEnum;
import cn.hug.boot.api.enums.ResultEnum;
import cn.hug.boot.api.exception.BusinessException;
import cn.hug.boot.api.model.dto.result.ResultBase;
import cn.hutool.core.collection.CollectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 统一异常捕获
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-09-23 22:15
 */
@Slf4j
@ControllerAdvice
public class BusinessExceptionHandler {
    /**
     * 自定义业务异常
     * @param ex
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResultBase handlerResultException(BusinessException ex) {
        return new ResultBase(ex.getStatus(), ex.getMessage());
    }

    /**
     * 系统异常/运行时异常
     * @param ex
     * @return
     */
    @ExceptionHandler({Exception.class, RuntimeException.class})
    @ResponseBody
    public ResultBase handlerException(Exception ex) {
        ex.printStackTrace();
        log.error(ex.getMessage());
        return new ResultBase(ResultEnum.SYSTEM_ERROR.getStatus(),
                ex.getMessage() == null ? ResultEnum.SYSTEM_ERROR.getMessage() : ex.getMessage());
    }

    /**
     * 请求方式或Json格式异常
     * @param ex
     * @return
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    public ResultBase handlerMessageNotReadableException(HttpMessageNotReadableException ex) {
        log.error(ex.getMessage());
        return new ResultBase(ResultEnum.BUSINESS.getStatus(), ex.getMessage());
    }

    /**
     * 参数校验抛出异常
     * @param ex
     * @return
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public ResultBase handelValidateException(MethodArgumentNotValidException ex) {
        log.warn("raised MethodArgumentNotValidException : " + ex);
        BindingResult result = ex.getBindingResult();
        final List<FieldError> fieldErrors = result.getFieldErrors();
        List errList = new ArrayList();

        for (FieldError error : fieldErrors) {
            errList.add(error.getDefaultMessage());
        }

        return new ResultBase(ErrCodeEnum.PARAM_ERR.getCode(), CollectionUtil.join(errList, ","));
    }
}

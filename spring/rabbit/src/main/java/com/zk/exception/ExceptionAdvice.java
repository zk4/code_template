package com.zk.exception;

import com.zk.result.CodeMsg;
import com.zk.result.Result;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestControllerAdvice
public class ExceptionAdvice {
	@ExceptionHandler(UserNotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Result<String> handleNonExistingUser() {
		System.out.println("user not found");
		return Result.error(CodeMsg.USER_NOT_EXIST);
	}


	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ResponseBody
	public Result<String> requestHandlingNoHandlerFound(final NoHandlerFoundException ex) {
		return Result.error(CodeMsg.REQUEST_ILLEGAL);
	}

	@ExceptionHandler(value=Exception.class)
	public Result<String> exceptionHandler(HttpServletRequest request, Exception e){
		e.printStackTrace();
		if(e instanceof GlobalException) {
			GlobalException ex = (GlobalException)e;
			return Result.error(ex.getCm());
		}else if(e instanceof BindException) {
			BindException ex = (BindException)e;
			List<ObjectError> errors = ex.getAllErrors();
			ObjectError error = errors.get(0);
			String msg = error.getDefaultMessage();
			return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
		}else {
			return Result.error(CodeMsg.SERVER_ERROR);
		}
	}
}

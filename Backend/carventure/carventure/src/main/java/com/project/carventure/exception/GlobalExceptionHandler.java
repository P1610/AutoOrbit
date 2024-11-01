package com.project.carventure.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.carventure.admin.AdminException;
import com.project.carventure.application.ApplicationException;
import com.project.carventure.car.CarException;
import com.project.carventure.inventory.InventoryException;
import com.project.carventure.testdrive.TestDriveException;
import com.project.carventure.transaction.TransactionException;
import com.project.carventure.user.UserException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(UserException.class)
	public ResponseEntity<String> handleUserException(UserException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}

	@ExceptionHandler(AdminException.class)
	public ResponseEntity<String> handleAdminException(AdminException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}

	@ExceptionHandler(InventoryException.class)
	public ResponseEntity<String> handleInventoryException(InventoryException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}

	@ExceptionHandler(TransactionException.class)
	public ResponseEntity<String> handleTransactionException(TransactionException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}

	@ExceptionHandler(CarException.class)
	public ResponseEntity<String> handleCarException(CarException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}

	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<String> handleApplicationException(ApplicationException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}

	@ExceptionHandler(TestDriveException.class)
	public ResponseEntity<String> handleTestDriveException(TestDriveException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
}

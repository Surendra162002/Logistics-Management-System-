package com.example.logistics.exception;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime; import java.util.*;
@RestControllerAdvice
public class GlobalExceptionHandler {
 @ExceptionHandler(ResourceNotFoundException.class)
 public ResponseEntity<Map<String,Object>> notFound(ResourceNotFoundException ex){return build(HttpStatus.NOT_FOUND,ex.getMessage());}
 @ExceptionHandler(IllegalArgumentException.class)
 public ResponseEntity<Map<String,Object>> badRequest(IllegalArgumentException ex){return build(HttpStatus.BAD_REQUEST,ex.getMessage());}
 @ExceptionHandler(DataIntegrityViolationException.class)
 public ResponseEntity<Map<String,Object>> conflict(DataIntegrityViolationException ex){return build(HttpStatus.BAD_REQUEST,"Duplicate or related data constraint error");}
 @ExceptionHandler(MethodArgumentNotValidException.class)
 public ResponseEntity<Map<String,Object>> validation(MethodArgumentNotValidException ex){
   Map<String,String> errors=new LinkedHashMap<>(); ex.getBindingResult().getFieldErrors().forEach(e->errors.put(e.getField(),e.getDefaultMessage()));
   Map<String,Object> body=new LinkedHashMap<>(); body.put("timestamp",LocalDateTime.now()); body.put("status",400); body.put("message","Validation failed"); body.put("errors",errors);
   return ResponseEntity.badRequest().body(body);
 }
 private ResponseEntity<Map<String,Object>> build(HttpStatus s,String m){Map<String,Object>b=new LinkedHashMap<>();b.put("timestamp",LocalDateTime.now());b.put("status",s.value());b.put("message",m);return ResponseEntity.status(s).body(b);}
}

package com.gamedoora.backend.proxy.aggregation.exceptions;

public class ClientResponseException  extends RuntimeException{
 int status;
 String message;

 public ClientResponseException(String message, int status) {
  super(message);
  this.status =status;
 }
}

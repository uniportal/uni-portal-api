package br.com.uniportal.shared.api.controller;

import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

import br.com.uniportal.shared.api.response.ApiReturn;

@RestController
public class BaseController { 
    private Executor executor;
	
	public BaseController(Executor executor) {
		this.executor = executor;
	}
	
	public <T> CompletableFuture<T> asyncResultOf(Supplier<T> supplier) {
		return CompletableFuture.supplyAsync(() -> supplier.get(), executor);
	}
}
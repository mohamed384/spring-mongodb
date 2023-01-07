package com.workshop.mongodb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.mongodb.document.Author;
import com.workshop.mongodb.service.AuthorService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;

@Validated
@RestController
@RequestMapping("/auther")
public class AuthorController {

	private AuthorService autherService;

	public AuthorController(AuthorService autherService) {
		super();
		this.autherService = autherService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable String id) {

		return ResponseEntity.ok(autherService.findById(id));
	}

	@GetMapping()
	public ResponseEntity<?> findAll() {

		return ResponseEntity.ok(autherService.findAll());
	}

	@PostMapping("")
	public ResponseEntity<?> insert(@RequestBody @Valid Author entity) {

		return ResponseEntity.ok(autherService.insert(entity));
	}

	@PutMapping("")
	public ResponseEntity<?> update(@RequestBody @Valid Author entity) {

		return ResponseEntity.ok(autherService.update(entity));
	}

	@PutMapping("/custom")
	public ResponseEntity<?> updateEmail(@RequestParam @Email String email, @RequestParam String name,
			@RequestParam String phone) {

		autherService.updateByEmail(email, name, phone);

		return ResponseEntity.ok(null);
	}

	@GetMapping("/find-by-email/{email}")
	public ResponseEntity<?> findAuthorByEmail(@PathVariable @Email String email) {

		return ResponseEntity.ok(autherService.findAuthorByEmail(email));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable String id) {
		autherService.deleteById(id);
		return ResponseEntity.ok(null);
	}

}
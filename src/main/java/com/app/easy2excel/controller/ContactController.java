package com.app.easy2excel.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.app.easy2excel.dto.ContactDTO;
import com.app.easy2excel.exception.EmailAlreadyExistException;
import com.app.easy2excel.exception.ErrorResponse;
import com.app.easy2excel.exception.RecordNotFoundException;
import com.app.easy2excel.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.app.easy2excel.entity.Contact;
import com.app.easy2excel.repository.ContactRepository;

@RestController
@RequestMapping("api/v1/contact")
public class ContactController {
	@Autowired
	ContactService contactService;
	
	@PostMapping
	public ResponseEntity<ContactDTO> saveContact(@Valid  @RequestBody ContactDTO contactDTO) {

			if(contactService.isEmailPresent(contactDTO.getEmail())){
				ContactDTO dto = contactService.saveContact(contactDTO);
				return new ResponseEntity<ContactDTO>(dto, HttpStatus.OK);

			}else{
				throw new EmailAlreadyExistException("email already exist with this email : " +contactDTO.getEmail());
			}
	}


	@GetMapping("/{id}")
	public ResponseEntity<ContactDTO> fetchContactById(@PathVariable("id") Long id) {

		ContactDTO dto =contactService.getContactById(id);
		return new ResponseEntity<ContactDTO>(dto, HttpStatus.OK);

	}

}

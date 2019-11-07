package com.ibm.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.dto.TrainingDto;
import com.ibm.service.impl.TrainingServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api")
@RestController
public class TrainingController {

	private final TrainingServiceImpl trainingServiceImpl;
	
	public TrainingController(TrainingServiceImpl trainingServiceImpl) {
		this.trainingServiceImpl = trainingServiceImpl;
	}
	
	@PostMapping("/training")
	public ResponseEntity<TrainingDto> createTraing(@Valid @RequestBody TrainingDto traingingDto) throws Exception {
		log.info("createTraing:"+traingingDto);
		return ResponseEntity.ok(trainingServiceImpl.save(traingingDto));
	}
	
	@PutMapping("/training/{id}")
	public ResponseEntity<TrainingDto> updateTraing(@PathVariable(name = "id", required = true) Integer id,@Valid @RequestBody TrainingDto traingingDto) throws Exception {
		log.info("updateTraing:"+traingingDto);
		return ResponseEntity.ok(trainingServiceImpl.update(id,traingingDto));
	}
}

package com.stefanini.pessoa.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.stefanini.pessoa.entidades.Cargo;
import com.stefanini.pessoa.repository.CargoRepository;

@Service
public class CargoService {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	
	public Cargo atualizar(Long id, Cargo cargo) {
		
		Cargo cargoSalvo = buscarPeloId(id);
		BeanUtils.copyProperties(cargo, cargoSalvo, "id");
		
		return cargoRepository.save(cargoSalvo);
	}
	
	
	public Cargo buscarPeloId(Long id) {
		Cargo cargo = cargoRepository.findOne(id);
		if(cargo==null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return cargo;
	}


	

}

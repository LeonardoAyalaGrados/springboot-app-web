package com.pildoras.informatica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pildoras.informatica.entity.Departamento;
import com.pildoras.informatica.repository.DepartamentoRepository;

@Service
public class DepartamentoImpl implements DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Override
	public List<Departamento> listar() {
		
		return departamentoRepository.findAll() ;
	}

	@Override
	public Departamento guardarDepartamento(Departamento departamento) {
		
		return departamentoRepository.save(departamento);
	}

	@Override
	public Departamento buscarDepartamentoPorId(Long id) {
		
		return departamentoRepository.findById(id).get();
	}

	@Override
	public Departamento actualizarDepartamento(Departamento departamento) {
		
		return departamentoRepository.save(departamento);
	}

	@Override
	public void eliminarDepartamento(Long id) {
		
		departamentoRepository.deleteById(id);
		
	}
	
	
}

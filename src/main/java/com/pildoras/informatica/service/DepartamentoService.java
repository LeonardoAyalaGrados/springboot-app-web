package com.pildoras.informatica.service;

import java.util.List;

import com.pildoras.informatica.entity.Departamento;


public interface DepartamentoService {
	
	public List<Departamento> listar();
	
	public Departamento guardarDepartamento( Departamento departamento);
	
	public Departamento buscarDepartamentoPorId(Long id);
	
	public Departamento actualizarDepartamento(Departamento departamento);
	
	public void eliminarDepartamento(Long id);
}

package com.pildoras.informatica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pildoras.informatica.entity.Empleado;
import com.pildoras.informatica.repository.EmpleadoRepository;

@Service
public class EmpleadoImpl implements EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public List<Empleado> listar() {
		
		return empleadoRepository.findAll();
	}

	@Override
	public Empleado guardarEmpleado(Empleado empleado) {
		
		return empleadoRepository.save(empleado);
	}

	@Override
	public Empleado buscarEmpleadoPorId(Long id) {
		
		return empleadoRepository.findById(id).get();
	}

	@Override
	public Empleado actualizarEmpleado(Empleado empleado) {
		
		return empleadoRepository.save(empleado);
	}

	@Override
	public void eliminarEmpleado(Long id) {
		
		empleadoRepository.deleteById(id);
		
	}
	
	
	
}

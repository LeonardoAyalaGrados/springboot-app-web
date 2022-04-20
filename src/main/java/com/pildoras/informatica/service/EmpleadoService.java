package com.pildoras.informatica.service;

import java.util.List;

import com.pildoras.informatica.entity.Empleado;



public interface EmpleadoService {
	
	public List<Empleado> listar();
	
	public Empleado guardarEmpleado(Empleado empleado);
	
	public Empleado buscarEmpleadoPorId(Long id);
	
	public Empleado actualizarEmpleado(Empleado empleado);
	
	public void eliminarEmpleado(Long id);
	
}

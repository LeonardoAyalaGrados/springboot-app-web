package com.pildoras.informatica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pildoras.informatica.entity.Departamento;
import com.pildoras.informatica.entity.Empleado;
import com.pildoras.informatica.service.DepartamentoService;
import com.pildoras.informatica.service.EmpleadoService;

@Controller
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

	@Autowired
	private DepartamentoService departamentoService;

	// MENU
	@GetMapping("/menu")
	public String menu(Model model) {

		String mensaje = "BIENVENIDOS";
		model.addAttribute("saluda", mensaje);
		return "Menu";
	}

	// _______________________________________________________________________________

	@GetMapping("/empleadosLista-rest")
	public @ResponseBody List<Empleado> listarRest(Model model) {
	
		return empleadoService.listar();

	}			
	
	
	
	// CRUD EMPLEADOS
	@GetMapping("/empleadosLista")
	public String listar(Model model) {
		List<Empleado> listaEmpleado = empleadoService.listar();
		model.addAttribute("listar", listaEmpleado);
		return "Lista_Empleados";

	}
	
	@GetMapping("/nuevoEmpleado")
	public String nuevoRegistro(Model model) {

		Empleado nuevoEmpleado = new Empleado();

		List<Departamento> departamentos = departamentoService.listar();

		model.addAttribute("departamentos", departamentos);
		model.addAttribute("empleado", nuevoEmpleado);

		return "Formulario_Empleado";
	}

	@PostMapping("/registrarEmpleado")
	public String guardarRegistroEmpleado(@ModelAttribute("empleado") Empleado empleado) {
		empleadoService.guardarEmpleado(empleado);

		return "redirect:/empleadosLista";
	}

	//_____________________
	
	@GetMapping("/editarEmpleado/{id}")
	public String editarEmpleado(@PathVariable(value = "id") Long id, Empleado empleado, Model model) {

		empleado = empleadoService.buscarEmpleadoPorId(id);
		List<Departamento> departamentos = departamentoService.listar();

		model.addAttribute("departamentos", departamentos);
		model.addAttribute("empleado", empleado);
		
		
		return "Editar_Empleado";
	}

	@PostMapping("/actualizarRegistro/{id}")
	public String actualizarRegistro(@PathVariable Long id, Empleado empleado) {

		Empleado empleadoEncontrado=empleadoService.buscarEmpleadoPorId(id);
		
		empleadoEncontrado.setNombre(empleado.getNombre());
		empleadoEncontrado.setApellido(empleado.getApellido());
		empleadoEncontrado.setDni(empleado.getDni());
		empleadoEncontrado.setCelular(empleado.getCelular());
		empleadoEncontrado.setSueldo(empleado.getSueldo());
		empleadoEncontrado.setDepartamento(empleado.getDepartamento());
		
		empleadoService.guardarEmpleado(empleadoEncontrado);
		
		return "redirect:/empleadosLista";

	}

	//________
	@GetMapping("/eliminar/{id}")
	public String eliminarEmpleado(@PathVariable(value = "id") Long id) {
		empleadoService.eliminarEmpleado(id);
		return "redirect:/empleadosLista";
	}

}

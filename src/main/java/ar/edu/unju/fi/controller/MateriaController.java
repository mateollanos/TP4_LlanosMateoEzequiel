package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.collections.ListadoMaterias;
import ar.edu.unju.fi.model.Materia;

@Controller
public class MateriaController {
	@Autowired
	Materia nuevaMateria = new Materia();
	
	@GetMapping("/formularioMateria")
    public ModelAndView getFormularioMaterias() {
		//vista de formDocente
		ModelAndView modelView = new ModelAndView("formMateria");
		modelView.addObject("nuevaMateria", nuevaMateria);
		modelView.addObject("listadoDocente", ListadoDocentes.listarDocentes());
		modelView.addObject("listadoCarrera", ListadoCarreras.listarCarreras());	
        return modelView;
    }
	
	@PostMapping("/guardarMateria")
	public ModelAndView saveMateria(@ModelAttribute("nuevaMateria") Materia materiaAGuardar) {
		//guardar
		materiaAGuardar.setDocente(ListadoDocentes.buscarDocentePorLegajo(materiaAGuardar.getDocente().getLegajo()));
		materiaAGuardar.setCarrera(ListadoCarreras.buscarCarreraPorCodigo(materiaAGuardar.getCarrera().getCodigo()));
		ListadoMaterias.agregarMateria(materiaAGuardar);
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoMateria", ListadoMaterias.listarMaterias());	
		return modelView;	
	}
	
	@GetMapping("/borrarMateria/{codigo}")
	public ModelAndView deleteMateriaDelListado(@PathVariable(name="codigo") String codigo) {
		//borrar
		ListadoMaterias.eliminarMateria(codigo);
		//mostrar el nuevo listado
		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoMateria", ListadoMaterias.listarMaterias());	
		return modelView;		
	}
	
	@GetMapping("/modificarMateria/{codigo}")
	public ModelAndView editMateria(@PathVariable(name="codigo") String codigo) {
		//seleccionar el docente para modificar
		Materia materiaAModificar = ListadoMaterias.buscarMateriaPorCodigo(codigo);
		
		//mostrar el formulario de modificacion
		ModelAndView modelView = new ModelAndView("formMateria");
		modelView.addObject("nuevaMateria", materiaAModificar);	
		modelView.addObject("listadoDocente", ListadoDocentes.listarDocentes());
		modelView.addObject("listadoCarrera", ListadoCarreras.listarCarreras());	
		modelView.addObject("flag", true);
		return modelView;		
		}
	
	@PostMapping("/modificarMateria")
	public ModelAndView updateMateria(@ModelAttribute("nuevaMateria") Materia materiaModificada) {
					
		//modificar el docente
		materiaModificada.setDocente(ListadoDocentes.buscarDocentePorLegajo(materiaModificada.getDocente().getLegajo()));
		materiaModificada.setCarrera(ListadoCarreras.buscarCarreraPorCodigo(materiaModificada.getCarrera().getCodigo()));
		ListadoMaterias.modificarMateria(materiaModificada);
		
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoMateria", ListadoMaterias.listarMaterias());	
		return modelView;		
	}
	
	@GetMapping("/materias")
	public ModelAndView showMaterias() {
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoMateria", ListadoMaterias.listarMaterias());	
		return modelView;		
	}
}

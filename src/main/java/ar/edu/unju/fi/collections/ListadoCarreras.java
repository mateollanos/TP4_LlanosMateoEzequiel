package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Carrera;


public class ListadoCarreras {
	
	public static List<Carrera> carreras = new ArrayList<Carrera>();
	
	public static List<Carrera> listarCarreras() {
		return carreras;
	}
	
	public static Carrera buscarCarreraPorCodigo(String codigo) {
		for(Carrera c : carreras) {
			if (c.getCodigo().equals(codigo)) {
				return c;
			}
		}
		return null;
	}
	
	public static void agregarCarrera(Carrera c) {
		//agregando el estado
		c.setEstado(true);
		carreras.add(c);
	}
	
	public static void modificarCarrera(Carrera carreraModificada) {
		for (int i=0; i<carreras.size(); i++) {
			Carrera carrera = carreras.get(i);
			if (carrera.getCodigo().equals(carreraModificada.getCodigo())) {
				carreras.set(i, carreraModificada);
				break;
			}
		}
	}
	
	public static void eliminarCarrera(String codigo) {
		//borrado fisico
		//carreras.removeIf(carrera->carrera.getCodigo().equals(codigo));
		//borrado lógico
		  for (int i=0;i<carreras.size();i++) {
		      Carrera carrera = carreras.get(i);
		      if (carrera.getCodigo().equals(codigo)) {
		        carrera.setEstado(false);;
		        break;
		      }
		    }
	}
	
	
}

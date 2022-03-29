package modelo.negocio;

import java.util.List;

import modelo.entidad.Coche;
import modelo.persistencia.DaoCocheMySQL;
import modelo.persistencia.interfaces.DaoCoche;

public class GestorCoche {
	
	private DaoCoche daoCoche = new DaoCocheMySQL();
	
	public int alta(Coche c) {
		if(c.getMatricula().length() >= 7) {
			boolean alta = daoCoche.alta(c);
			if(alta) {
				return 0;
			}else {
				return 1;
			}
		}else {
			return 2;
		}
	}
	
	public boolean baja(int id) {
		return daoCoche.baja(id);
	}
	
	public boolean modificar(int id) {
		return daoCoche.modificar(id);
	}
	
	public List<Coche> listar(){
		return daoCoche.listar();
	}
}

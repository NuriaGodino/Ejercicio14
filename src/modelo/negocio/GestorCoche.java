package modelo.negocio;

import java.util.List;

import modelo.entidad.Coche;
import modelo.persistencia.DaoCocheMySQL;
import modelo.persistencia.interfaces.DaoCoche;

public class GestorCoche {
	
	private DaoCoche daoCoche = new DaoCocheMySQL();
	
	public int alta(Coche c) {
		if(c.getMatricula().length() >= 7) {
			if(!(c.getMatricula().equals(daoCoche.buscarPorMatricula(c.getMatricula()).getMatricula()))) {
				if(c.getKilometros() >= 0) {
					boolean alta = daoCoche.alta(c);
					if(alta) {
						return 0;
					}else {
						return 1;
					}
				}else { //km negativos
					return 3;
				}
			}else { //la matricula ya esta introducida
				return 4;
			}
			
		}else { //matricula menor de 7 caracter
			return 2;
		}
	}
	
	public boolean baja(int id) {
		return daoCoche.baja(id);
	}
	
	public boolean modificar(Coche id) {
		return daoCoche.modificar(id);
	}
	
	public List<Coche> listar(){
		return daoCoche.listar();
	}
}

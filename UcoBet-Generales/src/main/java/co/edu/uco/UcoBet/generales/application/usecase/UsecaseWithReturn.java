package co.edu.uco.UcoBet.generales.application.usecase;

public interface UsecaseWithReturn<R,D> {
	
	
	R execute(D data);
	
	

}

package co.edu.uco.UcoBet.generales.application.primaryports.interactor;

public interface InteractorWithReturn<T,R> {
	
	R execute(T data);

}

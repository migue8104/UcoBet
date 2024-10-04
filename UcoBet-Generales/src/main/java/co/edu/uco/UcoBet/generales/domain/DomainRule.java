package co.edu.uco.UcoBet.generales.domain;

public interface DomainRule<T> {
	void execute(T data);

}

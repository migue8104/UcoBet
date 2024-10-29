package co.edu.uco.UcoBet.generales.application.usecase.state;

import java.util.List;

import co.edu.uco.UcoBet.generales.application.usecase.UsecaseWithReturn;
import co.edu.uco.UcoBet.generales.domain.state.StateDomain;

public interface ConsultState extends UsecaseWithReturn< List<StateDomain>,StateDomain> {

}

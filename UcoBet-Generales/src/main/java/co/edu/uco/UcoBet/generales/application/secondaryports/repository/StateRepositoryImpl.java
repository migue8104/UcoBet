package co.edu.uco.UcoBet.generales.application.secondaryports.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.uco.UcoBet.generales.application.secondaryports.entity.StateEntity;
import co.edu.uco.UcoBet.generales.crosscutting.exceptions.DataUcoBetException;
import co.edu.uco.UcoBet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.UcoBet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.UcoBet.generales.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;

@Service
public class StateRepositoryImpl implements StateRepositoryCustom{
	
	private EntityManager entityManager;
	
	public StateRepositoryImpl(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<StateEntity> findByFilter(StateEntity filter) {
		try {
			var criteriaBuilder = entityManager.getCriteriaBuilder();
			var query = criteriaBuilder.createQuery(StateEntity.class);
			var result = query.from(StateEntity.class);
			
			var predicates = new ArrayList<>();
			
			if(!ObjectHelper.isNull(filter)) {
				if(!UUIDHelper.isDefault(filter.getId())) {
					predicates.add(criteriaBuilder.equal(result.get("id"), filter.getId()));
				}
				
				if(!TextHelper.isEmpty(filter.getName())) {
					predicates.add(criteriaBuilder.equal(result.get("name"), filter.getName()));
				}
				
				if(!UUIDHelper.isDefault(filter.getCountry().getId())) {
					predicates.add(criteriaBuilder.equal(result.get("state"), filter.getCountry()));
				}
			}
			
			query.select(result).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
			return entityManager.createQuery(query).getResultList();
			
		} catch (final Exception exception) {
			throw DataUcoBetException.create(null, null, exception);
		}
	}




}

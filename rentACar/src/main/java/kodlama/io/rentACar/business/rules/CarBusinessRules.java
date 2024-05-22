package kodlama.io.rentACar.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.core.utilies.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class CarBusinessRules {
	private CarRepository repository;

	public void checkIfCarPlateExists(String plate) {
		if (this.repository.existsByPlate(plate)) {
			throw new BusinessException("Araba plakası zaten mevcut");
		}
	}
}

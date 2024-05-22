package kodlama.io.rentACar.core.utilies.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ModelMapperManager implements ModelMapperService {
    ModelMapper modelMapper = new ModelMapper();
	
	public ModelMapper forResponse() {
		modelMapper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper;
	}

	
	public ModelMapper forRequest() {
	modelMapper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.STANDARD);//requestten gelen her nesneyi mapler
		return modelMapper;
	}

}

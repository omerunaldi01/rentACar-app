package kodlama.io.rentACar.core.utilies.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
 ModelMapper forResponse();
 ModelMapper forRequest();
}

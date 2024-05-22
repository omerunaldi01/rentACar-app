package kodlama.io.rentACar.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilies.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service // bu sınıf business nesnesidir
@AllArgsConstructor
public class BrandManager implements BrandService {
	 private final BrandRepository brandRepository;
	    private final ModelMapperService modelMapperService;
	    private BrandBusinessRules brandBusinessRules;

	
	    @Override
	    public List<GetAllBrandsResponse> getAll() {

	        List<Brand> brands = brandRepository.findAll();

	       
	        return brands.stream()
	                .map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).toList();
	    }

	    @Override
	    public GetByIdBrandResponse getById(int id) {

	        Brand brand = this.brandRepository.findById(id).orElseThrow(); // Bulamazsan hata firlat


	        return this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
	    }

	    @Override
	    public void add(CreateBrandRequest createBrandRequest) {

	        brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());

	        Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class); 

	        brandRepository.save(brand);
	    }

	    @Override
	    public void update(UpdateBrandRequest updateBrandRequest) {
	     

	        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
			brand.setId(0);
	        this.brandRepository.save(brand); 
	    }

	    @Override
	    public void delete(int id) {

	        this.brandRepository.deleteById(id);

	    }
	}
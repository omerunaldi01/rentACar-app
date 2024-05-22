package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;



import kodlama.io.rentACar.entities.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    boolean existsByName(String name); //exists görünce arkada sorgu oluşturuyor
    //Spring JPA keywords olarak arastir
}
  
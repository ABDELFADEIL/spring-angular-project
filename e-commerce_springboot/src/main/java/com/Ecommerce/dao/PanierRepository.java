package com.Ecommerce.dao;


import org.springframework.data.jpa.repository.JpaRepository;




import com.Ecommerce.entities.Panier;





public interface PanierRepository extends JpaRepository<Panier, Long>{
	
	//public Panier findByAppUserId(@Param("id") Long id);
	
	//@Query("select p from Panier p where p.appUser.id=:id")
	//public Panier searchByUserId(@Param("id") Long id);

}

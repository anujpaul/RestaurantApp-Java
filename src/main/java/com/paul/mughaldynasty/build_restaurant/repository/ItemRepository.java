package com.paul.mughaldynasty.build_restaurant.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.paul.mughaldynasty.build_restaurant.bean.ItemTable;

public interface ItemRepository extends JpaRepository<ItemTable, Long> {

	@Query("SELECT MAX(id)+1 FROM ItemTable")
	Long nextId();

	@Query("SELECT i.amount FROM ItemTable i WHERE i.id = :id")
	Double findAmountById(Long id);

	@Query("SELECT i.id, i.amount FROM ItemTable i WHERE i.id IN :ids")
	Map<Long, Double> findAmountByIds(@Param("ids") List<Long> ids);

}

package com.paul.mughaldynasty.build_restaurant.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paul.mughaldynasty.build_restaurant.bean.ItemTable;
import com.paul.mughaldynasty.build_restaurant.repository.ItemRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ItemController {

	@Autowired
	private ItemRepository ItemRepositary;

	@GetMapping("/menu")
	public List<ItemTable> getMenuItem()
	{
		return ItemRepositary.findAll();
	}

	@PostMapping("/addItem")
	public String createItem(@RequestBody ItemTable itemTable) {

		if (itemTable.getItemName() == null || itemTable.getAmount() <= 0) {
			return itemTable.toString();
		}

		if (itemTable.getId() == null) {

			Long nextId = ItemRepositary.nextId();

			itemTable.setId(nextId);
		}
		ItemRepositary.save(itemTable);
		return "Inserted Successfully " + itemTable.toString();
	}

	@PutMapping("/updateItem/{id}")
	public String updateItem(@PathVariable long id, @RequestBody ItemTable ItemTable) {

		if (ItemTable.getItemName() == null || ItemTable.getAmount() <= 0) {
			return ItemTable.toString();
		}

		ItemTable.setId(id);
		
		ItemRepositary.save(ItemTable);
		return "Inserted Successfully " + ItemTable.getId();
	}

	@GetMapping("/menu/{id}")
	public Optional<ItemTable> getItem(@PathVariable Long id) {

		return ItemRepositary.findById(id);
	}

	@DeleteMapping("/menu/{id}")
	public String DeleteItem(@PathVariable Long id) {

		ItemRepositary.deleteById(id);

		return "Item Deleted";

	}

}

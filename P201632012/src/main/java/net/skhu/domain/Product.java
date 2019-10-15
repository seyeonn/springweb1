package net.skhu.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
@Entity
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
	String title;
	int unitCost;
	int quantity;

	@ManyToOne
    @JoinColumn(name = "categoryId")
    Category category;

	@JsonIgnore
	@OneToMany(mappedBy="product")
	List<Supply> supplies;

}

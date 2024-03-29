package net.skhu.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Category {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;

    @JsonIgnore
    @OneToMany(mappedBy="category", fetch = FetchType.LAZY)
    List<Product> products;

}

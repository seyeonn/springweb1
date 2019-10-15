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
/*import lombok.EqualsAndHashCode;
import lombok.ToString;*/

@Data
/*
 * @ToString(exclude="publisher")
 *
 * @EqualsAndHashCode(exclude="publisher")
 */
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String categoryName;

    @JsonIgnore
    @OneToMany(mappedBy="category", fetch = FetchType.LAZY)
    List<Book> books;

}


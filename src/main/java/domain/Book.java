package domain;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String isbc;
	
	@ManyToMany
	@JoinTable(name= "author_book", joinColumns = @JoinColumn(name ="book_id"),
	inverseJoinColumns = @JoinColumn (name = "author_id"))
	private Set<Author> authors;
	
	public Set<Author> getAuthors(){
		return authors;
	}
	
	public void setAuthors(Set<Author> authors) {
		this.authors= authors;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIsbc() {
		return isbc;
	}
	
	public void setIsbc(String isbc) {
		this.isbc = isbc;
	}
	
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isbc='" + isbc + '\'' +
                ", authors='" + authors +
                '}';
    }
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof Book)) return false;
	    Book book = (Book) o;
	    return getId() != null ? getId().equals(book.getId()) : book.getId() == null;
	}

	@Override
	public int hashCode() {
	    return getId() != null ? getId().hashCode() : 0;
	}
	
}

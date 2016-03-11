package boke.po;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@SuppressWarnings("serial")
public class User implements Serializable {
		Integer id;
		String name;
		String password;
		String author;
		@SuppressWarnings("rawtypes")
		Set blog = new HashSet(0);
		@SuppressWarnings("rawtypes")
		Set com = new HashSet(0);
		@SuppressWarnings("rawtypes")
		public Set getCom() {
			return com;
		}
		

		@SuppressWarnings("rawtypes")
		public void setCom(Set com) {
			this.com = com;
		}


		public User() {
			super();
		}
		
	
		public User(String name, String password, String author) {
			super();
			this.name = name;
			this.password = password;
			this.author = author;
			
		}



		public User(Integer id, String name, String password, String author) {
			super();
			this.id = id;
			this.name = name;
			this.password = password;
			this.author = author;
		}


		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", password=" + password + ", author=" + author + "]";
		}


		public String getAuthor() {
			return author;
		}


		public void setAuthor(String author) {
			this.author = author;
		}


		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}


		@SuppressWarnings("rawtypes")
		public Set getBlog() {
			return blog;
		}


		@SuppressWarnings("rawtypes")
		public void setBlog(Set blog) {
			this.blog = blog;
		}


		
		
}

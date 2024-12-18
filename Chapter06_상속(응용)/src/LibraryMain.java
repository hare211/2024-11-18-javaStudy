
public class LibraryMain {
	public static void main(String[] args) {
		Library library = new Library(4);
		library.addBook("제목1", "저자1");
		library.addBook("제목2", "저자2");
		library.addBook("제목3", "저자3");
		library.addBook("제목4", "저자4");
		library.addBook("제목5", "저자5");
		library.showBooks();
		
	}
}

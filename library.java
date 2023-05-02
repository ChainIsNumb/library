import java.util.ArrayList;

class library extends Book{
  public ArrayList<Book> books = new ArrayList<>();
  public ArrayList<Member> members = new ArrayList<Member>();
  public String title;
  public String id;
  
  public void addbook(Book book){
    if (!isMemberIdExist(book.id)) {
      this.books.add(book);
      System.out.println("Book added successfully.");
  } else {
      System.out.println("Book with ID " + book.id + " already exists.");
  }
}
  

  public Boolean isBookIdExist(String id) {
    Boolean isExist = false;
    for (Book book : this.books) {
      if (book.id.equals(id)) {
        isExist = true;
      }
    }
    return isExist;
  }

  public void addMember(Member member) {
    if (!isMemberIdExist(member.id)) {
      this.members.add(member);
      System.out.println("Member added successfully.");
  } else {
      System.out.println("Member with ID " + member.id + " already exists.");
  }
}

  public Boolean isMemberIdExist(String id) {
    Boolean isExist = false;
    for (Member member : this.members) {
      if (member.id.equals(id)) {
        isExist = true;
      }
    }
    return isExist;
  }

  public void giveBook(String bookId, String memberId) {
    Book book = this.getBookById(bookId);
    this.books.remove(book);

    Member member = this.getMemberById(memberId);
    int memberIndex = this.getMemberIndex(member);
    this.members.get(memberIndex).borrowedBooks.add(book);
  }

  public void receiveBook(String bookId, String memberId) {
    Book book = this.getBookById(bookId);
    this.books.add(book);

    Member member = this.getMemberById(memberId);
    int memberIndex = this.getMemberIndex(member);
    this.members.get(memberIndex).borrowedBooks.remove(book);
  }

  private int getMemberIndex(Member member) {
    return this.members.indexOf(member);
  }

  private Member getMemberById(String id) {
    for (Member member : this.members) {
      if (member.id.equals(id)) {
        return member;
      }
    }
    return null;
  }

  private Book getBookById(String id) {
    for (Book book : this.books) {
      if (book.id.equals(id)) {
        return book;
      }
    }
    return null;
  }
}
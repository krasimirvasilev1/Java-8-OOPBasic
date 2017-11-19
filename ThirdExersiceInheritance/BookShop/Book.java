package ThirdExersiceInheritance.BookShop;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String author, String title, double price) {
        setAuthor(author);
        setTitle(title);
        setPrice(price);
    }

    private void setTitle(String title) {
        if (title.length() > 2){
            this.title = title;
        }
        else{
            throw new IllegalArgumentException("Title not valid!");
        }
    }

    private void setAuthor(String author) {
        String[] twoNames = author.split(" ");
        if (twoNames.length == 2 && Character.isDigit(twoNames[1].charAt(0))){
            throw new IllegalArgumentException("Author not valid!");
        }
        else{
            this.author = author;
        }
    }

    private void setPrice(double price) {
        if (price > 0){
            this.price = price;
        }
        else {
            throw new IllegalArgumentException("Price not valid!");
        }
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());
        return sb.toString();
    }
}

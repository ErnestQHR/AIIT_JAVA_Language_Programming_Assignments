/**
 * 图书类，使用String作为ID类型（ISBN）
 */
class Book implements InventoryItem<String> {
    private String isbn;    // 使用ISBN作为唯一标识符
    private String title;
    private String author;
    private double price;
    private int pageCount;
    
    /**
     * 构造一个图书对象
     * @param isbn 图书ISBN
     * @param title 图书标题
     * @param author 图书作者
     * @param price 图书价格
     * @param pageCount 图书页数
     */
    public Book(String isbn, String title, String author, double price, int pageCount) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
        this.pageCount = pageCount;
    }
    
    /**
     * 获取图书ISBN
     * @return 图书ISBN
     */
    @Override
    public String getId() {
        return isbn;
    }
    
    /**
     * 获取图书价格
     * @return 图书价格
     */
    @Override
    public double getPrice() {
        return price;
    }
    
    /**
     * 获取图书标题
     * @return 图书标题
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * 获取图书作者
     * @return 图书作者
     */
    public String getAuthor() {
        return author;
    }
    
    /**
     * 获取图书页数
     * @return 图书页数
     */
    public int getPageCount() {
        return pageCount;
    }
    
    /**
     * 返回图书的字符串表示
     * @return 字符串表示
     */
    @Override
    public String toString() {
        return "图书 [ISBN=" + isbn + ", 标题=" + title + ", 作者=" + author + 
               ", 价格=" + price + ", 页数=" + pageCount + "]";
    }
}
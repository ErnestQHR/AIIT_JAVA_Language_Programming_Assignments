/**
 * 食品类，使用String作为ID类型
 */
class Food implements InventoryItem<String> {
    private String id;
    private String name;
    private double price;
    private String expiryDate;
    private String category;
    
    /**
     * 构造一个食品对象
     * @param id 食品ID
     * @param name 食品名称
     * @param price 食品价格
     * @param expiryDate 保质期
     * @param category 食品类别
     */
    public Food(String id, String name, double price, String expiryDate, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expiryDate = expiryDate;
        this.category = category;
    }
    
    /**
     * 获取食品ID
     * @return 食品ID
     */
    @Override
    public String getId() {
        return id;
    }
    
    /**
     * 获取食品价格
     * @return 食品价格
     */
    @Override
    public double getPrice() {
        return price;
    }
    
    /**
     * 获取食品名称
     * @return 食品名称
     */
    public String getName() {
        return name;
    }
    
    /**
     * 获取食品保质期
     * @return 食品保质期
     */
    public String getExpiryDate() {
        return expiryDate;
    }
    
    /**
     * 获取食品类别
     * @return 食品类别
     */
    public String getCategory() {
        return category;
    }
    
    /**
     * 返回食品的字符串表示
     * @return 字符串表示
     */
    @Override
    public String toString() {
        return "食品 [ID=" + id + ", 名称=" + name + ", 价格=" + price + 
               ", 保质期=" + expiryDate + ", 类别=" + category + "]";
    }
}
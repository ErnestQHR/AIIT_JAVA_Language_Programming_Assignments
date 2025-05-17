/**
 * 电子产品类，使用Integer作为ID类型
 */
class Electronics implements InventoryItem<Integer> {
    private Integer id;
    private String name;
    private double price;
    private String brand;
    private String model;
    
    /**
     * 构造一个电子产品对象
     * @param id 产品ID
     * @param name 产品名称
     * @param price 产品价格
     * @param brand 产品品牌
     * @param model 产品型号
     */
    public Electronics(Integer id, String name, double price, String brand, String model) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.model = model;
    }
    
    /**
     * 获取产品ID
     * @return 产品ID
     */
    @Override
    public Integer getId() {
        return id;
    }
    
    /**
     * 获取产品价格
     * @return 产品价格
     */
    @Override
    public double getPrice() {
        return price;
    }
    
    /**
     * 获取产品名称
     * @return 产品名称
     */
    public String getName() {
        return name;
    }
    
    /**
     * 获取产品品牌
     * @return 产品品牌
     */
    public String getBrand() {
        return brand;
    }
    
    /**
     * 获取产品型号
     * @return 产品型号
     */
    public String getModel() {
        return model;
    }
    
    /**
     * 返回电子产品的字符串表示
     * @return 字符串表示
     */
    @Override
    public String toString() {
        return "电子产品 [ID=" + id + ", 名称=" + name + ", 价格=" + price + 
               ", 品牌=" + brand + ", 型号=" + model + "]";
    }
}
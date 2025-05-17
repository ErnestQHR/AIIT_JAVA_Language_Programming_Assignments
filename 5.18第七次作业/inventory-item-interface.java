/**
 * InventoryItem 泛型接口
 * 所有库存商品必须实现此接口
 * @param <T> 商品唯一标识符的类型
 */
interface InventoryItem<T> {
    /**
     * 获取商品的唯一标识符
     * @return 商品的唯一标识符
     */
    T getId();
    
    /**
     * 获取商品的价格
     * @return 商品的价格
     */
    double getPrice();
}
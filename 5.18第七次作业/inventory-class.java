/**
 * Inventory 泛型类，用于管理商品库存
 * @param <T> 商品唯一标识符的类型
 * @param <E> 实现了InventoryItem接口的商品类型
 */
class Inventory<T, E extends InventoryItem<T>> {
    // 存储商品的数组
    private Object[] items;
    // 当前库存中的商品数量
    private int count;
    // 库存容量
    private int capacity;
    
    /**
     * 构造一个指定容量的库存
     * @param capacity 库存容量
     */
    public Inventory(int capacity) {
        this.capacity = capacity;
        this.items = new Object[capacity];
        this.count = 0;
    }
    
    /**
     * 添加商品到库存
     * @param item 要添加的商品
     * @return 添加成功返回true，库存已满则返回false
     */
    public boolean add(E item) {
        if (count < capacity) {
            items[count] = item;
            count++;
            return true;
        }
        return false;
    }
    
    /**
     * 根据商品ID查询商品
     * @param id 商品的唯一标识符
     * @return 找到的商品，如果未找到则返回null
     */
    @SuppressWarnings("unchecked")
    public E get(T id) {
        for (int i = 0; i < count; i++) {
            E item = (E) items[i];
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }
    
    /**
     * 计算库存中所有商品的总价值
     * @return 总价值
     */
    @SuppressWarnings("unchecked")
    public double totalValue() {
        double total = 0.0;
        for (int i = 0; i < count; i++) {
            E item = (E) items[i];
            total += item.getPrice();
        }
        return total;
    }
    
    /**
     * 获取当前库存中的商品数量
     * @return 商品数量
     */
    public int getCount() {
        return count;
    }
    
    /**
     * 获取库存容量
     * @return 库存容量
     */
    public int getCapacity() {
        return capacity;
    }
}
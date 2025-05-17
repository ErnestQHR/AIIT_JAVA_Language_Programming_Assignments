/**
 * 库存管理系统的测试类
 */
class InventoryManagementSystem {
    
    public static void main(String[] args) {
        // 创建电子产品库存
        System.out.println("========== 电子产品库存管理 ==========");
        Inventory<Integer, Electronics> electronicsInventory = new Inventory<>(10);
        
        // 添加电子产品
        Electronics laptop = new Electronics(1001, "笔记本电脑", 5999.99, "联想", "ThinkPad X1");
        Electronics phone = new Electronics(1002, "智能手机", 3999.99, "华为", "P50 Pro");
        Electronics tablet = new Electronics(1003, "平板电脑", 2999.99, "Apple", "iPad Air");
        
        electronicsInventory.add(laptop);
        electronicsInventory.add(phone);
        electronicsInventory.add(tablet);
        
        // 查询电子产品
        System.out.println("库存中的电子产品数量: " + electronicsInventory.getCount());
        System.out.println("查询ID为1002的产品: " + electronicsInventory.get(1002));
        System.out.println("查询ID为1004的产品: " + electronicsInventory.get(1004)); // 不存在的产品
        System.out.println("电子产品库存总价值: " + electronicsInventory.totalValue() + " 元");
        
        // 创建图书库存
        System.out.println("\n========== 图书库存管理 ==========");
        Inventory<String, Book> bookInventory = new Inventory<>(10);
        
        // 添加图书
        Book book1 = new Book("978-7-111-54227-0", "Java编程思想", "Bruce Eckel", 108.00, 880);
        Book book2 = new Book("978-7-115-47968-0", "深入理解Java虚拟机", "周志明", 89.00, 482);
        Book book3 = new Book("978-7-111-64605-2", "算法导论", "Thomas H. Cormen", 128.00, 770);
        
        bookInventory.add(book1);
        bookInventory.add(book2);
        bookInventory.add(book3);
        
        // 查询图书
        System.out.println("库存中的图书数量: " + bookInventory.getCount());
        System.out.println("查询ISBN为978-7-115-47968-0的图书: " + bookInventory.get("978-7-115-47968-0"));
        System.out.println("查询ISBN为978-7-000-00000-0的图书: " + bookInventory.get("978-7-000-00000-0")); // 不存在的图书
        System.out.println("图书库存总价值: " + bookInventory.totalValue() + " 元");
        
        // 创建食品库存
        System.out.println("\n========== 食品库存管理 ==========");
        Inventory<String, Food> foodInventory = new Inventory<>(10);
        
        // 添加食品
        Food food1 = new Food("F001", "纯牛奶", 4.50, "2023-12-31", "乳制品");
        Food food2 = new Food("F002", "巧克力", 15.80, "2023-06-30", "零食");
        Food food3 = new Food("F003", "面包", 8.50, "2023-01-15", "烘焙食品");
        
        foodInventory.add(food1);
        foodInventory.add(food2);
        foodInventory.add(food3);
        
        // 查询食品
        System.out.println("库存中的食品数量: " + foodInventory.getCount());
        System.out.println("查询ID为F002的食品: " + foodInventory.get("F002"));
        System.out.println("查询ID为F004的食品: " + foodInventory.get("F004")); // 不存在的食品
        System.out.println("食品库存总价值: " + foodInventory.totalValue() + " 元");
        
        // 计算所有库存的总价值
        double totalValue = electronicsInventory.totalValue() + bookInventory.totalValue() + foodInventory.totalValue();
        System.out.println("\n========== 库存总计 ==========");
        System.out.println("所有库存的总价值: " + totalValue + " 元");
    }
}
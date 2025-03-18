import java.util.Scanner;

/**
 * 学生信息录入系统
 * 实现通过控制台输入学生基本信息并按指定格式输出
 */
public class StudentInfoSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 声明变量
        int age = 0;
        double weight = 0.0;
        String fullName = "";
        
        // 1. 输入年龄（整数）范围1-120
        boolean validAge = false;
        while (!validAge) {
            System.out.print("请输入学生年龄（1-120）: ");
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                // 验证年龄范围
                if (age >= 1 && age <= 120) {
                    validAge = true;
                } else {
                    System.out.println("错误：年龄必须在1-120之间，请重新输入。");
                }
            } else {
                System.out.println("错误：请输入有效的整数。");
                scanner.next(); // 清除无效输入
            }
        }
        
        // 2. 输入体重（浮点数）范围10.0-200.0
        boolean validWeight = false;
        while (!validWeight) {
            System.out.print("请输入学生体重（10.0-200.0）: ");
            if (scanner.hasNextDouble()) {
                weight = scanner.nextDouble();
                // 验证体重范围
                if (weight >= 10.0 && weight <= 200.0) {
                    validWeight = true;
                } else {
                    System.out.println("错误：体重必须在10.0-200.0之间，请重新输入。");
                }
            } else {
                System.out.println("错误：请输入有效的浮点数。");
                scanner.next(); // 清除无效输入
            }
        }
        
        // 清除输入缓冲区中的换行符，避免下一个输入被跳过
        scanner.nextLine();
        
        // 3. 输入全名（字符串）
        System.out.print("请输入学生全名: ");
        fullName = scanner.nextLine();
        
        // 按指定格式输出学生信息
        System.out.println("\n========== 学生信息 ==========");
        System.out.println("姓名: " + fullName);
        System.out.println("年龄: " + age);
        System.out.printf("体重: %.1f kg\n", weight);
        
        System.out.println("=============================");
        
        // 关闭Scanner
        scanner.close();
    }
}

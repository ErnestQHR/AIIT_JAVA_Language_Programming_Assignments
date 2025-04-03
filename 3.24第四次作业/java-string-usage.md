# Java String的八种常用用法

## 1. 字符串创建与初始化
```java
// 直接创建
String str1 = "Hello World";
// 使用构造方法
String str2 = new String("Hello World");
// 从字符数组创建
char[] charArray = {'H', 'e', 'l', 'l', 'o'};
String str3 = new String(charArray);
```

## 2. 字符串连接
```java
// 使用 + 运算符
String firstName = "John";
String lastName = "Doe";
String fullName = firstName + " " + lastName; // "John Doe"

// 使用concat()方法
String result = firstName.concat(" ").concat(lastName); // "John Doe"

// 使用StringBuilder（推荐用于多次连接操作）
StringBuilder sb = new StringBuilder();
sb.append(firstName).append(" ").append(lastName);
String name = sb.toString(); // "John Doe"
```

## 3. 字符串比较
```java
String str1 = "Hello";
String str2 = "hello";

// 比较内容是否相等
boolean isEqual = str1.equals(str2); // false
// 忽略大小写比较
boolean isEqualIgnoreCase = str1.equalsIgnoreCase(str2); // true

// 使用 == 比较引用
String s1 = "Java";
String s2 = "Java";
String s3 = new String("Java");
boolean b1 = (s1 == s2); // true（引用相同的字符串池中的对象）
boolean b2 = (s1 == s3); // false（引用不同的对象）
```

## 4. 字符串查找和获取
```java
String text = "Hello World";

// 获取长度
int length = text.length(); // 11

// 获取指定索引的字符
char ch = text.charAt(6); // 'W'

// 查找子字符串位置
int index = text.indexOf("World"); // 6
int lastIndex = text.lastIndexOf('o'); // 7

// 判断是否包含子字符串
boolean contains = text.contains("ello"); // true
```

## 5. 字符串替换
```java
String original = "Hello World";

// 替换字符或子字符串
String replaced = original.replace('l', 'L'); // "HeLLo WorLd"
String replacedStr = original.replace("World", "Java"); // "Hello Java"

// 替换全部匹配的子字符串
String text = "apple,apple,orange";
String replacedAll = text.replaceAll("apple", "banana"); // "banana,banana,orange"
```

## 6. 字符串截取和分割
```java
String text = "Hello World";

// 截取子字符串
String sub1 = text.substring(6); // "World"
String sub2 = text.substring(0, 5); // "Hello"

// 分割字符串
String csv = "apple,orange,banana";
String[] fruits = csv.split(","); // ["apple", "orange", "banana"]
```

## 7. 字符串转换
```java
// 大小写转换
String lower = "Hello".toLowerCase(); // "hello"
String upper = "Hello".toUpperCase(); // "HELLO"

// 去除首尾空格
String trimmed = "  Hello  ".trim(); // "Hello"

// 转换为字符数组
char[] chars = "Hello".toCharArray(); // ['H', 'e', 'l', 'l', 'o']

// 其他类型转字符串
String numStr = String.valueOf(123); // "123"
String boolStr = String.valueOf(true); // "true"
```

## 8. 字符串格式化
```java
// 使用format方法
String formatted = String.format("Name: %s, Age: %d", "John", 25);
// "Name: John, Age: 25"

// 使用printf方法(输出到控制台)
System.out.printf("Pi value is %.2f\n", Math.PI); // "Pi value is 3.14"

// 带占位符的格式化字符串
int id = 1001;
String name = "张三";
float score = 98.5f;
String info = String.format("学号: %d, 姓名: %s, 成绩: %.1f", id, name, score);
// "学号: 1001, 姓名: 张三, 成绩: 98.5"
```
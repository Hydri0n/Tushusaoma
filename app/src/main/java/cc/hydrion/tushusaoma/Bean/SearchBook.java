package cc.hydrion.tushusaoma.Bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Hydrion on 2018/4/19.
 */

public class SearchBook {

    /**
     * count : 20
     * start : 0
     * total : 292
     * books : [{"rating":{"max":10,"numRaters":2988,"average":"9.1","min":0},"subtitle":"","author":["[美] Bruce Eckel"],"pubdate":"2007-6","tags":[{"count":2874,"name":"Java","title":"Java"},{"count":1166,"name":"编程思想","title":"编程思想"},{"count":890,"name":"编程","title":"编程"},{"count":767,"name":"TinkingInJava","title":"TinkingInJava"},{"count":726,"name":"计算机","title":"计算机"},{"count":571,"name":"程序设计","title":"程序设计"},{"count":458,"name":"经典","title":"经典"},{"count":377,"name":"软件开发","title":"软件开发"}],"origin_title":"Thinking in Java","image":"https://img3.doubanio.com/view/subject/m/public/s27243455.jpg","binding":"平装","translator":["陈昊鹏"],"catalog":"读者评论\n前言\n简介\n第1章 对象导论\n1.1 抽象过程\n1.2 每个对象都有一个接口\n1.3 每个对象都提供服务\n1.4 被隐藏的具体实现\n1.5 复用具体实现\n1.6 继承\n1.6.1 \u201c是一个\u201d（is-a）与\u201c像是一个\u201d（is-like-a）关系\n1.7 伴随多态的可互换对象\n1.8 单根继承结构\n1.9 容器\n1.9.1 参数化类型（范型）\n1.10 对象的创建和生命期\n1.11 异常处理：处理错误\n1.12 并发编程\n1.13 Java与Internet\n1.13.1 Web是什么\n1.13.2 客户端编程\n1.13.3 服务器端编程\n1.22 总结\n第2章 一切都是对象\n2.1 用引用操纵对象\n2.2 必须由你创建所有对象\n2.2.1 存储到什么地方\n2.2.2 特例：基本类型\n2.2.3 Java中的数组\n2.3 永远不需要销毁对象\n2.3.1 作用域\n2.3.2 对象的作用域\n2.4 创建新的数据类型：类\n2.4.1 域和方法\n2.4.2 基本成员默认值\n2.5 方法、参数和返回值\n2.5.1 参数列表\n2.6 构建一个Java程序\n2.6.1 名字可见性\n2.6.2 运用其他构件\n2.6.3 static 关键字\n2.7 你的第一个Java程序\n编译和运行\n2.8 注释和嵌入式文档\n2.8.1 注释文档\n2.8.2 语法\n2.8.3 嵌入式HTML\n2.8.4 一些标签示例\n2.8.5 文档示例\n2.9 编码风格\n2.10 总结\n2.11 练习\n第3章 操作符\n3.1 更简单的打印语句\n3.2 使用Java操作符\n3.3 优先级\n3.4 赋值\n3.4.1 方法调用中的别名问题\n3.5 算术操作符\n3.5.1 一元加、减操作符\n3.6 自动递增和递减\n3.7 关系操作符\n3.7.1 测试对象的等价性\n3.8 逻辑操作符\n3.8.1 短路\n3.9 直接常量\n3.9.1 指数记数法\n3.10 按位操作符\n3.11 移位操作符\n3.12 三元操作符 if-else\n3.13 字符串操作符 + 和 +=\n3.14 使用操作符时常犯的错误\n3.15 类型转换操作符\n3.15.1 截尾和舍入\n3.15.2提升\n3.16 Java没有\u201csizeof\u201d\n3.17 操作符小结\n3.18 总结\n第4章 控制执行流程\n4.1 true和false\n4.2 if-else\n4.3 迭代\n4.3.1 do-while\n4.3.2 for\n4.3.3 逗号操作符\n4.4 Foreach语法\n4.5 return\n4.6 break和 continue\n4.7 臭名昭著的\u201cgoto\u201d\n4.8 switch\n4.9 总结\n第5章 初始化与清理\n5.1 用构造器确保初始化\n5.2 方法重载\n5.2.1 区分重载方法\n5.2.2 涉及基本类型的重载\n5.2.3 以返回值区分重载方法\n5.3 缺省构造器\n5.4 this关键字\n5.4.1 在构造器中调用构造器\n5.4.2 static的含义\n5.5 清理：终结处理和垃圾回收\n5.5.1 finalize()的用途何在\n5.5.2 你必须实施清理\n5.5.3 终结条件\n5.5.4 垃圾回收器如何工作\n5.6 成员初始化\n5.6.1 指定初始化\n5.7 构造器初始化\n5.7.1 初始化顺序\n5.7.2. 静态数据的初始化\n5.7.3. 显式的静态初始化\n5.7.4. 非静态实例初始化\n5.8 数组初始化\n5.8.1 可变参数列表\n5.9 枚举类型\n5.10 总结\n第6章 访问权限控制\n第7章 复用类\n第8章 多态\n第9章 接口\n第10章 内部类\n第11章 持有对象\n第12章 通过异常处理错误\n第13章 字符串\n第14章 类型信息\n第15章 泛型\n第16章 数组\n第17章 容器深入研究\n第18章 Java I/O系统\n第19章 枚举类型\n第20章 注解\n第21章 并发\n第22章 图形化用户界面\n附录A 补充材料\n可下载的补充材料\nThinking in C：Java的基础\nJava编程思想 研讨课\nHands-on Java研讨课CD\nThinking in Objects研讨课\nThinking in Enterprise Java\nThinking in Patterns(with Java)\nThinking in Patterns研讨课\n设计咨询与复审\n附录B 资源\n软件\n编辑器与IDE\n书籍\n分析与设计\nPython\n我的著作列表\n索引","pages":"880","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s27243455.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s27243455.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s27243455.jpg"},"alt":"https://book.douban.com/subject/2130190/","id":"2130190","publisher":"机械工业出版社","isbn10":"7111213823","isbn13":"9787111213826","title":"Java编程思想 （第4版）","url":"https://api.douban.com/v2/book/2130190","alt_title":"Thinking in Java","author_intro":"Bruce Eckel是MindView公司（www.MindView.net）的总裁，该公司向客户提供软件咨询和培训。他是C++标准委员会拥有表决权的成员之一，拥有应用物理学学士和计算机工程硕士学位。除本书外，他还是《C++编程思想》的作者，并与人合著了《C++编程思想 第2卷》（这两本书的英文影印版及中文版均已由机械工业出版社引进出版）及其他著作。他已经发表了150多篇论文，还经常参加世界各地的研讨会并进行演讲。","summary":"本书赢得了全球程序员的广泛赞誉，即使是最晦涩的概念，在Bruce Eckel的文字亲和力和小而直接的编程示例面前也会化解于无形。从Java的基础语法到最高级特性（深入的面向对象概念、多线程、自动项目构建、单元测试和调试等），本书都能逐步指导你轻松掌握。\n从本书获得的各项大奖以及来自世界各地的读者评论中，不难看出这是一本经典之作。本书的作者拥有多年教学经验，对C、C++以及Java语言都有独到、深入的见解，以通俗易懂及小而直接的示例解释了一个个晦涩抽象的概念。本书共22章，包括操作符、控制执行流程、访问权限控制、复用类、多态、接口、通过异常处理错误、字符串、泛型、数组、容器深入研究、Java I/O系统、枚举类型、并发以及图形化用户界面等内容。这些丰富的内容，包含了Java语言基础语法以及高级特性，适合各个层次的Java程序员阅读，同时也是高等院校讲授面向对象程序设计语言以及Java语言的绝佳教材和参考书。\n第4版特点：\n适合初学者与专业人员的经典的面向对象叙述方式，为更新的Java SE5/6增加了新的示例和章节。\n 测验框架显示程序输出。","series":{"id":"1163","title":"计算机科学丛书"},"price":"108.00元"},{"rating":{"max":10,"numRaters":636,"average":"8.6","min":0},"subtitle":"","author":["[美] Bruce Eckel"],"pubdate":"2002-9","tags":[{"count":444,"name":"Java","title":"Java"},{"count":143,"name":"编程思想","title":"编程思想"},{"count":104,"name":"编程","title":"编程"},{"count":98,"name":"计算机","title":"计算机"},{"count":83,"name":"软件开发","title":"软件开发"},{"count":78,"name":"程序设计","title":"程序设计"},{"count":55,"name":"经典","title":"经典"},{"count":40,"name":"IT","title":"IT"}],"origin_title":"Thinking in Java","image":"https://img1.doubanio.com/view/subject/m/public/s1085058.jpg","binding":"平装","translator":["侯捷"],"catalog":"出版者的话\n专家指导委员会\n读者回应\n关于《Thinking in C++》\n题献\n译序\nJava环境设定\n序言\n简介\n第一章 对象导论\n第二章 万事万物皆对象\n第三章 控制程序流程\n第四章 初始化与清理\n第五章 隐藏实现细目\n第六章 重复运用Classes\n第七章 多态\n第八章 接口与内隐类\n\u2026\u2026\n附录A 对象的传递和返回\n\u2026\u2026\n索引","pages":"809","images":{"small":"https://img1.doubanio.com/view/subject/s/public/s1085058.jpg","large":"https://img1.doubanio.com/view/subject/l/public/s1085058.jpg","medium":"https://img1.doubanio.com/view/subject/m/public/s1085058.jpg"},"alt":"https://book.douban.com/subject/1101158/","id":"1101158","publisher":"机械工业出版社","isbn10":"7111104412","isbn13":"9787111104414","title":"Java编程思想(第2版)","url":"https://api.douban.com/v2/book/1101158","alt_title":"Thinking in Java","author_intro":"Bruce Eckel是Thinking in C++和《C++编程思想》的作者。他有20年专业编程经验，并自1986年起教育人们如何撰写面向对象程序，足迹遍及全球，成为一位知名的C++教师和顾问，如今兼涉Java。Eckel是C++标准委员会拥有表决权的成员之一，曾经写过另五本面向对象编程书籍，发表过150篇以上的文章，是多本计算机杂志的专栏作家。","summary":"作者根据多年教学实践中发现的问题，通过简练的示例和叙述，阐明了在学习Java中特别容易混淆的诸多概念。与前一版相比，此第2版不但新增了Java2的语言特性，还根据语言的演变作出了彻底的更新，其中最主要的改变是第9章的群集。","series":{"id":"1163","title":"计算机科学丛书"},"price":"99.00元"},{"rating":{"max":10,"numRaters":612,"average":"9.0","min":0},"subtitle":"第3版","author":["[美] Bruce Eckel"],"pubdate":"2005-9","tags":[{"count":403,"name":"java","title":"java"},{"count":181,"name":"编程","title":"编程"},{"count":154,"name":"java编程思想","title":"java编程思想"},{"count":106,"name":"计算机","title":"计算机"},{"count":69,"name":"软件开发","title":"软件开发"},{"count":64,"name":"Programming","title":"Programming"},{"count":63,"name":"Java","title":"Java"},{"count":43,"name":"技术","title":"技术"}],"origin_title":"Thinking in Java","image":"https://img1.doubanio.com/view/subject/m/public/s1320039.jpg","binding":"平装","translator":["陈昊鹏","饶若楠"],"catalog":"","pages":"756","images":{"small":"https://img1.doubanio.com/view/subject/s/public/s1320039.jpg","large":"https://img1.doubanio.com/view/subject/l/public/s1320039.jpg","medium":"https://img1.doubanio.com/view/subject/m/public/s1320039.jpg"},"alt":"https://book.douban.com/subject/1313042/","id":"1313042","publisher":"机械工业出版社","isbn10":"711116220X","isbn13":"9787111162209","title":"Java编程思想","url":"https://api.douban.com/v2/book/1313042","alt_title":"Thinking in Java","author_intro":"","summary":"本书赢得了全球程序员的广泛赞誉，即使是最晦涩的概念，在Bruce Eckel的文字亲和力和小而直接的编程示例面前也会化解于无形。从Java的基础语法到最高级特性（深入的面向对象概念、多线程、自动项目构建、单元测试和调试等），本书都能逐步指导你轻松掌握。\n从本书获得的各项大奖以及来自世界各地的读者评论中，不难看出这是一本经典之作。本书的作者拥有多年教学经验，对C、C++以及Java语言都有独到、深入的见解，以通俗易懂及小而直接的示例解释了一个个晦涩抽象的概念。本书共22章，包括操作符、控制执行流程、访问权限控制、复用类、多态、接口、通过异常处理错误、字符串、泛型、数组、容器深入研究、Java I/O系统、枚举类型、并发以及图形化用户界面等内容。这些丰富的内容，包含了Java语言基础语法以及高级特性，适合各个层次的Java程序员阅读，同时也是高等院校讲授面向对象程序设计语言以及Java语言的绝佳教材和参考书。","series":{"id":"1163","title":"计算机科学丛书"},"price":"95.00元"},{"rating":{"max":10,"numRaters":144,"average":"9.3","min":0},"subtitle":"英文版·第4版","author":["埃克尔"],"pubdate":"2007-5-1","tags":[{"count":113,"name":"Java","title":"Java"},{"count":61,"name":"编程","title":"编程"},{"count":30,"name":"计算机","title":"计算机"},{"count":21,"name":"程序设计","title":"程序设计"},{"count":21,"name":"OOP","title":"OOP"},{"count":20,"name":"编程语言","title":"编程语言"},{"count":20,"name":"经典","title":"经典"},{"count":17,"name":"programming","title":"programming"}],"origin_title":"Thinking in Java","image":"https://img3.doubanio.com/view/subject/m/public/s27969801.jpg","binding":"平装","translator":[],"catalog":"","pages":"1482","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s27969801.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s27969801.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s27969801.jpg"},"alt":"https://book.douban.com/subject/2061172/","id":"2061172","publisher":"机械工业出版社","isbn10":"7111212509","isbn13":"9787111212508","title":"Java编程思想","url":"https://api.douban.com/v2/book/2061172","alt_title":"Thinking in Java","author_intro":"","summary":"《Java编程思想(英文版\u2022第4版)》内容简介：特色：1.适合初学者与专业人员的经典的面向对象的叙述方式；为更新的Java SE5/6的相关内容增加了新的示例和章节。2.测验框架显示程序输出。3.设计模式贯穿于众多示例中：适配器、桥接器、职责链、命令、装饰器、外观、工厂方法、享元、点名、数据传输对象、空对象、代理、单例、状态、策略、模板方法以及访问者。4.为数据传输引入了XML；为用户界面引入了SWT和Flash。5.重新撰写了有关并发的章节，使您能牢牢地掌握线程的相关知识。6.专门为第4版以及Java SE5/6重写了在700多个编译文件中的500多个程序。7.支持网站包含了所有源代码、带注解的解决方案指南、网络日志以及多媒体学习资料。8.完全覆盖了所有基础知识，同时也论述了高级特性。9.详细彻底地阐述了面向对象原理。10.在线可获得Java讲座CD，包含Bruce Eckel的全部多媒体讲座。","series":{"id":"1895","title":"经典原版书库"},"price":"79.00元"},{"rating":{"max":10,"numRaters":104,"average":"8.9","min":0},"subtitle":"","author":["埃克尔"],"pubdate":"2004-1","tags":[{"count":59,"name":"java","title":"java"},{"count":17,"name":"编程","title":"编程"},{"count":15,"name":"计算机","title":"计算机"},{"count":15,"name":"编程语言","title":"编程语言"},{"count":9,"name":"软件开发","title":"软件开发"},{"count":9,"name":"programming","title":"programming"},{"count":8,"name":"经典教程","title":"经典教程"},{"count":6,"name":"计算机科学","title":"计算机科学"}],"origin_title":"Thinking in Java","image":"https://img3.doubanio.com/view/subject/m/public/s1157073.jpg","binding":"平装（带盘）","translator":[],"catalog":"","pages":"1119","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s1157073.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s1157073.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s1157073.jpg"},"alt":"https://book.douban.com/subject/1140257/","id":"1140257","publisher":"机械工业出版社","isbn10":"7111131657","isbn13":"9787111131656","title":"Java编程思想","url":"https://api.douban.com/v2/book/1140257","alt_title":"Thinking in Java","author_intro":"","summary":"本书赢得了全球程序员的广泛赞誉，即使是最晦涩的概念，在Bruce Eckel的文字亲和力和小而直接的编程示例面前也会化解于无形。从Java的基础语法到最高级特性，本书能逐步指导你轻松掌握。 \n　　本书经典的Java介绍，完全针对Java1.4版本更新，并增加了许多新主题。350多个可运行的Java程序，15000多行代码。讲述Java的同时着得阐释面向对象原理。支持网站包括所有源代码、带注释的解决方案指南、评论以及其他资源。随书光盘包括可用于Windows、Linux和Mac的完整的Fundations for Java多媒体研讨教材。本书的全面性，适用于初学者；本书的深入性，适用于专家。随书光盘含有15个小时的Bruce Eckel演讲课程。","series":{"id":"1895","title":"经典原版书库"},"price":"66.00元"},{"rating":{"max":10,"numRaters":20,"average":"7.8","min":0},"subtitle":"","author":["美 Heaton J."],"pubdate":"2002-7","tags":[{"count":42,"name":"java","title":"java"},{"count":22,"name":"爬虫","title":"爬虫"},{"count":15,"name":"spider","title":"spider"},{"count":12,"name":"网络机器人","title":"网络机器人"},{"count":11,"name":"搜索引擎","title":"搜索引擎"},{"count":10,"name":"计算机","title":"计算机"},{"count":9,"name":"编程","title":"编程"},{"count":9,"name":"web","title":"web"}],"origin_title":"","image":"https://img3.doubanio.com/view/subject/m/public/s1083584.jpg","binding":"","translator":[],"catalog":"第1章\nJava套接字编程技术\n套接字家族\n网络编程\nJava I/O编程技术\n代理的问题\nJava中的套接字编程\n客户端套接字\n","pages":"420","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s1083584.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s1083584.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s1083584.jpg"},"alt":"https://book.douban.com/subject/1099242/","id":"1099242","publisher":"电子工业出版社","isbn10":"750537740X","isbn13":"9787505377400","title":"网络机器人Java编程指南","url":"https://api.douban.com/v2/book/1099242","alt_title":"","author_intro":"","summary":"这是一本研究如何实现具有Web访问能力的网络机器人的书。该书从Internet编程的基本原理出发，深入浅出、循序渐进地阐述了网络机器人程序Spider、Bot、Aggregator的实现技术，并分析了每种程序的优点及适用场合。本书提供了大量的有效源代码，并对这些代码进行了详细的分析。通过本书的介绍，你可以很方便地利用这些技术，设计并实现网络蜘蛛或网络信息搜索器等机器人程序。\n适合于具有","price":"44.00元"},{"rating":{"max":10,"numRaters":51,"average":"8.2","min":0},"subtitle":"","author":["(美)Bruce Eckel"],"pubdate":"1999-04","tags":[{"count":23,"name":"java","title":"java"},{"count":10,"name":"编程思想","title":"编程思想"},{"count":8,"name":"计算机","title":"计算机"},{"count":8,"name":"程序设计","title":"程序设计"},{"count":4,"name":"编程","title":"编程"},{"count":4,"name":"OO","title":"OO"},{"count":3,"name":"编程与语言","title":"编程与语言"},{"count":3,"name":"Thinking","title":"Thinking"}],"origin_title":"","image":"https://img3.doubanio.com/view/subject/m/public/s1183463.jpg","binding":"平装","translator":["京京工作室"],"catalog":"前言\n第1章 对象入门\n1.1 抽象的进步\n1.2对象的接口\n1.3实现方案的隐藏\n1.4方案的重复使用\n1.5继承：重新使用接口\n1.5.1改善基础类\n1.5.2等价与类似关系\n1.6多形对象的互换使用\n1.6.1动态绑定\n1.6.2抽象的基础类和接口\n1.7 对象的创建和存在时间\n1.7.1集合与继承器\n1.7.2单根结构\n1.7.3集合库与方便使用集合\n1.7.4清除时的困境：由谁负责清除？\n1.8违例控制：解决错误\n1.9多线程\n1.10永久性\n1.11Java和因特网\n1.11.1什么是Web\n1.11.2客户端编程\n1.11.3服务器端编程\n1.11.4一个独立的领域：应用程序\n1.12分析和设计\n1.12.1不要迷失\n1.12.2阶段0：拟出一个计划\n1.12.3阶段1：要制作什么\n1.12.4阶段2：如何构建\n1.12.5阶段3：开始创建\n1.12.6阶段4：校订\n1.12.7计划的回报\n1.13Java还是C＋＋\n第2章 一切都是对象\n2.1用句柄操纵对象\n2.2所有对象都必须创建\n2.2.1保存到什么地方\n2.2.2特殊情况：主要类型\n2.2.3Java的数组\n2.3绝对不要清除对象\n2.3.1作用域\n2.3.2对象的作用域\n2.4新建数据类型：类\n2.5方法、自变量和返回值\n2.6构建Java程序\n2.6.1名字的可见性\n2.6.2使用其他组件\n2.6.3static关键字\n2.7我们的第一个Java程序\n2.8注释和嵌入文档\n2.8.1注释文档\n2.8.2具体语法\n2.8.3嵌入HTML\n2.8.4＠see：引用其他类\n2.8.5类文档标记\n2.8.6变量文档标记\n2.8.7方法文档标记\n2.8.8文档示例\n2.9编码样式\n2.10总结\n2.11练习\n第3章 控制程序流程\n3.1使用Java运算符\n3.1.1优先级\n3.1.2赋值\n3.1.3算术运算符\n3.1.4自动递增和递减\n3.1.5关系运算符\n3.1.6逻辑运算符\n3.1.7按位运算符\n3.1.8移位运算符\n3.1.9三元if－else运算符\n3.1.10逗号运算符\n3.1.11字串运算符＋\n3.1.12运算符常规操作规则\n3.1.13造型运算符\n3.1.14 Java没有\u201csizeof\u201d\n3.1.15复习计算顺序\n3.1.16运算符总结\n3.2执行控制\n3.2.1真和假\n3.2.2if－else\n3.2.3反复\n3.2.4do－while\n3.2.5for\n3.2.6中断和继续\n3.2.7开关\n3.3总结\n3.4练习\n第4章 初始化和清除\n4.1用构建器自动初始化\n4.2方法过载\n4.2.1区分过载方法\n4.2.2主类型的过载\n4.2.3返回值过载\n4.2.4默认构建器\n4.2.5 this关键字\n4.3清除：收尾和垃圾收集\n4.3.1 finalize（）用途何在\n4.3.2必须执行清除\n4.4成员初始化\n4.4.1规定初始化\n4.4.2构建器初始化\n4.5数组初始化\n4.6总结\n4.7 练习\n第5章 隐藏实施过程\n5.1包：库单元\n5.1.1创建独一无二的包名\n5.1.2自定义工具库\n5.1.3利用导入改变行为\n5.1.4包的停用\n5.2Java访问指示符\n5.2.1\u201c友好的\u201d\n5.2.2public：接口访问\n5.2.3private：不能接触\n5.2.4protected：\u201c友好的一种\u201d\n5.3接口与实现\n5.4类访问\n5.5总结\n5.6练习\n第6章 类再生\n6.1合成的语法\n6.2继承的语法\n6.3合成与继承的结合\n6.3.1确保正确的清除\n6.3.2名字的隐藏\n6.4到底选择合成还是继承\n6.5protected\n6.6累积开发\n6.7上溯造型\n6.8final关键字\n6.8.1final数据\n6.8.2final方法\n6.8.3final类\n6.8.4final的注意事项\n6.9初始化和类装载\n6.10总结\n6.11练习\n第7章 多形性\n7.1上溯造型\n7.2深入理解\n7.2.1方法调用的绑定\n7.2.2产生正确的行为\n7.2.3扩展性\n7.3覆盖与过载\n7.4抽象类和方法\n7.5接口\n7.5.1Java的\u201c多重继承\u201d\n7.5.2通过继承扩展接口\n7.5.3常数分组\n7.5.4初始化接口中的字段\n7.6 内部类\n7.6.1内部类和上溯造型\n7.6.2方法和作用域中的内部类\n7.6.3链接到外部类\n7.6.4static内部类\n7.6.5引用外部类对象\n7.6.6从内部类继承\n7.6.7内部类可以覆盖吗？\n7.6.8内部类标识符\n7.6.9为什么要用内部类：控制框架\n7.7构建器和多形性\n7.7.1构建器的调用顺序\n7.7.2继承和finalize（）\n7.7.3构建器内部的多形性方法的行为\n7.8通过继承进行设计\n7.8.1纯继承与扩展\n7.8.2下溯造型与运行期类型标识\n7.9 总结\n7.10 练习\n第8章 对象的容纳\n8.1数组\n8.1.1数组和第一类对象\n8.1.2数组的返回\n8.2集合\n8.3枚举器（反复器）\n8.4集合的类型\n8.4.1Vector\n8.4.2BitSet\n8.4.3Stack\n8.4.4Hashtable\n8.4.5再论枚举器\n8.5排序\n8.6通用集合库\n8.7新集合\n8.7.1使用Collections\n8.7.2使用Lists\n8.7.3使用Sets\n8.7.4使用Maps\n8.7.5决定实施方案\n8.7.6未支持的操作\n8.7.7排序和搜索\n8.7.8实用工具\n8.8总结\n8.9练习\n第9章 违例差错控制\n9.1基本违例\n9.2违例的捕获\n9.2.1try块\n9.2.2违例控制器\n9.2.3违例规范\n9.2.4捕获所有违例\n9.2.5重新\u201c掷\u201d出违例\n9.3标准Java违例\n9.4创建自己的违例\n9.5违例的限制\n9.6用finally清除\n9.6.1用finally做什么？\n9.6.2缺点：丢失的违例\n9.7构建器\n9.8违例匹配\n9.9总结\n9.10练习\n第10章 JavaIO系统\n10.1输入和输出\n10.1.1InputStream的类型\n10.1.2OutputStream的类型\n10.2增添属性和有用的接口\n10.2.1通过FilterInputStream从InputStream里读人数据\n10.2.2通过FilterOutputStream向Output Strea－m里写入数据\n10.3本身的缺陷：RandomAccessFile\n10.4File类\n10.4.1目录列表器\n10.4.2检查与创建目录\n10.5IO流的典型应用\n10.5.1输入流\n10.5.2输出流\n10.5.3快捷文件处理\n10.5.4从标准输入中读取数据\n10.5.5管道数据流\n10.6StreamTokenizer\n10.7Java1.1的IO流\n10.7.1数据的发起与接收\n10.7.2修改数据流的行为\n10.7.3未改变的类\n10.7.4 一个例子\n10.7.5重导向标准IO\n10.8压缩\n10.8.1用GZIP进行简单压缩\n10.8.2用Zip进行多文件保存\n10.8.3Java归档（jar）实用程序\n10.9对象序列化\n10.9.1寻找类\n10.9.2序列化的控制\n10.9.3利用\u201c持久性\u201d\n10.10 总结\n10.11练习\n第11章 运行期类型鉴定\n11.1对RTTI的需要\n11.1.1Class对象\n11.1.2造型前的检查\n11.2RTTI语法\n11.3反射：运行期类信息\n11.4总结\n11.5练习\n第12章 传递和返回对象\n12.1传递句柄\n12.2制作本地副本\n12.2.1按值传递\n12.2.2克隆对象\n12.2.3使类具有克隆能力\n12.2.4成功的克隆\n12.2.5Object.clone（）的效果\n12.2.6克隆合成对象\n12.2.7用Vector进行深层复制\n12.2.8通过序列化进行深层复制\n12.2.9使克隆具有更大的深度\n12.2.10为什么有这个奇怪的设计\n12.3克隆的控制\n12.4只读类\n12.4.1创建只读类\n12.4.2\u201c一成不变\u201d的弊端\n12.4.3不变字串\n12.4.4String和String Buffer类\n12.4.5字串的特殊性\n12.5总结\n12.6练习\n第13章 创建窗口和程序片\n13.1为何要用AWT？\n13.2基本程序片\n13.2.1程序片的测试\n13.2.2一个更图形化的例子\n13.2.3框架方法的演示\n13.3制作按钮\n13.4捕获事件\n13.5文本字段\n13.6文本区域\n13.7标签\n13.8复选框\n13.9单选钮\n13.10下拉列表\n13.11列表框\n13.12布局的控制\n13.12.1FlowLayout\n13.12.2BorderLayout\n13.12.3GridLayout\n13.12.4CardLayout\n13.12.5GridBagLayout\n13.13action的替代品\n13.14程序片的局限\n13.15视窗化应用\n13.15.1菜单\n13.15.2对话框\n13.16新型AWT\n13.16.1新的事件模型\n13.16.2事件和接收者类型\n13.16.3用Java1.1AWT制作窗口和程序片\n13.16.4再研究一下以前的例子\n13.16.5动态绑定事件\n13.16.6将事务逻辑与UI逻辑区分开\n13.16.7推荐编码方法\n13.17Java1.1用户接口API\n13.17.1桌面颜色\n13.17.2打印\n13.17.3剪贴板\n13.18可视编程和Beans\n13.18.1什么是Bean？\n13.18.2用Introspector提取BeanInfo\n13.18.3一个更复杂的Bean\n13.18.4Bean的封装\n13.18.5更复杂的Bean支持\n13.18.6Bean更多的知识\n13.19Swing入门\n13.19.1Swing有哪些优点\n13.19.2方便的转换\n13.19.3功能框架\n13.19.4功能提示\n13.19.5边框\n13.19.6按钮\n13.19.7按钮组\n13.19.8图标\n13.19.9菜单\n13.19.10弹出式菜单\n13.19.11列表框和组合框\n13.19.12滑块和进程条\n13.19.13树\n13.19.14表格\n13.19.15卡片式对话框\n13.19.16Swing消息框\n13.19.17Swing更多的知识\n13.20 总结\n13.21 练习\n第14章 多线程\n14.1反应灵敏的用户界面\n14.1.1从线程继承\n14.1.2针对用户界面的多线程\n14.1.3用主类合并线程\n14.1.4制作多个线程\n14.1.5Daemon线程\n14.2共享有限的资源\n14.2.1资源访问的错误方法\n14.2.2Java如何共享资源\n14.2.3回顾JavaBeans\n14.3堵塞\n14.3.1为何会堵塞\n14.3.2死锁\n14.4优先级\n14.5回顾runnable\n14.6总结\n14.7练习\n第15章 网络编程\n15.1机器的标识\n15.1.1服务器和客户机\n15.1.2端口：机器内独一无二的场所\n15.2套接字\n15.3服务多个客户\n15.4数据报\n15.5一个Web应用\n15.5.1服务器应用\n15.5.2NameSender程序片\n15.5.3要注意的问题\n15.6Java与CGI的沟通\n15.6.1CGI数据的编码\n15.6.2程序片\n15.6.3用C＋＋写的CGI程序\n15.6.4POST的概念\n15.7用JDBC连接数据库\n15.7.1让示例运行起来\n15.7.2查找程序的GUI版本\n15.7.3JDBCAPI为何如此复杂\n15.8远程方法\n15.8.1远程接口概念\n15.8.2远程接口的实施\n15.8.3创建根与干\n15.8.4使用远程对象\n15.8.5RMI的替选方案\n15.9总结\n15.10练习\n第16章 设计范式\n16.1范式的概念\n16.1.1单子\n16.1.2范式分类\n16.2观察器范式\n16.3模拟垃圾回收站\n16.4改进设计\n16.4.1\u201c制作更多的对象\u201d\n16.4.2用于原型创建的一个范式\n16.5抽象的应用\n16.6多重派遣\n16.7访问器范式\n16.8RTTI真的有害吗？\n16.9总结\n16.10练习\n第17章 项目\n17.1文字处理\n17.1.1提取代码列表\n17.1.2检查大小写样式\n17.2方法查找工具\n17.3复杂性理论\n17.4总结\n17.5练习\n附录A 使用非Java代码\n附录B C＋＋和Java的对比\n附录CJava编程规则\n附录D 性能\n附录E 关于垃圾收集的一些话","pages":"665","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s1183463.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s1183463.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s1183463.jpg"},"alt":"https://book.douban.com/subject/1044101/","id":"1044101","publisher":"机械工业出版社","isbn10":"711107064X","isbn13":"9787111070641","title":"Java编程思想","url":"https://api.douban.com/v2/book/1044101","alt_title":"","author_intro":"","summary":"\n      ","price":"60.00"},{"rating":{"max":10,"numRaters":32,"average":"8.2","min":0},"subtitle":"","author":["[美]KenArnold等"],"pubdate":"2003-12","tags":[{"count":42,"name":"Java","title":"Java"},{"count":11,"name":"计算机","title":"计算机"},{"count":8,"name":"编程语言","title":"编程语言"},{"count":5,"name":"编程","title":"编程"},{"count":2,"name":"计算机科学","title":"计算机科学"},{"count":2,"name":"programming","title":"programming"},{"count":2,"name":"language","title":"language"},{"count":1,"name":"重读大学计划","title":"重读大学计划"}],"origin_title":"","image":"https://img1.doubanio.com/view/subject/m/public/s4423847.jpg","binding":"","translator":[],"catalog":"","pages":"567","images":{"small":"https://img1.doubanio.com/view/subject/s/public/s4423847.jpg","large":"https://img1.doubanio.com/view/subject/l/public/s4423847.jpg","medium":"https://img1.doubanio.com/view/subject/m/public/s4423847.jpg"},"alt":"https://book.douban.com/subject/1230098/","id":"1230098","publisher":"中国电力出版社","isbn10":"7508315162","isbn13":"9787508315164","title":"Java编程语言","url":"https://api.douban.com/v2/book/1230098","alt_title":"","author_intro":"","summary":"","series":{"id":"41187","title":"开发大师系列"},"price":"45.00元"},{"rating":{"max":10,"numRaters":30,"average":"8.9","min":0},"subtitle":"","author":[],"pubdate":"2003-8-1","tags":[{"count":22,"name":"JAVA","title":"JAVA"},{"count":10,"name":"程序设计","title":"程序设计"},{"count":9,"name":"思想","title":"思想"},{"count":7,"name":"编程","title":"编程"},{"count":7,"name":"java基础","title":"java基础"},{"count":4,"name":"计算机科学","title":"计算机科学"},{"count":2,"name":"计算机","title":"计算机"},{"count":2,"name":"思维","title":"思维"}],"origin_title":"","image":"https://img1.doubanio.com/view/subject/m/public/s28459968.jpg","binding":"","translator":[],"catalog":"","pages":"","images":{"small":"https://img1.doubanio.com/view/subject/s/public/s28459968.jpg","large":"https://img1.doubanio.com/view/subject/l/public/s28459968.jpg","medium":"https://img1.doubanio.com/view/subject/m/public/s28459968.jpg"},"alt":"https://book.douban.com/subject/1723199/","id":"1723199","publisher":"机械工业出版社","isbn10":"7111002873","isbn13":"9787111002871","title":"Java编程思想 Thinking in Java","url":"https://api.douban.com/v2/book/1723199","alt_title":"","author_intro":"","summary":"","price":"260"},{"rating":{"max":10,"numRaters":11,"average":"7.2","min":0},"subtitle":"","author":["高斯林"],"pubdate":"2006-7","tags":[{"count":28,"name":"Java","title":"Java"},{"count":8,"name":"编程","title":"编程"},{"count":7,"name":"计算机","title":"计算机"},{"count":6,"name":"程序设计","title":"程序设计"},{"count":2,"name":"经典","title":"经典"},{"count":2,"name":"programming","title":"programming"},{"count":1,"name":"软件开发","title":"软件开发"},{"count":1,"name":"软件工程","title":"软件工程"}],"origin_title":"The Java Language Specification, 3rd Ed.","image":"https://img3.doubanio.com/view/subject/m/public/s24452452.jpg","binding":"","translator":["陈宗斌","沈金河"],"catalog":"前言\n第二版 前言\n第三版 前言\n第1章 简介\n1.1 示例程序\n1.2 符号\n1.3 预定义类和接口的关系\n1.4 参考文献\n第2章 语法\n2.1 与环境无关的语法\n2.2 词法语法\n2.3 语义语法\n2.4 .语法符号\n第3章 词法结构\n3.1 Unicode\n3.2 词法转换\n3.3 Unicode转义符\n3.4 行终止符\n3.5 输入元素和标记\n3.6 空白\n3.7 注释\n3.8 标识符\n3.9 关键字\n3.10 字面值\n3.11 分隔符\n3.12 运算符\n第4章 类型、值和变量\n4.1 各种类型和值\n4.2 基本类型和值\n4.3 引用类型和值\n4.4 类型变量\n4.5 参数化类型\n4.6 类型擦除\n4.7 可具体化的类型\n4.8 原生类型\n4.9 交集类型\n4.10 子类型化\n4.11 在何处使用类型\n4.12 变量\n第5章 转换和提升\n5.1 转换的种类\n5.2 赋值转换\n5.3 方法调用转换\n5.4 字符串转换\n5.5 强制转换\n5.6 数值提升\n第6章 名称\n6.1 声明\n6.2 名称和标识符\n6.3 声明的作用域\n6.4 成员和继承\n6.5 确定名称的含义\n6.6 访问控制\n6.7 完全限定的名称和规范名称\n6.8 命名约定\n第7章 包\n7.1 包成员\n7.2 包的主机支持\n7.3 编译单元\n7.4 包声明\n7.5 导入声明\n7.6 顶级类型声明\n7.7 惟一的包名称\n第8章 类\n8.1 类声明\n8.2 类成员\n8.3 字段声明\n8.4 方法声明\n8.5 成员类型声明\n8.6 实例初始化语句\n8.7 静态初始化语句\n8.8 构造函数声明\n8.9 枚举\n第9章 接口\n9.1 接口声明\n9.2 接口成员\n9.3 字段(常量）声明\n9.4 抽象方法声明\n9.5 成员类型声明\n9.6 注释类型\n9.7 注释\n第10章 数组\n10.1 数组类型\n10.2 数组变量\n10.3 数组创建\n10.4 数组访问\n10.5 数组：一个简单的示例\n10.6 数组初始化语句\n10.7 数组成员\n10.8 数组的Class对象\n10.9 字符的数组不是一个String\n10.10 数组存储异常\n第11章 异常\n11.1 异常的起因\n11.2 异常的编译时检查\n11.3 异常处理\n11.4 异常的示例\n11.5 异常层次结构\n第12章 执行\n12.1 虚拟机启动\n12.2 加载类和接口\n12.3 链接类和接口\n12.4 初始化类和接口\n12.5 创建新的类实例\n12.6 类实例的终结\n12.7 卸载类和接口\n12.8 程序退出\n第13章 二进制兼容性\n13.1 二进制的形式\n13.2 二进制兼容性是什么，不是什么\n13.3 包的演变\n13.4 类的演变\n13.5 接口的演变\n第14章 块和语句\n14.1 语句的正常结束和突然结束\n14.2 块\n14.3 本地类声明\n14.4 局部变量声明语句\n14.5 语句\n14.6 空语句\n14.7 标签语句\n14.8 表达式语句\n14.9 if语句\n14.10 assert语句\n14.11 SWitch语句\n14.12 while语句\n14.13 do语句\n14.14 for语句\n14.15 break语句\n14.16 continue语句\n14.17 return语句\n14.18 throw语句\n14.19 synchronized语句\n14.20 try语句\n14.21 不可到达语句\n第15章 表达式\n15.1 计算、表示和结果\n15.2 变量作为值\n15.3 表达式的类型\n15.4 精确浮点数表达式\n15.5 表达式和运行时检查\n15.6 计算的正常和突然结束\n15.7 求值顺序\n15.8 主表达式\n15.9 类实例创建表达式\n15.10 数组创建表达式\n15.11 字段访问表达式\n15.12 内存调用表达式\n15.13 数组访问表达式\n15.14 后缀表达式\n15.15 一元运算符\n15.16 强制转换表达式\n15.17 乘法运算符\n15.18 加运算符\n15.19 移位运算符\n15.20 关系运算符\n15.21 相等运算符\n15.22 位和逻辑运算符\n15.23 条件与运算符&&\n15.24 条件或运算符2\n15.25 条件运算符?\n15.26 赋值运算符\n15.27 表达式\n15.28 常量表达式\n第16章 明确赋值\n16.1 明确赋值和表达式\n16.2 语明确赋值和语句\n16.3 明确赋值和参数\n16.4 明确赋值和数组初始化方法\n16.5 明确赋值和枚举常量\n16.6 明确赋值和匿名类\n16.7 明确赋值和成员类型\n16.8 明确赋值和静态初始化方法\n16.9 明确赋值、构造函数和实例初始化方法\n第17章 线程和锁\n17.1 锁\n17.2 示例中的符号\n17.3 不正确同步的程序出现意外行为\n17.4 内存模型\n17.5 Final字段语义\n17.6 字分开\n17.7 double和long的非原子处理\n17.8 等待集合和通知\n17.9 休眠和转交\n第18章 语法\n18.1 Java编程语言的语法","pages":"448","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s24452452.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s24452452.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s24452452.jpg"},"alt":"https://book.douban.com/subject/1837615/","id":"1837615","publisher":"中国电力出版社","isbn10":"7508342925","isbn13":"9787508342924","title":"Java编程规范","url":"https://api.douban.com/v2/book/1837615","alt_title":"The Java Language Specification, 3rd Ed.","author_intro":"","summary":"本书由Java技术的发明者编写，是Java编程语言的权威性技术指南。如果你想知识语言之构造的精确含义，本书是最好的资源。本书全面、准确而详细地论及了Java编程语言。它提供了对于自前一版以来添加的所有新特性的完整描述，包括泛型、注释、断言、自动装臬、枚举、for-each循环、可变元数方法和静态导入子句。\n    本书试图详细说明Java语言的语法和语义规范。编者试图在每一种语言结构的行为，以便让所有实现都接受同一个程序。除了时间相关性或无法确定因素之外，如果有足够的时间和足够的内存空间，用Java编程语言所写的程序应该可以在所有机器和所有实现中计算出相同的结果。","price":"49.80元"},{"rating":{"max":10,"numRaters":23,"average":"7.5","min":0},"subtitle":"","author":["徐明浩"],"pubdate":"2005-10","tags":[{"count":19,"name":"Java","title":"Java"},{"count":12,"name":"Java编程基础、应用与实例","title":"Java编程基础、应用与实例"},{"count":10,"name":"java基础","title":"java基础"},{"count":3,"name":"是","title":"是"},{"count":2,"name":"计算机","title":"计算机"},{"count":2,"name":"编程","title":"编程"},{"count":2,"name":"java","title":"java"},{"count":2,"name":"JAVA","title":"JAVA"}],"origin_title":"","image":"https://img3.doubanio.com/view/subject/m/public/s24977355.jpg","binding":"","translator":[],"catalog":"","pages":"451","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s24977355.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s24977355.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s24977355.jpg"},"alt":"https://book.douban.com/subject/1449028/","id":"1449028","publisher":"人民邮电出版社","isbn10":"7115136459","isbn13":"9787115136459","title":"Java编程基础、应用与实例","url":"https://api.douban.com/v2/book/1449028","alt_title":"","author_intro":"","summary":"本书通过丰富的实例讲授Java语言的基础和程序设计方法。\n    全书共22章。第1到19章分别介绍了Java语言基础知识、对象和类的概念、Java语言的基本语法、流程控制、数组、对象和方法、继承、抽象类和接口、内隐类、异常处理、API、输入输出、线程、AWT程序设计和事件处理、Java 2D图形、Applet等内容。第20章通过3个完整的实例介绍了Applet游戏的设计。第21章通过一个游戏实例介绍网络程序设计基础。第22章用五子棋的实例介绍了网络游戏的制作。书中每章后面的\"巩固练习\"部分，给出了精心挑选的练习题，帮助读者巩固本章所学知识，进一步提高Java编程水平。附录部分给出了书中\u201c独立完成\u201d练习的提示，说明了JCreator的安装和使用方法，并且对Swing和JDBC程序设计方法进行了简要说明。\n    本书的示例能够把Java程序设计原理以浅显易懂的方式呈现给读者。后3章注重对Java热门应用领域的介绍和讨论，通过完整的例子教给读者Applet游戏和网络游戏的制作方法。 \n    本书适合Java编程语言初学者阅读。","price":"49.00元"},{"rating":{"max":10,"numRaters":15,"average":"7.6","min":0},"subtitle":"","author":["Alan Vermeulan","Scott W. Ambler"],"pubdate":"2008.10","tags":[{"count":13,"name":"Java","title":"Java"},{"count":6,"name":"programming","title":"programming"},{"count":5,"name":"编程","title":"编程"},{"count":4,"name":"程序设计","title":"程序设计"},{"count":2,"name":"IT","title":"IT"},{"count":1,"name":"计算机","title":"计算机"},{"count":1,"name":"ww","title":"ww"},{"count":1,"name":"autorun","title":"autorun"}],"origin_title":"","image":"https://img3.doubanio.com/view/subject/m/public/s3232496.jpg","binding":"","translator":["曹铁鸥"],"catalog":"","pages":"192","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s3232496.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s3232496.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s3232496.jpg"},"alt":"https://book.douban.com/subject/3190527/","id":"3190527","publisher":"人民邮电出版社","isbn10":"7115177686","isbn13":"9787115177681","title":"Java编程风格","url":"https://api.douban.com/v2/book/3190527","alt_title":"","author_intro":"本书由世界著名的软件工程专家Scott W. Ambler和Rogue Wave公司包括副总裁Allan Vermeulen在内的6位资深程序员联袂奉献。\nScott W. Ambler 国际知名的软件过程改进顾问，敏捷建模、敏捷数据、企业统一过程、敏捷统一过程方法学的创始人。Scott经常在Software Development、JavaOne、OOPSLA和DAMA等会议上进行主题演讲，他写作（或与人合著）出版的图书包括Agile Modeling、 Agile Database Techniques、The Object Primer，Third Edition等，并多次获奖。可以通过他的个人网站www.ambysoft.com与他联系。","summary":"曹铁鸥  网络ID Autorun，2005年毕业于中央财经大学信息学院，硕士学位，现任职于新华社信息部对外专线，豆瓣知名文艺男青年。个人博客：蚌病生珠（http://caotieou.com）。","price":"29.00元"},{"rating":{"max":10,"numRaters":0,"average":"0.0","min":0},"subtitle":"","author":["法瑞尔"],"pubdate":"2012-1","tags":[{"count":1,"name":"d","title":"d"},{"count":1,"name":"JAVA","title":"JAVA"}],"origin_title":"","image":"https://img1.doubanio.com/view/subject/m/public/s7657609.jpg","binding":"","translator":[],"catalog":"","pages":"700","images":{"small":"https://img1.doubanio.com/view/subject/s/public/s7657609.jpg","large":"https://img1.doubanio.com/view/subject/l/public/s7657609.jpg","medium":"https://img1.doubanio.com/view/subject/m/public/s7657609.jpg"},"alt":"https://book.douban.com/subject/10354542/","id":"10354542","publisher":"","isbn10":"7030329104","isbn13":"9787030329103","title":"JAVA编程","url":"https://api.douban.com/v2/book/10354542","alt_title":"","author_intro":"","summary":"《JAVA编程(第五版)(英文影印版))》为入门级程序员提供了用JAVA编程语言开发应用程序的方法。JAVA语言深受专业程序员青睐，因为它可以用来制造在视觉上有趣的图形用户界面（GUI）和互联网应用程序。《JAVA编程(第五版)(英文影印版))》也为学生在学习基本的结构化和面向对象程序设计技术的前提下，尽快开始程序编制提供了良好的指导。 \n《JAVA编程(第五版)(英文影印版))》可作为计算机专业的双语教材或教学参考书，也可供工程技术人员参考。","series":{"id":"19731","title":"国外信息科学与技术经典图书系列"},"price":"99.00元"},{"rating":{"max":10,"numRaters":27,"average":"8.3","min":0},"subtitle":"","author":["Bruce Eckel"],"pubdate":"2002-1-1","tags":[{"count":12,"name":"JAVA","title":"JAVA"},{"count":5,"name":"程序设计","title":"程序设计"},{"count":5,"name":"programming","title":"programming"},{"count":2,"name":"软件技术","title":"软件技术"},{"count":1,"name":"软件开发","title":"软件开发"},{"count":1,"name":"计算机","title":"计算机"},{"count":1,"name":"编程","title":"编程"},{"count":1,"name":"武汉","title":"武汉"}],"origin_title":"Thinking in Java","image":"https://img3.doubanio.com/view/subject/m/public/s1150244.jpg","binding":"平装（带盘）","translator":[],"catalog":"Preface\nIntroduction\n1 Introduction to Objects\n2 Everything is an Object\n3 Controlling Program Flow\n4 Initialization & Cleanup\n5 Hiding the Implementation\n6 Reusing Classes\n7 Polymorphism\n8 Interfaces & Inner Classes\n9 Holding Your Objects\n10 Error Handling with Exceptions\n11 The Java I/O System\n12 Run-time Type Identification\n13 Creating Windows & Applets\n14 Multiple Threads\n15 Distributed Computing\nA: Passing & Returning Objects\nB: The Java Native Interface(JNI)\nC: Java Programming Guidelines\nD: Resources\nIndex","pages":"1164","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s1150244.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s1150244.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s1150244.jpg"},"alt":"https://book.douban.com/subject/1094798/","id":"1094798","publisher":"机械工业出版社","isbn10":"7111092864","isbn13":"9787111092865","title":"Java 编程思想","url":"https://api.douban.com/v2/book/1094798","alt_title":"Thinking in Java","author_intro":"","summary":"本书赢得了全球程序员的广泛赞誉，即使是最晦涩的概念，在Bruce Eckel的文字亲和力和小而直接的编程示例面前也会化解于无形。从Java的基础语法到最高级特性（深入的面向对象概念、多线程、自动项目构建、单元测试和调试等），本书都能逐步指导你轻松掌握。\n从本书获得的各项大奖以及来自世界各地的读者评论中，不难看出这是一本经典之作。本书的作者拥有多年教学经验，对C、C++以及Java语言都有独到、深入的见解，以通俗易懂及小而直接的示例解释了一个个晦涩抽象的概念。本书共22章，包括操作符、控制执行流程、访问权限控制、复用类、多态、接口、通过异常处理错误、字符串、泛型、数组、容器深入研究、Java I/O系统、枚举类型、并发以及图形化用户界面等内容。这些丰富的内容，包含了Java语言基础语法以及高级特性，适合各个层次的Java程序员阅读，同时也是高等院校讲授面向对象程序设计语言以及Java语言的绝佳教材和参考书。","price":"69.00元"},{"rating":{"max":10,"numRaters":19,"average":"6.8","min":0},"subtitle":"第4版(评注版)","author":["Bruce Eckel"],"pubdate":"2011-6-1","tags":[{"count":13,"name":"java","title":"java"},{"count":5,"name":"Java","title":"Java"},{"count":4,"name":"程序设计","title":"程序设计"},{"count":3,"name":"计算机","title":"计算机"},{"count":3,"name":"经典","title":"经典"},{"count":3,"name":"Programming","title":"Programming"},{"count":1,"name":"编程","title":"编程"},{"count":1,"name":"科技","title":"科技"}],"origin_title":"Thinking in Java (4th Edition)","image":"https://img3.doubanio.com/view/subject/m/public/s6618125.jpg","binding":"","translator":[],"catalog":"《java编程思想(第4版)(评注版)》\n第1部分 基本语法\noperators（新增批注30条） 1\nsimpler print statements 1\nusing java operators 2\nprecedence 2\nassignment 3\nmathematical operators 4\nunary minus and plus operators 6\nauto increment and decrement 6\nrelational operators 7\ntesting object equivalence 7\nlogical operators 9\nliterals 10\nexponential notation 11\nbitwise operators 12\nshift operators 13\nternary if-else operator 16\nstring operator + and += 17\ncommon pitfalls when using\n.operators 18\ncasting operators 18\ntruncation and rounding 19\npromotion 20\njava has no \u201csizeof \u201d 20\nsummary 20\ncontrolling execution\n（新增批注21条） 21\ntrue and false 21\nif-else 21\niteration 22\ndo-while 23\nfor 23\nthe comma operator 24\nforeach syntax 25\nreturn 27\nbreak and continue 27\nthe infamous \u201cgoto\u201d 29\nswitch 32\nsummary 34\n第2部分 面向对象\ninitialization & cleanup\n（新增批注55条） 35\nguaranteed initialization with\nthe constructor 35\nmethod overloading 37\ndistinguishing overloaded\nmethods 39\noverloading with primitives 39\noverloading on return values 42\ndefault constructors 43\nthe this keyword 44\ncalling constructors from\nconstructors 46\nthe meaning of static 47\ncleanup: finalization and\ngarbage collection 47\nwhat is finalize() for? 48\nyou must perform cleanup 49\nthe termination condition 50\nhow a garbage collector works 51\nmember initialization 54\nspecifying initialization 55\nconstructor initialization 56\norder of initialization 56\nstatic data initialization 57\nexplicit static initialization 59\nnon-static instance initialization 61\narray initialization 62\nvariable argument lists 65\nenumerated types 70\nsummary 72\naccess control\n（新增批注21条） 73\npackage: the library unit 74\ncode organization 75\ncreating unique package names 76\na custom tool library 79\njava access specifiers 80\npackage access 80\npublic: interface access 81\nprivate: you can\u2019t touch that! 82\nprotected: inheritance access 83\ninterface and implementation 85\nclass access 86\nsummary 87\nreusing classes\n（新增批注35条） 89\ncomposition syntax 89\ninheritance syntax 92\ninitializing the base class 94\ndelegation 96\ncombining composition and\ninheritance 97\nguaranteeing proper cleanup 99\nname hiding 101\nchoosing composition vs.\ninheritance 103\nprotected 104\nupcasting 105\nwhy \u201cupcasting\u201d? 106\ncomposition vs. inheritance\nrevisited 106\nthe final keyword 107\nfinal data 107\nfinal methods 110\nfinal classes 112\nfinal caution 113\ninitialization and class\nloading 113\ninitialization with inheritance 114\nsummary 115\ninterfaces\n（新增批注16条） 117\nabstract classes and methods 117\ninterfaces 120\n\u201cmultiple inheritance\u201d in java 123\nextending an interface with\ninheritance 125\nname collisions when combining\ninterfaces 127\nfields in interfaces 127\ninitializing fields in interfaces 128\ninterfaces and factories 129\nsummary 130\ninner classes\n（新增批注32条） 131\ncreating inner classes 131\nthe link to the outer class 133\nusing .this and .new 134\ninner classes and upcasting 135\nanonymous inner classes 137\nfactory method revisited 140\nnested classes 142\nclasses inside interfaces 143\nreaching outward from a\nmultiply nested class 145\nwhy inner classes? 145\nclosures & callbacks 148\ninheriting from inner classes 150\ncan inner classes be\noverridden? 150\nlocal inner classes 152\ninner-class identifiers 153\nsummary 154\nerror handling with excep- tions（新增批注52条） 155\nbasic exceptions 155\nexception arguments 156\ncatching an exception 157\nthe try block 157\nexception handlers . 157\ncreating your own\nexceptions 159\nexceptions and logging 161\nthe exception specification 164\ncatching any exception 164\nthe stack trace 166\nrethrowing an exception 167\nexception chaining 169\nstandard java exceptions 172\nspecial case: runtimeexception 172\nperforming cleanup with\nfinally 174\nwhat\u2019s finally for? 175\nusing finally during return 177\npitfall: the lost exception 178\nexception restrictions 180\nconstructors 182\nexception matching 187\nalternative approaches 188\npassing exceptions to the console 189\nsummary 189\n第3部分 数据存储\nstrings（新增批注53条） 191\nimmutable strings 191\noverloading \u2018+\u2019 vs.\nstringbuilder 192\nunintended recursion 195\noperations on strings 196\nformatting output 199\nprintf() 199\nsystem.out.format() 199\nthe formatter class 200\nformat specifiers 200\nformatter conversions 202\nstring.format() 204\nregular expressions 205\nbasics 206\ncreating regular expressions 208\nquantifiers 210\npattern and matcher 211\nsplit() 218\nreplace operations 218\nreset() 220\nregular expressions and java i/o 221\nscanning input 222\nscanner delimiters 224\nscanning with regular\nexpressions 225\nstringtokenizer 225\nsummary 226\narrays（新增批注36条） 227\nwhy arrays are special 227\narrays are first-class objects 228\nreturning an array 231\nmultidimensional arrays 232\narrays and generics 235\ncreating test data 237\narrays.fill() 238\ndata generators 239\narrays utilities 243\ncopying an array 243\ncomparing arrays 244\narray element comparisons 245\nsorting an array 248\nsearching a sorted array 249\nsummary 251\nholding your objects\n（新增批注35条） 253\ngenerics and type-safe\ncontainers 254\nbasic concepts 256\nadding groups of elements 258\nprinting containers 259\nlist 261\niterator 263\nlistiterator 266\nlinkedlist 267\nstack 268\nset 270\nmap 273\nqueue 276\npriorityqueue 277\ncollection vs. iterator 279\nforeach and iterators 281\nthe adapter method idiom 283\nsummary 286\ncontainers in depth\n（新增批注102条） 289\nfull container taxonomy 289\nfilling containers 290\na generator solution 291\nmap generators 292\ncollection functionality 294\noptional operations 297\nunsupported operations 298\nlist functionality 300\nsets and storage order 302\nsortedset 306\nqueues 307\npriority queues 308\ndeques 309\nunderstanding maps 310\nperformance 311\nsortedmap 314\nlinkedhashmap 315\nhashing and hash codes 316\nunderstanding hashcode() 319\nhashing for speed 321\noverriding hashcode() 324\nchoosing an implementation 329\na performance test framework 330\nchoosing between lists 333\nmicrobenchmarking dangers 338\nchoosing between sets 339\nchoosing between maps 341\nutilities 344\nsorting and searching lists 347\nmaking a collection or map\nunmodifiable 349\nsynchronizing a collection or\nmap 350\nholding references 351\nthe weakhashmap 353\njava 1.0/1.1 containers 355\nvector & enumeration 355\nhashtable 356\nstack 356\nbitset 357\nsummary 359\n第4部分 核心功能\ni/o（新增批注89条） 361\nthe file class 361\na directory lister 361\ndirectory utilities 364\nchecking for and creating\ndirectories 369\ninput and output 370\ntypes of inputstream 371\ntypes of outputstream 372\nadding attributes and useful\ninterfaces 373\nreading from an inputstream\nwith filterinputstream 374\nwriting to an outputstream\nwith filteroutputstream 375\nreaders & writers 376\nsources and sinks of data 377\nmodifying stream behavior 377\nunchanged classes 378\noff by itself:\nrandomaccessfile 379\ntypical uses of i/o streams 379\nbuffered input file 379\ninput from memory 380\nformatted memory input 381\nbasic file output 382\nstoring and recovering data 383\nreading and writing\nrandom-access files 385\npiped streams 386\nfile reading &\nwriting utilities 386\nreading binary files 389\nstandard i/o 389\nreading from standard input 389\nchanging system.out to a\nprintwriter 390\nredirecting standard i/o 391\nprocess control 391\nnew i/o 393\nconverting data 396\nfetching primitives 398\nview buffers 399\ndata manipulation with buffers 403\nbuffer details 404\nmemory-mapped files 406\nfile locking 409\ncompression 411\nsimple compression with gzip 412\nmultifile storage with zip 413\njava archives (jars) 415\nobject serialization 416\nfinding the class 419\ncontrolling serialization 420\nusing persistence 427\nxml 432\nsummary 434\nconcurrency\n（新增批注117条） 435\nbasic threading 435\ndefining tasks 435\nthe thread class 436\nusing executors 438\nproducing return values from\ntasks 440\nsleeping 442\npriority 443\nyielding 444\ndaemon threads 445\ncoding variations 446\njoining a thread 450\ncatching exceptions 451\nsharing resources 454\nresolving shared resource\ncontention 454\natomicity and volatility 457\natomic classes 460\ncritical sections 462\nsynchronizing on other objects 462\nthread local storage 463\nterminating tasks 464\nthe ornamental garden 465\nterminating when blocked 467\ninterruption 469\ncooperation between tasks 475\nwait() and notifyall() 475\nnotify() vs. notifyall() 479\nproducers and consumers 482\nproducer-consumers and queues 486\nusing pipes for i/o between tasks 491\ndeadlock 492\nnew library components 497\ncountdownlatch 497\ncyclicbarrier 499\ndelayqueue 501\npriorityblockingqueue 503\nthe greenhouse controller with\nscheduledexecutor 505\nsemaphore 508\nexchanger 511\nsimulation 513\nbank teller simulation 513\nthe restaurant simulation 517\ndistributing work 521\nperformance tuning 526\ncomparing mutex technologies 526\nlock-free containers 532\nreadwritelocks 533\nactive objects 535\nsummary 537\n第5部分 高级特性\ntype information\n（新增批注59条） 539\nthe need for rtti 539\nthe class object 541\nclass literals 545\ngeneric class references 547\nnew cast syntax 549\nchecking before a cast 550\nusing class literals 555\na dynamic instanceof 557\ncounting recursively 558\nregistered factories 559\ninstanceof vs. class\nequivalence 562\nreflection: runtime class\ninformation 563\na class method extractor 564\ndynamic proxies 566\nnull objects 570\nmock objects & stubs 575\ninterfaces and type\ninformation 576\nsummary 580\ngenerics\n（新增批注126条） 583\ncomparison with c++ 584\nsimple generics 584\na tuple library 586\na stack class 588\nrandomlist 589\ngeneric interfaces 590\ngeneric methods 593\nleveraging type argument\ninference 594\nvarargs and generic methods 596\na generic method to use with\ngenerators 596\na general-purpose generator 597\nsimplifying tuple use 598\na set utility 600\nanonymous inner classes 603\nbuilding complex models 604\nthe mystery of erasure 606\nthe c++ approach 607\nmigration compatibility 609\nthe problem with erasure 611\nthe action at the boundaries 612\ncompensating for erasure 615\ncreating instances of types 616\narrays of generics 618\nbounds 622\nwildcards 625\nhow smart is the compiler? 628\ncontravariance 629\nunbounded wildcards 632\ncapture conversion 636\nissues 637\nno primitives as type parameters 637\nimplementing parameterized\ninterfaces 639\ncasting and warnings 640\noverloading 641\nbase class hijacks an interface 642\nself-bounded types 642\ncuriously-recurring generics 643\nself-bounding 644\nargument covariance 646\ndynamic type safety 649\nexceptions 650\nmixins 651\nmixins in c++ 651\nmixing with interfaces 653\nusing the decorator pattern 654\nmixins with dynamic proxies 655\nlatent typing 657\ncompensating for the lack of\nlatent typing 660\nreflection 661\napplying a method to a sequence 662\nwhen you don\u2019t happen\nto have the right interface 664\nsimulating latent typing\nwith adapters 665\nusing function objects as\nstrategies 668\nsummary: is casting really\nso bad? 672\nenumerated types\n（新增批注55条） 675\nbasic enum features 675\nusing static imports with enums 676\nadding methods to an enum 677\noverriding enum methods 678\nenums in switch statements 678\nthe mystery of values() 679\nimplements, not inherits 681\nrandom selection 682\nusing interfaces for\norganization 683\nusing enumset instead of\nflags 686\nusing enummap 688\nconstant-specific methods 689\nchain of responsibility with\nenums 692\nstate machines with enums 695\nmultiple dispatching 700\ndispatching with enums 702\nusing constant-specific methods 704\ndispatching with enummaps 705\nusing a 2-d array 706\nsummary 707\nannotations\n（新增批注51条） 709\nbasic syntax 710\ndefining annotations 710\nmeta-annotations 712\nwriting annotation processors 712\nannotation elements 713\ndefault value constraints 713\ngenerating external files 714\nannotations don\u2019t\nsupport inheritance 717\nimplementing the processor 717\nusing apt to process\nannotations 719\nusing the visitor pattern with\napt 723\nannotation-based unit testing 726\nusing @unit with generics 733\nno \u201csuites\u201d necessary 735\nimplementing @unit 735\nremoving test code 741\nsum","pages":"742","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s6618125.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s6618125.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s6618125.jpg"},"alt":"https://book.douban.com/subject/6523999/","id":"6523999","publisher":"电子工业出版社","isbn10":"7121135213","isbn13":"9787121135217","title":"Java编程思想","url":"https://api.douban.com/v2/book/6523999","alt_title":"Thinking in Java (4th Edition)","author_intro":"Bruce Echel是MindView公司的CEO。该公司向客户提供软件咨询和培训。他是《Thinking in C++》一书的作者，并与他人合著了该书的第2卷以及其他图书。20多年来，他已发表了150多篇论文，并在全世界参与教学讲座和研讨，他是C++标准委员会成员，拥有应用物理大学学位和计算机工程硕士学位。\n刘中兵：Java研究室首席技术专家 ，应用数学专业，曾任职于清华同方、NEC等企业，长期深入Java／Java EE大型企业应用的架构、设计与开发工作，目前专注于手机无线互联网与网络通信领域的架构设计与研究工作。","summary":"《java编程思想(第4版)(评注版)》作者拥有多年教学经验，对c、c++以及java语言都有独到、深入的见解，书中以通俗易懂且小而直接的示例阐释了一个个晦涩抽象的概念，是一本当之无愧的经典之作。本评注版讲解了java设计、语法和库的各个方面，包括java的运算符、控制逻辑、构造、回收、重用、接口、内部类、存储、异常、字符串、类型、泛型、数组、容器、i/o、注释、并发等内容。\n对于国外技术图书，选择翻译版还是影印版，常常让人陷入两难的境地。本评注版力邀国内资深专家执笔，在英文原著基础上增加中文点评与注释，旨在融合二者之长，既保留经典的原创文字与味道，又以先行者的学研心得与实践感悟，对读者阅读与学习加以点拨、指明捷径。\n经过评注的版本，更值得反复阅读与体会。希望这《java编程思想(第4版)(评注版)》能够帮助您跨越java的重重险阻，领略高处才有的壮美风光，做一个成功而快乐的java程序员。","series":{"id":"12876","title":"博文视点评注版"},"price":"108.00元"},{"rating":{"max":10,"numRaters":22,"average":"7.0","min":0},"subtitle":"","author":["陈跃峰","李中彬","谷骁勇"],"pubdate":"2010-1","tags":[{"count":16,"name":"Java","title":"Java"},{"count":5,"name":"编程","title":"编程"},{"count":1,"name":"阅读来源:实体书","title":"阅读来源:实体书"},{"count":1,"name":"阅读年份:2011","title":"阅读年份:2011"},{"count":1,"name":"适合精读","title":"适合精读"},{"count":1,"name":"越读者:主食类","title":"越读者:主食类"},{"count":1,"name":"编程语言","title":"编程语言"},{"count":1,"name":"程序员","title":"程序员"}],"origin_title":"","image":"https://img3.doubanio.com/view/subject/m/public/s6110836.jpg","binding":"","translator":[],"catalog":"第1章  计算机基础    1.1  计算机软件的基本概念      1.1.1  软件的概念      1.1.2  计算机为什么使用二进制数据      1.1.3  计算机存储单位    1.2  进制的概念      1.2.1  二进制      1.2.2  二进制和十进制之间的转换      1.2.3  二进制和八进制、十六进制之间的转换    1.3  计算机内部的数据表达      1.3.1  整数的表达      1.3.2  字符的表达      1.3.3  小结    1.4  网络编程基础      1.4.1  网络编程是什么      1.4.2  IP地址和域名      1.4.3  端口的概念      1.4.4  数据传输方式      1.4.5  协议的概念      1.4.6  小结    1.5  Java语言简介      1.5.1  Java语言历史      1.5.2  Java程序开发过程      1.5.3  Java虚拟机介绍      1.5.4  其他  第2章  建立开发环境第3章  Java基础语法第4章  运算符  第5章  流程控制  第6章  数组  第7章  方法  第8章  面向对象  第9章  JDK文档使用  第10章  异常处理  第11章  I/O处理  第12章  多线程  第13章  网络编程  第14章  GUI界面编程","pages":"393","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s6110836.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s6110836.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s6110836.jpg"},"alt":"https://book.douban.com/subject/4240960/","id":"4240960","publisher":"清华大学出版社","isbn10":"7302214050","isbn13":"9787302214052","title":"Java编程那些事儿","url":"https://api.douban.com/v2/book/4240960","alt_title":"","author_intro":"","summary":"《Java编程那些事儿》以通俗易懂的语言和代码示例介绍Java语言编程的各种知识，是一本指导初学者进行自学编程，并通过相关章节附带的练习融会贯通相关技术的入门书籍。《Java编程那些事儿》按照技术学习的顺序，依次介绍了计算机基础知识、建立Java开发环境、Java基础语法、流程控制使用、数组使用、方法使用等编程基础知识，然后介绍了面向对象编程、JDK API结构、I/O技术、多线程技术、网络编程技术和界面开发技术等内容，并结合例子深入介绍了技术的实际应用，是一本实用的Java学习书籍。\n《Java编程那些事儿》难易适中，书中内容讲解和示例均源自作者多年在教育第一线的经验，讲解深入，介绍全面，示例丰富。\n《Java编程那些事儿》适用于各类Java编程人员，既适合初学Java编程的各类高校学生、培训机构学员进行编程学习，也适合作为Java程序员加深Java编程理解的参考用书。","price":"39.00元"},{"rating":{"max":10,"numRaters":16,"average":"7.1","min":0},"subtitle":"","author":["卡登赫斯第"],"pubdate":"2007-3","tags":[{"count":10,"name":"JAVA","title":"JAVA"},{"count":7,"name":"编程","title":"编程"},{"count":3,"name":"Programming","title":"Programming"},{"count":2,"name":"Java","title":"Java"},{"count":1,"name":"java,编程,Programming","title":"java,编程,Programming"},{"count":1,"name":"java","title":"java"}],"origin_title":"","image":"https://img1.doubanio.com/view/subject/m/public/s8825317.jpg","binding":"","translator":["梅兴文"],"catalog":"","pages":"376","images":{"small":"https://img1.doubanio.com/view/subject/s/public/s8825317.jpg","large":"https://img1.doubanio.com/view/subject/l/public/s8825317.jpg","medium":"https://img1.doubanio.com/view/subject/m/public/s8825317.jpg"},"alt":"https://book.douban.com/subject/2023097/","id":"2023097","publisher":"人民邮电出版社","isbn10":"7115157499","isbn13":"9787115157492","title":"Java编程入门经典","url":"https://api.douban.com/v2/book/2023097","alt_title":"","author_intro":"","summary":"《Java编程入门经典(第4版)》通过大量示例程序循序渐进地引导读者快速掌握使用Java开发程序的基本技能。全书分8个部分，包含25章和5个附录。第一部分通过一个简单的Java程序和各种动态网页，让读者对Java程序的编写流程和工作原理以及Java的广泛用途有感性的认识；第二部分分绍有关编程的基本知识，包括变量、条件语句和循环语句；第三部分探讨数组和对象；第四部分介绍如何创建图形用户界面，包括如何使用各种图形界面组件、如何使用布局管理器来排列组件以及如何响应用户输入；第五部分阐述如何创建交互式Web程序、处理错误、使用线程及读写文件；第六部分探讨如何读写XML数据、如何使用字体、颜色和图形，以及如何创建动画；第七部分介绍如何使用XML-RPC创建Web服务；第八部分为附录，阐述了如何安装与使用JDK和NetBeans集成开发环境，并介绍了网上的各种Java资源。\n《Java编程入门经典(第4版)》可作为初学者学习Java编程技术的教程，也可供其他语言的程序员学习Java时参考。","price":"39.00元"},{"rating":{"max":10,"numRaters":3,"average":"0.0","min":0},"subtitle":"Android系统下Java编程详解","author":["郑萌"],"pubdate":"2012-10","tags":[{"count":8,"name":"Android","title":"Android"},{"count":6,"name":"java","title":"java"},{"count":2,"name":"计算机科学","title":"计算机科学"},{"count":1,"name":"电子工业出版社","title":"电子工业出版社"}],"origin_title":"","image":"https://img3.doubanio.com/view/subject/m/public/s24410851.jpg","binding":"","translator":[],"catalog":"","pages":"285","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s24410851.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s24410851.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s24410851.jpg"},"alt":"https://book.douban.com/subject/20260929/","id":"20260929","publisher":"","isbn10":"7121184931","isbn13":"9787121184932","title":"Android系统下Java编程详解","url":"https://api.douban.com/v2/book/20260929","alt_title":"","author_intro":"","summary":"《高等院校3G人才培养规划教材:Android系统下Java编程详解》共12章，内容主要包含两大部分。第一部分是Java语法相关内容，主要介绍Java语言语法、JSP和MySQL数据库等知识。第二部分关注Android系统下的Java编程特点，讲解Android系统下Java编程的优化原则和方法，并给出了具体建议。","price":"45.00元"},{"rating":{"max":10,"numRaters":13,"average":"6.9","min":0},"subtitle":"","author":["高永强"],"pubdate":"2009-7","tags":[{"count":9,"name":"JAVA","title":"JAVA"},{"count":2,"name":"科技","title":"科技"},{"count":2,"name":"Java","title":"Java"},{"count":1,"name":"好","title":"好"}],"origin_title":"","image":"https://img3.doubanio.com/view/subject/m/public/s4457802.jpg","binding":"","translator":[],"catalog":"","pages":"759","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s4457802.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s4457802.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s4457802.jpg"},"alt":"https://book.douban.com/subject/3867972/","id":"3867972","publisher":"","isbn10":"7302193177","isbn13":"9787302193173","title":"Java编程艺术","url":"https://api.douban.com/v2/book/3867972","alt_title":"","author_intro":"","summary":"《Java编程艺术》共分5个部分。第1部分为新手上路篇，介绍Java编程基础和环境。第2部分为深入篇，将带领你走进Java面向对象编程大门。第4部分为GUI和多媒体，按钮、菜单、文本选项等20多种GUI组件，以及颜色、字体、图像和声音编程，使你进入一个五彩缤纷、绘声绘色的Java编程艺术世界。第5部分为数据流和处理，指导你掌握Java文件I/O、数据库编程以及网络编程。\n除涵盖广泛的Java编程概念和技术外，《Java编程艺术》还具有如下几个特点：一是利用3W（What, Why and How）为主线引导对Java语言的学习；二是利用图示化方式讨论面向对象编程技术（Object-Oriented Program-ming）；三是在几乎每章最后，都包括了解决实际问题的实例，综合性地介绍了如何利用在该章讨论过的概念和编程技术来解决实际问题。四是在每章后的巩固提高练习中，进一步指导读者理解、消化以及深入掌握本章程序讨论过的编程概念和例子。\n《Java编程艺术》适用于初学者以及有一定编程基础的读者。可以作为大学、大专、中专以及培训中心作为教科书、自学课本，也可以作为专业人员和教师的参考书。","price":"89.00元"},{"rating":{"max":10,"numRaters":5,"average":"0.0","min":0},"subtitle":"","author":["邓劲生","Herbert Schildt","James holmes"],"pubdate":"2004-9-1","tags":[{"count":4,"name":"Java","title":"Java"},{"count":2,"name":"编程语言","title":"编程语言"},{"count":1,"name":"Java编程艺术","title":"Java编程艺术"}],"origin_title":"","image":"https://img3.doubanio.com/view/subject/m/public/s1163820.jpg","binding":"平装(无盘)","translator":["邓劲生"],"catalog":"第1章 JAVA精髓\n第2章 递归下降的表达式解析器\n第3章 使用JAVA实现语言解释器\n第4章 使用JAVA创建下载管理器\n第5章 用JAVA实现E-mail客户端\n第6章 使用JAVA搜索Internet\n第7章 使用JAVA提交HTML\n第8章 统计、图表与JAVA\n第9章 金融应用中的Applet和Servlet\n第10章 基于AI的问题求解","pages":"356","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s1163820.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s1163820.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s1163820.jpg"},"alt":"https://book.douban.com/subject/1187384/","id":"1187384","publisher":"清华大学出版社","isbn10":"7302090548","isbn13":"9787302090540","title":"Java编程艺术","url":"https://api.douban.com/v2/book/1187384","alt_title":"","author_intro":"","summary":"本书揭示了Java程序员如何创建高质量软件的奥秘。Herbert Schildt 和James Holmes两位编程大师通过将Java应用于某些有趣、实用的计算机问题和编程任务中，全面展示了Java语言的强大功能、敏捷性、多样性和艺术性。本书各章内容分别涉及到Java精髓、递归下降的表达式解析器、用Java实现语言解释器、用Java创建下载管理器、用Java实现E-mail客户端和Internet搜索、用Java修饰HTML、显示统计图表、金融应用中的Applet和Servlet、基于AI的问题求解等，每章给出的示例代码都可以直接运行，无需修改，而且读者可以从www.osborne.com站点上免费下载这些代码。本书是亚马逊网站上的五星级图书，相信读者能够通过研读本书大大提高自己的Java开发能力。本书代码示例易懂有趣，设计思想独特，定会使您受益匪浅！","price":"45.0"}]
     */

    private int count;
    private int start;
    private int total;
    private List<BooksBean> books;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<BooksBean> getBooks() {
        return books;
    }

    public void setBooks(List<BooksBean> books) {
        this.books = books;
    }

    public static class BooksBean implements Serializable{

        private RatingBean rating;
        private String subtitle;
        private String pubdate;
        private String origin_title;
        private String image;
        private String binding;
        private String pages;
        private String alt;
        private String id;
        private String publisher;
        private String isbn10;
        private String isbn13;
        private String title;
        private String url;
        private String alt_title;
        private String summary;
        private String price;
        private String author_intro;
        private String catalog;
        private List<String> author;
        private List<String> translator;

        public String getAuthor_intro() {
            return author_intro;
        }

        public void setAuthor_intro(String author_intro) {
            this.author_intro = author_intro;
        }

        public String getCatalog() {
            return catalog;
        }

        public void setCatalog(String catalog) {
            this.catalog = catalog;
        }

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getPubdate() {
            return pubdate;
        }

        public void setPubdate(String pubdate) {
            this.pubdate = pubdate;
        }

        public String getOrigin_title() {
            return origin_title;
        }

        public void setOrigin_title(String origin_title) {
            this.origin_title = origin_title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getBinding() {
            return binding;
        }

        public void setBinding(String binding) {
            this.binding = binding;
        }

        public String getPages() {
            return pages;
        }

        public void setPages(String pages) {
            this.pages = pages;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public String getIsbn10() {
            return isbn10;
        }

        public void setIsbn10(String isbn10) {
            this.isbn10 = isbn10;
        }

        public String getIsbn13() {
            return isbn13;
        }

        public void setIsbn13(String isbn13) {
            this.isbn13 = isbn13;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAlt_title() {
            return alt_title;
        }

        public void setAlt_title(String alt_title) {
            this.alt_title = alt_title;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public List<String> getAuthor() {
            return author;
        }

        public void setAuthor(List<String> author) {
            this.author = author;
        }

        public List<String> getTranslator() {
            return translator;
        }

        public void setTranslator(List<String> translator) {
            this.translator = translator;
        }

        public static class RatingBean {
            /**
             * max : 10
             * numRaters : 2988
             * average : 9.1
             * min : 0
             */

            private int max;
            private int numRaters;
            private String average;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public int getNumRaters() {
                return numRaters;
            }

            public void setNumRaters(int numRaters) {
                this.numRaters = numRaters;
            }

            public String getAverage() {
                return average;
            }

            public void setAverage(String average) {
                this.average = average;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }


    }
}

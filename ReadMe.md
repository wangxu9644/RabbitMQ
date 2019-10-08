1.RabbitMQ-fanout
先运行两次 TestCustomer，启动两个消费者。
然后运行一次 TestProducer， 启动生产者，生产100条信息。
此时就可以看到如图所示两个消费者都能收到 这100条信息。
http://stepimagewm.how2j.cn/9246.png
picture/9246.png

2.RabbitMQ-direct
先运行两次 TestDriectCustomer，启动两个消费者。
然后运行一次 TestDriectProducer， 启动生产者，生产100条信息。此时就可以看到如图所示两个消费者分食 这100条信息。
http://stepimagewm.how2j.cn/9240.png
picture/9240.png

3.RabbitMQ-topic
先运行 TestCustomer4USA 专门用于接受美国专题消息
再运行 TestCustomer4News 专门用于接受新闻专题消息
最后运行 TestProducer ，分别在 
四个路由："usa.news", "usa.weather", "europe.news", "europe.weather" 
上发布     "美国新闻", "美国天气",    "欧洲新闻",    "欧洲天气".
于是就能在消费者端看到 不同的主题收到对应的消息了。
http://stepimagewm.how2j.cn/9252.png
picture/9252.png

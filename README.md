# service_test

### 属性
	exported: 是否能被其他应用隐式调用
	name：对应Service类名
	permission：权限声明
	process：指定进程
	enable是否可以被系统实例化

1. 采用扩展Binder方式来实现IBinder
2. 使用Messenger方式来实现IBinder
3. 使用AIDL
4. 共享匿名内存

疑问： 为什么unbindService调用后，远程方法IBinder依然可以成功调用


#设计模式
###单例模式
    懒汉式 - 延迟加载 -  线程不安全
    饿汉式-提前加载-无锁安全，新的jvm上类只有在使用时才会被加载，最佳单例是这个，效率最高
    同步锁单例模式--两种方式实现
    双重校验锁机制-避免已经示例化的对象仍请求锁,请求锁比if判断消耗资源


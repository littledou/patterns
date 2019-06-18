# service_test

### 属性
	* exported: 是否能被其他应用隐式调用
	* name：对应Service类名
	* permission：权限声明
	* process：指定进程
	* enable是否可以被系统实例化

1. 采用扩展Binder方式来实现IBinder
2. 使用Messenger方式来实现IBinder
3. 使用AIDL
4. 共享匿名内存

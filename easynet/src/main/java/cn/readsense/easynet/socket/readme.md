1. 服务器实例化一个ServerSocket对象，表示通过服务器的端口通信
2. 服务器调用ServerSocket的accept()方法，该方法一直等待，知道客户端连接到服务器上给定的端口
3. 服务器正在等待时，一个客户端实例化一个Socket对象，指定连接该服务器名称和端口
4. Socket类的构造函数试图将客户端连接到指定到服务器和端口号，如果通信被建立，则在客户端创建一个Socket对象能够与服务器进行通信
5. 在服务器端，accept()方法返回服务器上一个新的socket引用，该socket连接到客户端到socket

ServerSocket

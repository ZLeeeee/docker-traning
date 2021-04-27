

### Require

- [java8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) 
- [maven](http://maven.apache.org/) 
- [docker](https://www.docker.com/)
- [docker-compose](https://docs.docker.com/compose/)

### Quick Start

`./install.sh` 

### Index Page

`http://localhost` 

### Structure
![avatar](structure.png)

### Docker network drivers

- host
  ```
  如果启动容器的时候使用host模式，那么这个容器将不会获得一个独立的Network Namespace，
  而是和宿主机共用一个Network Namespace。容器将不会虚拟出自己的网卡，配置自己的IP等，
  而是使用宿主机的IP和端口。但是，容器的其他方面，如文件系统、进程列表等还是和宿主机隔离的。
  使用host模式的容器可以直接使用宿主机的IP地址与外界通信，
  容器内部的服务端口也可以使用宿主机的端口，不需要进行NAT，host最大的优势就是网络性能比较好，
  但是docker host上已经使用的端口就不能再用了，网络的隔离性不好。
  ```

- container
  ```
  这个模式指定新创建的容器和已经存在的一个容器共享一个 Network Namespace，
  而不是和宿主机共享。新创建的容器不会创建自己的网卡，配置自己的 IP，
  而是和一个指定的容器共享 IP、端口范围等。同样，两个容器除了网络方面，
  其他的如文件系统、进程列表等还是隔离的。两个容器的进程可以通过 lo 网卡设备通信。
  ```
- none
  ```
  使用none模式，Docker容器拥有自己的Network Namespace，但是，并不为Docker容器进行任何网络配置。
  也就是说，这个Docker容器没有网卡、IP、路由等信息。需要我们自己为Docker容器添加网卡、配置IP等。
  这种网络模式下容器只有lo回环网络，没有其他网卡。none模式可以在容器创建时通过--network=none来指定。
  这种类型的网络没有办法联网，封闭的网络能很好的保证容器的安全性。
  ```
- bridge
  ```
  当Docker进程启动时，会在主机上创建一个名为docker0的虚拟网桥，
  此主机上启动的Docker容器会连接到这个虚拟网桥上。虚拟网桥的工作方式和物理交换机类似，
  这样主机上的所有容器就通过交换机连在了一个二层网络中。
  ```

